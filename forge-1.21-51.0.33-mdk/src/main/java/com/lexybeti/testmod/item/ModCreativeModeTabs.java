package com.lexybeti.testmod.item;

import com.lexybeti.testmod.TestMod;
import com.lexybeti.testmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);

    public static final RegistryObject<CreativeModeTab> JADE_ITEMS_TAB = CREATIVE_MODE_TABS.register("jade_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.JADE.get()))
                    .title(Component.translatable("creativetab.testmod.jade_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.JADE.get());
                        output.accept(ModItems.RAW_JADE.get());

                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> JADE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("jade_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.JADE_BLOCK.get()))
                    .withTabsBefore(JADE_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.testmod.jade_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.JADE_BLOCK.get());
                        output.accept(ModBlocks.RAW_JADE_BLOCK.get());
                        output.accept(ModBlocks.JADE_ORE_BLOCK.get());
                        output.accept(ModBlocks.DEEPSLATE_JADE_ORE_BLOCK.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
