package com.temporal.api.core.util;

import com.temporal.api.core.engine.io.IOLayer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Objects;
import java.util.function.Predicate;

public final class RegistryUtils {
    private RegistryUtils() {
    }

    @Deprecated(since = "1.9.0", forRemoval = true)
    public static DeferredRegister.Items createItemRegistry() {
        return DeferredRegister.createItems(IOLayer.NEO_MOD.getModId());
    }

    @Deprecated(since = "1.9.0", forRemoval = true)
    public static DeferredRegister.Blocks createBlockRegistry() {
        return DeferredRegister.createBlocks(IOLayer.NEO_MOD.getModId());
    }

    @Deprecated(since = "1.9.0", forRemoval = true)
    public static <T> DeferredRegister<T> createRegistry(ResourceKey<Registry<T>> registry) {
        return DeferredRegister.create(registry, IOLayer.NEO_MOD.getModId());
    }

    public static SoundEvent getSoundEvent(String id) {
        return getObjectByCondition(BuiltInRegistries.SOUND_EVENT, soundEvent -> soundEvent.getLocation()
                .equals(ResourceUtils.parse(id)));
    }

    public static Item getItem(String id) {
        return getObjectByCondition(BuiltInRegistries.ITEM, item -> Objects.requireNonNull(item.getDefaultInstance()
                        .getItemHolder()
                        .getKey())
                .location()
                .equals(ResourceUtils.parse(id)));
    }

    public static Block getBlock(String id) {
        return getObjectByCondition(BuiltInRegistries.BLOCK, block -> Objects.requireNonNull(block.defaultBlockState()
                        .getBlockHolder()
                        .getKey())
                .location()
                .equals(ResourceUtils.parse(id)));
    }

    public static BlockEntityType<?> getBlockEntityType(String id) {
        return getObjectByCondition(BuiltInRegistries.BLOCK_ENTITY_TYPE, blockEntityType -> Objects.requireNonNull(blockEntityType.builtInRegistryHolder())
                .getKey()
                .location()
                .equals(ResourceUtils.parse(id)));
    }

    public static EntityType<?> getEntityType(String id) {
        return getObjectByCondition(BuiltInRegistries.ENTITY_TYPE, entityType -> Objects.requireNonNull(entityType.builtInRegistryHolder())
                .getKey()
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
