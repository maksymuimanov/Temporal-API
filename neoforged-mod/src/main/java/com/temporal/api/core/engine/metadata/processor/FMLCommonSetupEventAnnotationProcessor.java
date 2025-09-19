package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Processor;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Processor(FMLCommonSetupEventAnnotationProcessor.NAME)
public class FMLCommonSetupEventAnnotationProcessor extends AbstractEventAnnotationProcessor {
    public static final String NAME = "default_fml_common_setup_event";

    @Override
    public void handle() {
        this.subscribeModEvent(FMLCommonSetupEvent.class, event -> {
            ApiMod.LOGGER.info("FMLCommonSetupEvent received for modId: {}", ModContext.NEO_MOD.getModId());
            event.enqueueWork(() -> this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, ModContext.ALL_CLASSES));
        });
    }
}