package com.temporal.api.core.engine.io.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.io.metadata.annotation.data.properties.Compostable;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.event.data.map.CompostableDto;
import net.minecraft.core.Holder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class CompostableStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Compostable compostable = field.getAnnotation(Compostable.class);
        CompostableDto compostableDto;
        Object o = field.get(object);
        compostableDto = switch (o) {
            case DeferredItem<?> item -> new CompostableDto(item, compostable.chance(), compostable.replace());
            case DeferredBlock<?> block -> new CompostableDto(Holder.direct(block.asItem()), compostable.chance(), compostable.replace());
            case null, default -> throw new RuntimeException();
        };
        ApiDataMapProvider.COMPOSTABLES.add(compostableDto);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return Compostable.class;
    }
}
