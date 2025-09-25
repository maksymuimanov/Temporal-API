package com.temporal.api.core.engine.registry.extension.entity;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.EntityTypeFactory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.neoforged.neoforge.registries.DeferredHolder;

public interface ThrowableProjectileSubFactory {
    default <T extends ThrowableProjectile> DeferredHolder<EntityType<?>, EntityType<T>> createProjectile(String name, float width, float height, EntityType.EntityFactory<T> entityFactory) {
        EntityTypeFactory factory = InjectionPool.getFromInstance(EntityTypeFactory.class);
        return factory.create(name, entityFactory, MobCategory.MISC, width, height);
    }
}
