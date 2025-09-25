package net.temporal.example.item;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateMultiple;
import com.temporal.api.core.engine.metadata.annotation.data.model.item.*;
import com.temporal.api.core.engine.metadata.annotation.data.properties.Compostable;
import com.temporal.api.core.engine.metadata.annotation.data.properties.FurnaceFuel;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddItemTag;
import com.temporal.api.core.engine.metadata.annotation.event.creative.AddCreativeModeTab;
import com.temporal.api.core.engine.metadata.annotation.event.fml.SetupBow;
import com.temporal.api.core.engine.metadata.annotation.event.fml.SetupCrossbow;
import com.temporal.api.core.engine.metadata.constant.CreativeModeTabType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;
import net.temporal.example.armor.ExampleArmorMaterials;
import net.temporal.example.block.ExampleBlocks;
import net.temporal.example.entity.ExampleEntityTypes;
import net.temporal.example.instrument.ExampleInstrumentTags;
import net.temporal.example.jukebox.ExampleJukeboxSongs;
import net.temporal.example.tag.ExampleBannerPatternTags;

public final class ExampleItems {
    private static final ExampleItemFactory ITEM_FACTORY = InjectionPool.getFromInstance(ExampleItemFactory.class);

    @AddCreativeModeTab(CreativeModeTabType.INGREDIENTS)
    @GenerateBasicItemModel
    @AddItemTag({"example:repairs_example_armor", "minecraft:trim_materials"})
    @TranslateAmericanEnglish("Example Ingot")
    public static final DeferredItem<?> EXAMPLE_INGOT = ITEM_FACTORY.create("example_ingot");

    @AddCreativeModeTab(CreativeModeTabType.COMBAT)
    @GenerateHandheldItemModel
    @TranslateAmericanEnglish("Example Sword")
    public static final DeferredItem<?> EXAMPLE_SWORD = ITEM_FACTORY.createSword("example_sword", Tiers.NETHERITE, 1, 1f);

    @AddCreativeModeTab(CreativeModeTabType.COMBAT)
    @GenerateTrimmedArmorItemModel
    @AddItemTag("minecraft:trimmable_armor")
    @TranslateAmericanEnglish("Example Helmet")
    public static final DeferredItem<?> EXAMPLE_HELMET = ITEM_FACTORY.createArmor("example_helmet", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.HELMET);

    @AddCreativeModeTab(CreativeModeTabType.COMBAT)
    @GenerateTrimmedArmorItemModel
    @AddItemTag("minecraft:trimmable_armor")
    @TranslateAmericanEnglish("Example Chestplate")
    public static final DeferredItem<?> EXAMPLE_CHESTPLATE = ITEM_FACTORY.createArmor("example_chestplate", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE);

    @AddCreativeModeTab(CreativeModeTabType.COMBAT)
    @GenerateTrimmedArmorItemModel
    @AddItemTag("minecraft:trimmable_armor")
    @TranslateAmericanEnglish("Example Leggings")
    public static final DeferredItem<?> EXAMPLE_LEGGINGS = ITEM_FACTORY.createArmor("example_leggings", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS);

    @AddCreativeModeTab(CreativeModeTabType.COMBAT)
    @GenerateTrimmedArmorItemModel
    @AddItemTag("minecraft:trimmable_armor")
    @TranslateAmericanEnglish("Example Boots")
    public static final DeferredItem<?> EXAMPLE_BOOTS = ITEM_FACTORY.createArmor("example_boots", ExampleArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS);

    @AddCreativeModeTab(CreativeModeTabType.INGREDIENTS)
    @GenerateBasicItemModel
    @TranslateAmericanEnglish("Example Armor Trim Smithing Template")
    public static final DeferredItem<?> EXAMPLE_ARMOR_TRIM_SMITHING_TEMPLATE = ITEM_FACTORY.createSmithingTemplate("example_armor_trim_smithing_template", "example:example");

    @AddCreativeModeTab(CreativeModeTabType.COMBAT)
    @SetupBow
    @GenerateBowItemModel
    @TranslateAmericanEnglish("Example Bow")
    public static final DeferredItem<?> EXAMPLE_BOW = ITEM_FACTORY.createBow("example_bow");

    @AddCreativeModeTab(CreativeModeTabType.COMBAT)
    @SetupCrossbow
    @GenerateCrossbowItemModel
    @TranslateAmericanEnglish("Example Crossbow")
    public static final DeferredItem<?> EXAMPLE_CROSSBOW = ITEM_FACTORY.createCrossbow("example_crossbow");

    @AddCreativeModeTab(CreativeModeTabType.INGREDIENTS)
    @GenerateBasicItemModel
    @FurnaceFuel(burnTime = 1000)
    @TranslateAmericanEnglish("Example Fuel")
    public static final DeferredItem<?> EXAMPLE_FUEL = ITEM_FACTORY.create("example_fuel");

    @AddCreativeModeTab(CreativeModeTabType.INGREDIENTS)
    @GenerateBasicItemModel
    @Compostable(chance = 1)
    @TranslateAmericanEnglish("Example Compostable Item")
    public static final DeferredItem<?> EXAMPLE_COMPOSTABLE_ITEM = ITEM_FACTORY.create("example_compostable_item");

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateBasicItemModel
    @TranslateAmericanEnglish("Example Sign")
    public static final DeferredItem<?> EXAMPLE_SIGN = ITEM_FACTORY.createSign("example_sign", ExampleBlocks.EXAMPLE_SIGN, ExampleBlocks.EXAMPLE_WALL_SIGN);

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateBasicItemModel
    @TranslateAmericanEnglish("Example Hanging Sign")
    public static final DeferredItem<?> EXAMPLE_HANGING_SIGN = ITEM_FACTORY.createHangingSign("example_hanging_sign", ExampleBlocks.EXAMPLE_HANGING_SIGN, ExampleBlocks.EXAMPLE_HANGING_WALL_SIGN);

    @AddCreativeModeTab(CreativeModeTabType.TOOLS_AND_UTILITIES)
    @GenerateBasicItemModel
    @TranslateAmericanEnglish("Example Boat")
    public static final DeferredItem<?> EXAMPLE_BOAT = ITEM_FACTORY.createBoat("example_boat", "EXAMPLE");

    @AddCreativeModeTab(CreativeModeTabType.TOOLS_AND_UTILITIES)
    @GenerateBasicItemModel
    @TranslateAmericanEnglish("Example Chest Boat")
    public static final DeferredItem<?> EXAMPLE_CHEST_BOAT = ITEM_FACTORY.createChestBoat("example_chest_boat", "EXAMPLE");

    @AddCreativeModeTab(CreativeModeTabType.SPAWN_EGGS)
    @GenerateSpawnEggItemModel
    @TranslateAmericanEnglish("Example Spawn Egg")
    public static final DeferredItem<?> EXAMPLE_SPAWN_EGG = ITEM_FACTORY.createSpawnEgg("example_spawn_egg", ExampleEntityTypes.EXAMPLE_ENTITY, 0x473A24FF, 0x71634FFF);

    @AddCreativeModeTab(CreativeModeTabType.INGREDIENTS)
    @GenerateBasicItemModel
    @TranslateMultiple(americanEnglish = {
            @TranslateAmericanEnglish("Banner Pattern"),
            @TranslateAmericanEnglish(value = "Example Banner Pattern", suffix = "desc")
    })
    public static final DeferredItem<?> EXAMPLE_BANNER_ITEM = ITEM_FACTORY.createBannerPattern("example_banner_pattern", ExampleBannerPatternTags.EXAMPLE);

    @AddCreativeModeTab(CreativeModeTabType.TOOLS_AND_UTILITIES)
    @GenerateBasicItemModel
    @TranslateAmericanEnglish("Example Music Disc")
    public static final DeferredItem<?> EXAMPLE_MUSIC_DISC = ITEM_FACTORY.createMusicDisc("example_music_disc", ExampleJukeboxSongs.EXAMPLE_JUKEBOX_SONG);

    @AddCreativeModeTab(CreativeModeTabType.TOOLS_AND_UTILITIES)
    @GenerateBasicItemModel
    @TranslateAmericanEnglish("Example Instrument")
    public static final DeferredItem<?> EXAMPLE_INSTRUMENT = ITEM_FACTORY.createInstrument("example_instrument", ExampleInstrumentTags.EXAMPLE);
}