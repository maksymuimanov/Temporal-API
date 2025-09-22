package com.temporal.api.core.engine.event.data.model.item.spec;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

public class CustomItemModelSpec extends ItemModelSpec {
    private final List<String> additionalData;

    public CustomItemModelSpec(Holder<? extends Item> holder) {
        this(holder, new ArrayList<>());
    }

    public CustomItemModelSpec(Holder<? extends Item> holder, List<String> additionalData) {
        super(holder);
        this.additionalData = additionalData;
    }

    public String getAdditionalDataElement(int index) {
        return this.getAdditionalData().get(index);
    }

    public List<String> getAdditionalData() {
        return additionalData;
    }
}
