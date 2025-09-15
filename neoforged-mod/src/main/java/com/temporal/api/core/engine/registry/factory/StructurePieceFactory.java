package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

public class StructurePieceFactory extends AbstractObjectFactory<StructurePieceType> {
    public StructurePieceFactory() {
        this(InjectionPool.getFromInstance("$StructurePieces"));
    }

    public StructurePieceFactory(TemporalRegister<StructurePieceType> register) {
        super(register);
    }
}
