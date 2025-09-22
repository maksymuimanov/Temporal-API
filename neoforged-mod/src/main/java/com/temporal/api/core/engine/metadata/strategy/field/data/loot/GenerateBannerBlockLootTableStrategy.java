package com.temporal.api.core.engine.metadata.strategy.field.data.loot;

import com.temporal.api.core.engine.event.data.loot.BlockLootTableContainer;
import com.temporal.api.core.engine.event.data.loot.spec.BlockLootTableSpec;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.loot.GenerateBannerBlockLootTable;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateBannerBlockLootTableStrategy implements FieldAnnotationStrategy<GenerateBannerBlockLootTable> {
    @Override
    public void execute(Field field, Object object, GenerateBannerBlockLootTable annotation) throws Exception {
        Holder<? extends Block> holder = (Holder<? extends Block>) field.get(object);
        BlockLootTableSpec spec = new BlockLootTableSpec(holder);
        BlockLootTableContainer.BANNERS.add(spec);
    }

    @Override
    public Class<GenerateBannerBlockLootTable> getAnnotationClass() {
        return GenerateBannerBlockLootTable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
