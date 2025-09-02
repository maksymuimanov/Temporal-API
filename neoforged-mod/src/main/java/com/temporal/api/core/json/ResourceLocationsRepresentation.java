package com.temporal.api.core.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;

import java.io.Serial;

public record ResourceLocationsRepresentation(boolean replace, ResourceLocation[] values) implements JsonRepresentation {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("replace", replace);
        JsonArray jsonArray = new JsonArray();
        for (ResourceLocation value : values) {
            jsonArray.add(value.toString());
        }
        jsonObject.add("values", jsonArray);
        return jsonObject;
    }
}
