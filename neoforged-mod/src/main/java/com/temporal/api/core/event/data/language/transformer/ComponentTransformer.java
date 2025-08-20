package com.temporal.api.core.event.data.language.transformer;

import net.minecraft.network.chat.Component;

public class ComponentTransformer implements KeyTransformer<Component> {
    @Override
    public String transform(Component component) {
        return component.getContents().type().id();
    }
}
