package com.temporal.api.core.engine.metadata.strategy.field.data;

import com.temporal.api.core.engine.event.data.damage.ApiDamageTypeProvider;
import com.temporal.api.core.engine.event.data.damage.DamageTypeDescription;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.GenerateDamageType;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateDamageTypeStrategy implements FieldAnnotationStrategy<GenerateDamageType> {
    @Override
    public void execute(Field field, Object object, GenerateDamageType annotation) throws Exception {
        ResourceKey<DamageType> damageType = ReflectionUtils.getFieldValue(field, object);
        DamageTypeDescription description = new DamageTypeDescription(annotation.scaling(), annotation.exhaustion(), annotation.effects(), annotation.message());
        ApiDamageTypeProvider.DAMAGE_TYPES.put(damageType, description);
    }

    @Override
    public Class<GenerateDamageType> getAnnotationClass() {
        return GenerateDamageType.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
