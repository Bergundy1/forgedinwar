package org.bergundy1.forged_in_war.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import org.bergundy1.forged_in_war.fabric.Forged_in_warFabric;
import org.bergundy1.forged_in_war.fabric.blocks.ModBlocks;

public final class Forged_in_warFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        ParticleFactoryRegistry.getInstance().register(Forged_in_warFabric.ZINC_FLAME, FlameParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(Forged_in_warFabric.BRASS_FLAME, FlameParticle.Provider::new);
        BlockRenderLayerMap.putBlock(ModBlocks.ZINC_LANTERN, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.BRASS_LANTERN, ChunkSectionLayer.CUTOUT);

    }
}
