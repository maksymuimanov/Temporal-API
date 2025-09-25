package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;

public interface BlockModelProviderStrategy<T extends BlockModelSpec> {
    void registerBlockModel(T spec, ApiBlockModelProvider provider);
}
