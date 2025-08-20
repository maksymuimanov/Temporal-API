package com.temporal.api.core.engine.io.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.io.metadata.annotation.data.properties.RaidHeroGift;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.event.data.map.RaidHeroGiftDto;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.npc.VillagerProfession;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class RaidHeroGiftStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        RaidHeroGift raidHeroGift = field.getAnnotation(RaidHeroGift.class);
        Holder<VillagerProfession> villagerProfession = (Holder<VillagerProfession>) field.get(object);
        RaidHeroGiftDto raidHeroGiftDto = new RaidHeroGiftDto(villagerProfession, raidHeroGift.lootTablePath(), raidHeroGift.replace());
        ApiDataMapProvider.RAID_HERO_GIFTS.add(raidHeroGiftDto);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return RaidHeroGift.class;
    }
}
