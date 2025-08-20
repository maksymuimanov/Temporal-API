package net.temporal.example.registry;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.metadata.annotation.data.language.EnglishTranslation;
import com.temporal.api.core.engine.io.metadata.annotation.data.model.ItemModel;
import com.temporal.api.core.engine.io.metadata.annotation.data.properties.Compostable;
import com.temporal.api.core.engine.io.metadata.annotation.data.properties.FurnaceFuel;
import com.temporal.api.core.engine.io.metadata.annotation.data.tag.ItemTagComponent;
import com.temporal.api.core.engine.io.metadata.annotation.event.fml.SetupBowClient;
import com.temporal.api.core.engine.io.metadata.annotation.event.fml.SetupCrossbowClient;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Registry;
import com.temporal.api.core.engine.io.metadata.constant.ItemModelType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;

@Injected(false)
public final class ExampleItems {
    @Registry
    private static final ExampleItemFactory ITEM_FACTORY = InjectionPool.getFromInstance(ExampleItemFactory.class);

    @ItemModel
    @ItemTagComponent("example:repairs_example_armor")
    @EnglishTranslation("Example Ingot")
    public static final DeferredItem<?> EXAMPLE_INGOT = ITEM_FACTORY.create("example_ingot");

    @ItemModel(ItemModelType.HANDHELD)
    @EnglishTranslation("Example Sword")
    public static final DeferredItem<?> EXAMPLE_SWORD = ITEM_FACTORY.createSword("example_sword", Tiers.NETHERITE, 1, 1f);

    @ItemModel(ItemModelType.TRIMMED_ARMOR)
    @ItemTagComponent("minecraft:trimmable_armor")
    @EnglishTranslation("Example Helmet")
    public static final DeferredItem<?> EXAMPLE_HELMET = ITEM_FACTORY.createArmor("example_helmet", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.HELMET);

    @ItemModel(ItemModelType.TRIMMED_ARMOR)
    @ItemTagComponent("minecraft:trimmable_armor")
    @EnglishTranslation("Example Chestplate")
    public static final DeferredItem<?> EXAMPLE_CHESTPLATE = ITEM_FACTORY.createArmor("example_chestplate", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE);

    @ItemModel(ItemModelType.TRIMMED_ARMOR)
    @ItemTagComponent("minecraft:trimmable_armor")
    @EnglishTranslation("Example Leggings")
    public static final DeferredItem<?> EXAMPLE_LEGGINGS = ITEM_FACTORY.createArmor("example_leggings", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS);

    @ItemModel(ItemModelType.TRIMMED_ARMOR)
    @ItemTagComponent("minecraft:trimmable_armor")
    @EnglishTranslation("Example Boots")
    public static final DeferredItem<?> EXAMPLE_BOOTS = ITEM_FACTORY.createArmor("example_boots", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS);

    @SetupBowClient
    @ItemModel(ItemModelType.BOW)
    @EnglishTranslation("Example Bow")
    public static final DeferredItem<?> EXAMPLE_BOW = ITEM_FACTORY.createBow("example_bow");

    @SetupCrossbowClient
    @ItemModel(ItemModelType.CROSSBOW)
    @EnglishTranslation("Example Crossbow")
    public static final DeferredItem<?> EXAMPLE_CROSSBOW = ITEM_FACTORY.createCrossbow("example_crossbow");

    @ItemModel
    @FurnaceFuel(burnTime = 1000)
    @EnglishTranslation("Example Fuel")
    public static final DeferredItem<?> EXAMPLE_FUEL = ITEM_FACTORY.create("example_fuel");

    @ItemModel
    @Compostable(chance = 1)
    @EnglishTranslation("Example Compostable Item")
    public static final DeferredItem<?> EXAMPLE_COMPOSTABLE_ITEM = ITEM_FACTORY.create("example_compostable_item");

    @ItemModel
    @EnglishTranslation("Example Sign")
    public static final DeferredItem<?> EXAMPLE_SIGN = ITEM_FACTORY.createSign("example_sign", ExampleBlocks.EXAMPLE_SIGN, ExampleBlocks.EXAMPLE_WALL_SIGN);

    @ItemModel
    @EnglishTranslation("Example Hanging Sign")
    public static final DeferredItem<?> EXAMPLE_HANGING_SIGN = ITEM_FACTORY.createHangingSign("example_hanging_sign", ExampleBlocks.EXAMPLE_HANGING_SIGN, ExampleBlocks.EXAMPLE_HANGING_WALL_SIGN);
}