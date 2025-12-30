package org.bergundy1.forged_in_war.neoforge.items;

import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.component.AttackRange;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.bergundy1.forged_in_war.Forged_in_war;
import org.bergundy1.forged_in_war.neoforge.blocks.ModBlocks;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Forged_in_war.MOD_ID);

    public static final DeferredItem<Item> BRASS_INGOT = ITEMS.register("brass_ingot", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "brass_ingot")))));
    public static final DeferredItem<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "zinc_ingot")))));
    public static final DeferredItem<Item> ZINC_NUGGET = ITEMS.register("zinc_nugget", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "zinc_nugget")))));
    public static final DeferredItem<Item> BRASS_NUGGET = ITEMS.register("brass_nugget", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "brass_nugget")))));
    public static final DeferredItem<BlockItem> ZINC_ORE = ITEMS.registerSimpleBlockItem(ModBlocks.ZINC_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_ZINC_ORE = ITEMS.registerSimpleBlockItem(ModBlocks.DEEPSLATE_ZINC_ORE);
    public static final DeferredItem<StandingAndWallBlockItem> ZINC_TORCH = ITEMS.register("zinc_torch", () -> new StandingAndWallBlockItem(ModBlocks.ZINC_TORCH.get(), ModBlocks.ZINC_WALL_TORCH.get(), Direction.DOWN, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "zinc_torch")))));
    public static final DeferredItem<StandingAndWallBlockItem> BRASS_TORCH = ITEMS.register("brass_torch", () -> new StandingAndWallBlockItem(ModBlocks.BRASS_TORCH.get(), ModBlocks.BRASS_WALL_TORCH.get(), Direction.DOWN, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "brass_torch")))));
    public static final DeferredItem<BlockItem> ZINC_LANTERN = ITEMS.registerSimpleBlockItem(ModBlocks.ZINC_LANTERN);
    public static final DeferredItem<BlockItem> BRASS_LANTERN = ITEMS.registerSimpleBlockItem(ModBlocks.BRASS_LANTERN);
    public static final DeferredItem<BlockItem> ZINC_BLOCK = ITEMS.registerSimpleBlockItem(ModBlocks.ZINC_BLOCK);
    public static final DeferredItem<BlockItem> BRASS_BLOCK = ITEMS.registerSimpleBlockItem(ModBlocks.BRASS_BLOCK);
    public static final DeferredItem<Item> BRASS_BATTLE_AXE = ITEMS.register("brass_battle_axe", () -> new Item(new Item.Properties().sword(ModToolMaterials.BRASS_TOOL_MATERIAL, 4f, -3f).component(DataComponents.ATTACK_RANGE, new AttackRange(1.5F, 3.5F, 1.5F, 5.5F, 0.125F, 0.5F)).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "brass_battle_axe")))));
    public static final DeferredItem<Item> BRASS_KNUCKLES = ITEMS.register("brass_knuckles", () -> new Item(new Item.Properties().sword(ModToolMaterials.BRASS_TOOL_MATERIAL, 3f, -1f).component(DataComponents.ATTACK_RANGE, new AttackRange(0F, 2.5F, 1F, 3.5f, 0.125F, 0.5F)).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "brass_knuckles")))));
    public static final DeferredItem<Item> LONGBOW = ITEMS.register("longbow", () -> new LongBowItem(new Item.Properties().enchantable(3).durability(384).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "longbow")))));


    public static void register(IEventBus modBus) {
     ITEMS.register(modBus);
    }
}
