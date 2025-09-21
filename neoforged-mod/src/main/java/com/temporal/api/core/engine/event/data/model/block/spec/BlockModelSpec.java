package com.temporal.api.core.engine.event.data.model.block.spec;

import com.temporal.api.core.util.RegistryUtils;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;

public class BlockModelSpec {
    public static final String BLOCK_PREFIX = "block";
    private final Holder<? extends Block> holder;
    private final String renderType;

    public BlockModelSpec(Holder<? extends Block> holder) {
        this(holder, null);
    }

    public BlockModelSpec(Holder<? extends Block> holder, String renderType) {
        this.holder = holder;
        this.renderType = renderType;
    }

    public ResourceLocation getLocation() {
        return this.getLocation("");
    }

    public ResourceLocation getLocation(String suffix) {
        return ResourceUtils.parse(this.getPath() + suffix);
    }

    public String getPath() {
        return getBlockPath(this.getBlock());
    }

    @SuppressWarnings("unchecked")
    public <T extends Block> T getBlock() {
        return (T) this.getHolder().value();
    }

    public Holder<? extends Block> getHolder() {
        return holder;
    }

    @Nullable
    public String getRenderType() {
        return renderType;
    }

    public static String getBlockPath(Block block) {
        return RegistryUtils.getObjectName(BuiltInRegistries.BLOCK, block, BLOCK_PREFIX);
    }
}
