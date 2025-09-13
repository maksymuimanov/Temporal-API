package net.temporal.example.event.handler;

import com.temporal.api.core.engine.event.handler.EventHandler;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;

@Handler(value = FMLLoadCompleteEvent.class, override = ExampleHelloWorldEventHandler.class)
public class ExampleHelloWorldOverrideEventHandler implements EventHandler {
    @Override
    public void handle() {
        this.subscribeModEvent(FMLLoadCompleteEvent.class, event -> {
            System.out.println("Hello World! from Override :D");
        });
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
