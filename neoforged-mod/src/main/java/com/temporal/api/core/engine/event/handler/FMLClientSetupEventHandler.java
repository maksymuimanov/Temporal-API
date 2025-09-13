package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.event.client.*;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.pool.StrategyPool;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.ArrayList;
import java.util.List;

@Handler(FMLClientSetupEvent.class)
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
            StrategyPool strategyPool = SimpleStrategyPool.getInstance();
            MetadataLayer.ASYNC_STRATEGY_CONSUMER.execute(strategyPool.getAll(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_FML), ModContext.ALL_CLASSES);
            WOOD_TYPE_STRATEGY.execute(WOOD_TYPES);
            event.enqueueWork(() -> {
                BOW_STRATEGY.execute(BOWS);
                CROSSBOW_STRATEGY.execute(CROSSBOWS);
                SHIELD_STRATEGY.execute(SHIELDS);
            });
        });
    }
}
