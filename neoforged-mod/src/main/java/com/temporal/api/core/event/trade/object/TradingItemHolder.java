package com.temporal.api.core.event.trade.object;

import net.minecraft.world.item.Item;

public record TradingItemHolder(Item item, int itemCount) {
}
