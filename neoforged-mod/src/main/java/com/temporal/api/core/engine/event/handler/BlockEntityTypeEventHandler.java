package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.event.AddBlockEntityType;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
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

    @Override
    public void handle() {
        this.subscribeModEvent(BlockEntityTypeAddBlocksEvent.class, event -> {
            Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> strategies = SimpleStrategyPool.getInstance().getStrategies(AddBlockEntityType.class);
            MetadataLayer.ASYNC_STRATEGY_CONSUMER.execute(MetadataLayer.STATIC_FIELD_EXECUTOR, strategies, ModContext.NEO_MOD.getClasses());
            BLOCKS.forEach((type, holders) -> {
                event.modify(type, holders.stream()
                        .map(Holder::value)
                        .toArray(Block[]::new));
            });
            BLOCKS.clear();
        });
    }
}
