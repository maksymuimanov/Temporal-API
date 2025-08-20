package com.temporal.api.core.event.data.model.item;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.util.other.ResourceUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ApiItemModelProvider extends ItemModelProvider {
    private static final ItemModelProviderStrategyConsumer CONSUMER = new ItemModelProviderStrategyConsumerImpl();

    public ApiItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IOLayer.NEO_MOD.getModId(), existingFileHelper);
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
        return this.withExistingParent(itemPath, "item/" + parent)
                .texture("layer0", ResourceUtils.parse(itemPath));
    }

    protected String getItemPath(Item item) {
        return this.getItemPath(item, "item");
    }

    protected String getItemPath(Item item, String prefix) {
        ResourceLocation location = BuiltInRegistries.ITEM.getKey(item);
        return location.getNamespace() + ":" + prefix + "/" + location.getPath();
    }
}
