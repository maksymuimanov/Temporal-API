package com.temporal.api.core.event.data.map;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.util.other.RegistryUtils;
import com.temporal.api.core.util.other.ResourceUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.util.random.Weight;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.*;
import org.jetbrains.annotations.NotNull;

import java.util.Queue;
import java.util.concurrent.CompletableFuture;

public class ApiDataMapProvider extends DataMapProvider {
    public static final Queue<FurnaceFuelDto> FURNACE_FUELS = new TemporalQueue<>();
    public static final Queue<CompostableDto> COMPOSTABLES = new TemporalQueue<>();
    public static final Queue<OxidizableDto> OXIDIZABLES = new TemporalQueue<>();
    public static final Queue<WaxableDto> WAXABLES = new TemporalQueue<>();
    public static final Queue<RaidHeroGiftDto> RAID_HERO_GIFTS = new TemporalQueue<>();
    public static final Queue<MonsterRoomMobDto> MONSTER_ROOM_MOBS = new TemporalQueue<>();
    public static final Queue<ParrotImitationDto> PARROT_IMITATIONS = new TemporalQueue<>();

    public ApiDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(@NotNull HolderLookup.Provider provider) {
        Builder<FurnaceFuel, Item> fuelItemBuilder = this.builder(NeoForgeDataMaps.FURNACE_FUELS);
        FURNACE_FUELS.forEach(fuel ->
                fuelItemBuilder.add(fuel.item(), new FurnaceFuel(fuel.burnTime()), fuel.replace()));
        Builder<Compostable, Item> compostableItemBuilder = this.builder(NeoForgeDataMaps.COMPOSTABLES);
        COMPOSTABLES.forEach(compostable ->
                compostableItemBuilder.add(compostable.item(), new Compostable(compostable.chance()), compostable.replace()));
        Builder<Oxidizable, Block> oxidizableBlockBuilder = this.builder(NeoForgeDataMaps.OXIDIZABLES);
        OXIDIZABLES.forEach(oxidizable ->
                oxidizableBlockBuilder.add(oxidizable.block(), new Oxidizable(RegistryUtils.getBlockById(oxidizable.nextStageBlockId())), oxidizable.replace()));
        Builder<Waxable, Block> waxableBlockBuilder = this.builder(NeoForgeDataMaps.WAXABLES);
        WAXABLES.forEach(waxable ->
                waxableBlockBuilder.add(waxable.block(), new Waxable(RegistryUtils.getBlockById(waxable.waxedBlock())), waxable.replace()));
        Builder<RaidHeroGift, VillagerProfession> raidHeroGiftVillagerProfessionBuilder = this.builder(NeoForgeDataMaps.RAID_HERO_GIFTS);
        RAID_HERO_GIFTS.forEach(raidHeroGift ->
                raidHeroGiftVillagerProfessionBuilder.add(raidHeroGift.villagerProfession(), new RaidHeroGift(ResourceUtils.createKey(Registries.LOOT_TABLE, raidHeroGift.lootTablePath())), raidHeroGift.replace()));
        Builder<MonsterRoomMob, EntityType<?>> monsterRoomMobEntityTypeBuilder = this.builder(NeoForgeDataMaps.MONSTER_ROOM_MOBS);
        MONSTER_ROOM_MOBS.forEach(monsterRoomMob ->
                monsterRoomMobEntityTypeBuilder.add(monsterRoomMob.entity(), new MonsterRoomMob(Weight.of(monsterRoomMob.weight())), monsterRoomMob.replace()));
        Builder<ParrotImitation, EntityType<?>> parrotImitationEntityTypeBuilder = this.builder(NeoForgeDataMaps.PARROT_IMITATIONS);
        PARROT_IMITATIONS.forEach(parrotImitation ->
                parrotImitationEntityTypeBuilder.add(parrotImitation.entity(), new ParrotImitation(RegistryUtils.getSoundEventById(parrotImitation.soundEventId())), parrotImitation.replace()));
    }
}
