package com.temporal.api.core.engine.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.engine.event.data.map.FurnaceFuelDto;
import com.temporal.api.core.engine.metadata.annotation.data.properties.FurnaceFuel;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.lang.reflect.Field;

public class FurnaceFuelStrategy implements FieldAnnotationStrategy<FurnaceFuel> {
    @Override
    public void execute(Field field, Object object, FurnaceFuel annotation) throws Exception {
        FurnaceFuelDto fuelDto;
        Object o = field.get(object);
        fuelDto = switch (o) {
            case DeferredItem<?> item -> new FurnaceFuelDto(item, annotation.burnTime(), annotation.replace());
            case DeferredBlock<?> block -> new FurnaceFuelDto(Holder.direct(block.asItem()), annotation.burnTime(), annotation.replace());
            case null, default -> throw new RuntimeException();
        };
        ApiDataMapProvider.FURNACE_FUELS.add(fuelDto);
    }

    @Override
    public Class<? extends FurnaceFuel> getAnnotationClass() {
        return FurnaceFuel.class;
    }
}
