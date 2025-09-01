package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.language.provider.ApiLanguageProvider;
import com.temporal.api.core.event.data.language.transformer.KeyTransformer;
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
        Method valueMethod = annotationClass.getDeclaredMethod("value");
        String value = (String) valueMethod.invoke(annotation);
        this.putDynamicTranslation(id, value, o);
    }

    protected void putDynamicTranslation(String possibleKey, String value, Object o) {
        if (!possibleKey.isBlank()) {
            this.putTranslation(possibleKey, value, ApiLanguageProvider.STRING_TRANSFORMER);
        } else {
            switch (o) {
                case String stringField -> {
                    this.putTranslation(stringField, value, ApiLanguageProvider.STRING_TRANSFORMER);
                }
                case Component component -> {
                    this.putTranslation(component, value, ApiLanguageProvider.COMPONENT_TRANSFORMER);
                }
                case Holder<?> holder -> {
                    ResourceKey<?> key = Objects.requireNonNull(holder.getKey());
                    this.putTranslation(key, value);
                }
                case ResourceKey<?> key -> {
                    this.putTranslation(key, value);
                }
                default -> throw new IllegalStateException("Unexpected value: " + o);
            }
        }
    }

    protected <T> void putTranslation(ResourceKey<T> key, String value) {
        ResourceKey<Registry<T>> registryKey = key.registryKey();
        ApiLanguageProvider.REGISTRY_KEY_TRANSFORMERS.entrySet()
                .stream()
                .filter(entry -> registryKey.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .map(transformer -> (KeyTransformer<ResourceKey<T>>) transformer)
                .forEach(transformer -> this.putTranslation(key, value, transformer));
    }

    protected <T> void putTranslation(T key, String value, KeyTransformer<T> keyTransformer) {
        try {
            Map<String, String> translationMap = (Map<String, String>) this.translationProvider.getDeclaredField("TRANSLATIONS").get(null);
            String transformedKey = keyTransformer.transform(key);
            translationMap.put(transformedKey, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected Class<?> getTranslationProvider() {
        return translationProvider;
    }
}
