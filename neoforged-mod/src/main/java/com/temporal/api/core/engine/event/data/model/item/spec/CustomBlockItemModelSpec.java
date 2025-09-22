package com.temporal.api.core.engine.event.data.model.item.spec;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class CustomBlockItemModelSpec extends BlockItemModelSpec {
    private final List<String> additionalData;

    public CustomBlockItemModelSpec(Holder<? extends Item> holder) {
        this(holder, new ArrayList<>());
    }

    public CustomBlockItemModelSpec(Holder<? extends Item> holder, List<String> additionalData) {
        super(holder);
        this.additionalData = additionalData;
    }

    public CustomBlockItemModelSpec(Holder<? extends Item> holder, String blockId) {
        this(holder, blockId, new ArrayList<>());
    }

    public CustomBlockItemModelSpec(Holder<? extends Item> holder, String blockId, List<String> additionalData) {
        super(holder, blockId);
        this.additionalData = additionalData;
    }

    public CustomBlockItemModelSpec(Holder<? extends Item> holder, Block block) {
        this(holder, block, new ArrayList<>());
    }

    public CustomBlockItemModelSpec(Holder<? extends Item> holder, Block block, List<String> additionalData) {
        super(holder, block);
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
