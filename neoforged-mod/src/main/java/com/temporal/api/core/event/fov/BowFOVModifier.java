package com.temporal.api.core.event.fov;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

import java.util.Arrays;

public class BowFOVModifier implements FOVModifier {
    @Override
    public void modify(ComputeFovModifierEvent event, Item... items) {
        if (checkItems(event, items)) {
            float fov = event.getPlayer().getTicksUsingItem() / 20.0F;
            if (fov > 1.0F) fov = 1.0F;
            else fov *= fov;
            event.setNewFovModifier(event.getFovModifier() * (1.0F - (fov * 0.15F)));
        }
    }


    private boolean checkItems(ComputeFovModifierEvent event, Item... items) {
        return Arrays.stream(items).map(item -> checkUsingItem(event, item)).filter(condition -> condition.equals(Boolean.TRUE)).findAny().orElse(false);
    }

    private boolean checkUsingItem(ComputeFovModifierEvent event, Item item) {
        return event.getPlayer().getUseItem().is(item) && event.getPlayer().isUsingItem();
    }
}
