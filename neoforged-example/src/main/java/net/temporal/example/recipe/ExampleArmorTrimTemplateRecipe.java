package net.temporal.example.recipe;

import com.temporal.api.core.engine.event.data.recipe.description.TemplateSmithingTrimRecipeDescription;
import com.temporal.api.core.engine.metadata.annotation.data.RegisterRecipe;
import net.minecraft.world.level.ItemLike;
import net.temporal.example.registry.ExampleItems;

@RegisterRecipe
public class ExampleArmorTrimTemplateRecipe implements TemplateSmithingTrimRecipeDescription {
    @Override
    public ItemLike[] getTemplates() {
        return new ItemLike[]{ExampleItems.EXAMPLE_ARMOR_TRIM_SMITHING_TEMPLATE};
    }

    @Override
    public String getName() {
        return "trim_templates_recipe";
    }
}
