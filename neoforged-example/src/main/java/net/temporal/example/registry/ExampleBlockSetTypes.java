package net.temporal.example.registry;

import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.registry.factory.BlockSetTypeFactory;
import net.minecraft.world.level.block.state.properties.BlockSetType;

@Injected
public final class ExampleBlockSetTypes {
    public static final BlockSetType EXAMPLE_BLOCK_SET_TYPE = BlockSetTypeFactory.createWood("example");
}
