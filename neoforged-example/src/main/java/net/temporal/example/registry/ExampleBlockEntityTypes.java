package net.temporal.example.registry;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;

@Injected
public final class ExampleBlockEntityTypes {
    private static final ExampleBlockEntityTypeFactory BLOCK_ENTITY_TYPE_FACTORY = InjectionPool.getFromInstance(ExampleBlockEntityTypeFactory.class);
}