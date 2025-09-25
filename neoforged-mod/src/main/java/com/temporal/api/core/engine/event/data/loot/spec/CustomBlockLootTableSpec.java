package com.temporal.api.core.engine.event.data.loot.spec;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class CustomBlockLootTableSpec extends BlockLootTableSpec {
    private final List<String> additionalData;

    public CustomBlockLootTableSpec(Holder<? extends Block> holder) {
        this(holder, new ArrayList<>());
    }

    public CustomBlockLootTableSpec(Holder<? extends Block> holder, List<String> additionalData) {
        super(holder);
        this.additionalData = additionalData;
    }

    public int getAdditionalInteger(int index) {
        return Integer.parseInt(this.getAdditionalString(index));
    }

    public float getAdditionalFloat(int index) {
        return Float.parseFloat(this.getAdditionalString(index));
    }

    public String getAdditionalString(int index) {
        return this.getAdditionalData().get(index);
    }

    public List<String> getAdditionalData() {
        return additionalData;
    }
}
