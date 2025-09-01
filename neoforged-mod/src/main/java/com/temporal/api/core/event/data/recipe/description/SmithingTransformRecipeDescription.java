package com.temporal.api.core.event.data.recipe.description;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

public interface SmithingTransformRecipeDescription extends RecipeDescription {
    ItemLike[] getTemplates();

    ItemLike[] getBases();

    ItemLike[] getAdditions();

    default TagKey<Item> getBaseTag() {
        return null;
    }

    default TagKey<Item> getAdditionTag() {
        return null;
    }

    @Override
    default RecipeCategory getRecipeCategory() {
        return RecipeCategory.MISC;
    }
}
