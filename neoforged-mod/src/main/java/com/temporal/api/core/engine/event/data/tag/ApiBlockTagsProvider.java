package com.temporal.api.core.engine.event.data.tag;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.event.data.preparer.tag.BlockTagDynamicPreparer;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ApiBlockTagsProvider extends BlockTagsProvider {
    public static final Map<String, List<Holder<? extends Block>>> TAG_GENERATION_DESCRIPTIONS = new HashMap<>();

    public ApiBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ModContext.NEO_MOD.getModId(), existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        TAG_GENERATION_DESCRIPTIONS.forEach((tag, blocks) -> {
            if (BlockTagDynamicPreparer.BLOCK_TAGS.containsKey(tag)) {
                TagKey<Block> tagKey = BlockTagDynamicPreparer.BLOCK_TAGS.get(tag);
                tag(tagKey).add(blocks.stream()
                        .map(Holder::value)
                        .toArray(Block[]::new));
            }
        });
        TAG_GENERATION_DESCRIPTIONS.clear();
    }
}
