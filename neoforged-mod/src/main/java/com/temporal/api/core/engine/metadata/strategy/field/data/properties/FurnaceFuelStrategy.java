package com.temporal.api.core.engine.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.engine.event.data.map.FurnaceFuelDto;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.data.properties.FurnaceFuel;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class FurnaceFuelStrategy implements FieldAnnotationStrategy<FurnaceFuel> {
    @Override
    public void execute(Field field, Object object, FurnaceFuel annotation) throws Exception {
        Holder<? extends Item> itemHolder = ReflectionUtils.getItemHolder(field, object);
        FurnaceFuelDto fuelDto = new FurnaceFuelDto(itemHolder, annotation.burnTime(), annotation.replace());
        ApiDataMapProvider.FURNACE_FUELS.add(fuelDto);
    }

    @Override
    public Class<? extends FurnaceFuel> getAnnotationClass() {
        return FurnaceFuel.class;
    }

    @Override
    public AnnotationExecutor<? extends AnnotationStrategy<Field, ?>> getExecutor() {
        return MetadataLayer.STATIC_FIELD_EXECUTOR;
    }
}
