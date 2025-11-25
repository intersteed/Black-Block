package io.github.intersteed.blackblock.blocks;

import io.github.intersteed.blackblock.BlackBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class TheBlackBlock extends Block {

    public static String REGISTRY_NAME = "the_black_block";
    public static String DISPLAY_NAME = "The Black Block";
    public static ResourceLocation RESOURCE_ID = ResourceLocation.fromNamespaceAndPath(BlackBlock.MODID, REGISTRY_NAME);

    public TheBlackBlock(Properties p_49795_) {
        super(p_49795_);
        BlackBlock.LOGGER.info("Registering TheBlackBlock");
    }

    public static Properties getBlockProperties() {
        Properties props = Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, RESOURCE_ID))
                .mapColor(MapColor.STONE)
                .strength(1.0F)
                .overrideDescription(DISPLAY_NAME);
        return props;
    }

    public static Item.Properties getItemProperties() {
        Item.Properties itemProperties = new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, RESOURCE_ID));
        return itemProperties;
    }

}
