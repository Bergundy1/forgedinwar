package org.bergundy1.forged_in_war.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.FlameParticle;
import org.bergundy1.forged_in_war.fabric.Forged_in_warFabric;

public final class Forged_in_warFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        ParticleFactoryRegistry.getInstance().register(Forged_in_warFabric.ZINC_FLAME, FlameParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(Forged_in_warFabric.BRASS_FLAME, FlameParticle.Provider::new);
    }
}
