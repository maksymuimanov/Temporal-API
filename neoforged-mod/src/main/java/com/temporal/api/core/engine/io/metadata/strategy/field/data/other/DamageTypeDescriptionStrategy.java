package com.temporal.api.core.engine.io.metadata.strategy.field.data.other;

import com.temporal.api.core.engine.io.metadata.annotation.data.other.DamageTypeDescription;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.damage.ApiDamageTypeProvider;
import com.temporal.api.core.event.data.damage.DamageTypeDescriptionHolder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class DamageTypeDescriptionStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        DamageTypeDescription annotation = field.getDeclaredAnnotation(DamageTypeDescription.class);
        ResourceKey<DamageType> damageType = (ResourceKey<DamageType>) field.get(object);
        DamageTypeDescriptionHolder descriptionHolder = new DamageTypeDescriptionHolder(annotation.damageScaling(), annotation.exhaustion(), annotation.effects(), annotation.messageType());
        ApiDamageTypeProvider.DAMAGE_TYPES.put(damageType, descriptionHolder);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return DamageTypeDescription.class;
    }
}
