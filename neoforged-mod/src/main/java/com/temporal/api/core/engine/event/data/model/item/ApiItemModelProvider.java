package com.temporal.api.core.engine.event.data.model.item;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.event.data.model.ModelConstants;
import com.temporal.api.core.engine.event.data.model.item.spec.ItemModelSpec;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class ApiItemModelProvider extends ItemModelProvider {
    private static final ItemModelProviderStrategyConsumer CONSUMER = new ItemModelProviderStrategyConsumerImpl();

    public ApiItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModContext.NEO_MOD.getModId(), existingFileHelper);
    }

    @Override
    protected void registerModels() {
        CONSUMER.registerModels(this);
    }

    @SafeVarargs
    public final ItemModelBuilder applyOverrides(ItemModelBuilder builder, Function<ItemModelBuilder.OverrideBuilder, ItemModelBuilder.OverrideBuilder>... overrides) {
        for (var function : overrides) {
            ItemModelBuilder.OverrideBuilder overrideBuilder = builder.override();
            function.apply(overrideBuilder).end();
        }
        return builder;
    }

    public ItemModelBuilder simpleItem(String itemPath, String parent) {
        return this.withExistingParent(itemPath, ItemModelSpec.ITEM_PREFIX + "/" + parent)
                .texture(ModelConstants.LAYER_0, ResourceUtils.parse(itemPath));
    }
}
