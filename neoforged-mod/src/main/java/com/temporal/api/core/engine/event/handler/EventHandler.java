package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.event.adapter.EventAdapter;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;

import java.util.function.Consumer;

public interface EventHandler {
    int MAX_PRIORITY = Integer.MAX_VALUE;

    void handle();

    default <T extends Event> void subscribeEvent(Class<T> event, EventAdapter<T, ?> eventAdapter) {
        this.subscribeEvent(event, eventAdapter, EventPriority.NORMAL);
    }

    default <T extends Event> void subscribeModEvent(Class<T> event, EventAdapter<T, ?> eventAdapter) {
        this.subscribeModEvent(event, eventAdapter, EventPriority.NORMAL);
    }

    default <T extends Event> void subscribeEvent(Class<T> event, EventAdapter<T, ?> eventAdapter, EventPriority priority) {
        this.subscribeEvent(event, eventAdapter::adapt, priority);
    }

    default <T extends Event> void subscribeModEvent(Class<T> event, EventAdapter<T, ?> eventAdapter, EventPriority priority) {
        this.subscribeModEvent(event, eventAdapter::adapt, priority);
    }

    default <T extends Event> void subscribeEvent(Class<T> event, Consumer<T> consumer) {
        this.subscribeEvent(event, consumer, EventPriority.NORMAL);
    }

    default <T extends Event> void subscribeModEvent(Class<T> event, Consumer<T> consumer) {
        this.subscribeModEvent(event, consumer, EventPriority.NORMAL);
    }

    default <T extends Event> void subscribeEvent(Class<T> event, Consumer<T> consumer, EventPriority priority) {
        this.getEventBus().addListener(priority, event, consumer);
    }

    default <T extends Event> void subscribeModEvent(Class<T> event, Consumer<T> consumer, EventPriority priority) {
        this.getModEventBus().addListener(priority, event, consumer);
    }

    default IEventBus getEventBus() {
        return NeoForge.EVENT_BUS;
    }

    default IEventBus getModEventBus() {
        return InjectionPool.getFromInstance(IEventBus.class);
    }
}
