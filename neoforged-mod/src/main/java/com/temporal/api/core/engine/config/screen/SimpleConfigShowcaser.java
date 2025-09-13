package com.temporal.api.core.engine.config.screen;

import com.temporal.api.core.engine.context.InjectionPool;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

public class SimpleConfigShowcaser implements ConfigShowcaser {
    @Override
    public void showcase() {
        ModContainer modContainer = InjectionPool.getFromInstance(ModContainer.class);
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
