package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.metadata.strategy.method.MethodAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.method.event.CreateEntityAttributesStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class EntityAttributeEventHandler implements EventHandler {
    public static final Map<Holder<? extends EntityType<?>>, AttributeSupplier.Builder> ENTITY_ATTRIBUTES = new TemporalMap<>();
    private static final Map<Class<? extends Annotation>, MethodAnnotationStrategy<?>> STRATEGIES = ReflectionUtils.createAnnotationStrategyMap(List.of(
            new CreateEntityAttributesStrategy()
    ));


    @Override
    public void handle() {
        this.subscribeModEvent(EntityAttributeCreationEvent.class, event -> {
            IOLayer.ASYNC_STRATEGY_CONSUMER.execute(IOLayer.STATIC_METHOD_EXECUTOR, STRATEGIES, IOLayer.NEO_MOD.getClasses());
            ENTITY_ATTRIBUTES.forEach((holder, attributes) -> {
                event.put((EntityType<? extends LivingEntity>) holder.value(), attributes.build());
            });
        });
    }
}
