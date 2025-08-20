package com.temporal.api.core.event.data.language.transformer;

public class StringTransformer implements KeyTransformer<String> {
    @Override
    public String transform(String string) {
        return string;
    }
}
