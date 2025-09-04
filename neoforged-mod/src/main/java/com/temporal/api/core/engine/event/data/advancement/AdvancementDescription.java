package com.temporal.api.core.engine.event.data.advancement;

import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.Criterion;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public interface AdvancementDescription {
    String TITLE_ID_FIELD_NAME = "TITLE_ID";
    String DESCRIPTION_ID_FIELD_NAME = "DESCRIPTION_ID";

    String getId();

    String getParentRoot();

    ItemLike icon();

    default Component getTitleComponent() {
        return Component.translatable(this.getTitle());
    }

    default String getTitle() {
        return getStringField(TITLE_ID_FIELD_NAME);
    }

    default Component getDescriptionComponent() {
        return Component.translatable(this.getDescription());
    }

    default String getDescription() {
        return getStringField(DESCRIPTION_ID_FIELD_NAME);
    }

    default String getStringField(String fieldName) {
        try {
            Field field = this.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(this).toString();
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    default ResourceLocation getBackground() {
        return null;
    }

    AdvancementType getType();

    boolean showToast();

    boolean isAnnouncedInChat();

    boolean isHidden();

    int getExperience();

    Map<String, Criterion<?>> getCriterions();

    AdvancementRequirements getRequirements(Set<String> criterions);
}
