package net.temporal.example.registry;

import com.temporal.api.core.engine.metadata.annotation.event.SetupWoodType;
import com.temporal.api.core.engine.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.registry.factory.WoodTypeFactory;
import net.minecraft.world.level.block.state.properties.WoodType;

@Injected
public final class ExampleWoodTypes {
    @SetupWoodType
    public static final WoodType EXAMPLE_WOOD_TYPE = WoodTypeFactory.create("example", ExampleBlockSetTypes.EXAMPLE_BLOCK_SET_TYPE);
}
