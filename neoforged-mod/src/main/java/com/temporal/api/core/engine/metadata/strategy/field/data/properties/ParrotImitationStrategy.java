package com.temporal.api.core.engine.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.engine.event.data.map.ParrotImitationDto;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.data.properties.ParrotImitation;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class ParrotImitationStrategy implements FieldAnnotationStrategy<ParrotImitation> {
    @Override
    public void execute(Field field, Object object, ParrotImitation annotation) throws Exception {
        Holder<EntityType<?>> entityType = (Holder<EntityType<?>>) field.get(object);
        ParrotImitationDto parrotImitationDto = new ParrotImitationDto(entityType, annotation.soundEventId(), annotation.replace());
        ApiDataMapProvider.PARROT_IMITATIONS.add(parrotImitationDto);
    }

    @Override
    public Class<? extends ParrotImitation> getAnnotationClass() {
        return ParrotImitation.class;
    }

    @Override
    public AnnotationExecutor<? extends AnnotationStrategy<Field, ?>> getExecutor() {
        return MetadataLayer.STATIC_FIELD_EXECUTOR;
    }
}
