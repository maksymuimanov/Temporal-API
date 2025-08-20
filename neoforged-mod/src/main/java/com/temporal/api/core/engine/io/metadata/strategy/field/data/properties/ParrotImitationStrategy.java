package com.temporal.api.core.engine.io.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.io.metadata.annotation.data.properties.ParrotImitation;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.event.data.map.ParrotImitationDto;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ParrotImitationStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        ParrotImitation parrotImitation = field.getAnnotation(ParrotImitation.class);
        Holder<EntityType<?>> entityType = (Holder<EntityType<?>>) field.get(object);
        ParrotImitationDto parrotImitationDto = new ParrotImitationDto(entityType, parrotImitation.soundEventId(), parrotImitation.replace());
        ApiDataMapProvider.PARROT_IMITATIONS.add(parrotImitationDto);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return ParrotImitation.class;
    }
}
