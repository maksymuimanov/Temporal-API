package com.temporal.api.core.engine.event.data.language.provider;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.event.data.language.resolver.*;
import com.temporal.api.core.engine.event.data.language.transformer.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.StatType;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ApiLanguageProvider extends LanguageProvider {
    public static final Map<KeyTransformer<? extends ResourceKey<?>>, ResourceKey<? extends Registry<?>>> REGISTRY_KEY_TRANSFORMERS = new HashMap<>();
    public static final KeyTransformer<ResourceKey<Item>> ITEM_TRANSFORMER = new ItemTransformer();
    public static final KeyTransformer<ResourceKey<Block>> BLOCK_TRANSFORMER = new BlockTransformer();
    public static final KeyTransformer<ResourceKey<Block>> BLOCK_ITEM_TRANSFORMER = new BlockItemTransformer();
    public static final KeyTransformer<ResourceKey<EntityType<?>>> ENTITY_TYPE_TRANSFORMER = new EntityTypeTransformer();
    public static final KeyTransformer<ResourceKey<MobEffect>> MOB_EFFECT_TRANSFORMER = new MobEffectTransformer();
    public static final KeyTransformer<ResourceKey<SoundEvent>> SOUND_EVENT_TRANSFORMER = new SoundEventTransformer();
    public static final KeyTransformer<ResourceKey<CreativeModeTab>> CREATIVE_MODE_TAB_TRANSFORMER = new CreativeModeTabTransformer();
    public static final KeyTransformer<ResourceKey<Enchantment>> ENCHANTMENT_TRANSFORMER = new EnchantmentTransformer();
    public static final KeyTransformer<ResourceKey<TrimMaterial>> TRIM_MATERIAL_TRANSFORMER = new TrimMaterialTransformer();
    public static final KeyTransformer<ResourceKey<TrimPattern>> TRIM_PATTERN_TRANSFORMER = new TrimPatternTransformer();
    public static final KeyTransformer<ResourceKey<BannerPattern>> BANNER_PATTERN_TRANSFORMER = new BannerPatternTransformer();
    public static final KeyTransformer<ResourceKey<JukeboxSong>> JUKEBOX_SONG_TRANSFORMER = new JukeboxSongTransformer();
    public static final KeyTransformer<ResourceKey<DamageType>> DAMAGE_TYPE_TRANSFORMER = new DamageTypeTransformer();
    public static final KeyTransformer<ResourceKey<PaintingVariant>> PAINTING_VARIANT_TRANSFORMER = new PaintingVariantTransformer();
    public static final KeyTransformer<ResourceKey<StatType<?>>> STAT_TYPE_TRANSFORMER = new StatTypeTransformer();
    public static final KeyTransformer<ModConfigSpec.ConfigValue<?>> CONFIG_TRANSFORMER = new ConfigTransformer();
    public static final KeyTransformer<Component> COMPONENT_TRANSFORMER = new ComponentTransformer();
    public static final KeyTransformer<String> STRING_TRANSFORMER = new StringTransformer();
    public static final TranslationValueResolver SIMPLE_TRANSLATION_VALUE_RESOLVER = new SimpleTranslationValueResolver();
    public static final List<TranslationPlaceholderResolver> TRANSLATION_PLACEHOLDER_RESOLVERS = new ArrayList<>();
    public static final TranslationPlaceholderResolver KEY_TRANSLATION_PLACEHOLDER_RESOLVER = new KeyTranslationPlaceholderResolver();
    public static final TranslationPlaceholderResolver THIS_TRANSLATION_PLACEHOLDER_RESOLVER = new ThisTranslationPlaceholderResolver();
    public static final String TRANSLATIONS_FIELD_NAME = "TRANSLATIONS";

    static {
        REGISTRY_KEY_TRANSFORMERS.put(ITEM_TRANSFORMER, Registries.ITEM);
        REGISTRY_KEY_TRANSFORMERS.put(BLOCK_TRANSFORMER, Registries.BLOCK);
        REGISTRY_KEY_TRANSFORMERS.put(BLOCK_ITEM_TRANSFORMER, Registries.BLOCK);
        REGISTRY_KEY_TRANSFORMERS.put(ENTITY_TYPE_TRANSFORMER, Registries.ENTITY_TYPE);
        REGISTRY_KEY_TRANSFORMERS.put(MOB_EFFECT_TRANSFORMER, Registries.MOB_EFFECT);
        REGISTRY_KEY_TRANSFORMERS.put(SOUND_EVENT_TRANSFORMER, Registries.SOUND_EVENT);
        REGISTRY_KEY_TRANSFORMERS.put(CREATIVE_MODE_TAB_TRANSFORMER, Registries.CREATIVE_MODE_TAB);
        REGISTRY_KEY_TRANSFORMERS.put(ENCHANTMENT_TRANSFORMER, Registries.ENCHANTMENT);
        REGISTRY_KEY_TRANSFORMERS.put(TRIM_MATERIAL_TRANSFORMER, Registries.TRIM_MATERIAL);
        REGISTRY_KEY_TRANSFORMERS.put(TRIM_PATTERN_TRANSFORMER, Registries.TRIM_PATTERN);
        REGISTRY_KEY_TRANSFORMERS.put(BANNER_PATTERN_TRANSFORMER, Registries.BANNER_PATTERN);
        REGISTRY_KEY_TRANSFORMERS.put(JUKEBOX_SONG_TRANSFORMER, Registries.JUKEBOX_SONG);
        REGISTRY_KEY_TRANSFORMERS.put(DAMAGE_TYPE_TRANSFORMER, Registries.DAMAGE_TYPE);
        REGISTRY_KEY_TRANSFORMERS.put(PAINTING_VARIANT_TRANSFORMER, Registries.PAINTING_VARIANT);
        REGISTRY_KEY_TRANSFORMERS.put(STAT_TYPE_TRANSFORMER, Registries.STAT_TYPE);
        TRANSLATION_PLACEHOLDER_RESOLVERS.add(KEY_TRANSLATION_PLACEHOLDER_RESOLVER);
        TRANSLATION_PLACEHOLDER_RESOLVERS.add(THIS_TRANSLATION_PLACEHOLDER_RESOLVER);
    }

    public ApiLanguageProvider(PackOutput output, String locale) {
        super(output, ModContext.NEO_MOD.getModId(), locale);
    }

    @Override
    protected void addTranslations() {
        this.getTranslations().forEach(this::add);
    }

    @SuppressWarnings("unchecked")
    public Map<String, String> getTranslations() {
        try {
            Field field = this.getClass().getDeclaredField(TRANSLATIONS_FIELD_NAME);
            field.setAccessible(true);
            Map<String, String> translationsField = new HashMap<>((Map<String, String>) field.get(this));
            HashMap<String, String> result = new HashMap<>();
            translationsField.forEach((key, value) -> {
                result.put(key, SIMPLE_TRANSLATION_VALUE_RESOLVER.resolve(key, value, translationsField, TRANSLATION_PLACEHOLDER_RESOLVERS));
            });
            return result;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
