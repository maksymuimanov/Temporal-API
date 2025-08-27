package com.temporal.api.core.registry.factory;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SimpleTier;

public final class ToolTierFactory {
    private ToolTierFactory() {
    }

    public static Tier create(TagKey<Block> incorrectBlocksForDrops, Item ingredient, int uses, float speed, float attackDamageBonus, int enchantmentValue) {
        return new SimpleTier(incorrectBlocksForDrops, uses, speed, attackDamageBonus, enchantmentValue, () -> Ingredient.of(ingredient));
    }
}
