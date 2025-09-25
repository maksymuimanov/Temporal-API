package com.temporal.api.core.engine.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

public class EntityTypeTransformer implements KeyTransformer<ResourceKey<EntityType<?>>> {
    public static final String PREFIX = "entity";

    @Override
    public String transform(ResourceKey<EntityType<?>> entityType) {
        return this.transformResourceKey(PREFIX, entityType);
    }
}
