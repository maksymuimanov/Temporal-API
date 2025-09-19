package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Processor;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

@Processor(BlockEntityTypeEventAnnotationProcessor.NAME)
public class BlockEntityTypeEventAnnotationProcessor extends AbstractEventAnnotationProcessor {
    public static final String NAME = "default_block_entity_type_event";

    @Override
    public void handle() {
        this.subscribeModEvent(BlockEntityTypeAddBlocksEvent.class, event -> {
            this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, ModContext.ALL_CLASSES);
        });
    }
}