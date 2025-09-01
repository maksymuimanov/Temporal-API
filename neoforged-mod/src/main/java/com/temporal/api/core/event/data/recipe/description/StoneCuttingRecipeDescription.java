package com.temporal.api.core.event.data.recipe.description;

import net.minecraft.world.level.ItemLike;

public interface StoneCuttingRecipeDescription extends RecipeDescription {
    ItemLike getIngredient();
}
