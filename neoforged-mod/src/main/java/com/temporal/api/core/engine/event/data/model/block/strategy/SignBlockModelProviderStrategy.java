package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.SignBlockModelSpec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;

public class SignBlockModelProviderStrategy implements BlockModelProviderStrategy<SignBlockModelSpec> {
    @Override
    public void registerBlockModel(SignBlockModelSpec spec, ApiBlockModelProvider provider) {
        StandingSignBlock standingBlock = spec.getBlock();
        WallSignBlock wallBlock = spec.getDependencyBlock();
        ResourceLocation particleTexture = spec.getParticleTexture();
        provider.signBlock(standingBlock, wallBlock, particleTexture);
    }
}
