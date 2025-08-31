package com.temporal.api.core.engine.io.metadata.strategy.method.event;

import com.temporal.api.core.engine.event.handler.EntityAttributeEventHandler;
import com.temporal.api.core.engine.io.metadata.annotation.event.CreateEntityAttributes;
import com.temporal.api.core.engine.io.metadata.strategy.method.MethodAnnotationStrategy;
import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.lang.reflect.Method;

public class CreateEntityAttributesStrategy implements MethodAnnotationStrategy<CreateEntityAttributes> {
    @Override
    public void execute(Method method, Object object, CreateEntityAttributes annotation) throws Exception {
        AttributeSupplier.Builder attributes = (AttributeSupplier.Builder) method.invoke(object);
        String[] entityTypeIds = annotation.value();
        for (String id : entityTypeIds) {
            Holder<? extends EntityType<?>> entityType = RegistryUtils.getEntityType(id).builtInRegistryHolder();
            EntityAttributeEventHandler.ENTITY_ATTRIBUTES.put(entityType, attributes);
        }
    }

    @Override
    public Class<? extends CreateEntityAttributes> getAnnotationClass() {
        return CreateEntityAttributes.class;
    }
}
