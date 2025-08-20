package com.temporal.api.core.event.data.modifier;

import net.minecraft.world.item.Item;

public interface ChestModifierDescription {
    String getModifierName();

    Item getItem();

    String getChestId();

    float getChance();
}
