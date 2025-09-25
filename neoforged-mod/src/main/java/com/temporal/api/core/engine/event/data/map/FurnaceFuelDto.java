package com.temporal.api.core.engine.event.data.map;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public record FurnaceFuelDto(Holder<? extends Item> item, int burnTime, boolean replace) {
}
