package net.temporal.example.registry;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.metadata.annotation.event.RegisterHangingSignRenderer;
import com.temporal.api.core.engine.io.metadata.annotation.event.RegisterSignRenderer;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.io.metadata.annotation.injection.RegisterFactory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.neoforged.neoforge.registries.DeferredHolder;

@Injected
public final class ExampleBlockEntityTypes {
    @RegisterFactory
    private static final ExampleBlockEntityTypeFactory BLOCK_ENTITY_TYPE_FACTORY = InjectionPool.getFromInstance(ExampleBlockEntityTypeFactory.class);

    @RegisterSignRenderer
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SignBlockEntity>> EXAMPLE_SIGN = BLOCK_ENTITY_TYPE_FACTORY.createSign("example_sign", ExampleBlocks.EXAMPLE_SIGN, ExampleBlocks.EXAMPLE_WALL_SIGN);

    @RegisterHangingSignRenderer
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HangingSignBlockEntity>> EXAMPLE_HANGING_SIGN = BLOCK_ENTITY_TYPE_FACTORY.createHangingSign("example_hanging_sign", ExampleBlocks.EXAMPLE_HANGING_SIGN, ExampleBlocks.EXAMPLE_HANGING_WALL_SIGN);
}