package com.temporal.api.core.engine.event.data.model.block.spec;

import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class SignBlockModelSpec extends DependantBlockModelSpec {
    private final ResourceLocation particleTexture;

    public SignBlockModelSpec(Holder<? extends Block> holder, String dependencyBlockId, String particleTexture) {
        this(holder, null, dependencyBlockId, particleTexture);
    }

    public SignBlockModelSpec(Holder<? extends Block> holder, String renderType, String dependencyBlockId, String particleTexture) {
        this(holder, renderType, dependencyBlockId, ResourceUtils.parse(particleTexture));
    }

    public SignBlockModelSpec(Holder<? extends Block> holder, Block dependencyBlock, String particleTexture) {
        this(holder, null, dependencyBlock, particleTexture);
    }

    public SignBlockModelSpec(Holder<? extends Block> holder, String renderType, Block dependencyBlock, String particleTexture) {
        this(holder, renderType, dependencyBlock, ResourceUtils.parse(particleTexture));
    }

    public SignBlockModelSpec(Holder<? extends Block> holder, String dependencyBlockId, ResourceLocation particleTexture) {
        this(holder, null, dependencyBlockId, particleTexture);
    }

    public SignBlockModelSpec(Holder<? extends Block> holder, String renderType, String dependencyBlockId, ResourceLocation particleTexture) {
        super(holder, renderType, dependencyBlockId);
        this.particleTexture = particleTexture;
    }

    public SignBlockModelSpec(Holder<? extends Block> holder, Block dependencyBlock, ResourceLocation particleTexture) {
        this(holder, null, dependencyBlock, particleTexture);
    }

    public SignBlockModelSpec(Holder<? extends Block> holder, String renderType, Block dependencyBlock, ResourceLocation particleTexture) {
        super(holder, renderType, dependencyBlock);
        this.particleTexture = particleTexture;
    }

    public ResourceLocation getParticleTexture() {
        return particleTexture;
    }
}
