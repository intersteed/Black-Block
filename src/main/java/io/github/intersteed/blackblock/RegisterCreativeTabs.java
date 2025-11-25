package io.github.intersteed.blackblock;

import io.github.intersteed.blackblock.blocks.RegisterBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;

public class RegisterCreativeTabs {
    public static final String REGISTRY_NAME = "black_block_stuff";
    public static final String DISPLAY_NAME = "Black Block";
    public static final DeferredRegister<CreativeModeTab> DR = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BlackBlock.MODID);
    private static final CreativeModeTab.DisplayItemsGenerator itemsToDisplay = new CreativeModeTab.DisplayItemsGenerator() {

        @Override
        public void accept(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
            output.accept(RegisterBlocks.THE_BLACK_BLOCK_ITEM.get());
        }
    };
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = DR.register(REGISTRY_NAME, () -> {
        return CreativeModeTab.builder()
                .title(Component.translatable(DISPLAY_NAME))
                .withTabsBefore(CreativeModeTabs.COMBAT)
                .icon(() -> RegisterBlocks.THE_BLACK_BLOCK_ITEM.get().getDefaultInstance())
                .displayItems(itemsToDisplay)
                .build();
    });

    static {
        BlackBlock.LOGGER.info("Loaded CreativeModeTabs");
    }
}
