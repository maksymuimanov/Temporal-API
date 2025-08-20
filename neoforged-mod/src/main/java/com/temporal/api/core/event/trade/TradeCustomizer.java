package com.temporal.api.core.event.trade;

import com.temporal.api.core.event.trade.object.VillagerTrade;
import com.temporal.api.core.event.trade.object.WandererTrade;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

public interface TradeCustomizer {
    void customize(VillagerTradesEvent event, VillagerTrade villagerTrade);

    void customize(WandererTradesEvent event, WandererTrade wandererTrade);
}
