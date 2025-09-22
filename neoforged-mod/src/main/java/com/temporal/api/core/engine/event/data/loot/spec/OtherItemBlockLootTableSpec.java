package com.temporal.api.core.engine.event.data.loot.spec;

import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class OtherItemBlockLootTableSpec extends BlockLootTableSpec {
    private final Item otherItem;

    public OtherItemBlockLootTableSpec(Holder<? extends Block> holder, String otherItemId) {
        this(holder, RegistryUtils.getItem(otherItemId));
    }

    public OtherItemBlockLootTableSpec(Holder<? extends Block> holder, Item otherItem) {
        super(holder);
        this.otherItem = otherItem;
    }

    public Item getOtherItem() {
        return otherItem;
    }
}