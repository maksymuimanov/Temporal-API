package com.temporal.api.core.engine.event.handler;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import com.temporal.api.core.engine.metadata.processor.AnnotationProcessor;
import com.temporal.api.core.engine.metadata.processor.InjectionAnnotationProcessor;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Handler(FMLCommonSetupEvent.class)
public class CommonSetupEventHandler implements EventHandler {
    private static final AnnotationProcessor INJECTION_ANNOTATION_PROCESSOR = new InjectionAnnotationProcessor();

    @Override
    public void handle() {
        this.subscribeModEvent(FMLCommonSetupEvent.class, event -> {
            ApiMod.LOGGER.info("FMLCommonSetupEvent received for modId: {}", ModContext.NEO_MOD.getModId());
            event.enqueueWork(() -> {
                INJECTION_ANNOTATION_PROCESSOR.process(ModContext.NEO_MOD.getClasses());
            });
        });
    }
}
