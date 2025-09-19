package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.engine.event.data.ApiDataGenerator;
import com.temporal.api.core.engine.event.data.DataGatherer;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Handler(GatherDataEvent.class)
public class DataEventHandler implements EventHandler {
    private static final DataGatherer GENERATOR = new ApiDataGenerator();

    @Override
    public void handle() {
        this.subscribeModEvent(GatherDataEvent.class, GENERATOR::gatherData);
    }
}
