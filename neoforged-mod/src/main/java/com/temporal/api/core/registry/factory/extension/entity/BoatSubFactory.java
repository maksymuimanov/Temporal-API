package com.temporal.api.core.registry.factory.extension.entity;

import com.temporal.api.client.dto.Size;
import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.common.EntityTypeFactory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.neoforged.neoforge.registries.DeferredHolder;

public interface BoatSubFactory {
    default <T extends Boat> DeferredHolder<EntityType<?>, EntityType<T>> createBoat(String name, EntityType.EntityFactory<T> entityFactory) {
        EntityTypeFactory factory = InjectionPool.getFromInstance(EntityTypeFactory.class);
        return factory.create(name, entityFactory, new Size(1.375f, 0.5625f), MobCategory.MISC);
    }
}
