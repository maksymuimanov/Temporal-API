package com.temporal.api.core.event.data.language.provider;

import com.temporal.api.core.collection.TemporalMap;
import net.minecraft.data.PackOutput;

import java.util.Map;

public class CroatianProvider extends ApiLanguageProvider {
    public static final Map<String, String> TRANSLATIONS = new TemporalMap<>();

    public CroatianProvider(PackOutput output) {
        super(output, "hr_hr");
    }

    @Override
    public Map<String, String> getTranslations() {
        return TRANSLATIONS;
    }
}