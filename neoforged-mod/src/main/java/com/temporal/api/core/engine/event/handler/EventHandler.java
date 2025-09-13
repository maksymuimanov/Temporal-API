package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.event.adapter.EventAdapter;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface EventHandler extends Comparable<EventHandler> {
    int DEFAULT_PRIORITY = 0;

    void handle();

    default int getPriority() {
        return DEFAULT_PRIORITY;
    }

    default IEventBus getEventBus() {
        return NeoForge.EVENT_BUS;
    }

    default IEventBus getModEventBus() {
        return InjectionPool.getFromInstance(IEventBus.class);
    }

    default <T extends Event> void subscribeEvent(Class<T> event, EventAdapter<T, Void> eventAdapter) {
        subscribeEvent(event, eventAdapter::adapt);
    }

    default <T extends Event> void subscribeModEvent(Class<T> event, EventAdapter<T, Void> eventAdapter) {
        subscribeModEvent(event, eventAdapter::adapt);
    }

    default <T extends Event> void subscribeEvent(Class<T> event, Consumer<T> consumer) {
        getEventBus().addListener(event, consumer);
    }

    default <T extends Event> void subscribeModEvent(Class<T> event, Consumer<T> consumer) {
        getModEventBus().addListener(event, consumer);
    }

    @Override
    default int compareTo(@NotNull EventHandler o) {
        return o.getPriority() - this.getPriority();
    }
}
