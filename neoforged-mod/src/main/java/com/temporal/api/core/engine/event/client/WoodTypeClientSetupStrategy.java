package com.temporal.api.core.engine.event.client;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.List;

public class WoodTypeClientSetupStrategy implements ClientSetupStrategy<WoodType> {
    @Override
    public void execute(List<WoodType> source) {
        source.forEach(Sheets::addWoodType);
    }
}
