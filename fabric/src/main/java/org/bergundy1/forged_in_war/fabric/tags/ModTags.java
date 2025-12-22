package org.bergundy1.forged_in_war.fabric.tags;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.bergundy1.forged_in_war.Forged_in_war;

public class ModTags {
    public static final TagKey<Item> REPAIRS_BRASS_TOOLS = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "repairs_brass_tools"));

    public static void initialize() {}
}
