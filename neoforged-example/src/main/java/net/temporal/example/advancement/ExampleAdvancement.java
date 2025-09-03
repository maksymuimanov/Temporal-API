package net.temporal.example.advancement;

import com.temporal.api.core.engine.event.data.advancement.AdvancementDescription;
import com.temporal.api.core.engine.metadata.annotation.data.RegisterAdvancement;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.world.level.ItemLike;
import net.temporal.example.registry.ExampleItems;

import java.util.Map;
import java.util.Set;

@RegisterAdvancement
public class ExampleAdvancement implements AdvancementDescription {
    @TranslateAmericanEnglish("Example Advancement")
    private static final String TITLE_ID = "advancement.example.example.title";
    @TranslateAmericanEnglish("Example Description for Example Advancement")
    private static final String DESCRIPTION_ID = "advancement.example.example.description";

    @Override
    public String getId() {
        return "example:example";
    }

    @Override
    public String getParentRoot() {
        return "minecraft:story/root";
    }

    @Override
    public ItemLike icon() {
        return ExampleItems.EXAMPLE_BOW;
    }

    @Override
    public AdvancementType getType() {
        return AdvancementType.TASK;
    }

    @Override
    public boolean showToast() {
        return true;
    }

    @Override
    public boolean isAnnouncedInChat() {
        return true;
    }

    @Override
    public boolean isHidden() {
        return false;
    }

    @Override
    public int getExperience() {
        return 10;
    }

    @Override
    public Map<String, Criterion<?>> getCriterions() {
        return Map.of("has_example_bow", InventoryChangeTrigger.TriggerInstance.hasItems(ExampleItems.EXAMPLE_BOW));
    }

    @Override
    public AdvancementRequirements getRequirements(Set<String> criterions) {
        return AdvancementRequirements.allOf(criterions);
    }
}
