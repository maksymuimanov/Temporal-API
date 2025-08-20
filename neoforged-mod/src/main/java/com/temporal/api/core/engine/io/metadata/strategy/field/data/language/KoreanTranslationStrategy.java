package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.KoreanTranslation;
import com.temporal.api.core.event.data.language.provider.KoreanProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class KoreanTranslationStrategy extends TranslationStrategy {
    public KoreanTranslationStrategy() {
        super(KoreanProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        KoreanTranslation translation = field.getDeclaredAnnotation(KoreanTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return KoreanTranslation.class;
    }
}
