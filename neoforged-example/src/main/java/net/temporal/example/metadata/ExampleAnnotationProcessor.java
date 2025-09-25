package net.temporal.example.metadata;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Processor;
import com.temporal.api.core.engine.metadata.processor.AbstractAnnotationProcessor;

@Processor(ExampleAnnotationProcessor.NAME)
public class ExampleAnnotationProcessor extends AbstractAnnotationProcessor {
    public static final String NAME = "example";

    @Override
    public void process() {
        this.processAll(MetadataLayer.SIMPLE_STRATEGY_CONSUMER, ModContext.NEO_MOD.getClasses());
    }
}