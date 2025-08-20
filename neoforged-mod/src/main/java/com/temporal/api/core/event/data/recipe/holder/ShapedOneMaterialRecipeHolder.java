package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.world.level.ItemLike;

import java.util.Map;

public interface ShapedOneMaterialRecipeHolder extends ShapedRecipeHolder {
    ItemLike getSimplePatternTranslation();

    @Override
    default Map<Character, ItemLike> getPatternTranslation() {
        return Map.of('X', getSimplePatternTranslation());
    }
}
