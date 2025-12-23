package org.bergundy1.forged_in_war.fabric.blocks;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.bergundy1.forged_in_war.Forged_in_war;
import org.bergundy1.forged_in_war.fabric.Forged_in_warFabric;

import java.util.function.Function;

public class ModBlocks {
    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));
        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return  Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, name));
    }

    public static final Block ZINC_ORE = register("zinc_ore", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_ORE), true);
    public static final Block DEEPSLATE_ZINC_ORE = register("deepslate_zinc_ore", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_COPPER_ORE), true);
    public static final Block ZINC_BLOCK = register("zinc_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK), true);
    public static final Block BRASS_BLOCK = register("brass_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK), true);
    public static final Block ZINC_LANTERN = register("zinc_lantern", LanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN), true);
    public static final Block ZINC_TORCH = register("zinc_torch", properties -> new TorchBlock(Forged_in_warFabric.ZINC_FLAME, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH), false);
    public static final Block ZINC_WALL_TORCH = register("zinc_wall_torch", properties -> new WallTorchBlock(Forged_in_warFabric.ZINC_FLAME, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).overrideLootTable(ModBlocks.ZINC_TORCH.getLootTable()), false);
    public static final Block BRASS_LANTERN = register("brass_lantern", LanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN), true);
    public static final Block BRASS_TORCH = register("brass_torch", properties -> new TorchBlock(Forged_in_warFabric.BRASS_FLAME, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH), false);
    public static final Block BRASS_WALL_TORCH = register("brass_wall_torch", properties -> new WallTorchBlock(Forged_in_warFabric.BRASS_FLAME, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).overrideLootTable(ModBlocks.BRASS_TORCH.getLootTable()), false);

    public static void initialize() {}
}
