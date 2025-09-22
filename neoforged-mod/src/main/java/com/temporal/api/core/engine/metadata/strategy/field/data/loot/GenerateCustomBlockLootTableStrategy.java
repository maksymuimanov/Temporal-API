package com.temporal.api.core.engine.metadata.strategy.field.data.loot;

import com.temporal.api.core.engine.event.data.loot.BlockLootTableContainer;
import com.temporal.api.core.engine.event.data.loot.LootProviderStrategy;
import com.temporal.api.core.engine.event.data.loot.spec.CustomBlockLootTableSpec;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.loot.GenerateCustomBlockLootTable;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;
import java.util.List;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateCustomBlockLootTableStrategy implements FieldAnnotationStrategy<GenerateCustomBlockLootTable> {
    @Override
    public void execute(Field field, Object object, GenerateCustomBlockLootTable annotation) throws Exception {
        Holder<? extends Block> holder = (Holder<? extends Block>) field.get(object);
        List<String> additionalData = List.of(annotation.additionalData());
        CustomBlockLootTableSpec spec = new CustomBlockLootTableSpec(holder, additionalData);
        LootProviderStrategy<CustomBlockLootTableSpec> strategy = ReflectionUtils.createObject(annotation.strategy());
        BlockLootTableContainer.CUSTOM_LOOT.put(spec, strategy);
    }

    @Override
    public Class<GenerateCustomBlockLootTable> getAnnotationClass() {
        return GenerateCustomBlockLootTable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
