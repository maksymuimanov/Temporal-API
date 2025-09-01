package com.temporal.api.core.event.data.tag;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.event.data.preparer.tag.ItemTagDynamicPreparer;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ApiItemTagsProvider extends ItemTagsProvider {
    public static final Map<String, List<Holder<? extends Item>>> TAG_GENERATION_DESCRIPTIONS = new HashMap<>();

    public ApiItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, IOLayer.NEO_MOD.getModId(), existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        TAG_GENERATION_DESCRIPTIONS.forEach((tag, items) -> {
            if (ItemTagDynamicPreparer.ITEM_TAGS.containsKey(tag)) {
                TagKey<Item> tagKey = ItemTagDynamicPreparer.ITEM_TAGS.get(tag);
                tag(tagKey).add(items.stream()
                        .map(Holder::value)
                        .toArray(Item[]::new));
            }
        });
        TAG_GENERATION_DESCRIPTIONS.clear();
    }
}
