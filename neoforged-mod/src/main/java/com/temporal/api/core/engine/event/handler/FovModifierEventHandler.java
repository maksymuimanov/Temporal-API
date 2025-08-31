package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.event.fov.BowFOVModifier;
import com.temporal.api.core.event.fov.FOVModifier;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.ArrayList;
import java.util.List;

public class FovModifierEventHandler implements EventHandler {
    public static final List<DeferredItem<?>> BOWS = new ArrayList<>();
    private static final FOVModifier FOV_MODIFIER = new BowFOVModifier();

    @Override
    public void handle() {
        subscribeEvent(ComputeFovModifierEvent.class, event -> {
            BOWS.forEach(bow -> FOV_MODIFIER.modify(event, bow.get()));
        });
    }
}
