package com.temporal.api.core.engine.event.data.model.block.spec;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class CustomBlockModelSpec extends BlockModelSpec {
    private final List<String> additionalData;

    public CustomBlockModelSpec(Holder<? extends Block> holder) {
        this(holder, null);
    }

    public CustomBlockModelSpec(Holder<? extends Block> holder, String renderType) {
        this(holder, renderType, new ArrayList<>());
    }

    public CustomBlockModelSpec(Holder<? extends Block> holder, String renderType, List<String> additionalData) {
        super(holder, renderType);
        this.additionalData = additionalData;
    }

    public String getAdditionalDataElement(int index) {
        return this.getAdditionalData().get(index);
    }

    public List<String> getAdditionalData() {
        return additionalData;
    }
}
