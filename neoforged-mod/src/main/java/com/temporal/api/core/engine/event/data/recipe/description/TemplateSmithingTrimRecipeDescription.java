package com.temporal.api.core.engine.event.data.recipe.description;

import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

public interface TemplateSmithingTrimRecipeDescription extends SmithingTrimRecipeDescription {
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
