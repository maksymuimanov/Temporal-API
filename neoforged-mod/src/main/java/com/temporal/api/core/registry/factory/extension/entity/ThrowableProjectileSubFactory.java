package com.temporal.api.core.registry.factory.extension.entity;

import com.temporal.api.client.dto.Size;
import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.EntityTypeFactory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.neoforged.neoforge.registries.DeferredHolder;

public interface ThrowableProjectileSubFactory {
    default <T extends ThrowableProjectile> DeferredHolder<EntityType<?>, EntityType<T>> createProjectile(String name, Size size, EntityType.EntityFactory<T> entityFactory) {
        EntityTypeFactory factory = InjectionPool.getFromInstance(EntityTypeFactory.class);
        return factory.create(name, entityFactory, size, MobCategory.MISC);
    }
}
