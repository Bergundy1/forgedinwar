package org.bergundy1.forged_in_war.neoforge;

import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.world.level.biome.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import org.bergundy1.forged_in_war.Forged_in_war;
import net.neoforged.fml.common.Mod;
import org.bergundy1.forged_in_war.neoforge.blocks.ModBlocks;
import org.bergundy1.forged_in_war.neoforge.items.ModCreativeModeTabs;
import org.bergundy1.forged_in_war.neoforge.items.ModItems;
import org.bergundy1.forged_in_war.neoforge.particles.ModParticles;

@Mod(Forged_in_war.MOD_ID)
public final class Forged_in_warNeoForge {
    public Forged_in_warNeoForge(IEventBus modEventBus) {
        // Run our common setup.
        Forged_in_war.init();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModParticles.register(modEventBus);
    }
    @EventBusSubscriber(modid = "forgedinwar", value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(ModParticles.ZINC_FLAME.get(), FlameParticle.Provider::new);
            event.registerSpriteSet(ModParticles.BRASS_FLAME.get(), FlameParticle.Provider::new);
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ZINC_LANTERN.get(), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRASS_LANTERN.get(), ChunkSectionLayer.CUTOUT);
        }
    }
}
