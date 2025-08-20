package com.temporal.api.core.registry.factory.extension.entity;

import com.temporal.api.client.dto.Size;
import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.common.EntityTypeFactory;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.ThrowableProjectile;

public interface ThrowableProjectileSubFactory {
    default <T extends ThrowableProjectile> Holder<EntityType<?>> createProjectile(String name, Size size, EntityType.EntityFactory<T> entityFactory) {
        EntityTypeFactory factory = InjectionPool.getFromInstance(EntityTypeFactory.class);
        return factory.create(name, entityFactory, size, MobCategory.MISC);
    }
}
