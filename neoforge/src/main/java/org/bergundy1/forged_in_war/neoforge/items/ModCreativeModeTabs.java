package org.bergundy1.forged_in_war.neoforge.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.bergundy1.forged_in_war.Forged_in_war;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Forged_in_war.MOD_ID);

    public static final Supplier<CreativeModeTab> FORGED_IN_WAR_TAB = CREATIVE_MODE_TAB.register("forgedinwar", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.BRASS_BATTLE_AXE.get()))
            .title(Component.translatable("creativetab.forgedinwar.forgedinwar"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.BRASS_INGOT);
                output.accept(ModItems.ZINC_INGOT);
                output.accept(ModItems.BRASS_BLOCK);
                output.accept(ModItems.ZINC_BLOCK);
                output.accept(ModItems.BRASS_NUGGET);
                output.accept(ModItems.ZINC_NUGGET);
                output.accept(ModItems.ZINC_ORE);
                output.accept(ModItems.DEEPSLATE_ZINC_ORE);
                output.accept(ModItems.ZINC_TORCH);
                output.accept(ModItems.BRASS_TORCH);
                output.accept(ModItems.ZINC_LANTERN);
                output.accept(ModItems.BRASS_LANTERN);
                output.accept(ModItems.BRASS_BATTLE_AXE);
                output.accept(ModItems.BRASS_KNUCKLES);
            })
            .build());

    public static void register(IEventBus modBus) {
        CREATIVE_MODE_TAB.register(modBus);
    }
}
