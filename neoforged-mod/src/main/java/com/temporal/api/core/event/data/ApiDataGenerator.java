package com.temporal.api.core.event.data;

import com.temporal.api.core.event.data.advancement.AdvancementProviderFactory;
import com.temporal.api.core.event.data.json.AtlasTrimProvider;
import com.temporal.api.core.event.data.json.JsonProvider;
import com.temporal.api.core.event.data.json.PlaceablePaintingProvider;
import com.temporal.api.core.event.data.language.provider.*;
import com.temporal.api.core.event.data.loot.LootTableProviderFactory;
import com.temporal.api.core.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.event.data.model.item.ApiItemModelProvider;
import com.temporal.api.core.event.data.modifier.ApiGlobalLootModifierProvider;
import com.temporal.api.core.event.data.pack.ApiDatapackProvider;
import com.temporal.api.core.event.data.particle.ApiParticleProvider;
import com.temporal.api.core.event.data.preparer.DynamicPreparer;
import com.temporal.api.core.event.data.preparer.tag.biome.BiomeTagDynamicPreparer;
import com.temporal.api.core.event.data.preparer.tag.block.BlockTagDynamicPreparer;
import com.temporal.api.core.event.data.preparer.tag.enchantment.EnchantmentTagDynamicPreparer;
import com.temporal.api.core.event.data.preparer.tag.item.ItemTagDynamicPreparer;
import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.sound.ApiSoundProvider;
import com.temporal.api.core.event.data.tag.biome.ApiBiomeTagsProvider;
import com.temporal.api.core.event.data.tag.block.ApiBlockTagsProvider;
import com.temporal.api.core.event.data.tag.item.ApiItemTagsProvider;
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
        addJsonProvider(event);
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
        generator.addProvider(event.includeClient(), new EnglishProvider(packOutput));
        generator.addProvider(event.includeClient(), new UkrainianProvider(packOutput));
        generator.addProvider(event.includeClient(), new PolishProvider(packOutput));
        generator.addProvider(event.includeClient(), new GermanProvider(packOutput));
        generator.addProvider(event.includeClient(), new FrenchProvider(packOutput));
        generator.addProvider(event.includeClient(), new ItalianProvider(packOutput));
        generator.addProvider(event.includeClient(), new SpanishProvider(packOutput));
        generator.addProvider(event.includeClient(), new AlbanianProvider(packOutput));
        generator.addProvider(event.includeClient(), new AustrianGermanProvider(packOutput));
        generator.addProvider(event.includeClient(), new SwissGermanProvider(packOutput));
        generator.addProvider(event.includeClient(), new BelarusianProvider(packOutput));
        generator.addProvider(event.includeClient(), new BosnianProvider(packOutput));
        generator.addProvider(event.includeClient(), new BulgarianProvider(packOutput));
        generator.addProvider(event.includeClient(), new CroatianProvider(packOutput));
        generator.addProvider(event.includeClient(), new CzechProvider(packOutput));
        generator.addProvider(event.includeClient(), new DanishProvider(packOutput));
        generator.addProvider(event.includeClient(), new DutchProvider(packOutput));
        generator.addProvider(event.includeClient(), new EstonianProvider(packOutput));
        generator.addProvider(event.includeClient(), new FilipinoProvider(packOutput));
        generator.addProvider(event.includeClient(), new FinnishProvider(packOutput));
        generator.addProvider(event.includeClient(), new GreekProvider(packOutput));
        generator.addProvider(event.includeClient(), new HebrewProvider(packOutput));
        generator.addProvider(event.includeClient(), new HindiProvider(packOutput));
        generator.addProvider(event.includeClient(), new HungarianProvider(packOutput));
        generator.addProvider(event.includeClient(), new IcelandicProvider(packOutput));
        generator.addProvider(event.includeClient(), new IndonesianProvider(packOutput));
        generator.addProvider(event.includeClient(), new IrishProvider(packOutput));
        generator.addProvider(event.includeClient(), new JapaneseProvider(packOutput));
        generator.addProvider(event.includeClient(), new KazakhProvider(packOutput));
        generator.addProvider(event.includeClient(), new KoreanProvider(packOutput));
        generator.addProvider(event.includeClient(), new LatvianProvider(packOutput));
        generator.addProvider(event.includeClient(), new LithuanianProvider(packOutput));
        generator.addProvider(event.includeClient(), new MandarinProvider(packOutput));
        generator.addProvider(event.includeClient(), new PersianProvider(packOutput));
        generator.addProvider(event.includeClient(), new PortugueseProvider(packOutput));
        generator.addProvider(event.includeClient(), new RomanianProvider(packOutput));
        generator.addProvider(event.includeClient(), new SerbianProvider(packOutput));
        generator.addProvider(event.includeClient(), new SlovakProvider(packOutput));
        generator.addProvider(event.includeClient(), new SlovenianProvider(packOutput));
        generator.addProvider(event.includeClient(), new SwedishProvider(packOutput));
        generator.addProvider(event.includeClient(), new ThaiProvider(packOutput));
        generator.addProvider(event.includeClient(), new TurkishProvider(packOutput));
        generator.addProvider(event.includeClient(), new VietnameseProvider(packOutput));
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
        final ExistingFileHelper existingFileHelper = getExistingFileHelper(event);
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ApiBlockTagsProvider blockTagsProvider = new ApiBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ApiItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ApiBiomeTagsProvider(packOutput, lookupProvider, existingFileHelper));
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
    public void addJsonProvider(GatherDataEvent event) {
        List.of(
                new PlaceablePaintingProvider(),
                new AtlasTrimProvider()
        ).forEach(JsonProvider::registerFiles);
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
