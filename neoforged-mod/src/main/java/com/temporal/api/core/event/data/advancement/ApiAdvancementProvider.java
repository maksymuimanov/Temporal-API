package com.temporal.api.core.event.data.advancement;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.advancements.AdvancementSubProvider;
import org.jetbrains.annotations.NotNull;
import oshi.util.tuples.Pair;

import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;

public class ApiAdvancementProvider implements AdvancementSubProvider {
    public static final Queue<AdvancementGenerationHolder> ADVANCEMENTS = new TemporalQueue<>();
    public static final Map<AdvancementGenerationHolder, AdvancementStrategy> CUSTOM_ADVANCEMENTS = new TemporalMap<>();

    @Override
    public void generate(@NotNull HolderLookup.Provider provider, @NotNull Consumer<AdvancementHolder> consumer) {
        ADVANCEMENTS.forEach(advancement -> {
            Advancement.Builder builder = Advancement.Builder.advancement();
            builder.parent(AdvancementSubProvider.createPlaceholder(advancement.getParentRoot()));
            builder.display(advancement.icon(),
                    advancement.getTitleComponent(), advancement.getDescriptionComponent(),
                    advancement.getBackground(), advancement.getType(),
                    advancement.showToast(), advancement.isAnnouncedInChat(), advancement.isHidden()
            );

            builder.rewards(AdvancementRewards.Builder.experience(advancement.getExperience()));
            Pair<String, Criterion<?>> criterion = advancement.getCriterion();
            builder.addCriterion(criterion.getA(), criterion.getB());
            builder.requirements(advancement.getRequirements());
            builder.save(consumer, ResourceUtils.parse(advancement.getId()).toString());
        });

        CUSTOM_ADVANCEMENTS.forEach((advancement, strategy) -> strategy.generateAdvancement(advancement, provider, consumer));
    }
}
