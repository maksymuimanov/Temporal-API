package com.temporal.api.core.engine.event.data.enchantment;

import com.temporal.api.core.collection.TemporalMap;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.Map;

public class ApiEnchantmentProvider implements EnchantmentProvider {
    public static final Map<ResourceKey<Enchantment>, EnchantmentDescription> ENCHANTMENTS = new TemporalMap<>();

    @Override
    public void registerEnchantments(BootstrapContext<Enchantment> context) {
        HolderGetter<Enchantment> enchantments = context.lookup(Registries.ENCHANTMENT);
        HolderGetter<Item> items = context.lookup(Registries.ITEM);
        ENCHANTMENTS.forEach((enchantment, description) -> {
            Enchantment.Builder builder = description.build(enchantments, items);
            context.register(enchantment, builder.build(enchantment.location()));
        });
    }

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        EnchantmentProvider provider = new ApiEnchantmentProvider();
        provider.registerEnchantments(context);
    }
}
