package com.temporal.api.core.event.data.model.block;

import com.temporal.api.core.util.other.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import static com.temporal.api.core.event.data.model.block.ApiBlockModelProvider.MINECRAFT_CUTOUT;

public class FlowerBlockModelProviderStrategy implements BlockModelProviderStrategy {
    private static final CrossBlockModelProviderStrategy CROSS_PROVIDER = new CrossBlockModelProviderStrategy();

    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        CROSS_PROVIDER.registerBlockModel(blockRegistry, provider);
        Block block = blockRegistry.value();
        String pottedId = additionalData[0];
        Block pottedBlock = RegistryUtils.getBlockById(pottedId);
        String flowerPath = provider.getBlockPath(block);
        String pottedPath = provider.getBlockPath(pottedBlock);
        provider.simpleBlock(pottedBlock, provider.models()
                .withExistingParent(pottedPath, provider.mcLoc("block/flower_pot_cross"))
                .texture("plant", flowerPath)
                .renderType(MINECRAFT_CUTOUT));
    }
}
