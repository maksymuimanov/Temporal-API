package com.temporal.api.core.json;

import com.google.gson.JsonElement;

import java.io.Serializable;

public interface JsonRepresentation extends Serializable {
    JsonElement toJson();
}
