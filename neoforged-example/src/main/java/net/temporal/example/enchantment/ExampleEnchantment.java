package net.temporal.example.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.temporal.example.damage.ExampleDamageTypes;
import org.jetbrains.annotations.NotNull;

public class ExampleEnchantment implements EnchantmentEntityEffect {
    public static final MapCodec<ExampleEnchantment> CODEC = MapCodec.unit(ExampleEnchantment::new);
    public static final float EXPLOSION_RADIUS = 2f;

    @Override
    public void apply(@NotNull ServerLevel serverLevel, int enchantmentLevel, @NotNull EnchantedItemInUse enchantedItemInUse, @NotNull Entity entity, @NotNull Vec3 vec3) {
        DamageSource damageSource = serverLevel.damageSources().source(ExampleDamageTypes.EXAMPLE_DAMAGE_TYPE);
        ExplosionDamageCalculator damageCalculator = new ExplosionDamageCalculator();
        for (int i = 0; i < enchantmentLevel; i++) {
            serverLevel.explode(entity, damageSource, damageCalculator, vec3, EXPLOSION_RADIUS, true, Level.ExplosionInteraction.MOB);
        }
    }

    @Override
    @NotNull
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
