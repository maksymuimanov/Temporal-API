package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

public interface TemplateSmithingTrimRecipeHolder extends SmithingTrimRecipeHolder {
    @Override
    default TagKey<Item> getBaseTag() {
        return ItemTags.TRIMMABLE_ARMOR;
    }

    @Override
    default TagKey<Item> getAdditionTag() {
        return ItemTags.TRIM_MATERIALS;
    }

    @Override
    default ItemLike[] getBases() {
        return null;
    }

    @Override
    default ItemLike[] getAdditions() {
        return null;
    }
}
