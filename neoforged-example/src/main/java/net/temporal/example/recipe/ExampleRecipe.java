package net.temporal.example.recipe;

import com.temporal.api.core.engine.event.data.recipe.description.ShapelessRecipeDescription;
import com.temporal.api.core.engine.metadata.annotation.data.RegisterRecipe;
import com.temporal.api.core.engine.metadata.annotation.injection.Injected;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.temporal.example.registry.ExampleItems;

import java.util.Map;

@RegisterRecipe
@Injected
public class ExampleRecipe implements ShapelessRecipeDescription {
    @Override
    public Map<ItemLike, Integer> getItemAndCountMap() {
        return Map.of(
                Items.DIAMOND, 1,
                Items.COPPER_BLOCK, 2
        );
    }

    @Override
    public RecipeCategory getRecipeCategory() {
        return RecipeCategory.FOOD;
    }

    @Override
    public ItemLike getResult() {
        return ExampleItems.EXAMPLE_FUEL;
    }
}
