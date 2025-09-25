package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Processor;

@Processor(InjectionAnnotationProcessor.NAME)
public class InjectionAnnotationProcessor extends AbstractAnnotationProcessor {
    public static final String NAME = "default_injection";

    @Override
    public void process() {
        this.processAll(MetadataLayer.SIMPLE_STRATEGY_CONSUMER, ModContext.NEO_MOD.getClasses());
    }
}
