package com.temporal.api.core.engine.registry;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.context.ModContext;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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

    protected TemporalRegister(final ResourceKey<? extends Registry<T>> registryKey, final String namespace) {
        super(registryKey, namespace);
        entries = new LinkedHashMap<>();
        entriesView = Collections.unmodifiableSet(entries.keySet());
        aliases = new HashMap<>();
        seenRegisterEvent = false;
        seenNewRegistryEvent = false;
        registeredEventBus = false;
    }

    public static <T> TemporalRegister<T> create(final Registry<T> registry) {
        return TemporalRegister.create(registry, ModContext.NEO_MOD.getModId());
    }

    public static <T> TemporalRegister<T> create(final Registry<T> registry, final String namespace) {
        return new TemporalRegister<>(registry.key(), namespace);
    }

    public static <T> TemporalRegister<T> create(final ResourceKey<? extends Registry<T>> key) {
        return TemporalRegister.create(key, ModContext.NEO_MOD.getModId());
    }

    public static <T> TemporalRegister<T> create(final ResourceKey<? extends Registry<T>> key, final String namespace) {
        return new TemporalRegister<>(key, namespace);
    }

    public static <T> TemporalRegister<T> create(@NotNull final ResourceLocation registryName) {
        return TemporalRegister.create(registryName, ModContext.NEO_MOD.getModId());
    }

    public static <T> TemporalRegister<T> create(@NotNull final ResourceLocation registryName, final String namespace) {
        return new TemporalRegister<>(ResourceKey.createRegistryKey(registryName), namespace);
    }

    public void register(@NotNull final IEventBus eventBus, @NotNull final Class<?>... containers) {
        final ResourceKey<? extends Registry<T>> registryKey = getRegistryKey();
        ApiMod.LOGGER.info("Registering DeferredRegister {} to EventBus with containers: [{}]", registryKey, Arrays.toString(containers));
        if (registeredEventBus) {
            ApiMod.LOGGER.error("DeferredRegister {} is already registered to an EventBus", registryKey);
            throw new IllegalStateException("Cannot register DeferredRegister to more than one eventClass bus.");
        } else {
            eventBus.addListener((RegisterEvent event) -> this.addEntries(event, containers));
            eventBus.addListener(this::addRegistry);
            registeredEventBus = true;
            ApiMod.LOGGER.debug("DeferredRegister {} successfully bound to EventBus", registryKey);
        }
    }

    @Override
    @NotNull
    public <I extends T> DeferredHolder<T, I> register(@NotNull final String name, @NotNull final Function<ResourceLocation, ? extends I> function) {
        final ResourceKey<? extends Registry<T>> registryKey = getRegistryKey();
        ApiMod.LOGGER.debug("Attempting to register entry '{}' in registry {}", name, registryKey);
        if (seenRegisterEvent) {
            ApiMod.LOGGER.error("RegisterEvent already fired! Cannot register '{}'", name);
            throw new IllegalStateException("Cannot register new entries to DeferredRegister after RegisterEvent has been fired.");
        } else {
            Objects.requireNonNull(name);
            Objects.requireNonNull(function);
            final ResourceLocation key = ResourceLocation.fromNamespaceAndPath(getNamespace(), name);
            final DeferredHolder<T, I> holder = createHolder(registryKey, key);
            if (null != this.getEntriesMap().putIfAbsent(holder, () -> function.apply(key))) {
                ApiMod.LOGGER.error("Duplicate registration attempted for '{}'", name);
                throw new IllegalArgumentException("Duplicate registration " + name);
            } else {
                ApiMod.LOGGER.info("Successfully registered entry '{}' with id={}", name, key);
                return holder;
            }
        }
    }

    protected void addEntries(final RegisterEvent event, final Class<?>... containers) {
        final ResourceKey<? extends Registry<T>> registryKey = getRegistryKey();
        if (event.getRegistryKey().equals(registryKey)) {
            ApiMod.LOGGER.info("Processing RegisterEvent for registry {} with containers: [{}]", registryKey, Arrays.toString(containers));
            loadFields(containers);
            seenRegisterEvent = true;
            final Registry<T> registry = event.getRegistry(registryKey);
            final Map<ResourceLocation, ResourceLocation> aliases = aliases;
            Objects.requireNonNull(registry);
            ApiMod.LOGGER.debug("Applying {} aliases for registry {}", aliases.size(), registryKey);
            aliases.forEach((from, to) -> {
                ApiMod.LOGGER.debug("Adding alias {} -> {}", from, to);
                registry.addAlias(from, to);
            });
            for (final Map.Entry<DeferredHolder<T, ? extends T>, Supplier<? extends T>> entry : entries.entrySet()) {
                final DeferredHolder<T, ? extends T> holder = entry.getKey();
                ApiMod.LOGGER.debug("Registering holder {} with id: {}", holder, holder.getId());
                event.register(registryKey, holder.getId(), () -> entry.getValue().get());
                holder.isBound();
            }
            ApiMod.LOGGER.info("Completed RegisterEvent for registry {}", registryKey);
        }
    }

    protected void loadFields(final Class<?>... containers) {
        for (final Class<?> container : containers) {
            for (final Field field : container.getDeclaredFields()) {
                try {
                    ApiMod.LOGGER.debug("Loading field {}.{}", container.getName(), field.getName());
                    field.setAccessible(true);
                    field.get(null);
                } catch (final IllegalAccessException e) {
                    ApiMod.LOGGER.error("Failed to load field {}.{}: {}", container.getName(), field.getName(), e.getMessage());
                    throw new RuntimeException(e);
                }
            }
        }
    }

    protected void addRegistry(final NewRegistryEvent event) {
        seenNewRegistryEvent = true;
        final ResourceKey<? extends Registry<T>> registryKey = getRegistryKey();
        ApiMod.LOGGER.info("Handling NewRegistryEvent for {}", registryKey);
        final Registry<T> customRegistry = customRegistry;
        if (null != customRegistry) {
            ApiMod.LOGGER.debug("Registering custom registry {}", customRegistry);
            event.register(Objects.requireNonNull(customRegistry));
        } else {
            ApiMod.LOGGER.warn("NewRegistryEvent fired but no custom registry set for {}", registryKey);
        }
    }

    @Override
    @NotNull
    public Registry<T> makeRegistry(@NotNull final Consumer<RegistryBuilder<T>> consumer) {
        return makeRegistry(getRegistryKey().location(), consumer);
    }

    protected Registry<T> makeRegistry(final ResourceLocation registryName, final Consumer<RegistryBuilder<T>> consumer) {
        ApiMod.LOGGER.debug("Creating registry with name - {}", registryName);
        if (null == registryName) {
            ApiMod.LOGGER.error("Cannot create a registry without specifying a registry name");
            throw new IllegalStateException("Cannot create a registry without specifying a registry name");
        } else if (!BuiltInRegistries.REGISTRY.containsKey(registryName) && null == this.getCustomRegistry()) {
            if (seenNewRegistryEvent) {
                ApiMod.LOGGER.error("NewRegistryEvent already fired, cannot create new registry {}", registryName);
                throw new IllegalStateException("Cannot create a registry after NewRegistryEvent was fired");
            } else {
                final ResourceKey<? extends Registry<T>> registryKey = getRegistryKey();
                final RegistryBuilder<T> registryBuilder = new RegistryBuilder<>(registryKey);
                consumer.accept(registryBuilder);
                customRegistry = registryBuilder.create();
                registryHolder = new RegistryHolder<>(registryKey);
                final Registry<T> customRegistry = customRegistry;
                Objects.requireNonNull(registryHolder).setRegistry(customRegistry);
                ApiMod.LOGGER.info("Successfully created custom registry - {}", registryName);
                return customRegistry;
            }
        } else {
            ApiMod.LOGGER.error("Registry {} already exists or custom registry already set", registryName);
            throw new IllegalStateException("Cannot create a registry that already exists - " + registryName);
        }
    }

    public void addAlias(@NotNull final ResourceLocation from, @NotNull final ResourceLocation to) {
        ApiMod.LOGGER.debug("Adding alias {} -> {}", from, to);
        if (seenRegisterEvent) {
            ApiMod.LOGGER.error("Cannot add alias {} -> {} after RegisterEvent fired", from, to);
            throw new IllegalStateException("Cannot add aliases to DeferredRegister after RegisterEvent has been fired.");
        } else {
            aliases.put(from, to);
        }
    }

    @Override
    @NotNull
    public Supplier<Registry<T>> getRegistry() {
        if (null == this.getRegistryHolder()) {
            registryHolder = new RegistryHolder<>(getRegistryKey());
        }
        return registryHolder;
    }

    public Map<DeferredHolder<T, ? extends T>, Supplier<? extends T>> getEntriesMap() {
        return this.entries;
    }

    @Override
    @NotNull
    public Collection<DeferredHolder<T, ? extends T>> getEntries() {
        return this.entriesView;
    }

    public Set<DeferredHolder<T, ? extends T>> getEntriesView() {
        return this.entriesView;
    }

    public Map<ResourceLocation, ResourceLocation> getAliases() {
        return this.aliases;
    }

    public void setAliases(final Map<ResourceLocation, ResourceLocation> aliases) {
        this.aliases = aliases;
    }

    public boolean isSeenRegisterEvent() {
        return this.seenRegisterEvent;
    }

    public void setSeenRegisterEvent(final boolean seenRegisterEvent) {
        this.seenRegisterEvent = seenRegisterEvent;
    }

    public boolean isSeenNewRegistryEvent() {
        return this.seenNewRegistryEvent;
    }

    public void setSeenNewRegistryEvent(final boolean seenNewRegistryEvent) {
        this.seenNewRegistryEvent = seenNewRegistryEvent;
    }

    public boolean isRegisteredEventBus() {
        return this.registeredEventBus;
    }

    public void setRegisteredEventBus(final boolean registeredEventBus) {
        this.registeredEventBus = registeredEventBus;
    }

    @Nullable
    public Registry<T> getCustomRegistry() {
        return this.customRegistry;
    }

    public void setCustomRegistry(@Nullable final Registry<T> customRegistry) {
        this.customRegistry = customRegistry;
    }

    @Nullable
    public RegistryHolder<T> getRegistryHolder() {
        return this.registryHolder;
    }

    public void setRegistryHolder(@Nullable final RegistryHolder<T> registryHolder) {
        this.registryHolder = registryHolder;
    }

    @SuppressWarnings("unchecked")
    public static class RegistryHolder<V> implements Supplier<Registry<V>> {
        private final ResourceKey<? extends Registry<V>> registryKey;
        private Registry<V> registry;

        private RegistryHolder(final ResourceKey<? extends Registry<V>> registryKey) {
            this.registryKey = registryKey;
        }

        @Nullable
        public Registry<V> get() {
            if (null == this.registry) {
                registry = (Registry<V>) BuiltInRegistries.REGISTRY.get(registryKey.location());
            }

            return registry;
        }

        public ResourceKey<? extends Registry<V>> getRegistryKey() {
            return this.registryKey;
        }

        public Registry<V> getRegistry() {
            return this.registry;
        }

        public void setRegistry(final Registry<V> registry) {
            this.registry = registry;
        }
    }
}
