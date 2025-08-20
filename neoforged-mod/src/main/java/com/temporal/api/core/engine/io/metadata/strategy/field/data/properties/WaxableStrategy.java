package com.temporal.api.core.engine.io.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.io.metadata.annotation.data.properties.Waxable;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.event.data.map.WaxableDto;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class WaxableStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Waxable waxable = field.getAnnotation(Waxable.class);
        DeferredBlock<?> block = (DeferredBlock<?>) field.get(object);
        WaxableDto waxableDto = new WaxableDto(block, waxable.waxedBlock(), waxable.replace());
        ApiDataMapProvider.WAXABLES.add(waxableDto);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return Waxable.class;
    }
}
