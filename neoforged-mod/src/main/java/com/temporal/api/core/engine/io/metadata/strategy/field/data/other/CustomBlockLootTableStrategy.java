package com.temporal.api.core.engine.io.metadata.strategy.field.data.other;

import com.temporal.api.core.collection.SimplePair;
import com.temporal.api.core.engine.io.metadata.annotation.data.other.CustomBlockLootTable;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.loot.BlockLootTableProvider;
import com.temporal.api.core.event.data.loot.LootProviderStrategy;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class CustomBlockLootTableStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        DeferredBlock<?> registryObject = (DeferredBlock<?>) field.get(object);
        CustomBlockLootTable blockLootTable = field.getDeclaredAnnotation(CustomBlockLootTable.class);
        String[] additionalData = blockLootTable.additionalData();
        LootProviderStrategy providerStrategy = blockLootTable.value()
                .getDeclaredConstructor()
                .newInstance();
        BlockLootTableProvider.CUSTOM_LOOT.put(new SimplePair<>(registryObject, additionalData), providerStrategy);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return CustomBlockLootTable.class;
    }
}
