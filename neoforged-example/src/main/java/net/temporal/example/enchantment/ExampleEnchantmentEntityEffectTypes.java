package net.temporal.example.enchantment;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.EnchantmentEntityEffectTypeFactory;
import net.neoforged.neoforge.registries.DeferredHolder;

public final class ExampleEnchantmentEntityEffectTypes {
    private static final EnchantmentEntityEffectTypeFactory FACTORY = InjectionPool.getFromInstance(EnchantmentEntityEffectTypeFactory.class);

    public static final DeferredHolder<?, ?> EXAMPLE_ENCHANTMENT_ENTITY_EFFECT = FACTORY.create("example_enchantment_entity_effect", () -> ExampleEnchantmentEntityEffect.CODEC);
}