package com.temporal.api.core.engine.metadata.strategy.type.data;

import com.temporal.api.core.engine.event.data.preparer.tag.BiomeTagDynamicPreparer;
import com.temporal.api.core.engine.event.data.preparer.tag.BlockTagDynamicPreparer;
import com.temporal.api.core.engine.event.data.preparer.tag.EnchantmentTagDynamicPreparer;
import com.temporal.api.core.engine.event.data.preparer.tag.ItemTagDynamicPreparer;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.AddTagContainer;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;

@Strategy(StrategyPoolInitializer.DEFAULT_CLASS_DATA)
public class AddTagContainerStrategy implements ClassAnnotationStrategy<AddTagContainer> {
    @Override
    public void execute(Class<?> clazz, Object object, AddTagContainer annotation) throws Exception {
        switch (annotation.value()) {
            case ITEM -> ItemTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
            case BLOCK -> BlockTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
            case BIOME -> BiomeTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
            case ENCHANTMENT -> EnchantmentTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
        }
    }

    @Override
    public Class<AddTagContainer> getAnnotationClass() {
        return AddTagContainer.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
