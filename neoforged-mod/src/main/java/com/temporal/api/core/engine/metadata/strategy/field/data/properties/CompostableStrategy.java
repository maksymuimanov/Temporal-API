package com.temporal.api.core.engine.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.engine.event.data.map.CompostableDto;
import com.temporal.api.core.engine.metadata.annotation.data.properties.Compostable;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

public class CompostableStrategy implements FieldAnnotationStrategy<Compostable> {
    @Override
    public void execute(Field field, Object object, Compostable annotation) throws Exception {
        Holder<? extends Item> itemHolder = ReflectionUtils.getItemHolder(field, object);
        CompostableDto compostableDto = new CompostableDto(itemHolder, annotation.chance(), annotation.replace());
        ApiDataMapProvider.COMPOSTABLES.add(compostableDto);
    }

    @Override
    public Class<? extends Compostable> getAnnotationClass() {
        return Compostable.class;
    }
}
