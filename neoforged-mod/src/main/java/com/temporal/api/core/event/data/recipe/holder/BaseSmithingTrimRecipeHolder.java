package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

public interface BaseSmithingTrimRecipeHolder extends SmithingTrimRecipeHolder {
    @Override
    default ItemLike[] getTemplates() {
        return ARMOR_TEMPLATES;
    }

    @Override
    default TagKey<Item> getAdditionTag() {
        return ItemTags.TRIM_MATERIALS;
    }

    @Override
    default ItemLike[] getAdditions() {
        return null;
    }
}
