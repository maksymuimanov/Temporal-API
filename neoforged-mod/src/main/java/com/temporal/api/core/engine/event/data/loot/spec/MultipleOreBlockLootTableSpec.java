package com.temporal.api.core.engine.event.data.loot.spec;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MultipleOreBlockLootTableSpec extends OtherItemBlockLootTableSpec {
    private final float minCount;
    private final float maxCount;

    public MultipleOreBlockLootTableSpec(Holder<? extends Block> holder, String otherItemId, float minCount, float maxCount) {
        super(holder, otherItemId);
        this.minCount = minCount;
        this.maxCount = maxCount;
    }

    public MultipleOreBlockLootTableSpec(Holder<? extends Block> holder, Item otherItem, float minCount, float maxCount) {
        super(holder, otherItem);
        this.minCount = minCount;
        this.maxCount = maxCount;
    }

    public float getMinCount() {
        return minCount;
    }

    public float getMaxCount() {
        return maxCount;
    }
}
