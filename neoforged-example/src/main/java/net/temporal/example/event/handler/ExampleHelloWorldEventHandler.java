package net.temporal.example.event.handler;

import com.temporal.api.core.engine.event.handler.EventHandler;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;

@Handler(FMLLoadCompleteEvent.class)
public class ExampleHelloWorldEventHandler implements EventHandler {
    @Override
    public void handle() {
        this.subscribeModEvent(FMLLoadCompleteEvent.class, event -> {
            System.out.println("Hello World!");
        });
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
