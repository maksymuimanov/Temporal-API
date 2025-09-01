package com.temporal.api.core.util;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public final class RegistryUtils {
    private RegistryUtils() {
    }

    public static SoundEvent getSoundEvent(String id) {
        return getObject(BuiltInRegistries.SOUND_EVENT, id);
    }

    public static Item getItem(String id) {
        return getObject(BuiltInRegistries.ITEM, id);
    }

    public static Block getBlock(String id) {
        return getObject(BuiltInRegistries.BLOCK, id);
    }

    public static BlockEntityType<?> getBlockEntityType(String id) {
        return getObject(BuiltInRegistries.BLOCK_ENTITY_TYPE, id);
    }

    public static EntityType<?> getEntityType(String id) {
        return getObject(BuiltInRegistries.ENTITY_TYPE, id);
    }

    public static <T> T getObject(Registry<T> registry, String id) {
        return registry.get(ResourceUtils.parse(id));
    }

    public static <T> Stream<T> getObjectsByCondition(Registry<T> registry, Predicate<T> condition) {
        return registry.stream()
                .filter(condition);
    }

    public static <T> String getObjectName(Registry<T> registry, T value) {
        return getObjectName(registry, value, "");
    }

    public static <T> String getObjectName(Registry<T> registry, T value, String prefix) {
        ResourceLocation location = Objects.requireNonNull(registry.getKey(value));
        return location.getNamespace() + ":" + prefix + "/" + location.getPath();
    }
}
