package com.temporal.api.core.engine.metadata.annotation.injection;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Strategy {
    String value();
    Class<? extends Annotation> override() default Annotation.class;
}
