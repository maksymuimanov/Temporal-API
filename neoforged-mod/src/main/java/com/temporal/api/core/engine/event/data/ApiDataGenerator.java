package com.temporal.api.core.engine.event.data;

import com.temporal.api.core.engine.event.data.advancement.AdvancementProviderFactory;
import com.temporal.api.core.engine.event.data.file.AtlasArmorTrimProvider;
import com.temporal.api.core.engine.event.data.file.PlaceablePaintingProvider;
import com.temporal.api.core.engine.event.data.language.provider.*;
import com.temporal.api.core.engine.event.data.loot.LootTableProviderFactory;
import com.temporal.api.core.engine.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.item.ApiItemModelProvider;
import com.temporal.api.core.engine.event.data.modifier.ApiGlobalLootModifierProvider;
import com.temporal.api.core.engine.event.data.pack.ApiDatapackProvider;
import com.temporal.api.core.engine.event.data.particle.ApiParticleProvider;
import com.temporal.api.core.engine.event.data.preparer.DynamicPreparer;
import com.temporal.api.core.engine.event.data.preparer.tag.BiomeTagDynamicPreparer;
import com.temporal.api.core.engine.event.data.preparer.tag.BlockTagDynamicPreparer;
import com.temporal.api.core.engine.event.data.preparer.tag.EnchantmentTagDynamicPreparer;
import com.temporal.api.core.engine.event.data.preparer.tag.ItemTagDynamicPreparer;
import com.temporal.api.core.engine.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.engine.event.data.sound.ApiSoundProvider;
import com.temporal.api.core.engine.event.data.tag.BannerPatternTagsProvider;
import com.temporal.api.core.engine.event.data.tag.BlockTagsProvider;
import com.temporal.api.core.engine.event.data.tag.ItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ApiDataGenerator implements DataGatherer {
    @Override
    public void gatherData(GatherDataEvent event) {
        init();
        addGlobalLootModifierProvider(event);
        addLootTableProvider(event);
        addRecipeProvider(event);
        addModelProvider(event);
        addLanguageProvider(event);
        addTagProvider(event);
        addDatapackProvider(event);
        addDataMapProvider(event);
        addAdvancementProvider(event);
        addSoundProvider(event);
        addParticleProvider(event);
        addFileProvider(event);
    }

    @Override
    public void init() {
        List.of(
                new ItemTagDynamicPreparer(),
                new BlockTagDynamicPreparer(),
                new BiomeTagDynamicPreparer(),
                new EnchantmentTagDynamicPreparer()
        ).forEach(DynamicPreparer::prepare);
    }

    @Override
    public void addGlobalLootModifierProvider(GatherDataEvent event) {
        final DataGenerator generator = getDataGenerator(event);
        final PackOutput packOutput = getPackOutput(event);
        final CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(event.includeServer(), new ApiGlobalLootModifierProvider(packOutput, lookupProvider));
    }

    @Override
    public void addLootTableProvider(GatherDataEvent event) {
        final DataGenerator generator = getDataGenerator(event);
        final PackOutput packOutput = getPackOutput(event);
        final CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(event.includeServer(), LootTableProviderFactory.createProvider(packOutput, lookupProvider));
    }

    @Override
    public void addModelProvider(GatherDataEvent event) {
        final DataGenerator generator = getDataGenerator(event);
        final PackOutput packOutput = getPackOutput(event);
        final ExistingFileHelper existingFileHelper = getExistingFileHelper(event);
        generator.addProvider(event.includeClient(), new ApiItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ApiBlockModelProvider(packOutput, existingFileHelper));
    }

    @Override
    public void addLanguageProvider(GatherDataEvent event) {
        final DataGenerator generator = getDataGenerator(event);
        final PackOutput packOutput = getPackOutput(event);
        generator.addProvider(event.includeClient(), new AfrikaansProvider(packOutput));
        generator.addProvider(event.includeClient(), new AlbanianProvider(packOutput));
        generator.addProvider(event.includeClient(), new AmericanEnglishProvider(packOutput));
        generator.addProvider(event.includeClient(), new AndalusianProvider(packOutput));
        generator.addProvider(event.includeClient(), new ArabicProvider(packOutput));
        generator.addProvider(event.includeClient(), new ArgentianSpanishProvider(packOutput));
        generator.addProvider(event.includeClient(), new ArmenianProvider(packOutput));
        generator.addProvider(event.includeClient(), new AsturianProvider(packOutput));
        generator.addProvider(event.includeClient(), new AustralianEnglishProvider(packOutput));
        generator.addProvider(event.includeClient(), new AustrianGermanProvider(packOutput));
        generator.addProvider(event.includeClient(), new AzerbaijaniProvider(packOutput));
        generator.addProvider(event.includeClient(), new BashkirProvider(packOutput));
        generator.addProvider(event.includeClient(), new BasqueProvider(packOutput));
        generator.addProvider(event.includeClient(), new BavarianProvider(packOutput));
        generator.addProvider(event.includeClient(), new BelarusianProvider(packOutput));
        generator.addProvider(event.includeClient(), new BosnianProvider(packOutput));
        generator.addProvider(event.includeClient(), new BrabantianProvider(packOutput));
        generator.addProvider(event.includeClient(), new BrazilianPortugueseProvider(packOutput));
        generator.addProvider(event.includeClient(), new BretonProvider(packOutput));
        generator.addProvider(event.includeClient(), new BritishEnglishProvider(packOutput));
        generator.addProvider(event.includeClient(), new BulgarianProvider(packOutput));
        generator.addProvider(event.includeClient(), new CanadianEnglishProvider(packOutput));
        generator.addProvider(event.includeClient(), new CanadianFrenchProvider(packOutput));
        generator.addProvider(event.includeClient(), new CatalanProvider(packOutput));
        generator.addProvider(event.includeClient(), new ChileanSpanishProvider(packOutput));
        generator.addProvider(event.includeClient(), new CornishProvider(packOutput));
        generator.addProvider(event.includeClient(), new CroatianProvider(packOutput));
        generator.addProvider(event.includeClient(), new CzechProvider(packOutput));
        generator.addProvider(event.includeClient(), new DanishProvider(packOutput));
        generator.addProvider(event.includeClient(), new DutchProvider(packOutput));
        generator.addProvider(event.includeClient(), new EastFranconianProvider(packOutput));
        generator.addProvider(event.includeClient(), new EcuadorianSpanishProvider(packOutput));
        generator.addProvider(event.includeClient(), new ElfdalianProvider(packOutput));
        generator.addProvider(event.includeClient(), new EsperantoProvider(packOutput));
        generator.addProvider(event.includeClient(), new EstonianProvider(packOutput));
        generator.addProvider(event.includeClient(), new FaroeseProvider(packOutput));
        generator.addProvider(event.includeClient(), new FilipinoProvider(packOutput));
        generator.addProvider(event.includeClient(), new FinnishProvider(packOutput));
        generator.addProvider(event.includeClient(), new FlemishProvider(packOutput));
        generator.addProvider(event.includeClient(), new FrenchProvider(packOutput));
        generator.addProvider(event.includeClient(), new FrisianProvider(packOutput));
        generator.addProvider(event.includeClient(), new FriulianProvider(packOutput));
        generator.addProvider(event.includeClient(), new GalicianProvider(packOutput));
        generator.addProvider(event.includeClient(), new GeorgianProvider(packOutput));
        generator.addProvider(event.includeClient(), new GermanProvider(packOutput));
        generator.addProvider(event.includeClient(), new GreekProvider(packOutput));
        generator.addProvider(event.includeClient(), new HalychianProvider(packOutput));
        generator.addProvider(event.includeClient(), new HawaiianProvider(packOutput));
        generator.addProvider(event.includeClient(), new HebrewProvider(packOutput));
        generator.addProvider(event.includeClient(), new HighNorwegianProvider(packOutput));
        generator.addProvider(event.includeClient(), new HindiProvider(packOutput));
        generator.addProvider(event.includeClient(), new HungarianProvider(packOutput));
        generator.addProvider(event.includeClient(), new IcelandicProvider(packOutput));
        generator.addProvider(event.includeClient(), new IdoProvider(packOutput));
        generator.addProvider(event.includeClient(), new IgboProvider(packOutput));
        generator.addProvider(event.includeClient(), new IndonesianProvider(packOutput));
        generator.addProvider(event.includeClient(), new InterslavicProvider(packOutput));
        generator.addProvider(event.includeClient(), new IrishProvider(packOutput));
        generator.addProvider(event.includeClient(), new ItalianProvider(packOutput));
        generator.addProvider(event.includeClient(), new JapaneseProvider(packOutput));
        generator.addProvider(event.includeClient(), new JawiProvider(packOutput));
        generator.addProvider(event.includeClient(), new KannadaProvider(packOutput));
        generator.addProvider(event.includeClient(), new KazakhProvider(packOutput));
        generator.addProvider(event.includeClient(), new KlingonProvider(packOutput));
        generator.addProvider(event.includeClient(), new KoreanProvider(packOutput));
        generator.addProvider(event.includeClient(), new KyrgyzProvider(packOutput));
        generator.addProvider(event.includeClient(), new LaoProvider(packOutput));
        generator.addProvider(event.includeClient(), new LatinProvider(packOutput));
        generator.addProvider(event.includeClient(), new LatinBelarusianProvider(packOutput));
        generator.addProvider(event.includeClient(), new LatinSerbianProvider(packOutput));
        generator.addProvider(event.includeClient(), new LatvianProvider(packOutput));
        generator.addProvider(event.includeClient(), new LimburgishProvider(packOutput));
        generator.addProvider(event.includeClient(), new LiteraryChineseProvider(packOutput));
        generator.addProvider(event.includeClient(), new LithuanianProvider(packOutput));
        generator.addProvider(event.includeClient(), new LojbanProvider(packOutput));
        generator.addProvider(event.includeClient(), new LolcatProvider(packOutput));
        generator.addProvider(event.includeClient(), new LombardProvider(packOutput));
        generator.addProvider(event.includeClient(), new LuxembourgishProvider(packOutput));
        generator.addProvider(event.includeClient(), new MacedonianProvider(packOutput));
        generator.addProvider(event.includeClient(), new MalayProvider(packOutput));
        generator.addProvider(event.includeClient(), new MalteseProvider(packOutput));
        generator.addProvider(event.includeClient(), new MexicanSpanishProvider(packOutput));
        generator.addProvider(event.includeClient(), new ModernEnglishWithoutBorrowedWordsProvider(packOutput));
        generator.addProvider(event.includeClient(), new MongolianProvider(packOutput));
        generator.addProvider(event.includeClient(), new NahuatlProvider(packOutput));
        generator.addProvider(event.includeClient(), new NewZealandEnglishProvider(packOutput));
        generator.addProvider(event.includeClient(), new NorthernSamiProvider(packOutput));
        generator.addProvider(event.includeClient(), new NorwegianBokmalProvider(packOutput));
        generator.addProvider(event.includeClient(), new NorwegianNynorskProvider(packOutput));
        generator.addProvider(event.includeClient(), new OccitanProvider(packOutput));
        generator.addProvider(event.includeClient(), new PersianProvider(packOutput));
        generator.addProvider(event.includeClient(), new PirateEnglishProvider(packOutput));
        generator.addProvider(event.includeClient(), new PolishProvider(packOutput));
        generator.addProvider(event.includeClient(), new PortugueseProvider(packOutput));
        generator.addProvider(event.includeClient(), new QuenyaProvider(packOutput));
        generator.addProvider(event.includeClient(), new RipuarianProvider(packOutput));
        generator.addProvider(event.includeClient(), new RomanianProvider(packOutput));
        generator.addProvider(event.includeClient(), new RussianProvider(packOutput));
        generator.addProvider(event.includeClient(), new RusynProvider(packOutput));
        generator.addProvider(event.includeClient(), new ScottishGaelicProvider(packOutput));
        generator.addProvider(event.includeClient(), new SerbianProvider(packOutput));
        generator.addProvider(event.includeClient(), new ShakespeareanEnglishProvider(packOutput));
        generator.addProvider(event.includeClient(), new SilesianProvider(packOutput));
        generator.addProvider(event.includeClient(), new SimplifiedChineseProvider(packOutput));
        generator.addProvider(event.includeClient(), new SlovakProvider(packOutput));
        generator.addProvider(event.includeClient(), new SlovenianProvider(packOutput));
        generator.addProvider(event.includeClient(), new SomaliProvider(packOutput));
        generator.addProvider(event.includeClient(), new SpanishProvider(packOutput));
        generator.addProvider(event.includeClient(), new SwedishProvider(packOutput));
        generator.addProvider(event.includeClient(), new SwissGermanProvider(packOutput));
        generator.addProvider(event.includeClient(), new TagalogProvider(packOutput));
        generator.addProvider(event.includeClient(), new TamilProvider(packOutput));
        generator.addProvider(event.includeClient(), new TatarProvider(packOutput));
        generator.addProvider(event.includeClient(), new ThaiProvider(packOutput));
        generator.addProvider(event.includeClient(), new TokiPonaProvider(packOutput));
        generator.addProvider(event.includeClient(), new TraditionalHongKongChineseProvider(packOutput));
        generator.addProvider(event.includeClient(), new TraditionalTaiwanChineseProvider(packOutput));
        generator.addProvider(event.includeClient(), new TurkishProvider(packOutput));
        generator.addProvider(event.includeClient(), new TzotzilProvider(packOutput));
        generator.addProvider(event.includeClient(), new UkrainianProvider(packOutput));
        generator.addProvider(event.includeClient(), new UpperSaxonGermanProvider(packOutput));
        generator.addProvider(event.includeClient(), new UpsideDownBritishEnglishProvider(packOutput));
        generator.addProvider(event.includeClient(), new UruguayanSpanishProvider(packOutput));
        generator.addProvider(event.includeClient(), new ValencianProvider(packOutput));
        generator.addProvider(event.includeClient(), new VenetianProvider(packOutput));
        generator.addProvider(event.includeClient(), new VenezuelanSpanishProvider(packOutput));
        generator.addProvider(event.includeClient(), new VietnameseProvider(packOutput));
        generator.addProvider(event.includeClient(), new ViossaProvider(packOutput));
        generator.addProvider(event.includeClient(), new WelshProvider(packOutput));
        generator.addProvider(event.includeClient(), new YakutProvider(packOutput));
        generator.addProvider(event.includeClient(), new YiddishProvider(packOutput));
        generator.addProvider(event.includeClient(), new YorubaProvider(packOutput));
    }

    @Override
    public void addRecipeProvider(GatherDataEvent event) {
        final DataGenerator generator = getDataGenerator(event);
        final PackOutput packOutput = getPackOutput(event);
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(event.includeServer(), new ApiRecipeProvider(packOutput, lookupProvider));
    }

    @Override
    public void addTagProvider(GatherDataEvent event) {
        final DataGenerator generator = getDataGenerator(event);
        final PackOutput packOutput = getPackOutput(event);
        generator.addProvider(event.includeServer(), new BlockTagsProvider(packOutput));
        generator.addProvider(event.includeServer(), new ItemTagsProvider(packOutput));
        generator.addProvider(event.includeServer(), new BannerPatternTagsProvider(packOutput));
    }

    @Override
    public void addDatapackProvider(GatherDataEvent event) {
        final DataGenerator generator = getDataGenerator(event);
        final PackOutput packOutput = getPackOutput(event);
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(event.includeServer(), new ApiDatapackProvider(packOutput, lookupProvider));
    }

    @Override
    public void addDataMapProvider(GatherDataEvent event) {
        final DataGenerator generator = getDataGenerator(event);
        final PackOutput packOutput = getPackOutput(event);
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(event.includeServer(), new ApiDataMapProvider(packOutput, lookupProvider));
    }

    @Override
    public void addAdvancementProvider(GatherDataEvent event) {
        final DataGenerator generator = getDataGenerator(event);
        final PackOutput packOutput = getPackOutput(event);
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(event.includeServer(), AdvancementProviderFactory.createProvider(packOutput, lookupProvider));
    }

    @Override
    public void addSoundProvider(GatherDataEvent event) {
        final DataGenerator generator = getDataGenerator(event);
        final PackOutput packOutput = getPackOutput(event);
        final ExistingFileHelper existingFileHelper = getExistingFileHelper(event);
        generator.addProvider(event.includeClient(), new ApiSoundProvider(packOutput, existingFileHelper));
    }

    @Override
    public void addParticleProvider(GatherDataEvent event) {
        final DataGenerator generator = getDataGenerator(event);
        final PackOutput packOutput = getPackOutput(event);
        final ExistingFileHelper existingFileHelper = getExistingFileHelper(event);
        generator.addProvider(event.includeClient(), new ApiParticleProvider(packOutput, existingFileHelper));
    }

    @Override
    public void addFileProvider(GatherDataEvent event) {
        final DataGenerator generator = getDataGenerator(event);
        final PackOutput packOutput = getPackOutput(event);
        generator.addProvider(event.includeClient(), new AtlasArmorTrimProvider(packOutput));
        generator.addProvider(event.includeServer(), new PlaceablePaintingProvider(packOutput));
    }

    @Override
    public @NotNull PackOutput getPackOutput(GatherDataEvent event) {
        return getDataGenerator(event).getPackOutput();
    }

    @Override
    public DataGenerator getDataGenerator(GatherDataEvent event) {
        return event.getGenerator();
    }

    @Override
    public ExistingFileHelper getExistingFileHelper(GatherDataEvent event) {
        return event.getExistingFileHelper();
    }
}
