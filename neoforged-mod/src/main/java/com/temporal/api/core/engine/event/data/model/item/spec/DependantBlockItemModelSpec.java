package com.temporal.api.core.engine.event.data.model.item.spec;

import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import com.temporal.api.core.util.RegistryUtils;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DependantBlockItemModelSpec extends BlockItemModelSpec {
    private final Block dependencyBlock;

    public DependantBlockItemModelSpec(Holder<? extends Item> holder, String dependencyBlockId) {
        this(holder, RegistryUtils.getBlock(dependencyBlockId));
    }

    public DependantBlockItemModelSpec(Holder<? extends Item> holder, Block dependencyBlock) {
        super(holder);
        this.dependencyBlock = dependencyBlock;
    }

    public ResourceLocation getDependencyBlockLocation() {
        return this.getDependencyBlockLocation("");
    }

    public ResourceLocation getDependencyBlockLocation(String suffix) {
        return ResourceUtils.parse(this.getDependencyBlockPath() + suffix);
    }

    public String getDependencyBlockPath() {
        return BlockModelSpec.getBlockPath(this.getDependencyBlock());
    }

    public Block getDependencyBlock() {
        return dependencyBlock;
    }
}
