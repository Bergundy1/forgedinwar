package org.bergundy1.forged_in_war.fabric;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.bergundy1.forged_in_war.Forged_in_war;
import net.fabricmc.api.ModInitializer;
import org.bergundy1.forged_in_war.fabric.blocks.ModBlocks;
import org.bergundy1.forged_in_war.fabric.items.ModItems;

public final class Forged_in_warFabric implements ModInitializer {
    public static final SimpleParticleType ZINC_FLAME = FabricParticleTypes.simple();
    public static final SimpleParticleType BRASS_FLAME = FabricParticleTypes.simple();
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Forged_in_war.init();
        ModItems.initialize();
        ModBlocks.initialize();
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "zinc_flame"), ZINC_FLAME);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "brass_flame"), BRASS_FLAME);

        ResourceKey<PlacedFeature> ZINC_ORE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Forged_in_war.MOD_ID, "zinc_ore_placed"));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, ZINC_ORE_PLACED_KEY);
    }
}
