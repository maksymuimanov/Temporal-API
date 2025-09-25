package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.SignBlockModelSpec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;

public class HangingSignBlockModelProviderStrategy implements BlockModelProviderStrategy<SignBlockModelSpec> {
    @Override
    public void registerBlockModel(SignBlockModelSpec spec, ApiBlockModelProvider provider) {
        CeilingHangingSignBlock ceilingBlock = spec.getBlock();
        WallHangingSignBlock wallBlock = spec.getDependencyBlock();
        ResourceLocation particleTexture = spec.getParticleTexture();
        provider.hangingSignBlock(ceilingBlock, wallBlock, particleTexture);
    }
}
