package com.temporal.api.core.event.data.language.provider;

import com.temporal.api.core.collection.TemporalMap;
import net.minecraft.data.PackOutput;

import java.util.Map;

public class EnglishProvider extends ApiLanguageProvider {
    public static final Map<String, String> TRANSLATIONS = new TemporalMap<>();

    public EnglishProvider(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    public Map<String, String> getTranslations() {
        return TRANSLATIONS;
    }
}