package com.temporal.api.core.event.data.tag.block;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.event.data.preparer.tag.block.BlockTagDynamicPreparer;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ApiBlockTagsProvider extends BlockTagsProvider {
    public static final Map<String, List<DeferredBlock<?>>> TAG_GENERATION_DESCRIPTIONS = new TemporalMap<>();

    public ApiBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, IOLayer.NEO_MOD.getModId(), existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        TAG_GENERATION_DESCRIPTIONS.forEach((tag, blocks) -> {
            if (BlockTagDynamicPreparer.BLOCK_TAGS.containsKey(tag)) {
                TagKey<Block> tagKey = BlockTagDynamicPreparer.BLOCK_TAGS.get(tag);
                tag(tagKey).add(blocks.stream()
                        .map(DeferredHolder::get)
                        .toArray(Block[]::new));
            }
        });
    }
}
