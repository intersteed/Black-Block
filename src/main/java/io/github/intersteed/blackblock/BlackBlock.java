package io.github.intersteed.blackblock;

import io.github.intersteed.blackblock.items.RegisterItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

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
        RegisterCreativeTabs.DR.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        NeoForge.EVENT_BUS.addListener(this::onServerStarting);

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
