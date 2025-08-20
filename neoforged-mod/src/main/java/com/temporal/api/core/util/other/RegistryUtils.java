package com.temporal.api.core.util.other;

import com.temporal.api.core.engine.io.IOLayer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public final class RegistryUtils {
    private RegistryUtils() {
    }

    public static DeferredRegister.Items createItemRegistry() {
        return DeferredRegister.createItems(IOLayer.NEO_MOD.getModId());
    }

    public static DeferredRegister.Blocks createBlockRegistry() {
        return DeferredRegister.createBlocks(IOLayer.NEO_MOD.getModId());
    }

    public static <T> DeferredRegister<T> createRegistry(ResourceKey<Registry<T>> registry) {
        return DeferredRegister.create(registry, IOLayer.NEO_MOD.getModId());
    }

    public static String mapId(String id, Function<String, String> pathMapper) {
        return mapId(id, (namespace) -> namespace, pathMapper);
    }

    public static String mapId(String id, Function<String, String> namespaceMapper, Function<String, String> pathMapper) {
        String[] resource = id.split(":");
        return namespaceMapper.apply(resource[0]) + ":" + pathMapper.apply(resource[1]);
    }

    public static SoundEvent getSoundEventById(String id) {
        return getObjectByCondition(BuiltInRegistries.SOUND_EVENT, soundEvent -> soundEvent.getLocation()
                .equals(ResourceUtils.parse(id)));
    }

    public static Item getItemById(String id) {
        return getObjectByCondition(BuiltInRegistries.ITEM, item -> Objects.requireNonNull(item.getDefaultInstance()
                        .getItemHolder()
                        .getKey())
                .location()
                .equals(ResourceUtils.parse(id)));
    }

    public static Block getBlockById(String id) {
        return getObjectByCondition(BuiltInRegistries.BLOCK, block -> Objects.requireNonNull(block.defaultBlockState()
                        .getBlockHolder()
                        .getKey())
                .location()
                .equals(ResourceUtils.parse(id)));
    }

    public static <T> T getObjectByCondition(Registry<T> registry, Predicate<T> condition) {
        return registry.stream()
                .filter(condition)
                .findFirst()
                .orElseThrow();
    }

    public static <T> String getIdFromRegistry(Registry<T> registry, T value) {
        return getIdFromRegistry(registry, value, "");
    }

    public static <T> String getIdFromRegistry(Registry<T> registry, T value, String prefix) {
        ResourceLocation location = Objects.requireNonNull(registry.getKey(value));
        return location.getNamespace() + ":" + prefix + "/" + location.getPath();
    }
}
