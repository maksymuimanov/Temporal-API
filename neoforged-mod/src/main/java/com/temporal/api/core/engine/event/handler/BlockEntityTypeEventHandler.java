package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.field.event.AddBlockEntityTypeStrategy;
import com.temporal.api.core.util.IOUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockEntityTypeEventHandler implements EventHandler {
    public static final Map<BlockEntityType<?>, List<Holder<Block>>> BLOCKS = new HashMap<>();
    private final Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> strategies = IOUtils.createAnnotationStrategyMap(List.of(
            new AddBlockEntityTypeStrategy()
    ));

    @Override
    public void handle() {
        subscribeModEvent(BlockEntityTypeAddBlocksEvent.class, event -> {
            IOLayer.SIMPLE_STRATEGY_CONSUMER.execute(IOLayer.STATIC_FIELD_EXECUTOR, strategies, IOLayer.NEO_MOD.getClasses());
            BLOCKS.forEach((type, holders) -> {
                event.modify(type, holders.stream()
                        .map(Holder::value)
                        .toArray(Block[]::new));
            });
            BLOCKS.clear();
        });
    }
}
