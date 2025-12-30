package org.bergundy1.forged_in_war.fabric.mixin;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.item.ItemStack;
import org.bergundy1.forged_in_war.fabric.items.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayer.class)
public abstract class AbstractClientPlayerMixin {
    @Inject(method = "getFieldOfViewModifier", at = @At("RETURN"), cancellable = true)
    private void injectCustomZoom(CallbackInfoReturnable<Float> cir) {
        AbstractClientPlayer abstractClientPlayer = (AbstractClientPlayer) (Object) this;
        ItemStack itemStack = abstractClientPlayer.getUseItem();

        if (itemStack.is(ModItems.LONGBOW)) {
            int i = abstractClientPlayer.getTicksUsingItem();
            if (i > 0) {
                float f = (float)i / 20.0F;
                if (f > 1.0F) {
                    f = 1.0F;
                } else {
                    f *= f;
                }
                cir.setReturnValue(cir.getReturnValue() * (1.0F - f * 0.15F));
            }
        }
    }
}
