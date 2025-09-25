package com.temporal.api.core.engine.event.data.recipe.description;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.level.ItemLike;

public interface RecipeDescription {
    RecipeCategory getRecipeCategory();

    ItemLike getResult();

    default String getName() {
        return null;
    }

    default int getCount() {
        return 1;
    }
}
