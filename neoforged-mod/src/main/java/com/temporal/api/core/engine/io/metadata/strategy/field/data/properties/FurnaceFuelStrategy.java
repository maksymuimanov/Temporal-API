package com.temporal.api.core.engine.io.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.io.metadata.annotation.data.properties.FurnaceFuel;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.event.data.map.FurnaceFuelDto;
import net.minecraft.core.Holder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FurnaceFuelStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        FurnaceFuel fuel = field.getAnnotation(FurnaceFuel.class);
        FurnaceFuelDto fuelDto;
        Object o = field.get(object);
        fuelDto = switch (o) {
            case DeferredItem<?> item -> new FurnaceFuelDto(item, fuel.burnTime(), fuel.replace());
            case DeferredBlock<?> block -> new FurnaceFuelDto(Holder.direct(block.asItem()), fuel.burnTime(), fuel.replace());
            case null, default -> throw new RuntimeException();
        };
        ApiDataMapProvider.FURNACE_FUELS.add(fuelDto);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return FurnaceFuel.class;
    }
}
