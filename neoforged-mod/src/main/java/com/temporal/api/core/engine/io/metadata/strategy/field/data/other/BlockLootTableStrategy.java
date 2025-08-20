package com.temporal.api.core.engine.io.metadata.strategy.field.data.other;

import com.temporal.api.core.collection.SimplePair;
import com.temporal.api.core.engine.io.metadata.annotation.data.other.BlockLootTable;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.loot.BlockLootTableProvider;
import com.temporal.api.core.event.data.loot.LootProviderStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class BlockLootTableStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Holder<? extends Block> registryObject = (Holder<? extends Block>) field.get(object);
        BlockLootTable blockLootTable = field.getDeclaredAnnotation(BlockLootTable.class);
        String[] additionalData = blockLootTable.additionalData();
        if (!LootProviderStrategy.class.equals(blockLootTable.custom())) {
            LootProviderStrategy providerStrategy = blockLootTable.custom()
                    .getDeclaredConstructor()
                    .newInstance();
            BlockLootTableProvider.CUSTOM_LOOT.put(new SimplePair<>(registryObject, additionalData), providerStrategy);
            return;
        }
        switch (blockLootTable.value()) {
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
    public Class<? extends Annotation> getAnnotationClass() {
        return BlockLootTable.class;
    }
}
