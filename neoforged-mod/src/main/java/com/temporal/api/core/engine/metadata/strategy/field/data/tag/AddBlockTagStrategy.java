package com.temporal.api.core.engine.metadata.strategy.field.data.tag;

import com.temporal.api.core.engine.event.data.tag.BlockTagsProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddBlockTag;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class AddBlockTagStrategy implements FieldAnnotationStrategy<AddBlockTag> {
    @Override
    public void execute(Field field, Object object, AddBlockTag annotation) throws Exception {
        Holder<? extends Block> deferredBlock = (Holder<? extends Block>) field.get(object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(BlockTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, deferredBlock);
        }
    }

    @Override
    public Class<? extends AddBlockTag> getAnnotationClass() {
        return AddBlockTag.class;
    }
}
