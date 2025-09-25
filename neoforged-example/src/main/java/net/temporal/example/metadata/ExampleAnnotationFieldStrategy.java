package net.temporal.example.metadata;

import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;

import java.lang.reflect.Field;

@Strategy(ExampleAnnotationFieldStrategy.EXAMPLE_FIELD)
public class ExampleAnnotationFieldStrategy implements FieldAnnotationStrategy<ExampleAnnotation> {
    public static final String EXAMPLE_FIELD = "example_field";

    @Override
    public void execute(Field field, Object object, ExampleAnnotation annotation) throws Exception {
        System.out.println(field.getName() + " : " + annotation.value());
    }

    @Override
    public Class<ExampleAnnotation> getAnnotationClass() {
        return ExampleAnnotation.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(ExampleAnnotationProcessor.NAME);
    }
}
