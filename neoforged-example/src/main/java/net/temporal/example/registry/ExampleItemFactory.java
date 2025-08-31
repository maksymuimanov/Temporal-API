package net.temporal.example.registry;

import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.registry.factory.ItemFactory;
import com.temporal.api.core.registry.factory.extension.item.*;

@Injected(true)
public final class ExampleItemFactory extends ItemFactory implements SwordSubFactory,
        BowSubFactory, CrossbowSubFactory,
        ArmorSubFactory,
        SignSubFactory, HangingSignSubFactory,
        BoatSubFactory,
        SpawnEggSubFactory {
}
