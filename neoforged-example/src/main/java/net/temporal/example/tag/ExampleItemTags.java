package net.temporal.example.tag;

import com.temporal.api.core.engine.metadata.annotation.data.RegisterTagContainer;
import com.temporal.api.core.engine.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.metadata.constant.TagContainerType;
import com.temporal.api.core.util.TagUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

@RegisterTagContainer(TagContainerType.ITEM)
@Injected
public final class ExampleItemTags {
    public static final TagKey<Item> REPAIRS_EXAMPLE_ARMOR = TagUtils.createItemTag("repairs_example_armor");
}
