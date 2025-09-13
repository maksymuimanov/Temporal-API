package net.temporal.example.event.handler;

import com.temporal.api.core.engine.event.handler.EventHandler;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.temporal.example.config.ExampleConfig;

@Handler(FMLCommonSetupEvent.class)
public class ExampleCommonSetupEventHandler implements EventHandler {
    @Override
    public void handle() {
        this.subscribeModEvent(FMLCommonSetupEvent.class, (event) -> {
            if (ExampleConfig.sayHelloConfigValue.get()) {
                System.out.println("Hello World!");
            }
        });
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
