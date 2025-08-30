package net.temporal.example;

import com.temporal.api.core.util.EnumExtensionUtils;

public class ExampleEnumExtensions {
    public static Object EXAMPLE_BOAT(int idx, Class<?> type) {
        return EnumExtensionUtils.createBoat(idx, type, "example:example_planks", "example:example", "example:example_boat", "example:example_chest_boat");
    }
}
