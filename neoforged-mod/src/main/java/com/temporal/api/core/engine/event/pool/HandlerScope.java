package com.temporal.api.core.engine.event.pool;

import net.neoforged.bus.api.Event;

public record HandlerScope(Class<? extends Event> eventClass) {
}