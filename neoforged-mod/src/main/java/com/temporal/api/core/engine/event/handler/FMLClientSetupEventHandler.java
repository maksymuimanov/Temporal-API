package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.field.event.SetupBowStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.field.event.SetupCrossbowStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.field.event.SetupShieldStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.field.event.SetupWoodTypeStrategy;
import com.temporal.api.core.event.client.*;
import com.temporal.api.core.util.IOUtils;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.DeferredItem;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FMLClientSetupEventHandler implements EventHandler {
    public static final List<DeferredItem<?>> BOWS = new ArrayList<>();
    public static final List<DeferredItem<?>> CROSSBOWS = new ArrayList<>();
    public static final List<DeferredItem<?>> SHIELDS = new ArrayList<>();
    public static final List<WoodType> WOOD_TYPES = new ArrayList<>();
    private static final ClientSetupStrategy<DeferredItem<?>> BOW_STRATEGY = new BowClientSetupStrategy();
    private static final ClientSetupStrategy<DeferredItem<?>> CROSSBOW_STRATEGY = new CrossbowClientSetupStrategy();
    private static final ClientSetupStrategy<DeferredItem<?>> SHIELD_STRATEGY = new ShieldClientSetupStrategy();
    private static final ClientSetupStrategy<WoodType> WOOD_TYPE_STRATEGY = new WoodTypeClientSetupStrategy();
    private final Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> strategies = IOUtils.createAnnotationStrategyMap(List.of(
            new SetupBowStrategy(),
            new SetupCrossbowStrategy(),
            new SetupShieldStrategy(),
            new SetupWoodTypeStrategy()
    ));

    @Override
    public void handle() {
        subscribeModEvent(FMLClientSetupEvent.class, event -> {
            IOLayer.ASYNC_STRATEGY_CONSUMER.execute(IOLayer.STATIC_FIELD_EXECUTOR, strategies, IOLayer.NEO_MOD.getClasses());
            WOOD_TYPE_STRATEGY.execute(WOOD_TYPES);
            event.enqueueWork(() -> {
                BOW_STRATEGY.execute(BOWS);
                CROSSBOW_STRATEGY.execute(CROSSBOWS);
                SHIELD_STRATEGY.execute(SHIELDS);
            });
        });
    }
}
