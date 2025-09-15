package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.gameevent.GameEvent;

public class GameEventFactory extends AbstractObjectFactory<GameEvent> {
    public GameEventFactory() {
        this(InjectionPool.getFromInstance("$GameEvents"));
    }

    public GameEventFactory(TemporalRegister<GameEvent> register) {
        super(register);
    }
}
