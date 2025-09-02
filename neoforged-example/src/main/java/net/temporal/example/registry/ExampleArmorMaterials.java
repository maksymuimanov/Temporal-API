package net.temporal.example.registry;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.ArmorMaterialFactory;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.temporal.example.tag.ExampleItemTags;

import java.util.EnumMap;

public final class ExampleArmorMaterials {
    private static final ArmorMaterialFactory ARMOR_MATERIAL_FACTORY = InjectionPool.getFromInstance(ArmorMaterialFactory.class);

    public static Holder<ArmorMaterial> EXAMPLE_ARMOR_MATERIAL = ARMOR_MATERIAL_FACTORY.create("example", Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
        map.put(ArmorItem.Type.BOOTS, 4);
        map.put(ArmorItem.Type.LEGGINGS, 7);
        map.put(ArmorItem.Type.CHESTPLATE, 9);
        map.put(ArmorItem.Type.HELMET, 4);
        map.put(ArmorItem.Type.BODY, 12);
    }), 4, 4F, 0.5F, ExampleItemTags.REPAIRS_EXAMPLE_ARMOR, ExampleSounds.EXAMPLE_SOUND);
}
