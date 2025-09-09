package net.temporal.example.block;

import com.temporal.api.core.engine.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.registry.extension.block.*;
import com.temporal.api.core.engine.registry.factory.BlockFactory;

@Injected
public final class ExampleBlockFactory extends BlockFactory implements FlowerSubFactory,
        LeavesSubFactory, LogSubFactory, SaplingSubFactory,
        SlabSubFactory, StairSubFactory,
        ButtonSubFactory, PressurePlateSubFactory,
        FenceSubFactory, FenceGateSubFactory,
        DoorSubFactory, TrapDoorSubFactory,
        SignSubFactory, HangingSignSubFactory {
}