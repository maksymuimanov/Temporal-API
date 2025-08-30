package com.temporal.api.core.event.data.loot;

import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class MultipleOreLootProviderStrategy implements LootProviderStrategy {
    @Override
    public void generateLoot(Holder<? extends Block> blockRegistry, ApiBlockLootTableProvider provider, String... additionalData) {
        Block block = blockRegistry.value();
        String itemId = additionalData[0];
        float itemCountMin = Float.parseFloat(additionalData[1]);
        float itemCountMax = Float.parseFloat(additionalData[2]);
        Item item = RegistryUtils.getItem(itemId);
        HolderLookup.RegistryLookup<Enchantment> registrylookup = provider.getRegistries().lookupOrThrow(Registries.ENCHANTMENT);
        provider.add(block, provider.createSilkTouchDispatchTable(block, provider.applyExplosionDecay(block, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(itemCountMin, itemCountMax)))
                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))))));
    }
}
