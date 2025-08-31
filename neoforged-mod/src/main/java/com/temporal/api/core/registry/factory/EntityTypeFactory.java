package com.temporal.api.core.registry.factory;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.TemporalRegister;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;

public class EntityTypeFactory extends AbstractObjectFactory<EntityType<?>> {
    public EntityTypeFactory() {
        this(InjectionPool.getFromInstance("$EntityTypes"));
    }

    public EntityTypeFactory(TemporalRegister<EntityType<?>> entityTypes) {
        super(entityTypes);
    }

    public <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> create(String name, EntityType.EntityFactory<T> entityFactory, MobCategory category, float width, float height) {
        return this.create(name, EntityType.Builder.of(entityFactory, category)
                .sized(width, height));
    }

    public <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return this.create(name, builder, ResourceUtils.createKey(Registries.ENTITY_TYPE, name));
    }

    public <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> create(String name, EntityType.Builder<T> builder, ResourceKey<EntityType<?>> entityType) {
        return this.create(name, () -> builder.build(entityType.registry().toString()));
    }
}
