package com.temporal.api.core.engine.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.engine.event.data.map.WaxableDto;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.properties.Waxable;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class WaxableStrategy implements FieldAnnotationStrategy<Waxable> {
    @Override
    public void execute(Field field, Object object, Waxable annotation) throws Exception {
        Holder<? extends Block> block = (Holder<? extends Block>) field.get(object);
        WaxableDto waxableDto = new WaxableDto(block, annotation.waxedBlock(), annotation.replace());
        ApiDataMapProvider.WAXABLES.add(waxableDto);
    }

    @Override
    public Class<? extends Waxable> getAnnotationClass() {
        return Waxable.class;
    }
}
