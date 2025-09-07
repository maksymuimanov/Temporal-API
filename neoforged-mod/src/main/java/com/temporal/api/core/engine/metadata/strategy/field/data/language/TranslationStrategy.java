package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ApiLanguageProvider;
import com.temporal.api.core.engine.event.data.language.transformer.KeyTransformer;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("unchecked")
public abstract class TranslationStrategy<A extends Annotation> implements FieldAnnotationStrategy<A> {
    public static final String TRANSLATION_ID_METHOD = "id";
    public static final String TRANSLATION_VALUE_METHOD = "value";
    public static final String TRANSLATION_SUFFIX_METHOD = "suffix";
    private final Class<?> translationProvider;

    protected TranslationStrategy(Class<?> translationProvider) {
        this.translationProvider = translationProvider;
    }

    @Override
    public void execute(Field field, Object object, A annotation) throws Exception {
        Object o = field.get(object);
        Class<? extends A> annotationClass = this.getAnnotationClass();
        Method idMethod = annotationClass.getDeclaredMethod(TRANSLATION_ID_METHOD);
        String id = (String) idMethod.invoke(annotation);
        Method valueMethod = annotationClass.getDeclaredMethod(TRANSLATION_VALUE_METHOD);
        String value = (String) valueMethod.invoke(annotation);
        Method suffixMethod = annotationClass.getDeclaredMethod(TRANSLATION_SUFFIX_METHOD);
        String suffix = (String) suffixMethod.invoke(annotation);
        this.directTranslation(id, value, suffix, o);
    }

    protected void directTranslation(String possibleKey, String value, String suffix, Object o) {
        if (!possibleKey.isBlank()) {
            this.putTranslation(possibleKey, value, suffix, ApiLanguageProvider.STRING_TRANSFORMER);
        } else {
            switch (o) {
                case String stringField -> this.putTranslation(stringField, value, suffix, ApiLanguageProvider.STRING_TRANSFORMER);
                case Component component -> this.putTranslation(component, value, suffix, ApiLanguageProvider.COMPONENT_TRANSFORMER);
                case Holder<?> holder -> this.putTranslation(Objects.requireNonNull(holder.getKey()), value, suffix);
                case ResourceKey<?> key -> this.putTranslation(key, value, suffix);
                default -> throw new IllegalStateException("Unexpected value: " + o);
            }
        }
    }

    protected <T> void putTranslation(ResourceKey<T> key, String value, String suffix) {
        ResourceKey<Registry<T>> registryKey = key.registryKey();
        ApiLanguageProvider.REGISTRY_KEY_TRANSFORMERS.entrySet()
                .stream()
                .filter(entry -> registryKey.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .map(transformer -> (KeyTransformer<ResourceKey<T>>) transformer)
                .forEach(transformer -> this.putTranslation(key, value, suffix, transformer));
    }

    protected <T> void putTranslation(T key, String value, String suffix, KeyTransformer<T> keyTransformer) {
        try {
            Map<String, String> translationMap = (Map<String, String>) this.translationProvider.getDeclaredField(ApiLanguageProvider.TRANSLATIONS_FIELD_NAME).get(null);
            String transformedKey = suffix.isBlank() ? keyTransformer.transform(key) : keyTransformer.transform(key) + "." + suffix;
            translationMap.put(transformedKey, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected Class<?> getTranslationProvider() {
        return translationProvider;
    }
}
