package com.temporal.api.core.util;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public final class EnumExtensionUtils {
    private EnumExtensionUtils() {
    }

    public static Object createBoatType(int id, Class<?> type, String planksBlockId, String name, String boatItemId, String chestBoatItemId) {
        if (id == 5)
            return false;
        return type.cast(switch (id) {
            case 0 -> (Supplier<Block>) () -> (Block) RegistryUtils.getBlock(planksBlockId);
            case 1 -> name;
            case 2 -> (Supplier<Item>) () -> (Item) RegistryUtils.getItem(boatItemId);
            case 3 -> (Supplier<Item>) () -> (Item) RegistryUtils.getItem(chestBoatItemId);
            case 4 -> (Supplier<Item>) () -> Items.STICK;
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + id);
        });
    }
}
