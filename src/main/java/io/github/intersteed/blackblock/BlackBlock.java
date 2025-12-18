package io.github.intersteed.blackblock;

import io.github.intersteed.blackblock.blockentities.RegisterBlockEntityTypes;
import io.github.intersteed.blackblock.datagen.RegisterProviders;
import io.github.intersteed.blackblock.items.RegisterItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import io.github.intersteed.blackblock.blocks.RegisterBlocks;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(BlackBlock.MODID)
public class BlackBlock {
    public static final String MODID = "blackblock";
    public static final Logger LOGGER = LogUtils.getLogger();


    public BlackBlock(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        RegisterBlocks.DR.register(modEventBus);
        RegisterItems.DR.register(modEventBus);
        RegisterBlockEntityTypes.DR.register(modEventBus);
        RegisterCreativeTabs.DR.register(modEventBus);
        modEventBus.addListener(this::addCreative);
        NeoForge.EVENT_BUS.addListener(this::onServerStarting);

        modEventBus.addListener(RegisterProviders::gatherData);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    /**
     * This is the handler for the common setup event. I'm
     * not sure why we would use this.
     */
    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Ran the Common Set up");
    }

    /**
     * This is where we would register stuff in other creative mode tabs
     * They recommend that we register our own stuff directly when we
     * register our tab.
     */
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        LOGGER.info("Registered our item in another tab");
    }

    /**
     * This is where we would initialize stuff for the server.
     */
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
