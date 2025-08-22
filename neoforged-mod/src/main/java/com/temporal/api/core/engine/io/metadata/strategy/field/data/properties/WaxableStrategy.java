package com.temporal.api.core.engine.io.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.io.metadata.annotation.data.properties.Waxable;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.event.data.map.WaxableDto;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.lang.reflect.Field;

public class WaxableStrategy implements FieldAnnotationStrategy<Waxable> {
    @Override
    public void execute(Field field, Object object, Waxable annotation) throws Exception {
        DeferredBlock<?> block = (DeferredBlock<?>) field.get(object);
        WaxableDto waxableDto = new WaxableDto(block, annotation.waxedBlock(), annotation.replace());
        ApiDataMapProvider.WAXABLES.add(waxableDto);
    }

    @Override
    public Class<? extends Waxable> getAnnotationClass() {
        return Waxable.class;
    }
}
