package com.temporal.api.core.engine.metadata.strategy.field.data.loot;

import com.temporal.api.core.engine.event.data.loot.BlockLootTableContainer;
import com.temporal.api.core.engine.event.data.loot.spec.MultipleOreBlockLootTableSpec;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.loot.GenerateMultipleOreBlockLootTable;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateMultipleOreBlockLootTableStrategy implements FieldAnnotationStrategy<GenerateMultipleOreBlockLootTable> {
    @Override
    public void execute(Field field, Object object, GenerateMultipleOreBlockLootTable annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        MultipleOreBlockLootTableSpec spec = new MultipleOreBlockLootTableSpec(holder, annotation.rawOre(), annotation.min(), annotation.max());
        BlockLootTableContainer.MULTIPLE_ORES.add(spec);
    }

    @Override
    public Class<GenerateMultipleOreBlockLootTable> getAnnotationClass() {
        return GenerateMultipleOreBlockLootTable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
