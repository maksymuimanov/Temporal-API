package com.temporal.api.core.event.data.language.provider;

import com.temporal.api.core.collection.TemporalMap;
import net.minecraft.data.PackOutput;

import java.util.Map;

public class KoreanProvider extends ApiLanguageProvider {
    public static final Map<String, String> TRANSLATIONS = new TemporalMap<>();

    public KoreanProvider(PackOutput output) {
        super(output, "ko_kr");
    }

    @Override
    public Map<String, String> getTranslations() {
        return TRANSLATIONS;
    }
}