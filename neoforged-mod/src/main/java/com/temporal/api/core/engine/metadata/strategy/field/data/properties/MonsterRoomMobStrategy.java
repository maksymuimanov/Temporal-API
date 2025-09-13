package com.temporal.api.core.engine.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.engine.event.data.map.MonsterRoomMobDto;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.data.properties.MonsterRoomMob;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class MonsterRoomMobStrategy implements FieldAnnotationStrategy<MonsterRoomMob> {
    @Override
    public void execute(Field field, Object object, MonsterRoomMob annotation) throws Exception {
        Holder<EntityType<?>> entityType = (Holder<EntityType<?>>) field.get(object);
        MonsterRoomMobDto monsterRoomMobDto = new MonsterRoomMobDto(entityType, annotation.weight(), annotation.replace());
        ApiDataMapProvider.MONSTER_ROOM_MOBS.add(monsterRoomMobDto);
    }

    @Override
    public Class<? extends MonsterRoomMob> getAnnotationClass() {
        return MonsterRoomMob.class;
    }

    @Override
    public AnnotationExecutor<? extends AnnotationStrategy<Field, ?>> getExecutor() {
        return MetadataLayer.STATIC_FIELD_EXECUTOR;
    }
}
