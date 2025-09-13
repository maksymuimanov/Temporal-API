package net.temporal.example.metadata;

import com.temporal.api.core.engine.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.metadata.processor.AbstractAnnotationProcessor;

import java.util.Set;

@Injected
public class ExampleAnnotationProcessor extends AbstractAnnotationProcessor {
    public static final String EXAMPLE_CLASS = "example_class";
    public static final String EXAMPLE_FIELD = "example_field";
    public static final String EXAMPLE_METHOD = "example_method";

    @Override
    public void process(Set<Class<?>> classes) {
        this.processAsync(EXAMPLE_CLASS, classes);
        this.processAsync(EXAMPLE_FIELD, classes);
        this.processAsync(EXAMPLE_METHOD, classes);
    }
}