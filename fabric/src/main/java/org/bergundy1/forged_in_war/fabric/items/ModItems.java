package org.bergundy1.forged_in_war.fabric.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.component.AttackRange;
import org.bergundy1.forged_in_war.Forged_in_war;
import org.bergundy1.forged_in_war.fabric.blocks.ModBlocks;

import java.util.function.Function;

import static net.minecraft.world.item.Items.registerBlock;

public class ModItems {
    public static Item register(String name, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, name));
        Item item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }
    public static final ResourceKey<CreativeModeTab> CUSTOM_ITEM_GROUP_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "forgedinwar"));
    public static final CreativeModeTab CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.BRASS_BATTLE_AXE))
            .title(Component.translatable("itemGroup.forgedinwar"))
            .build();

    public static final Item BRASS_INGOT = register("brass_ingot", Item::new, new Item.Properties());
    public static final Item ZINC_INGOT = register("zinc_ingot", Item::new, new Item.Properties());
    public static final Item ZINC_NUGGET = register("zinc_nugget", Item::new, new Item.Properties());
    public static final Item BRASS_NUGGET = register("brass_nugget", Item::new, new Item.Properties());
    public static final Item ZINC_TORCH = registerBlock(ModBlocks.ZINC_TORCH, (block, properties) -> new StandingAndWallBlockItem(block, ModBlocks.ZINC_WALL_TORCH, Direction.DOWN, properties));
    public static final Item BRASS_TORCH = registerBlock(ModBlocks.BRASS_TORCH, (block, properties) -> new StandingAndWallBlockItem(block, ModBlocks.BRASS_WALL_TORCH, Direction.DOWN, properties));
    public static final Item BRASS_BATTLE_AXE = register("brass_battle_axe", Item::new, new Item.Properties().sword(ModToolMaterials.BRASS_TOOL_MATERIAL, 3f, -2.5f).component(DataComponents.ATTACK_RANGE, new AttackRange(1.5F, 3.5F, 1.5F, 5.5F, 0.125F, 0.5F)));
    public static final Item BRASS_KNUCKLES = register("brass_knuckles", Item::new, new Item.Properties().sword(ModToolMaterials.BRASS_TOOL_MATERIAL, 2f, -1f).component(DataComponents.ATTACK_RANGE, new AttackRange(0F, 2.5F, 1F, 3.5f, 0.125F, 0.5F)));

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.accept(ModBlocks.ZINC_ORE);
            itemGroup.accept(ModBlocks.DEEPSLATE_ZINC_ORE);
            itemGroup.accept(ModBlocks.ZINC_BLOCK);
            itemGroup.accept(ModBlocks.BRASS_BLOCK);
            itemGroup.accept(ModItems.ZINC_INGOT);
            itemGroup.accept(ModItems.BRASS_INGOT);
            itemGroup.accept(ModItems.ZINC_NUGGET);
            itemGroup.accept(ModItems.BRASS_NUGGET);
            itemGroup.accept(ModItems.ZINC_TORCH);
            itemGroup.accept(ModItems.BRASS_TORCH);
            itemGroup.accept(ModBlocks.ZINC_LANTERN);
            itemGroup.accept(ModBlocks.BRASS_LANTERN);
            itemGroup.accept(ModItems.BRASS_BATTLE_AXE);
            itemGroup.accept(ModItems.BRASS_KNUCKLES);
        });
    }
}
