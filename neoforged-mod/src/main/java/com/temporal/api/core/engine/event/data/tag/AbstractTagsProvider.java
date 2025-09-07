package com.temporal.api.core.engine.event.data.tag;

import com.temporal.api.core.engine.event.data.file.FileSource;
import com.temporal.api.core.engine.event.data.file.MultiFileProvider;
import com.temporal.api.core.json.JsonRepresentation;
import com.temporal.api.core.json.ResourceLocationsRepresentation;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Map;

public abstract class AbstractTagsProvider<T> extends MultiFileProvider {
    private final String rootDirectory;

    public AbstractTagsProvider(PackOutput output, String rootDirectory) {
        super(output);
        this.rootDirectory = rootDirectory;
    }

    @Override
    public void registerFiles() {
        Map<String, List<ResourceKey<T>>> tagContents = this.getTagContents();
        tagContents.forEach((tag, keys) -> {
            ResourceLocation tagLocation = ResourceUtils.parse(tag);
            FileSource fileSource = new FileSource(PackOutput.Target.DATA_PACK, tagLocation.getNamespace(), this.getRootDirectory() + tagLocation.getPath() + JSON);
            List<ResourceLocation> locations = keys.stream()
                    .map(ResourceKey::location)
                    .toList();
            JsonRepresentation representation = new ResourceLocationsRepresentation(locations);
            this.define(fileSource, representation);
        });
        tagContents.clear();
    }

    protected abstract Map<String, List<ResourceKey<T>>> getTagContents();

    public String getRootDirectory() {
        return rootDirectory;
    }
}
