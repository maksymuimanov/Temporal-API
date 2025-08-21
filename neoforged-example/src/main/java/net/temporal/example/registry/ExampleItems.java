package net.temporal.example.registry;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateEnglish;
import com.temporal.api.core.engine.io.metadata.annotation.data.model.GenerateItemModel;
import com.temporal.api.core.engine.io.metadata.annotation.data.properties.Compostable;
import com.temporal.api.core.engine.io.metadata.annotation.data.properties.FurnaceFuel;
import com.temporal.api.core.engine.io.metadata.annotation.data.AddItemTag;
import com.temporal.api.core.engine.io.metadata.annotation.event.SetupBow;
import com.temporal.api.core.engine.io.metadata.annotation.event.SetupCrossbow;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.io.metadata.annotation.injection.RegisterFactory;
import com.temporal.api.core.engine.io.metadata.constant.ItemModelType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;

@Injected(false)
public final class ExampleItems {
    @RegisterFactory
    private static final ExampleItemFactory ITEM_FACTORY = InjectionPool.getFromInstance(ExampleItemFactory.class);

    @GenerateItemModel
    @AddItemTag("example:repairs_example_armor")
    @TranslateEnglish("Example Ingot")
    public static final DeferredItem<?> EXAMPLE_INGOT = ITEM_FACTORY.create("example_ingot");

    @GenerateItemModel(ItemModelType.HANDHELD)
    @TranslateEnglish("Example Sword")
    public static final DeferredItem<?> EXAMPLE_SWORD = ITEM_FACTORY.createSword("example_sword", Tiers.NETHERITE, 1, 1f);

    @GenerateItemModel(ItemModelType.TRIMMED_ARMOR)
    @AddItemTag("minecraft:trimmable_armor")
    @TranslateEnglish("Example Helmet")
    public static final DeferredItem<?> EXAMPLE_HELMET = ITEM_FACTORY.createArmor("example_helmet", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.HELMET);

    @GenerateItemModel(ItemModelType.TRIMMED_ARMOR)
    @AddItemTag("minecraft:trimmable_armor")
    @TranslateEnglish("Example Chestplate")
    public static final DeferredItem<?> EXAMPLE_CHESTPLATE = ITEM_FACTORY.createArmor("example_chestplate", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE);

    @GenerateItemModel(ItemModelType.TRIMMED_ARMOR)
    @AddItemTag("minecraft:trimmable_armor")
    @TranslateEnglish("Example Leggings")
    public static final DeferredItem<?> EXAMPLE_LEGGINGS = ITEM_FACTORY.createArmor("example_leggings", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS);

    @GenerateItemModel(ItemModelType.TRIMMED_ARMOR)
    @AddItemTag("minecraft:trimmable_armor")
    @TranslateEnglish("Example Boots")
    public static final DeferredItem<?> EXAMPLE_BOOTS = ITEM_FACTORY.createArmor("example_boots", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS);

    @SetupBow
    @GenerateItemModel(ItemModelType.BOW)
    @TranslateEnglish("Example Bow")
    public static final DeferredItem<?> EXAMPLE_BOW = ITEM_FACTORY.createBow("example_bow");

    @SetupCrossbow
    @GenerateItemModel(ItemModelType.CROSSBOW)
    @TranslateEnglish("Example Crossbow")
    public static final DeferredItem<?> EXAMPLE_CROSSBOW = ITEM_FACTORY.createCrossbow("example_crossbow");

    @GenerateItemModel
    @FurnaceFuel(burnTime = 1000)
    @TranslateEnglish("Example Fuel")
    public static final DeferredItem<?> EXAMPLE_FUEL = ITEM_FACTORY.create("example_fuel");

    @GenerateItemModel
    @Compostable(chance = 1)
    @TranslateEnglish("Example Compostable Item")
    public static final DeferredItem<?> EXAMPLE_COMPOSTABLE_ITEM = ITEM_FACTORY.create("example_compostable_item");

    @GenerateItemModel
    @TranslateEnglish("Example Sign")
    public static final DeferredItem<?> EXAMPLE_SIGN = ITEM_FACTORY.createSign("example_sign", ExampleBlocks.EXAMPLE_SIGN, ExampleBlocks.EXAMPLE_WALL_SIGN);

    @GenerateItemModel
    @TranslateEnglish("Example Hanging Sign")
    public static final DeferredItem<?> EXAMPLE_HANGING_SIGN = ITEM_FACTORY.createHangingSign("example_hanging_sign", ExampleBlocks.EXAMPLE_HANGING_SIGN, ExampleBlocks.EXAMPLE_HANGING_WALL_SIGN);
}