package com.temporal.api.core.engine.event.data.advancement;

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

import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;

public class ApiAdvancementProvider implements AdvancementSubProvider {
    public static final Queue<AdvancementDescription> ADVANCEMENTS = new TemporalQueue<>();
    public static final Map<AdvancementDescription, AdvancementStrategy> CUSTOM_ADVANCEMENTS = new TemporalMap<>();

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
            Map<String, Criterion<?>> criterions = advancement.getCriterions();
            criterions.forEach(builder::addCriterion);
            builder.requirements(advancement.getRequirements(criterions.keySet()));
            builder.save(consumer, ResourceUtils.parse(advancement.getId()).toString());
        });

        CUSTOM_ADVANCEMENTS.forEach((advancement, strategy) -> strategy.generateAdvancement(advancement, provider, consumer));
    }
}
