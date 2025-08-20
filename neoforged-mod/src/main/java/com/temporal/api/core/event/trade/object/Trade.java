package com.temporal.api.core.event.trade.object;

public abstract class Trade {
    private final TradingItemHolder holder1;
    private final TradingItemHolder holder2;

    public Trade(TradingItemHolder holder1, TradingItemHolder holder2) {
        this.holder1 = holder1;
        this.holder2 = holder2;
    }

    public TradingItemHolder getHolder1() {
        return holder1;
    }

    public TradingItemHolder getHolder2() {
        return holder2;
    }
}
