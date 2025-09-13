package com.temporal.api.core.engine.metadata.strategy.field.data.tag;

import com.temporal.api.core.engine.event.data.tag.BannerPatternTagsProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddBannerPatternTag;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class AddBannerPatternTagStrategy implements FieldAnnotationStrategy<AddBannerPatternTag> {
    @Override
    public void execute(Field field, Object object, AddBannerPatternTag annotation) throws Exception {
        ResourceKey<BannerPattern> bannerPattern = (ResourceKey<BannerPattern>) field.get(object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(BannerPatternTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, bannerPattern);
        }
    }

    @Override
    public Class<? extends AddBannerPatternTag> getAnnotationClass() {
        return AddBannerPatternTag.class;
    }

    @Override
    public AnnotationExecutor<? extends AnnotationStrategy<Field, ?>> getExecutor() {
        return MetadataLayer.STATIC_FIELD_EXECUTOR;
    }
}
