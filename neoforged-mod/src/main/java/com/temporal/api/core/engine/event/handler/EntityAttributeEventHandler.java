package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import java.util.Map;

@Handler(EntityAttributeCreationEvent.class)
public class EntityAttributeEventHandler implements EventHandler {
    public static final Map<Holder<? extends EntityType<?>>, AttributeSupplier.Builder> ENTITY_ATTRIBUTES = new TemporalMap<>();

    @Override
    public void handle() {
        this.subscribeModEvent(EntityAttributeCreationEvent.class, event -> {
            ENTITY_ATTRIBUTES.forEach((holder, attributes) -> {
                event.put((EntityType<? extends LivingEntity>) holder.value(), attributes.build());
            });
        });
    }
}
