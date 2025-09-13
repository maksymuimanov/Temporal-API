package com.temporal.api.core.engine.metadata.strategy.field.event.block;

import com.temporal.api.core.engine.event.handler.BlockEntityTypeEventHandler;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.event.block.AddBlockEntityType;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_BLOCK)
public class AddBlockEntityTypeStrategy implements FieldAnnotationStrategy<AddBlockEntityType> {
    @Override
    public void execute(Field field, Object object, AddBlockEntityType annotation) throws Exception {
        Holder<Block> blockHolder = (Holder<Block>) field.get(object);
        BlockEntityType<?> blockEntityType = RegistryUtils.getBlockEntityType(annotation.value());
        MapUtils.putToListMap(BlockEntityTypeEventHandler.BLOCKS, blockEntityType, blockHolder);
    }

    @Override
    public Class<? extends AddBlockEntityType> getAnnotationClass() {
        return AddBlockEntityType.class;
    }

    @Override
    public AnnotationExecutor<? extends AnnotationStrategy<Field, ?>> getExecutor() {
        return MetadataLayer.STATIC_FIELD_EXECUTOR;
    }
}
