package org.bergundy1.forged_in_war.neoforge.blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.bergundy1.forged_in_war.Forged_in_war;
import org.bergundy1.forged_in_war.neoforge.particles.ModParticles;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Forged_in_war.MOD_ID);

    public static final DeferredBlock<Block> ZINC_ORE = BLOCKS.register("zinc_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_ORE).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "zinc_ore")))));
    public static final DeferredBlock<Block> DEEPSLATE_ZINC_ORE = BLOCKS.register("deepslate_zinc_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_COPPER_ORE).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "deepslate_zinc_ore")))));
    public static final DeferredBlock<Block> ZINC_BLOCK = BLOCKS.register("zinc_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "zinc_block")))));
    public static final DeferredBlock<Block> BRASS_BLOCK = BLOCKS.register("brass_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "brass_block")))));
    public static final DeferredBlock<TorchBlock> ZINC_TORCH = BLOCKS.register("zinc_torch", () -> new TorchBlock(ModParticles.ZINC_FLAME.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "zinc_torch")))));
    public static final DeferredBlock<WallTorchBlock> ZINC_WALL_TORCH = BLOCKS.register("zinc_wall_torch", () -> new WallTorchBlock(ModParticles.ZINC_FLAME.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).overrideLootTable(ModBlocks.ZINC_TORCH.get().getLootTable()).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "zinc_torch")))));
    public static final DeferredBlock<TorchBlock> BRASS_TORCH = BLOCKS.register("brass_torch", () -> new TorchBlock(ModParticles.BRASS_FLAME.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "brass_torch")))));
    public static final DeferredBlock<WallTorchBlock> BRASS_WALL_TORCH = BLOCKS.register("brass_wall_torch", () -> new WallTorchBlock(ModParticles.BRASS_FLAME.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).overrideLootTable(ModBlocks.BRASS_TORCH.get().getLootTable()).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "brass_torch")))));
    public static final DeferredBlock<LanternBlock> ZINC_LANTERN = BLOCKS.register("zinc_lantern", () -> new LanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "zinc_lantern")))));
    public static final DeferredBlock<LanternBlock> BRASS_LANTERN = BLOCKS.register("brass_lantern", () -> new LanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "brass_lantern")))));

    public static void register(IEventBus modBus) {
        BLOCKS.register(modBus);
    }
}
