package com.temporal.api.core.engine.metadata.strategy.field.data.tag;

import com.temporal.api.core.engine.event.data.tag.GameEventTagsProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddGameEventTag;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.gameevent.GameEvent;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class AddGameEventTagStrategy implements FieldAnnotationStrategy<AddGameEventTag> {
    @Override
    public void execute(Field field, Object object, AddGameEventTag annotation) throws Exception {
        Holder<? extends GameEvent> gameEvent = (Holder<? extends GameEvent>) field.get(object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(GameEventTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, gameEvent);
        }
    }

    @Override
    public Class<AddGameEventTag> getAnnotationClass() {
        return AddGameEventTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
