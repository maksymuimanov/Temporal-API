package com.temporal.api.core.event.data.model.item;

import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

public class TrimmedItemModelProviderStrategy implements ItemModelProviderStrategy {
    private static final String[] TRIM_MATERIALS = {"quartz", "iron", "netherite", "redstone", "copper", "gold", "emerald", "diamond", "lapis", "amethyst"};

    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        if (item instanceof ArmorItem armorItem) {
            ResourceLocation location = BuiltInRegistries.ITEM.getKey(armorItem);
            ItemModelBuilder itemModel = provider.simpleItem(item, "generated");
            int trimType = 1;
            for (String trim : TRIM_MATERIALS) {
                ResourceLocation name = ResourceLocation.fromNamespaceAndPath(location.getNamespace(), "item/" + location.getPath() + "_" + trim + "_trim");
                itemModel.override().model(new ModelFile.UncheckedModelFile(name)).predicate(ResourceLocation.withDefaultNamespace("trim_type"), (float) (trimType / 10.0));
                ResourceLocation texture = ResourceLocation.withDefaultNamespace("trims/items/" + armorItem.getType().getName() + "_trim_" + trim);
                provider.existingFileHelper.trackGenerated(texture, PackType.CLIENT_RESOURCES, ".png", "textures");
                provider.withExistingParent(name.getPath(), "item/generated")
                        .texture("layer0", ResourceUtils.parse("item/" + location.getPath()))
                        .texture("layer1", texture);
                trimType++;
            }
        }
    }
}
