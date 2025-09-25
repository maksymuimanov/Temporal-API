package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Handler(BlockEntityTypeAddBlocksEvent.class)
public class BlockEntityTypeEventHandler implements EventHandler {
    public static final Map<BlockEntityType<?>, List<Holder<Block>>> BLOCKS = new HashMap<>();

    @Override
    public void handle() {
        this.subscribeModEvent(BlockEntityTypeAddBlocksEvent.class, event -> {
            BLOCKS.forEach((type, holders) -> {
                event.modify(type, holders.stream()
                        .map(Holder::value)
                        .toArray(Block[]::new));
            });
            BLOCKS.clear();
        });
    }
}
