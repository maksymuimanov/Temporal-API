package com.temporal.api.core.event.data.enchantment;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.event.data.preparer.tag.enchantment.EnchantmentTagDynamicPreparer;
import com.temporal.api.core.event.data.preparer.tag.item.ItemTagDynamicPreparer;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.Map;

//TODO: For the future updates: this class should either be refactored or contain more effect holders - #w4t3rcs
public class ApiEnchantmentProvider implements EnchantmentProvider {
    public static final Map<ResourceKey<Enchantment>, EnchantmentDescriptionHolder> ENCHANTMENTS = new TemporalMap<>();
    public static final Map<ResourceKey<Enchantment>, EnchantmentEntityEffectHolder> ENTITY_EFFECTS = new TemporalMap<>();

    @Override
    public void registerEnchantments(BootstrapContext<Enchantment> context) {
        HolderGetter<Enchantment> enchantments = context.lookup(Registries.ENCHANTMENT);
        HolderGetter<Item> items = context.lookup(Registries.ITEM);
        ENCHANTMENTS.forEach((enchantment, description) -> {
            EnchantmentCompatibility compatibility = description.compatibility();
            EnchantmentCost cost = description.cost();
            Enchantment.Builder builder = Enchantment.enchantment(Enchantment.definition(
                            items.getOrThrow(ItemTagDynamicPreparer.ITEM_TAGS.get(compatibility.compatibleItemsTag())),
                            items.getOrThrow(ItemTagDynamicPreparer.ITEM_TAGS.get(compatibility.primaryItemsTag())),
                            description.weight(),
                            description.maxLevel(),
                            cost.minCost(),
                            cost.maxCost(),
                            cost.anvilCost(),
                            description.equipmentSlots()))
                    .exclusiveWith(enchantments.getOrThrow(EnchantmentTagDynamicPreparer.ENCHANTMENT_TAGS.get(compatibility.incompatibleEnchantmentId())));
            if (ENTITY_EFFECTS.containsKey(enchantment)) {
                var effectHolder = ENTITY_EFFECTS.get(enchantment);
                builder.withEffect(effectHolder.getDataComponent(), effectHolder.getEnchanted(), effectHolder.getAffected(), effectHolder.getEffect());
            }

            context.register(enchantment, builder.build(enchantment.location()));
        });
    }

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        EnchantmentProvider provider = new ApiEnchantmentProvider();
        provider.registerEnchantments(context);
    }
}
