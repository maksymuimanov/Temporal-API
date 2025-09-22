package com.temporal.api.core.engine.event.data.loot.spec;

import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CropBlockLootTableSpec extends BlockLootTableSpec {
    private final Item grownItem;
    private final Item seedsItem;
    private final int grownAge;
    private final int minAge;
    private final int maxAge;

    public CropBlockLootTableSpec(Holder<? extends Block> holder, String grownItemId, String seedsItemId, int grownAge, int minAge, int maxAge) {
        this(holder, RegistryUtils.getItem(grownItemId), RegistryUtils.getItem(seedsItemId), grownAge, minAge, maxAge);
    }

    public CropBlockLootTableSpec(Holder<? extends Block> holder, Item grownItem, Item seedsItem, int grownAge, int minAge, int maxAge) {
        super(holder);
        this.grownItem = grownItem;
        this.seedsItem = seedsItem;
        this.grownAge = grownAge;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public Item getGrownItem() {
        return grownItem;
    }

    public Item getSeedsItem() {
        return seedsItem;
    }

    public int getGrownAge() {
        return grownAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }
}
