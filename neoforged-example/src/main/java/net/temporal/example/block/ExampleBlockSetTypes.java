package net.temporal.example.block;

import com.temporal.api.core.engine.registry.factory.BlockSetTypeFactory;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public final class ExampleBlockSetTypes {
    public static final BlockSetType EXAMPLE_BLOCK_SET_TYPE = BlockSetTypeFactory.createWood("example");
}
