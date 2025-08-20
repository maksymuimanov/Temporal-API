package net.temporal.example.event;

import com.temporal.api.core.event.tab.SimpleTabDirector;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.temporal.example.ExampleMod;
import net.temporal.example.registry.ExampleBlocks;
import net.temporal.example.registry.ExampleItems;

@EventBusSubscriber(modid = ExampleMod.MOD_ID)
public final class CreativeModeTabEventListener {
    @SubscribeEvent
    public static void listenEvent(BuildCreativeModeTabContentsEvent event) {
        SimpleTabDirector.create(event)
                .direct(CreativeModeTabs.INGREDIENTS,
                        ExampleItems.EXAMPLE_FUEL, ExampleItems.EXAMPLE_COMPOSTABLE_ITEM, ExampleItems.EXAMPLE_INGOT)
                .direct(CreativeModeTabs.COMBAT,
                        ExampleItems.EXAMPLE_SWORD,
                        ExampleItems.EXAMPLE_HELMET, ExampleItems.EXAMPLE_CHESTPLATE, ExampleItems.EXAMPLE_LEGGINGS, ExampleItems.EXAMPLE_BOOTS,
                        ExampleItems.EXAMPLE_BOW, ExampleItems.EXAMPLE_CROSSBOW)
                .direct(CreativeModeTabs.BUILDING_BLOCKS,
                        ExampleBlocks.EXAMPLE_BLOCK,
                        ExampleBlocks.EXAMPLE_PLANKS, ExampleBlocks.EXAMPLE_SLAB, ExampleBlocks.EXAMPLE_STAIRS,
                        ExampleBlocks.EXAMPLE_BUTTON, ExampleBlocks.EXAMPLE_PRESSURE_PLATE,
                        ExampleBlocks.EXAMPLE_FENCE, ExampleBlocks.EXAMPLE_FENCE_GATE)
                .direct(CreativeModeTabs.NATURAL_BLOCKS,
                        ExampleBlocks.EXAMPLE_ORE, ExampleBlocks.EXAMPLE_GRASS, ExampleBlocks.EXAMPLE_FLOWER,
                        ExampleBlocks.EXAMPLE_SAPLING, ExampleBlocks.EXAMPLE_LEAVES, ExampleBlocks.EXAMPLE_LOG, ExampleBlocks.EXAMPLE_STRIPPED_LOG);
    }
}
