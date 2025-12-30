package org.bergundy1.forged_in_war.neoforge.events;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;
import org.bergundy1.forged_in_war.Forged_in_war;
import org.bergundy1.forged_in_war.neoforge.items.ModItems;

@EventBusSubscriber(modid = Forged_in_war.MOD_ID, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void onComputeFovModifiersEvent(ComputeFovModifierEvent event) {
        if (event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() == ModItems.LONGBOW.get()) {
            int i = event.getPlayer().getTicksUsingItem();
            if (i > 0) {
                float f = (float)i / 20.0F;
                if (f > 1.0F) {
                    f = 1.0F;
                } else {
                    f *= f;
                }
                event.setNewFovModifier(event.getNewFovModifier() * (1.0F - f * 0.15F));
            }
        }
    }
}
