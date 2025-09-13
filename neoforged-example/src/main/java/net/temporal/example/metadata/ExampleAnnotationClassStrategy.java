package net.temporal.example.metadata;

import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;

@Strategy(ExampleAnnotationProcessor.EXAMPLE_CLASS)
public class ExampleAnnotationClassStrategy implements ClassAnnotationStrategy<ExampleAnnotation> {
    @Override
    public void execute(Class<?> clazz, Object object, ExampleAnnotation annotation) throws Exception {
        System.out.println(clazz.getName() + " : " + annotation.value());
    }

    @Override
    public Class<? extends ExampleAnnotation> getAnnotationClass() {
        return ExampleAnnotation.class;
    }
}
