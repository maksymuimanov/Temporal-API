package com.temporal.api.core.engine.io.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.io.metadata.annotation.data.properties.MonsterRoomMob;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.event.data.map.MonsterRoomMobDto;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class MonsterRoomMobStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        MonsterRoomMob monsterRoomMob = field.getAnnotation(MonsterRoomMob.class);
        Holder<EntityType<?>> entityType = (Holder<EntityType<?>>) field.get(object);
        MonsterRoomMobDto monsterRoomMobDto = new MonsterRoomMobDto(entityType, monsterRoomMob.weight(), monsterRoomMob.replace());
        ApiDataMapProvider.MONSTER_ROOM_MOBS.add(monsterRoomMobDto);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return MonsterRoomMob.class;
    }
}
