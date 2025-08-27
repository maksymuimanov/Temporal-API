package net.temporal.example.registry;

import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.registry.factory.BlockEntityTypeFactory;
import com.temporal.api.core.registry.factory.extension.entity.HangingSignSubFactory;
import com.temporal.api.core.registry.factory.extension.entity.SignSubFactory;

@Injected(true)
public final class ExampleBlockEntityTypeFactory extends BlockEntityTypeFactory implements SignSubFactory, HangingSignSubFactory {
}