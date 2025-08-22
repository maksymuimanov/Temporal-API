package com.temporal.api.core.engine.io.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.io.metadata.annotation.data.properties.RaidHeroGift;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.event.data.map.RaidHeroGiftDto;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.npc.VillagerProfession;

import java.lang.reflect.Field;

public class RaidHeroGiftStrategy implements FieldAnnotationStrategy<RaidHeroGift> {
    @Override
    public void execute(Field field, Object object, RaidHeroGift annotation) throws Exception {
        Holder<VillagerProfession> villagerProfession = (Holder<VillagerProfession>) field.get(object);
        RaidHeroGiftDto raidHeroGiftDto = new RaidHeroGiftDto(villagerProfession, annotation.lootTablePath(), annotation.replace());
        ApiDataMapProvider.RAID_HERO_GIFTS.add(raidHeroGiftDto);
    }

    @Override
    public Class<? extends RaidHeroGift> getAnnotationClass() {
        return RaidHeroGift.class;
    }
}
