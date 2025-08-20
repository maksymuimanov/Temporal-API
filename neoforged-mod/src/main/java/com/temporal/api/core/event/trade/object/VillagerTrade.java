package com.temporal.api.core.event.trade.object;

public class VillagerTrade extends Trade {
    private final VillagerTradeDescription tradeDescription;

    public VillagerTrade(TradingItemHolder holder1, TradingItemHolder holder2, VillagerTradeDescription tradeDescription) {
        super(holder1, holder2);
        this.tradeDescription = tradeDescription;
    }

    public VillagerTradeDescription getTradeDescription() {
        return tradeDescription;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends TradeBuilder<Builder, VillagerTrade, VillagerTradeDescription> {
        @Override
        public VillagerTrade build() {
            return new VillagerTrade(this.getLeftHolder(), this.getRightHolder(), this.getTradeDescription());
        }
    }
}
