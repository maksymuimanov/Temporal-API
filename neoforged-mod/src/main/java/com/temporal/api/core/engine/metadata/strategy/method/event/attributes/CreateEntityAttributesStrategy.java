package com.temporal.api.core.engine.metadata.strategy.method.event.attributes;

import com.temporal.api.core.engine.event.handler.EntityAttributeEventHandler;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.event.attributes.CreateEntityAttributes;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.EntityAttributeEventAnnotationProcessor;
import com.temporal.api.core.engine.metadata.strategy.method.MethodAnnotationStrategy;
import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.lang.reflect.Method;

@Strategy(StrategyPoolInitializer.DEFAULT_METHOD_EVENT_ATTRIBUTES)
public class CreateEntityAttributesStrategy implements MethodAnnotationStrategy<CreateEntityAttributes> {
    @SuppressWarnings("deprecation")
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
    public Class<CreateEntityAttributes> getAnnotationClass() {
        return CreateEntityAttributes.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(EntityAttributeEventAnnotationProcessor.NAME);
    }
}
