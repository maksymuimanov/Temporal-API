package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

public interface SmithingTransformRecipeHolder extends RecipeHolder {
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
