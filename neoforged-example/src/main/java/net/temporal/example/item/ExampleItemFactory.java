package net.temporal.example.item;

import com.temporal.api.core.engine.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.registry.extension.item.*;
import com.temporal.api.core.engine.registry.factory.ItemFactory;

@Injected
public final class ExampleItemFactory extends ItemFactory implements SwordSubFactory,
        BowSubFactory,
        CrossbowSubFactory,
        ArmorSubFactory,
        SignSubFactory,
        HangingSignSubFactory,
        BoatSubFactory,
        SpawnEggSubFactory,
        SmithingTemplateSubFactory,
        BannerPatternSubFactory,
        MusicDiscSubFactory,
        InstrumentSubFactory {
}
