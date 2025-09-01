package com.temporal.api.core.event.data.recipe.description;

import net.minecraft.world.level.ItemLike;

import java.util.Map;

public interface ShapedOneMaterialRecipeDescription extends ShapedRecipeDescription {
    ItemLike getSimplePatternTranslation();

    @Override
    default Map<Character, ItemLike> getPatternTranslation() {
        return Map.of('X', getSimplePatternTranslation());
    }
}
