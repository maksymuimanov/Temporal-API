package com.temporal.api.core.engine.event.data.loot.strategy;

import com.temporal.api.core.engine.event.data.loot.ApiBlockLootTableProvider;
import com.temporal.api.core.engine.event.data.loot.LootProviderStrategy;
import com.temporal.api.core.engine.event.data.loot.spec.CropBlockLootTableSpec;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;

public class CropLootProviderStrategy implements LootProviderStrategy<CropBlockLootTableSpec> {
    public static final String AGE_PROPERTY = "age";

    @Override
    public void generateLoot(CropBlockLootTableSpec spec, ApiBlockLootTableProvider provider) {
        Block block = spec.getBlock();
        Item grownItem = spec.getGrownItem();
        Item seedsItem = spec.getSeedsItem();
        int grownAge = spec.getGrownAge();
        int minAge = spec.getMinAge();
        int maxAge = spec.getMaxAge();
        provider.add(block, provider.createCropDrops(block, grownItem, seedsItem, LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                .setProperties(StatePropertiesPredicate.Builder.properties()
                        .hasProperty(IntegerProperty.create(AGE_PROPERTY, minAge, maxAge), grownAge))));
    }
}
