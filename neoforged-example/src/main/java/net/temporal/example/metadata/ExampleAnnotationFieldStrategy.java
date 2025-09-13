package net.temporal.example.metadata;

import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;

import java.lang.reflect.Field;

@Strategy(ExampleAnnotationProcessor.EXAMPLE_FIELD)
public class ExampleAnnotationFieldStrategy implements FieldAnnotationStrategy<ExampleAnnotation> {
    @Override
    public void execute(Field field, Object object, ExampleAnnotation annotation) throws Exception {
        System.out.println(field.getName() + " : " + annotation.value());
    }

    @Override
    public Class<? extends ExampleAnnotation> getAnnotationClass() {
        return ExampleAnnotation.class;
    }
}
