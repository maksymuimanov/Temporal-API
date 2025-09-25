package com.temporal.api.core.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;

import java.io.Serial;
import java.util.List;

public record ResourceLocationListRepresentation(Boolean replace, List<ResourceLocation> values) implements JsonRepresentation {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceLocationListRepresentation(List<ResourceLocation> values) {
        this(null, values);
    }

    @Override
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        if (replace != null) jsonObject.addProperty("replace", replace);
        JsonArray jsonArray = new JsonArray();
        for (ResourceLocation value : values) {
            jsonArray.add(value.toString());
        }
        jsonObject.add("values", jsonArray);
        return jsonObject;
    }
}
