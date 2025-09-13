package com.temporal.api.core.engine.metadata.strategy.field.data.tag;

import com.temporal.api.core.engine.event.data.tag.ItemTagsProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddItemTag;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class AddItemTagStrategy implements FieldAnnotationStrategy<AddItemTag> {
    @Override
    public void execute(Field field, Object object, AddItemTag annotation) throws Exception {
        Holder<? extends Item> deferredItem = ReflectionUtils.getItemHolder(field, object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(ItemTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, deferredItem);
        }
    }

    @Override
    public Class<? extends AddItemTag> getAnnotationClass() {
        return AddItemTag.class;
    }

    @Override
    public AnnotationExecutor<? extends AnnotationStrategy<Field, ?>> getExecutor() {
        return MetadataLayer.STATIC_FIELD_EXECUTOR;
    }
}
