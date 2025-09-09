package com.temporal.api.core.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serial;
import java.util.List;
import java.util.Map;

public record AtlasArmorTrimRepresentation(boolean replace, Source[] sources) implements JsonRepresentation {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("replace", replace);
        JsonArray jsonArray = new JsonArray();
        for (Source source : sources) {
            JsonElement sourceJson = source.toJson();
            jsonArray.add(sourceJson);
        }
        jsonObject.add("sources", jsonArray);
        return jsonObject;
    }

    public record Source(String type, List<String> textures, String paletteKey, Permutations permutations) implements JsonRepresentation {
        @Override
        public JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type", type);
            JsonArray textureJsonArray = new JsonArray();
            for (String texture : textures) {
                textureJsonArray.add(texture);
            }
            jsonObject.add("textures", textureJsonArray);
            jsonObject.addProperty("palette_key", paletteKey);
            jsonObject.add("permutations", permutations.toJson());
            return jsonObject;
        }
    }

    public record Permutations(Map<String, String> permutations) implements JsonRepresentation {
        @Override
        public JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            permutations.forEach(jsonObject::addProperty);
            return jsonObject;
        }
    }
}