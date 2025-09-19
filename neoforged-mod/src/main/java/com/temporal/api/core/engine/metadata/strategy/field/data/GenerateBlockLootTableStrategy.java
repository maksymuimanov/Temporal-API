package com.temporal.api.core.engine.metadata.strategy.field.data;

import com.temporal.api.core.engine.event.data.loot.BlockLootTableProvider;
import com.temporal.api.core.engine.event.data.loot.LootProviderStrategy;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.GenerateBlockLootTable;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventAnnotationProcessor;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.util.Tuple;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateBlockLootTableStrategy implements FieldAnnotationStrategy<GenerateBlockLootTable> {
    @Override
    public void execute(Field field, Object object, GenerateBlockLootTable annotation) throws Exception {
        Holder<? extends Block> registryObject = (Holder<? extends Block>) field.get(object);
        String[] additionalData = annotation.additionalData();
        if (!LootProviderStrategy.class.equals(annotation.custom())) {
            LootProviderStrategy providerStrategy = annotation.custom()
                    .getDeclaredConstructor()
                    .newInstance();
            BlockLootTableProvider.CUSTOM_LOOT.put(new Tuple<>(registryObject, additionalData), providerStrategy);
            return;
        }
        switch (annotation.value()) {
            case SELF -> BlockLootTableProvider.SELF.put(registryObject, additionalData);
            case SILK_TOUCH -> BlockLootTableProvider.SILK_TOUCH.put(registryObject, additionalData);
            case POTTED_CONTENT -> BlockLootTableProvider.POTTED_CONTENTS.put(registryObject, additionalData);
            case ORE -> BlockLootTableProvider.ORES.put(registryObject, additionalData);
            case MULTIPLE_ORE -> BlockLootTableProvider.MULTIPLE_ORES.put(registryObject, additionalData);
            case GRASS -> BlockLootTableProvider.GRASSES.put(registryObject, additionalData);
            case LEAVES -> BlockLootTableProvider.LEAVES.put(registryObject, additionalData);
            case SHULKER_BOX -> BlockLootTableProvider.SHULKER_BOXES.put(registryObject, additionalData);
            case BANNER -> BlockLootTableProvider.BANNERS.put(registryObject, additionalData);
            case MUSHROOM_BLOCK -> BlockLootTableProvider.MUSHROOM_BLOCKS.put(registryObject, additionalData);
            case SHEARS_ONLY -> BlockLootTableProvider.SHEARS_ONLY.put(registryObject, additionalData);
            case CROP -> BlockLootTableProvider.CROPS.put(registryObject, additionalData);
            case DOOR -> BlockLootTableProvider.DOORS.put(registryObject, additionalData);
            case OTHER -> BlockLootTableProvider.OTHER.put(registryObject, additionalData);
            case EMPTY -> BlockLootTableProvider.EMPTY.put(registryObject, additionalData);
        }
    }

    @Override
    public Class<GenerateBlockLootTable> getAnnotationClass() {
        return GenerateBlockLootTable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventAnnotationProcessor.NAME);
    }
}
