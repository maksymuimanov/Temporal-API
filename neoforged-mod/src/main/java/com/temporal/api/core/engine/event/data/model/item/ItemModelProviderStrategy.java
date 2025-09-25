package com.temporal.api.core.engine.event.data.model.item;

import com.temporal.api.core.engine.event.data.model.item.spec.ItemModelSpec;

public interface ItemModelProviderStrategy<T extends ItemModelSpec> {
    void registerItemModel(T spec, ApiItemModelProvider provider);
}
