package io.github.intersteed.blackblock.blocks;

import io.github.intersteed.blackblock.BlackBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.Blocks;

public class TheBlackBlock extends Block {

    public static String REGISTRY_NAME = "the_black_block";
    public static String DISPLAY_NAME = "The Black Block";

    private int interactionCount;

    public TheBlackBlock(Properties p_49795_) {
        super(p_49795_);
        interactionCount = 0;
        BlackBlock.LOGGER.info("Registering TheBlackBlock");
    }

    public static Properties getBlockProperties() {
        Properties props = Properties.of()
                .mapColor(MapColor.STONE)
                .strength(1.0F);
        return props;
    }

    public static Item.Properties getItemProperties() {
        Item.Properties itemProperties = new Item.Properties();
        return itemProperties;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        System.out.println("started an interaction against the black block for time " + String.valueOf(interactionCount) + " on level " + String.valueOf(level));
        this.interactionCount++;
        BlockState airState = Blocks.AIR.getStateDefinition().any();
        BlockState tntState = Blocks.TNT.getStateDefinition().any();
        level.setBlock(pos, airState, 0);
        Blocks.TNT.onCaughtFire(tntState, level, pos, null, null);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

}
