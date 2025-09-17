package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

public class GameEventFactory extends AbstractObjectFactory<GameEvent> {
    public GameEventFactory() {
        this(InjectionPool.getFromInstance("$GameEvents"));
    }

    public GameEventFactory(TemporalRegister<GameEvent> register) {
        super(register);
    }

    public DeferredHolder<GameEvent, GameEvent> create(String name) {
        return this.create(name, GameEvent.DEFAULT_NOTIFICATION_RADIUS);
    }

    public DeferredHolder<GameEvent, GameEvent> create(String name, int notificationRadius) {
        return this.create(name, () -> new GameEvent(notificationRadius));
    }
}
