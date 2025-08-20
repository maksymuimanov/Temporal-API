package com.temporal.api.core.event.data.map;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.npc.VillagerProfession;

public record RaidHeroGiftDto(Holder<VillagerProfession> villagerProfession, String lootTablePath, boolean replace) {
}