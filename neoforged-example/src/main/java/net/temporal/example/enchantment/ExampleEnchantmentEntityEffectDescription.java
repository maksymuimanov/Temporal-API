package net.temporal.example.enchantment;

import com.temporal.api.core.engine.event.data.enchantment.EnchantmentDescription;
import net.minecraft.core.HolderGetter;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;

public class ExampleEnchantmentEntityEffectDescription implements EnchantmentDescription {
    @Override
    public Enchantment.Builder build(HolderGetter<Enchantment> enchantments, HolderGetter<Item> items) {
        return Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                5,
                2,
                Enchantment.dynamicCost(5, 20),
                Enchantment.dynamicCost(55, 20),
                2,
                EquipmentSlotGroup.MAINHAND))
                .withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER, EnchantmentTarget.VICTIM, new ExampleEnchantmentEntityEffect());
    }
}
