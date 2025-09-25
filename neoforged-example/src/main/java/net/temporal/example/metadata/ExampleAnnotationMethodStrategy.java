package net.temporal.example.metadata;

import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.strategy.method.MethodAnnotationStrategy;

import java.lang.reflect.Method;

@Strategy(ExampleAnnotationMethodStrategy.EXAMPLE_METHOD)
public class ExampleAnnotationMethodStrategy implements MethodAnnotationStrategy<ExampleAnnotation> {
    public static final String EXAMPLE_METHOD = "example_method";

    @Override
    public void execute(Method method, Object object, ExampleAnnotation annotation) throws Exception {
        System.out.println(method.getName() + " : " + annotation.value());
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
