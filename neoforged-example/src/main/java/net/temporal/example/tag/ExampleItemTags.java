package net.temporal.example.tag;

import com.temporal.api.core.engine.io.metadata.annotation.data.tag.TagContainer;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.io.metadata.constant.TagContainerType;
import com.temporal.api.core.util.other.TagUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

@TagContainer(TagContainerType.ITEM)
@Injected(false)
public final class ExampleItemTags {
    public static final TagKey<Item> REPAIRS_EXAMPLE_ARMOR = TagUtils.createItemTag("repairs_example_armor");
}
