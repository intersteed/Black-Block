package io.github.intersteed.blackblock.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;

public class TheBlackBlock extends Block {

    public static String REGISTRY_NAME = "the_black_block";
    public static String DISPLAY_NAME = "The Black Block";

    public TheBlackBlock(Properties p_49795_) {
        super(p_49795_);
    }

    public static Properties getBlackBlockProperties() {
        Properties props = Properties.of()
                .mapColor(MapColor.STONE)
                .strength(1.0F)
                .overrideDescription(DISPLAY_NAME);
        return props;
    }

}
