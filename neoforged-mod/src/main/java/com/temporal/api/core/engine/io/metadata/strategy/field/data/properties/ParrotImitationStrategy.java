package com.temporal.api.core.engine.io.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.io.metadata.annotation.data.properties.ParrotImitation;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.event.data.map.ParrotImitationDto;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;

import java.lang.reflect.Field;

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
}
