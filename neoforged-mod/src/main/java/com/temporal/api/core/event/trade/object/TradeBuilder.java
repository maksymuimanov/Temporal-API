package com.temporal.api.core.event.trade.object;

@SuppressWarnings("unchecked")
public abstract class TradeBuilder<B extends TradeBuilder<B, T, D>, T extends Trade, D extends TradeDescription> {
    private TradingItemHolder leftHolder;
    private TradingItemHolder rightHolder;
    private D tradeDescription;

    public B leftHolder(TradingItemHolder leftHolder) {
        this.leftHolder = leftHolder;
        return (B) this;
    }

    public B rightHolder(TradingItemHolder rightHolder) {
        this.rightHolder = rightHolder;
        return (B) this;
    }

    public B tradeDescription(D tradeDescription) {
        this.tradeDescription = tradeDescription;
        return (B) this;
    }

    public abstract T build();

    public TradingItemHolder getLeftHolder() {
        return leftHolder;
    }

    public TradingItemHolder getRightHolder() {
        return rightHolder;
    }

    public D getTradeDescription() {
        return tradeDescription;
    }
}
