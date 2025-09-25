package com.temporal.api.core.engine.event.data.recipe.description;

import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

public interface AdditionSmithingTrimRecipeDescription extends SmithingTrimRecipeDescription {
    @Override
    default ItemLike[] getTemplates() {
        return ARMOR_TEMPLATES;
    }

    @Override
    default TagKey<Item> getBaseTag() {
        return ItemTags.TRIMMABLE_ARMOR;
    }

    @Override
    default ItemLike[] getBases() {
        return null;
    }
}
