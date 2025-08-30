package com.temporal.api.core.registry.factory;

import com.google.common.collect.ImmutableSet;
import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.TemporalRegister;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

public class VillagerProfessionFactory extends AbstractObjectFactory<VillagerProfession> {
    public VillagerProfessionFactory() {
        this(InjectionPool.getFromInstance("$VillagerProfessions"));
    }

    public VillagerProfessionFactory(TemporalRegister<VillagerProfession> villagerProfessions) {
        super(villagerProfessions);
    }

    public DeferredHolder<VillagerProfession, VillagerProfession> create(String name, String professionName, PoiType heldJobSite, SoundEvent workSound) {
        return this.create(name, professionName, heldJobSite, heldJobSite, workSound);
    }

    public DeferredHolder<VillagerProfession, VillagerProfession> create(String name, String professionName, PoiType heldJobSite, PoiType acquirableJobSite, SoundEvent workSound) {
        return this.create(name, professionName, heldJobSite, acquirableJobSite, ImmutableSet.of(), ImmutableSet.of(), workSound);
    }

    public DeferredHolder<VillagerProfession, VillagerProfession> create(String name, String professionName, PoiType heldJobSite, PoiType acquirableJobSite, ImmutableSet<Item> requestedItems, ImmutableSet<Block> secondaryPoi, SoundEvent workSound) {
        return this.create(name, () -> new VillagerProfession(professionName,
                holder -> holder.value() == heldJobSite,
                holder -> holder.value() == acquirableJobSite,
                requestedItems, secondaryPoi, workSound));
    }
}
