package com.temporal.api.core.engine.metadata.annotation.injection;

import com.temporal.api.core.engine.event.handler.EventHandler;
import net.neoforged.bus.api.Event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Handler {
    Class<? extends Event> value();
    Class<? extends EventHandler> override() default EventHandler.class;
}
