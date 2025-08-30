package com.temporal.api.core.event.data.loot;

import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;

public class CropLootProviderStrategy implements LootProviderStrategy {
    @Override
    public void generateLoot(Holder<? extends Block> blockRegistry, ApiBlockLootTableProvider provider, String... additionalData) {
        Block block = blockRegistry.value();
        String grownItemId = additionalData[0];
        Item grownItem = RegistryUtils.getItem(grownItemId);
        String seedsItemId = additionalData[1];
        Item seedsItem = RegistryUtils.getItem(seedsItemId);
        int grownAge = Integer.parseInt(additionalData[2]);
        int minAge = Integer.parseInt(additionalData[3]);
        int maxAge = Integer.parseInt(additionalData[4]);
        provider.add(block, provider.createCropDrops(block, grownItem, seedsItem, LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                .setProperties(StatePropertiesPredicate.Builder.properties()
                        .hasProperty(IntegerProperty.create("age", minAge, maxAge), grownAge))));
    }
}
