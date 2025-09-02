package com.temporal.api.core.engine.event.fov;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

public interface FOVModifier {
    void modify(ComputeFovModifierEvent event, Item... items);
}
