package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.event.client.*;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.event.SetupBow;
import com.temporal.api.core.engine.metadata.annotation.event.SetupCrossbow;
import com.temporal.api.core.engine.metadata.annotation.event.SetupShield;
import com.temporal.api.core.engine.metadata.annotation.event.SetupWoodType;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FMLClientSetupEventHandler implements EventHandler {
    public static final List<Holder<? extends Item>> BOWS = new ArrayList<>();
    public static final List<Holder<? extends Item>> CROSSBOWS = new ArrayList<>();
    public static final List<Holder<? extends Item>> SHIELDS = new ArrayList<>();
    public static final List<WoodType> WOOD_TYPES = new ArrayList<>();
    private static final ClientSetupStrategy<Holder<? extends Item>> BOW_STRATEGY = new BowClientSetupStrategy();
    private static final ClientSetupStrategy<Holder<? extends Item>> CROSSBOW_STRATEGY = new CrossbowClientSetupStrategy();
    private static final ClientSetupStrategy<Holder<? extends Item>> SHIELD_STRATEGY = new ShieldClientSetupStrategy();
    private static final ClientSetupStrategy<WoodType> WOOD_TYPE_STRATEGY = new WoodTypeClientSetupStrategy();

    @Override
    public void handle() {
        this.subscribeModEvent(FMLClientSetupEvent.class, event -> {
            Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> strategies = SimpleStrategyPool.getInstance().getStrategies(SetupBow.class, SetupCrossbow.class, SetupShield.class, SetupWoodType.class);
            MetadataLayer.ASYNC_STRATEGY_CONSUMER.execute(MetadataLayer.STATIC_FIELD_EXECUTOR, strategies, ModContext.NEO_MOD.getClasses());
            WOOD_TYPE_STRATEGY.execute(WOOD_TYPES);
            event.enqueueWork(() -> {
                BOW_STRATEGY.execute(BOWS);
                CROSSBOW_STRATEGY.execute(CROSSBOWS);
                SHIELD_STRATEGY.execute(SHIELDS);
            });
        });
    }
}
