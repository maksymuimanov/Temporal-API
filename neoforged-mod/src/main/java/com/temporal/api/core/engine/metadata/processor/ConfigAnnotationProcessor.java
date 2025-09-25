package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Processor;

@Processor(ConfigAnnotationProcessor.NAME)
public class ConfigAnnotationProcessor extends AbstractAnnotationProcessor {
    public static final String NAME = "default_config";

    @Override
    public void process() {
        this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, ModContext.NEO_MOD.getClasses());
    }
}