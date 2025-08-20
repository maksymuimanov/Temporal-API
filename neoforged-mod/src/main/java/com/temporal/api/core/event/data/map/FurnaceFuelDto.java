package com.temporal.api.core.event.data.map;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public record FurnaceFuelDto(Holder<Item> item, int burnTime, boolean replace) {
}
