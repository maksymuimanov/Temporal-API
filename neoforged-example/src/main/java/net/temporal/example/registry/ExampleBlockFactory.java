package net.temporal.example.registry;

import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import com.temporal.api.core.registry.factory.extension.block.*;

@Injected
public final class ExampleBlockFactory extends BlockFactory implements FlowerSubFactory,
        LeavesSubFactory, LogSubFactory, SaplingSubFactory,
        SlabSubFactory, StairSubFactory,
        ButtonSubFactory, PressurePlateSubFactory,
        FenceSubFactory, FenceGateSubFactory,
        DoorSubFactory, TrapDoorSubFactory,
        SignSubFactory, HangingSignSubFactory {
}