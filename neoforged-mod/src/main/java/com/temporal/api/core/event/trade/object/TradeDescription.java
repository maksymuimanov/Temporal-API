package com.temporal.api.core.event.trade.object;

public abstract class TradeDescription {
    private final int maxUses;
    private final int XP;
    private final float priceMultiplier;

    public TradeDescription(int maxUses, int XP, float priceMultiplier) {
        this.maxUses = maxUses;
        this.XP = XP;
        this.priceMultiplier = priceMultiplier;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public int getXP() {
        return XP;
    }

    public float getPriceMultiplier() {
        return priceMultiplier;
    }
}
