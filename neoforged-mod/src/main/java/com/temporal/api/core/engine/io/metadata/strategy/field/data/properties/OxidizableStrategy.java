package com.temporal.api.core.engine.io.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.io.metadata.annotation.data.properties.Oxidizable;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.event.data.map.OxidizableDto;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class OxidizableStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Oxidizable oxidizable = field.getAnnotation(Oxidizable.class);
        DeferredBlock<?> block = (DeferredBlock<?>) field.get(object);
        OxidizableDto oxidizableDto = new OxidizableDto(block, oxidizable.nextBlockStageId(), oxidizable.replace());
        ApiDataMapProvider.OXIDIZABLES.add(oxidizableDto);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return Oxidizable.class;
    }
}
