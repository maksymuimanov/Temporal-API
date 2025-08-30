package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.field.event.RegisterHangingSignStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.field.event.RegisterSignStrategy;
import com.temporal.api.core.util.CollectionUtils;
import com.temporal.api.core.util.IOUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class BlockEntityTypeEventHandler implements EventHandler {
    public static final Map<Holder<Block>, Holder<Block>> SIGNS = new TemporalMap<>();
    public static final Map<Holder<Block>, Holder<Block>> HANGING_SIGNS = new TemporalMap<>();
    private final Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> strategies = IOUtils.createAnnotationStrategyMap(List.of(
            new RegisterSignStrategy(),
            new RegisterHangingSignStrategy()
    ));

    @Override
    public void handle() {
        subscribeModEvent(BlockEntityTypeAddBlocksEvent.class, event -> {
            IOLayer.SIMPLE_STRATEGY_CONSUMER.execute(IOLayer.STATIC_FIELD_EXECUTOR, strategies, IOLayer.NEO_MOD.getClasses());
            event.modify(BlockEntityType.SIGN, CollectionUtils.toArray(SIGNS, Holder::value, Holder::value, Block[]::new));
            event.modify(BlockEntityType.HANGING_SIGN, CollectionUtils.toArray(HANGING_SIGNS, Holder::value, Holder::value, Block[]::new));
        });
    }
}
