package com.temporal.api.core.event.trade.object;

public class WandererTradeDescription extends TradeDescription {
    private final TradeRarity tradeRarity;

    public WandererTradeDescription(TradeRarity tradeRarity, int maxUses, int XP, float priceMultiplier) {
        super(maxUses, XP, priceMultiplier);
        this.tradeRarity = tradeRarity;
    }

    public TradeRarity getTradeRarity() {
        return tradeRarity;
    }

    public enum TradeRarity {
        GENERIC,
        RARE
    }
}
