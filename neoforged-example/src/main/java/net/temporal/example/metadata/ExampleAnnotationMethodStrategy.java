package net.temporal.example.metadata;

import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.method.MethodAnnotationStrategy;

import java.lang.reflect.Method;

@Strategy(ExampleAnnotationProcessor.EXAMPLE_METHOD)
public class ExampleAnnotationMethodStrategy implements MethodAnnotationStrategy<ExampleAnnotation> {
    @Override
    public void execute(Method method, Object object, ExampleAnnotation annotation) throws Exception {
        System.out.println(method.getName() + " : " + annotation.value());
    }

    @Override
    public Class<? extends ExampleAnnotation> getAnnotationClass() {
        return ExampleAnnotation.class;
    }

    @Override
    public AnnotationExecutor<? extends AnnotationStrategy<Method, ?>> getExecutor() {
        return MetadataLayer.METHOD_EXECUTOR;
    }
}
