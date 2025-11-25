package io.github.intersteed.blackblock;

import io.github.intersteed.blackblock.blocks.RegisterBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;

public class RegisterCreativeTabs {
    public static final String REGISTRY_NAME = "black_block_stuff";
    public static final String DISPLAY_NAME = "Black Block";
    static {BlackBlock.LOGGER.info("Loading CreativeModeTabs");}
    public static final DeferredRegister<CreativeModeTab> DR = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BlackBlock.MODID);
    static {BlackBlock.LOGGER.info("Created the CreativeModeTabs deferred register");}
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = DR.register(REGISTRY_NAME, () -> {
        BlackBlock.LOGGER.info("Creative mode tab being constructed");
        return CreativeModeTab.builder()
                .title(Component.translatable(DISPLAY_NAME)) //The language key for the title of your CreativeModeTab
                .withTabsBefore(CreativeModeTabs.COMBAT)
                .icon(() -> RegisterBlocks.THE_BLACK_BLOCK_ITEM.get().getDefaultInstance())
                .displayItems((parameters, output) -> {
                    output.accept(RegisterBlocks.THE_BLACK_BLOCK_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
                }).build();
    });

    static {BlackBlock.LOGGER.info("Loaded CreativeModeTabs");}
}
