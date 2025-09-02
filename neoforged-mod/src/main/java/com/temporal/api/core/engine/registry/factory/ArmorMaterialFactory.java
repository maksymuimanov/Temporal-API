package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ArmorMaterialFactory extends AbstractObjectFactory<ArmorMaterial> {
    public ArmorMaterialFactory() {
        this(InjectionPool.getFromInstance("$ArmorMaterials"));
    }

    public ArmorMaterialFactory(TemporalRegister<ArmorMaterial> armorMaterials) {
        super(armorMaterials);
    }

    public DeferredHolder<ArmorMaterial, ArmorMaterial> create(String name, EnumMap<ArmorItem.Type, Integer> defenses,
                                               int enchantmentValue, float toughness, float knockbackResistance,
                                               TagKey<Item> repairIngredient, Holder<SoundEvent> equipSound) {
        ResourceLocation location = ResourceUtils.parse(name);
        Supplier<Ingredient> ingredient = () -> Ingredient.of(repairIngredient);
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));
        EnumMap<ArmorItem.Type, Integer> map = Arrays.stream(ArmorItem.Type.values())
                .collect(Collectors.toMap(armoritem$type -> armoritem$type, defenses::get,
                        (a, b) -> b, () -> new EnumMap<>(ArmorItem.Type.class)));
        return this.create(name, () -> new ArmorMaterial(map, enchantmentValue, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}
