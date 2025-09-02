package com.temporal.api.core.engine.event.data.model.item;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.util.RegistryUtils;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ApiItemModelProvider extends ItemModelProvider {
    private static final ItemModelProviderStrategyConsumer CONSUMER = new ItemModelProviderStrategyConsumerImpl();
    public static final String ITEM_PREFIX = "item";
    public static final String ITEM_PREFIX_PATH = ITEM_PREFIX + "/";
    public static final String ITEM_GENERATED = "item/generated";
    public static final String LAYER_0 = "layer0";
    public static final String LAYER_1 = "layer1";

    public ApiItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModContext.NEO_MOD.getModId(), existingFileHelper);
    }

    @Override
    protected void registerModels() {
        CONSUMER.registerModels(this);
    }

    protected ItemModelBuilder simpleItem(Item item, String parent) {
        String itemPath = this.getItemPath(item);
        return this.simpleItem(itemPath, parent);
    }

    protected ItemModelBuilder simpleItem(String itemPath, String parent) {
        return this.withExistingParent(itemPath, ITEM_PREFIX_PATH + parent)
                .texture(LAYER_0, ResourceUtils.parse(itemPath));
    }

    protected String getItemPath(Item item) {
        return this.getItemPath(item, ITEM_PREFIX);
    }

    protected String getItemPath(Item item, String prefix) {
        return RegistryUtils.getObjectName(BuiltInRegistries.ITEM, item, prefix);
    }
}
