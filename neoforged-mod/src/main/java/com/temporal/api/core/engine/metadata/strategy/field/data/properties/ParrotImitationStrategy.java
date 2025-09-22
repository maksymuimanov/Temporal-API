package com.temporal.api.core.engine.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.engine.event.data.map.ParrotImitationDto;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.properties.ParrotImitation;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class ParrotImitationStrategy implements FieldAnnotationStrategy<ParrotImitation> {
    @Override
    public void execute(Field field, Object object, ParrotImitation annotation) throws Exception {
        Holder<EntityType<?>> entityType = (Holder<EntityType<?>>) field.get(object);
        ParrotImitationDto parrotImitationDto = new ParrotImitationDto(entityType, annotation.soundEvent(), annotation.replace());
        ApiDataMapProvider.PARROT_IMITATIONS.add(parrotImitationDto);
    }

    @Override
    public Class<ParrotImitation> getAnnotationClass() {
        return ParrotImitation.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
