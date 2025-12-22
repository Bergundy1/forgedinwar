package org.bergundy1.forged_in_war.neoforge.tags;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.bergundy1.forged_in_war.Forged_in_war;

public class ModTags {
    public static final TagKey<Item> REPAIRS_BRASS_TOOLS = createTag("repairs_brass_tools");

    private static TagKey<Item> createTag(String name) {
        return ItemTags.create(Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, name));
    }
}
