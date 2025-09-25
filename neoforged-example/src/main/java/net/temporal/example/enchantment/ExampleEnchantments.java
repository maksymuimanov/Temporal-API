package net.temporal.example.enchantment;

import com.temporal.api.core.engine.metadata.annotation.data.GenerateEnchantment;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public final class ExampleEnchantments {
    @TranslateAmericanEnglish("Example Enchantment")
    @GenerateEnchantment(ExampleEnchantmentEntityEffectDescription.class)
    public static final ResourceKey<Enchantment> EXAMPLE_ENCHANTMENT = ResourceUtils.createKey(Registries.ENCHANTMENT, "example_enchantment_entity_effect");
}
