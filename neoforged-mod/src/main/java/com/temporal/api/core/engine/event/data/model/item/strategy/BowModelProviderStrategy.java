package com.temporal.api.core.engine.event.data.model.item.strategy;

import com.temporal.api.core.engine.event.data.model.item.ApiItemModelProvider;
import com.temporal.api.core.engine.event.data.model.item.ItemModelProviderStrategy;
import com.temporal.api.core.engine.event.data.model.item.spec.ItemModelSpec;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;

public class BowModelProviderStrategy implements ItemModelProviderStrategy<ItemModelSpec> {
    public static final String MODEL_PARENT = "bow";
    public static final String PULLING_PROPERTY = "pulling";
    public static final String PULL_PROPERTY = "pull";
    public static final String PULLING_0 = "_" + PULLING_PROPERTY + "_0";
    public static final String PULLING_1 = "_" + PULLING_PROPERTY + "_1";
    public static final String PULLING_2 = "_" + PULLING_PROPERTY + "_2";
    public static final int IS_PULLING_VALUE = 1;
    public static final float IS_HALF_PULLED_VALUE = 0.65f;
    public static final float IS_NEARLY_END_PULLED_VALUE = 0.9f;

    @Override
    public void registerItemModel(ItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
//        provider.simpleItem(itemPath, MODEL_PARENT)
//                .override()
//                .predicate(provider.mcLoc(PULLING_PROPERTY), IS_PULLING_VALUE)
//                .model(provider.simpleItem(itemPath + PULLING_0, MODEL_PARENT))
//                .end()
//                .override()
//                .predicate(provider.mcLoc(PULLING_PROPERTY), IS_PULLING_VALUE)
//                .predicate(provider.mcLoc(PULL_PROPERTY), IS_HALF_PULLED_VALUE)
//                .model(provider.simpleItem(itemPath + PULLING_1, MODEL_PARENT))
//                .end()
//                .override()
//                .predicate(provider.mcLoc(PULLING_PROPERTY), IS_PULLING_VALUE)
//                .predicate(provider.mcLoc(PULL_PROPERTY), IS_NEARLY_END_PULLED_VALUE)
//                .model(provider.simpleItem(itemPath + PULLING_2, MODEL_PARENT))
//                .end();
        ItemModelBuilder modelBuilder = provider.simpleItem(itemPath, MODEL_PARENT);
        provider.applyOverrides(modelBuilder,
                (override) -> override
                        .predicate(provider.mcLoc(PULLING_PROPERTY), IS_PULLING_VALUE)
                        .model(provider.simpleItem(itemPath + PULLING_0, MODEL_PARENT)),
                (override) -> override
                        .predicate(provider.mcLoc(PULLING_PROPERTY), IS_PULLING_VALUE)
                        .predicate(provider.mcLoc(PULL_PROPERTY), IS_HALF_PULLED_VALUE)
                        .model(provider.simpleItem(itemPath + PULLING_1, MODEL_PARENT)),
                (override) -> override
                        .predicate(provider.mcLoc(PULLING_PROPERTY), IS_PULLING_VALUE)
                        .predicate(provider.mcLoc(PULL_PROPERTY), IS_NEARLY_END_PULLED_VALUE)
                        .model(provider.simpleItem(itemPath + PULLING_2, MODEL_PARENT)));
    }
}
