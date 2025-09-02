package com.temporal.api.core.engine.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.engine.event.data.map.RaidHeroGiftDto;
import com.temporal.api.core.engine.metadata.annotation.data.properties.RaidHeroGift;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
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
