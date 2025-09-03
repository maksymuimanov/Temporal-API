package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.data.*;
import com.temporal.api.core.engine.metadata.strategy.field.data.biome.*;
import com.temporal.api.core.engine.metadata.strategy.field.data.language.*;
import com.temporal.api.core.engine.metadata.strategy.field.data.model.*;
import com.temporal.api.core.engine.metadata.strategy.field.data.properties.*;
import com.temporal.api.core.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class DataFieldAnnotationProcessor implements AnnotationProcessor<FieldAnnotationStrategy<?>> {
    private final Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> strategies = ReflectionUtils.createAnnotationStrategyMap(List.of(
            new GenerateBlockModelStrategy(),
            new GenerateItemModelStrategy(),
            new GenerateBlockLootTableStrategy(),
            new AddBlockTagStrategy(),
            new AddItemTagStrategy(),
            new GenerateOreStrategy(),
            new GenerateTreeStrategy(),
            new GenerateFlowerStrategy(),
            new GenerateGrassStrategy(),
            new GenerateWorldFeatureStrategy(),
            new FurnaceFuelStrategy(),
            new CompostableStrategy(),
            new OxidizableStrategy(),
            new WaxableStrategy(),
            new RaidHeroGiftStrategy(),
            new MonsterRoomMobStrategy(),
            new ParrotImitationStrategy(),
            new GenerateSoundStrategy(),
            new GenerateJukeboxSongStrategy(),
            new GeneratePaintingStrategy(),
            new GenerateParticleSpriteSetStrategy(),
            new GenerateEnchantmentStrategy(),
            new GenerateDamageTypeStrategy(),
            new GenerateTrimMaterialStrategy(),
            new GenerateTrimPatternStrategy(),
            new GenerateWolfVariantStrategy(),
            new GenerateBannerPatternStrategy(),
            new TranslateAmericanEnglishStrategy(),
            new TranslateUkrainianStrategy(),
            new TranslatePolishStrategy(),
            new TranslateGermanStrategy(),
            new TranslateFrenchStrategy(),
            new TranslateItalianStrategy(),
            new TranslateSpanishStrategy(),
            new TranslateAlbanianStrategy(),
            new TranslateAustrianGermanStrategy(),
            new TranslateBelarusianStrategy(),
            new TranslateBosnianStrategy(),
            new TranslateBulgarianStrategy(),
            new TranslateCroatianStrategy(),
            new TranslateCzechStrategy(),
            new TranslateDanishStrategy(),
            new TranslateDutchStrategy(),
            new TranslateEstonianStrategy(),
            new TranslateFilipinoStrategy(),
            new TranslateFinnishStrategy(),
            new TranslateGreekStrategy(),
            new TranslateHebrewStrategy(),
            new TranslateHindiStrategy(),
            new TranslateHungarianStrategy(),
            new TranslateIcelandicStrategy(),
            new TranslateIndonesianStrategy(),
            new TranslateIrishStrategy(),
            new TranslateJapaneseStrategy(),
            new TranslateKazakhStrategy(),
            new TranslateKoreanStrategy(),
            new TranslateLatvianStrategy(),
            new TranslateLithuanianStrategy(),
            new TranslateSimplifiedChineseStrategy(),
            new TranslatePersianStrategy(),
            new TranslatePortugueseStrategy(),
            new TranslateRomanianStrategy(),
            new TranslateSerbianStrategy(),
            new TranslateSlovakStrategy(),
            new TranslateSlovenianStrategy(),
            new TranslateSwedishStrategy(),
            new TranslateSwissGermanStrategy(),
            new TranslateThaiStrategy(),
            new TranslateTurkishStrategy(),
            new TranslateVietnameseStrategy()
    ));

    @Override
    public AnnotationExecutor<FieldAnnotationStrategy<?>> getExecutor() {
        return MetadataLayer.STATIC_FIELD_EXECUTOR;
    }

    @Override
    public Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> getStrategies() {
        return strategies;
    }
}
