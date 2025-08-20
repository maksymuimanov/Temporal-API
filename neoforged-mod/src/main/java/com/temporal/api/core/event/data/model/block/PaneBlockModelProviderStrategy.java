package com.temporal.api.core.event.data.model.block;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import static com.temporal.api.core.event.data.model.block.ApiBlockModelProvider.MINECRAFT_CUTOUT;

public class PaneBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        Block block = blockRegistry.value();
        String blockPath = provider.getBlockPath(block);
        provider.simpleBlock(block, provider.models()
                .paneNoSide(blockPath, ResourceLocation.parse(blockPath))
                .renderType(MINECRAFT_CUTOUT));
        provider.simpleBlock(block, provider.models()
                .paneNoSideAlt(blockPath, ResourceLocation.parse(blockPath))
                .renderType(MINECRAFT_CUTOUT));
        provider.simpleBlock(block, provider.models()
                .panePost(blockPath, ResourceLocation.parse(blockPath), ResourceLocation.parse(blockPath + "_top"))
                .renderType(MINECRAFT_CUTOUT));
        provider.simpleBlock(block, provider.models()
                .paneSide(blockPath, ResourceLocation.parse(blockPath), ResourceLocation.parse(blockPath + "_top"))
                .renderType(MINECRAFT_CUTOUT));
        provider.simpleBlock(block, provider.models()
                .paneSideAlt(blockPath, ResourceLocation.parse(blockPath), ResourceLocation.parse(blockPath + "_top"))
                .renderType(MINECRAFT_CUTOUT));
    }
}
