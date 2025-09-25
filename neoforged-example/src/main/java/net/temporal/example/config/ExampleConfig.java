package net.temporal.example.config;

import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import com.temporal.api.core.engine.metadata.annotation.injection.RegisterConfig;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

@RegisterConfig(ModConfig.Type.COMMON)
public class ExampleConfig {
    @TranslateAmericanEnglish("Hello World Config")
    public static volatile ModConfigSpec.ConfigValue<Boolean> sayHelloConfigValue;

    public ExampleConfig(ModConfigSpec.Builder builder) {
        sayHelloConfigValue = builder.comment("Whether to say \"Hello World\" or not")
                .translation("config.example.hello_world")
                .define("Say Hello World", true);
    }
}
