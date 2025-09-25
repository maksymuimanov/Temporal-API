package com.temporal.api.core.engine.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.engine.event.data.map.MonsterRoomMobDto;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.properties.MonsterRoomMob;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class MonsterRoomMobStrategy implements FieldAnnotationStrategy<MonsterRoomMob> {
    @Override
    public void execute(Field field, Object object, MonsterRoomMob annotation) throws Exception {
        Holder<EntityType<?>> entityType = ReflectionUtils.getFieldValue(field, object);
        MonsterRoomMobDto monsterRoomMobDto = new MonsterRoomMobDto(entityType, annotation.weight(), annotation.replace());
        ApiDataMapProvider.MONSTER_ROOM_MOBS.add(monsterRoomMobDto);
    }

    @Override
    public Class<MonsterRoomMob> getAnnotationClass() {
        return MonsterRoomMob.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
