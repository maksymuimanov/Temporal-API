package com.temporal.api.core.engine.io.metadata.strategy.field.data;

import com.temporal.api.core.engine.io.metadata.annotation.data.GenerateDamageType;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.damage.ApiDamageTypeProvider;
import com.temporal.api.core.event.data.damage.DamageTypeDescription;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

import java.lang.reflect.Field;

public class GenerateDamageTypeStrategy implements FieldAnnotationStrategy<GenerateDamageType> {
    @Override
    public void execute(Field field, Object object, GenerateDamageType annotation) throws Exception {
        ResourceKey<DamageType> damageType = (ResourceKey<DamageType>) field.get(object);
        DamageTypeDescription descriptionHolder = new DamageTypeDescription(annotation.damageScaling(), annotation.exhaustion(), annotation.effects(), annotation.messageType());
        ApiDamageTypeProvider.DAMAGE_TYPES.put(damageType, descriptionHolder);

    }

    @Override
    public Class<? extends GenerateDamageType> getAnnotationClass() {
        return GenerateDamageType.class;
    }
}
