package io.github.intersteed.blackblock.blockentities;

import io.github.intersteed.blackblock.blocks.TheBlackBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;

import static io.github.intersteed.blackblock.blockentities.RegisterBlockEntityTypes.BLACK_BLOCK_ENTITY_TYPE;

public class BlackBlockEntity extends BlockEntity {

    public static String REGISTRY_NAME = "the_black_block_entity";



    public BlackBlockEntity(BlockPos pos, BlockState blockState) {
        super(BLACK_BLOCK_ENTITY_TYPE.get(), pos, blockState);
    }
}
