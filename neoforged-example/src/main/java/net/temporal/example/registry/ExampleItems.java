package net.temporal.example.registry;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.metadata.annotation.data.AddItemTag;
import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateEnglish;
import com.temporal.api.core.engine.io.metadata.annotation.data.model.GenerateItemModel;
import com.temporal.api.core.engine.io.metadata.annotation.data.properties.Compostable;
import com.temporal.api.core.engine.io.metadata.annotation.data.properties.FurnaceFuel;
import com.temporal.api.core.engine.io.metadata.annotation.event.AddCreativeModeTab;
import com.temporal.api.core.engine.io.metadata.annotation.event.SetupBow;
import com.temporal.api.core.engine.io.metadata.annotation.event.SetupCrossbow;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.io.metadata.constant.CreativeModeTabType;
import com.temporal.api.core.engine.io.metadata.constant.ItemModelType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;

@Injected
public final class ExampleItems {
    private static final ExampleItemFactory ITEM_FACTORY = InjectionPool.getFromInstance(ExampleItemFactory.class);

    @AddCreativeModeTab(CreativeModeTabType.INGREDIENTS)
    @GenerateItemModel
    @AddItemTag("example:repairs_example_armor")
    @TranslateEnglish("Example Ingot")
    public static final DeferredItem<?> EXAMPLE_INGOT = ITEM_FACTORY.create("example_ingot");

    @AddCreativeModeTab(CreativeModeTabType.COMBAT)
    @GenerateItemModel(ItemModelType.HANDHELD)
    @TranslateEnglish("Example Sword")
    public static final DeferredItem<?> EXAMPLE_SWORD = ITEM_FACTORY.createSword("example_sword", Tiers.NETHERITE, 1, 1f);

    @AddCreativeModeTab(CreativeModeTabType.COMBAT)
    @GenerateItemModel(ItemModelType.TRIMMED_ARMOR)
    @AddItemTag("minecraft:trimmable_armor")
    @TranslateEnglish("Example Helmet")
    public static final DeferredItem<?> EXAMPLE_HELMET = ITEM_FACTORY.createArmor("example_helmet", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.HELMET);

    @AddCreativeModeTab(CreativeModeTabType.COMBAT)
    @GenerateItemModel(ItemModelType.TRIMMED_ARMOR)
    @AddItemTag("minecraft:trimmable_armor")
    @TranslateEnglish("Example Chestplate")
    public static final DeferredItem<?> EXAMPLE_CHESTPLATE = ITEM_FACTORY.createArmor("example_chestplate", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE);

    @AddCreativeModeTab(CreativeModeTabType.COMBAT)
    @GenerateItemModel(ItemModelType.TRIMMED_ARMOR)
    @AddItemTag("minecraft:trimmable_armor")
    @TranslateEnglish("Example Leggings")
    public static final DeferredItem<?> EXAMPLE_LEGGINGS = ITEM_FACTORY.createArmor("example_leggings", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS);

    @AddCreativeModeTab(CreativeModeTabType.COMBAT)
    @GenerateItemModel(ItemModelType.TRIMMED_ARMOR)
    @AddItemTag("minecraft:trimmable_armor")
    @TranslateEnglish("Example Boots")
    public static final DeferredItem<?> EXAMPLE_BOOTS = ITEM_FACTORY.createArmor("example_boots", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS);

    @AddCreativeModeTab(CreativeModeTabType.COMBAT)
    @SetupBow
    @GenerateItemModel(ItemModelType.BOW)
    @TranslateEnglish("Example Bow")
    public static final DeferredItem<?> EXAMPLE_BOW = ITEM_FACTORY.createBow("example_bow");

    @AddCreativeModeTab(CreativeModeTabType.COMBAT)
    @SetupCrossbow
    @GenerateItemModel(ItemModelType.CROSSBOW)
    @TranslateEnglish("Example Crossbow")
    public static final DeferredItem<?> EXAMPLE_CROSSBOW = ITEM_FACTORY.createCrossbow("example_crossbow");

    @AddCreativeModeTab(CreativeModeTabType.INGREDIENTS)
    @GenerateItemModel
    @FurnaceFuel(burnTime = 1000)
    @TranslateEnglish("Example Fuel")
    public static final DeferredItem<?> EXAMPLE_FUEL = ITEM_FACTORY.create("example_fuel");

    @AddCreativeModeTab(CreativeModeTabType.INGREDIENTS)
    @GenerateItemModel
    @Compostable(chance = 1)
    @TranslateEnglish("Example Compostable Item")
    public static final DeferredItem<?> EXAMPLE_COMPOSTABLE_ITEM = ITEM_FACTORY.create("example_compostable_item");

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateItemModel
    @TranslateEnglish("Example Sign")
    public static final DeferredItem<?> EXAMPLE_SIGN = ITEM_FACTORY.createSign("example_sign", ExampleBlocks.EXAMPLE_SIGN, ExampleBlocks.EXAMPLE_WALL_SIGN);

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateItemModel
    @TranslateEnglish("Example Hanging Sign")
    public static final DeferredItem<?> EXAMPLE_HANGING_SIGN = ITEM_FACTORY.createHangingSign("example_hanging_sign", ExampleBlocks.EXAMPLE_HANGING_SIGN, ExampleBlocks.EXAMPLE_HANGING_WALL_SIGN);

    @AddCreativeModeTab(CreativeModeTabType.TOOLS_AND_UTILITIES)
    @GenerateItemModel
    @TranslateEnglish("Example Boat")
    public static final DeferredItem<?> EXAMPLE_BOAT = ITEM_FACTORY.createBoat("example_boat", "EXAMPLE");

    @AddCreativeModeTab(CreativeModeTabType.TOOLS_AND_UTILITIES)
    @GenerateItemModel
    @TranslateEnglish("Example Chest Boat")
    public static final DeferredItem<?> EXAMPLE_CHEST_BOAT = ITEM_FACTORY.createChestBoat("example_chest_boat", "EXAMPLE");

    @AddCreativeModeTab(CreativeModeTabType.SPAWN_EGGS)
    @GenerateItemModel(ItemModelType.SPAWN_EGG)
    @TranslateEnglish("Example Spawn Egg")
    public static final DeferredItem<?> EXAMPLE_SPAWN_EGG = ITEM_FACTORY.createSpawnEgg("example_spawn_egg", ExampleEntityTypes.EXAMPLE_ENTITY, 0x473A24FF, 0x71634FFF);
}