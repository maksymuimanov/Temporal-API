package com.temporal.api.core.engine.event.data.loot.strategy;

import com.temporal.api.core.engine.event.data.loot.ApiBlockLootTableProvider;
import com.temporal.api.core.engine.event.data.loot.LootProviderStrategy;
import com.temporal.api.core.engine.event.data.loot.spec.OtherItemBlockLootTableSpec;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

public class GrassLootProviderStrategy implements LootProviderStrategy<OtherItemBlockLootTableSpec> {
    public static final float RANDOM_CHANCE = 0.125F;
    public static final int BONUS_MULTIPLIER = 2;

    @Override
    public void generateLoot(OtherItemBlockLootTableSpec spec, ApiBlockLootTableProvider provider) {
        Block block = spec.getBlock();
        Item seedsItem = spec.getOtherItem();
        HolderLookup.RegistryLookup<Enchantment> registrylookup = provider.getRegistries().lookupOrThrow(Registries.ENCHANTMENT);
        provider.add(block, provider.createShearsDispatchTable(block, provider.applyExplosionDecay(block, LootItem.lootTableItem(seedsItem)
                        .when(LootItemRandomChanceCondition.randomChance(RANDOM_CHANCE)))
                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE), BONUS_MULTIPLIER))));
    }
}
