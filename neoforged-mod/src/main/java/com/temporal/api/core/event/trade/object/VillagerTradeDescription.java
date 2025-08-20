package com.temporal.api.core.event.trade.object;

import net.minecraft.world.entity.npc.VillagerProfession;

public class VillagerTradeDescription extends TradeDescription {
    private final VillagerProfession villagerProfession;
    private final int level;

    public VillagerTradeDescription(VillagerProfession villagerProfession, int level, int maxUses, int XP, float priceMultiplier) {
        super(maxUses, XP, priceMultiplier);
        this.villagerProfession = villagerProfession;
        this.level = level;
    }

    public VillagerProfession getVillagerProfession() {
        return villagerProfession;
    }

    public int getLevel() {
        return level;
    }
}
