package com.temporal.api.core.engine.metadata.strategy.field.data.loot;

import com.temporal.api.core.engine.event.data.loot.BlockLootTableContainer;
import com.temporal.api.core.engine.event.data.loot.spec.LeavesBlockLootTableSpec;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.loot.GenerateLeavesBlockLootTable;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateLeavesBlockLootTableStrategy implements FieldAnnotationStrategy<GenerateLeavesBlockLootTable> {
    @Override
    public void execute(Field field, Object object, GenerateLeavesBlockLootTable annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        List<Float> chances = new ArrayList<>();
        for (float chance : annotation.chances()) {
            chances.add(chance);
        }
        LeavesBlockLootTableSpec spec = new LeavesBlockLootTableSpec(holder, annotation.sapling(), chances);
        BlockLootTableContainer.LEAVES.add(spec);
    }

    @Override
    public Class<GenerateLeavesBlockLootTable> getAnnotationClass() {
        return GenerateLeavesBlockLootTable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
