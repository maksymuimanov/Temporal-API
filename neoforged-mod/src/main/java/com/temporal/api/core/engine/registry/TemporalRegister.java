package com.temporal.api.core.engine.registry;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.registry.factory.BlockPropertiesFactory;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TemporalRegister<T> extends DeferredRegister<T> {
    private final Map<DeferredHolder<T, ? extends T>, Supplier<? extends T>> entries;
    private final Set<DeferredHolder<T, ? extends T>> entriesView;
    private Map<ResourceLocation, ResourceLocation> aliases;
    private boolean seenRegisterEvent;
    private boolean seenNewRegistryEvent;
    private boolean registeredEventBus;
    @Nullable
    private Registry<T> customRegistry;
    @Nullable
    private RegistryHolder<T> registryHolder;

    protected TemporalRegister(ResourceKey<? extends Registry<T>> registryKey, String namespace) {
        super(registryKey, namespace);
        this.entries = new LinkedHashMap<>();
        this.entriesView = Collections.unmodifiableSet(this.entries.keySet());
        this.aliases = new HashMap<>();
        this.seenRegisterEvent = false;
        this.seenNewRegistryEvent = false;
        this.registeredEventBus = false;
    }

    public static TemporalItems createItems() {
        return new TemporalItems(ModContext.NEO_MOD.getModId());
    }

    public static TemporalBlocks createBlocks() {
        return new TemporalBlocks(ModContext.NEO_MOD.getModId());
    }

    public static <T> TemporalRegister<T> create(Registry<T> registry) {
        return create(registry, ModContext.NEO_MOD.getModId());
    }

    public static <T> TemporalRegister<T> create(Registry<T> registry, String namespace) {
        return new TemporalRegister<>(registry.key(), namespace);
    }

    public static <T> TemporalRegister<T> create(ResourceKey<? extends Registry<T>> key) {
        return create(key, ModContext.NEO_MOD.getModId());
    }

    public static <T> TemporalRegister<T> create(ResourceKey<? extends Registry<T>> key, String namespace) {
        return new TemporalRegister<>(key, namespace);
    }

    public static <T> TemporalRegister<T> create(@NotNull ResourceLocation registryName) {
        return create(registryName, ModContext.NEO_MOD.getModId());
    }

    public static <T> TemporalRegister<T> create(@NotNull ResourceLocation registryName, String namespace) {
        return new TemporalRegister<>(ResourceKey.createRegistryKey(registryName), namespace);
    }

    public void register(@NotNull IEventBus eventBus, @NotNull Class<?>... containers) {
        ResourceKey<? extends Registry<T>> registryKey = this.getRegistryKey();
        ApiMod.LOGGER.info("Registering DeferredRegister {} to EventBus with containers: [{}]", registryKey, Arrays.toString(containers));
        if (this.isRegisteredEventBus()) {
            ApiMod.LOGGER.error("DeferredRegister {} is already registered to an EventBus", registryKey);
            throw new IllegalStateException("Cannot register DeferredRegister to more than one event bus.");
        } else {
            eventBus.addListener((RegisterEvent event) -> addEntries(event, containers));
            eventBus.addListener(this::addRegistry);
            this.setRegisteredEventBus(true);
            ApiMod.LOGGER.debug("DeferredRegister {} successfully bound to EventBus", registryKey);
        }
    }

    @Override
    @NotNull
    public <I extends T> DeferredHolder<T, I> register(@NotNull String name, @NotNull Function<ResourceLocation, ? extends I> function) {
        ResourceKey<? extends Registry<T>> registryKey = this.getRegistryKey();
        ApiMod.LOGGER.debug("Attempting to register entry '{}' in registry {}", name, registryKey);
        if (this.isSeenRegisterEvent()) {
            ApiMod.LOGGER.error("RegisterEvent already fired! Cannot register '{}'", name);
            throw new IllegalStateException("Cannot register new entries to DeferredRegister after RegisterEvent has been fired.");
        } else {
            Objects.requireNonNull(name);
            Objects.requireNonNull(function);
            ResourceLocation key = ResourceLocation.fromNamespaceAndPath(this.getNamespace(), name);
            DeferredHolder<T, I> holder = this.createHolder(registryKey, key);
            if (this.getEntriesMap().putIfAbsent(holder, () -> function.apply(key)) != null) {
                ApiMod.LOGGER.error("Duplicate registration attempted for '{}'", name);
                throw new IllegalArgumentException("Duplicate registration " + name);
            } else {
                ApiMod.LOGGER.info("Successfully registered entry '{}' with id={}", name, key);
                return holder;
            }
        }
    }

    protected void addEntries(RegisterEvent event, Class<?>... containers) {
        ResourceKey<? extends Registry<T>> registryKey = this.getRegistryKey();
        if (event.getRegistryKey().equals(registryKey)) {
            ApiMod.LOGGER.info("Processing RegisterEvent for registry {} with containers: [{}]", registryKey, Arrays.toString(containers));
            this.loadFields(containers);
            this.setSeenRegisterEvent(true);
            Registry<T> registry = event.getRegistry(registryKey);
            Map<ResourceLocation, ResourceLocation> aliases = this.getAliases();
            Objects.requireNonNull(registry);
            ApiMod.LOGGER.debug("Applying {} aliases for registry {}", aliases.size(), registryKey);
            aliases.forEach((from, to) -> {
                ApiMod.LOGGER.debug("Adding alias {} -> {}", from, to);
                registry.addAlias(from, to);
            });
            for (Map.Entry<DeferredHolder<T, ? extends T>, Supplier<? extends T>> entry : this.entries.entrySet()) {
                DeferredHolder<T, ? extends T> holder = entry.getKey();
                ApiMod.LOGGER.debug("Registering holder {} with id: {}", holder, holder.getId());
                event.register(registryKey, holder.getId(), () -> entry.getValue().get());
                holder.isBound();
            }
            ApiMod.LOGGER.info("Completed RegisterEvent for registry {}", registryKey);
        }
    }

    protected void loadFields(Class<?>... containers) {
        for (Class<?> container : containers) {
            for (Field field : container.getDeclaredFields()) {
                try {
                    ApiMod.LOGGER.debug("Loading field {}.{}", container.getName(), field.getName());
                    field.setAccessible(true);
                    field.get(null);
                } catch (IllegalAccessException e) {
                    ApiMod.LOGGER.error("Failed to load field {}.{}: {}", container.getName(), field.getName(), e.getMessage());
                    throw new RuntimeException(e);
                }
            }
        }
    }

    protected void addRegistry(NewRegistryEvent event) {
        this.setSeenNewRegistryEvent(true);
        ResourceKey<? extends Registry<T>> registryKey = this.getRegistryKey();
        ApiMod.LOGGER.info("Handling NewRegistryEvent for {}", registryKey);
        Registry<T> customRegistry = this.getCustomRegistry();
        if (customRegistry != null) {
            ApiMod.LOGGER.debug("Registering custom registry {}", customRegistry);
            event.register(Objects.requireNonNull(customRegistry));
        } else {
            ApiMod.LOGGER.warn("NewRegistryEvent fired but no custom registry set for {}", registryKey);
        }
    }

    @Override
    @NotNull
    public Registry<T> makeRegistry(@NotNull Consumer<RegistryBuilder<T>> consumer) {
        return this.makeRegistry(this.getRegistryKey().location(), consumer);
    }

    protected Registry<T> makeRegistry(ResourceLocation registryName, Consumer<RegistryBuilder<T>> consumer) {
        ApiMod.LOGGER.debug("Creating registry with name - {}", registryName);
        if (registryName == null) {
            ApiMod.LOGGER.error("Cannot create a registry without specifying a registry name");
            throw new IllegalStateException("Cannot create a registry without specifying a registry name");
        } else if (!BuiltInRegistries.REGISTRY.containsKey(registryName) && this.getCustomRegistry() == null) {
            if (this.isSeenNewRegistryEvent()) {
                ApiMod.LOGGER.error("NewRegistryEvent already fired, cannot create new registry {}", registryName);
                throw new IllegalStateException("Cannot create a registry after NewRegistryEvent was fired");
            } else {
                ResourceKey<? extends Registry<T>> registryKey = this.getRegistryKey();
                RegistryBuilder<T> registryBuilder = new RegistryBuilder<>(registryKey);
                consumer.accept(registryBuilder);
                this.setCustomRegistry(registryBuilder.create());
                this.setRegistryHolder(new RegistryHolder<>(registryKey));
                Registry<T> customRegistry = this.getCustomRegistry();
                Objects.requireNonNull(this.getRegistryHolder()).setRegistry(customRegistry);
                ApiMod.LOGGER.info("Successfully created custom registry - {}", registryName);
                return customRegistry;
            }
        } else {
            ApiMod.LOGGER.error("Registry {} already exists or custom registry already set", registryName);
            throw new IllegalStateException("Cannot create a registry that already exists - " + registryName);
        }
    }

    public void addAlias(@NotNull ResourceLocation from, @NotNull ResourceLocation to) {
        ApiMod.LOGGER.debug("Adding alias {} -> {}", from, to);
        if (this.isSeenRegisterEvent()) {
            ApiMod.LOGGER.error("Cannot add alias {} -> {} after RegisterEvent fired", from, to);
            throw new IllegalStateException("Cannot add aliases to DeferredRegister after RegisterEvent has been fired.");
        } else {
            this.getAliases().put(from, to);
        }
    }

    @Override
    @NotNull
    public Supplier<Registry<T>> getRegistry() {
        if (this.getRegistryHolder() == null) {
            this.setRegistryHolder(new RegistryHolder<>(this.getRegistryKey()));
        }

        return this.getRegistryHolder();
    }

    public Map<DeferredHolder<T, ? extends T>, Supplier<? extends T>> getEntriesMap() {
        return entries;
    }

    @Override
    @NotNull
    public Collection<DeferredHolder<T, ? extends T>> getEntries() {
        return entriesView;
    }

    public Set<DeferredHolder<T, ? extends T>> getEntriesView() {
        return entriesView;
    }

    public Map<ResourceLocation, ResourceLocation> getAliases() {
        return aliases;
    }

    public void setAliases(Map<ResourceLocation, ResourceLocation> aliases) {
        this.aliases = aliases;
    }

    public boolean isSeenRegisterEvent() {
        return seenRegisterEvent;
    }

    public void setSeenRegisterEvent(boolean seenRegisterEvent) {
        this.seenRegisterEvent = seenRegisterEvent;
    }

    public boolean isSeenNewRegistryEvent() {
        return seenNewRegistryEvent;
    }

    public void setSeenNewRegistryEvent(boolean seenNewRegistryEvent) {
        this.seenNewRegistryEvent = seenNewRegistryEvent;
    }

    public boolean isRegisteredEventBus() {
        return registeredEventBus;
    }

    public void setRegisteredEventBus(boolean registeredEventBus) {
        this.registeredEventBus = registeredEventBus;
    }

    @Nullable
    public Registry<T> getCustomRegistry() {
        return customRegistry;
    }

    public void setCustomRegistry(@Nullable Registry<T> customRegistry) {
        this.customRegistry = customRegistry;
    }

    @Nullable
    public RegistryHolder<T> getRegistryHolder() {
        return registryHolder;
    }

    public void setRegistryHolder(@Nullable RegistryHolder<T> registryHolder) {
        this.registryHolder = registryHolder;
    }

    @SuppressWarnings("unchecked")
    public static class TemporalBlocks extends TemporalRegister<Block> {
        public TemporalBlocks(String namespace) {
            super(Registries.BLOCK, namespace);
        }

        @SuppressWarnings("unchecked")
        @NotNull
        public <B extends Block> DeferredBlock<B> register(@NotNull String name, @NotNull Function<ResourceLocation, ? extends B> function) {
            return (DeferredBlock<B>)super.register(name, function);
        }

        @NotNull
        public <B extends Block> DeferredBlock<B> register(@NotNull String name, @NotNull Supplier<? extends B> supplier) {
            return this.register(name, (key) -> supplier.get());
        }

        public <B extends Block> DeferredBlock<B> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends B> function) {
            return this.registerBlock(name, BlockPropertiesFactory.empty(), function);
        }

        public DeferredBlock<Block> registerSimpleBlock(String name, BlockBehaviour.Properties properties) {
            return this.registerBlock(name, properties, Block::new);
        }

        public <B extends Block> DeferredBlock<B> registerBlock(String name, BlockBehaviour.Properties properties, Function<BlockBehaviour.Properties, ? extends B> function) {
            return this.register(name, () -> function.apply(properties));
        }

        public DeferredBlock<Block> registerSimpleBlock(String name) {
            return this.registerSimpleBlock(name, BlockPropertiesFactory.empty());
        }

        @NotNull
        protected <I extends Block> DeferredBlock<I> createHolder(@NotNull ResourceKey<? extends Registry<Block>> registryKey,
                                                                  @NotNull ResourceLocation key) {
            return DeferredBlock.createBlock(ResourceKey.create(registryKey, key));
        }
    }

    @SuppressWarnings("unchecked")
    public static class TemporalItems extends TemporalRegister<Item> {
        public TemporalItems(String namespace) {
            super(Registries.ITEM, namespace);
        }

        @NotNull
        public <I extends Item> DeferredItem<I> register(@NotNull String name, @NotNull Function<ResourceLocation, ? extends I> function) {
            return (DeferredItem<I>)super.register(name, function);
        }

        @NotNull
        public <I extends Item> DeferredItem<I> register(@NotNull String name, @NotNull Supplier<? extends I> supplier) {
            return this.register(name, (key) -> supplier.get());
        }

        @NotNull
        public DeferredItem<BlockItem> registerSimpleBlockItem(String name, Supplier<? extends Block> block, Item.Properties properties) {
            return this.register(name, (key) -> new BlockItem(block.get(), properties));
        }

        public DeferredItem<BlockItem> registerSimpleBlockItem(String name, Supplier<? extends Block> block) {
            return this.registerSimpleBlockItem(name, block, new Item.Properties());
        }

        public DeferredItem<BlockItem> registerSimpleBlockItem(Holder<Block> block, Item.Properties properties) {
            String var10001 = (block.unwrapKey().orElseThrow()).location().getPath();
            Objects.requireNonNull(block);
            return this.registerSimpleBlockItem(var10001, block::value, properties);
        }

        public DeferredItem<BlockItem> registerSimpleBlockItem(Holder<Block> block) {
            return this.registerSimpleBlockItem(block, new Item.Properties());
        }

        public <I extends Item> DeferredItem<I> registerItem(String name, Item.Properties properties, Function<Item.Properties, ? extends I> function) {
            return this.register(name, () -> function.apply(properties));
        }

        public <I extends Item> DeferredItem<I> registerItem(String name, Function<Item.Properties, ? extends I> function) {
            return this.registerItem(name, new Item.Properties(), function);
        }

        public DeferredItem<Item> registerSimpleItem(String name, Item.Properties properties) {
            return this.registerItem(name, properties, Item::new);
        }

        public DeferredItem<Item> registerSimpleItem(String name) {
            return this.registerItem(name, new Item.Properties(), Item::new);
        }

        @NotNull
        protected <I extends Item> DeferredItem<I> createHolder(@NotNull ResourceKey<? extends Registry<Item>> registryKey, @NotNull ResourceLocation key) {
            return DeferredItem.createItem(ResourceKey.create(registryKey, key));
        }
    }

    @SuppressWarnings("unchecked")
    public static class RegistryHolder<V> implements Supplier<Registry<V>> {
        private final ResourceKey<? extends Registry<V>> registryKey;
        private Registry<V> registry;

        private RegistryHolder(ResourceKey<? extends Registry<V>> registryKey) {
            this.registryKey = registryKey;
        }

        @Nullable
        public Registry<V> get() {
            if (this.registry == null) {
                this.registry = (Registry<V>) BuiltInRegistries.REGISTRY.get(this.registryKey.location());
            }

            return this.registry;
        }

        public ResourceKey<? extends Registry<V>> getRegistryKey() {
            return registryKey;
        }

        public Registry<V> getRegistry() {
            return registry;
        }

        public void setRegistry(Registry<V> registry) {
            this.registry = registry;
        }
    }
}
