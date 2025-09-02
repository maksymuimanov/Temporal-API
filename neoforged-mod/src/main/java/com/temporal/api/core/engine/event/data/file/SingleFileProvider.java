package com.temporal.api.core.engine.event.data.file;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.temporal.api.core.json.JsonRepresentation;
import com.temporal.api.core.text.SimpleStringFormatter;
import com.temporal.api.core.text.StringFormatter;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public abstract class SingleFileProvider implements DataProvider {
    private final PackOutput output;
    private final PackOutput.Target target;
    private final String path;
    private final String modId;
    private JsonElement content;

    protected SingleFileProvider(final PackOutput output, final PackOutput.Target target, final String path, final String modId) {
        this.output = output;
        this.target = target;
        this.path = path;
        this.modId = modId;
    }

    @Override
    @NotNull
    public CompletableFuture<?> run(@NotNull CachedOutput cachedOutput) {
        this.content = null;
        this.registerFile();
        if (this.content != null) {
            return this.save(cachedOutput, this.output.getOutputFolder(this.target)
                    .resolve(this.modId)
                    .resolve(path));
        }

        return CompletableFuture.allOf();
    }

    abstract void registerFile();

    protected void define(String content, String... arguments) {
        SimpleStringFormatter simpleFileContentFormatter = new SimpleStringFormatter();
        this.define(content, arguments, simpleFileContentFormatter);
    }

    protected final void define(String content, String[] arguments, StringFormatter... formatters) {
        String formatted = content;
        for (StringFormatter formatter : formatters) {
            formatted = formatter.format(formatted, arguments);
        }
        this.content = JsonParser.parseString(formatted);
    }

    protected final void define(JsonRepresentation representation) {
        this.content = representation.toJson();
    }

    private CompletableFuture<?> save(final CachedOutput cache, final Path targetFile) {
        return DataProvider.saveStable(cache, this.content, targetFile);
    }

    @Override
    @NotNull
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
