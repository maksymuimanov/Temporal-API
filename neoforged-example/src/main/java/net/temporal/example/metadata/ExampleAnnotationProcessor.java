package net.temporal.example.metadata;

import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.metadata.pool.StrategyPool;
import com.temporal.api.core.engine.metadata.processor.AbstractAnnotationProcessor;

import java.util.Set;

@Injected
public class ExampleAnnotationProcessor extends AbstractAnnotationProcessor {
    public static final String EXAMPLE_CLASS = "example_class";
    public static final String EXAMPLE_FIELD = "example_field";
    public static final String EXAMPLE_METHOD = "example_method";

    @Override
    protected void process(StrategyPool strategyPool, Set<Class<?>> classes) {
        this.processAsync(MetadataLayer.CLASS_EXECUTOR, EXAMPLE_CLASS, classes);
        this.processAsync(MetadataLayer.FIELD_EXECUTOR, EXAMPLE_FIELD, classes);
        this.processAsync(MetadataLayer.METHOD_EXECUTOR, EXAMPLE_METHOD, classes);
    }
}
