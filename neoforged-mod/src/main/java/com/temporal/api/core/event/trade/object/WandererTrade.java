package com.temporal.api.core.event.trade.object;

public class WandererTrade extends Trade {
    private final WandererTradeDescription tradeDescription;

    public WandererTrade(TradingItemHolder holder1, TradingItemHolder holder2, WandererTradeDescription tradeDescription) {
        super(holder1, holder2);
        this.tradeDescription = tradeDescription;
    }

    public WandererTradeDescription getTradeDescription() {
        return tradeDescription;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends TradeBuilder<Builder, WandererTrade, WandererTradeDescription> {
        @Override
        public WandererTrade build() {
            return new WandererTrade(this.getLeftHolder(), this.getRightHolder(), this.getTradeDescription());
        }
    }
}
