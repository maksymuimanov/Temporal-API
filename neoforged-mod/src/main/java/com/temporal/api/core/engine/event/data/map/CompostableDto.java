package com.temporal.api.core.engine.event.data.map;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public record CompostableDto(Holder<? extends Item> item, float chance, boolean replace) {
}