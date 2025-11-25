package io.github.intersteed.blackblock.blocks;

import static io.github.intersteed.blackblock.BlackBlock.MODID;
import io.github.intersteed.blackblock.items.RegisterItems;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RegisterBlocks {
    public static final DeferredRegister.Blocks DR = DeferredRegister.createBlocks(MODID);

    private static final DeferredBlock<TheBlackBlock> THE_BLACK_BLOCK = DR.register(TheBlackBlock.REGISTRY_NAME,
            () -> new TheBlackBlock(TheBlackBlock.getBlackBlockProperties()));
    DeferredItem<BlockItem> THE_BLACK_BLOCK_ITEM = RegisterItems.DR.register(TheBlackBlock.REGISTRY_NAME,
            () -> new BlockItem(THE_BLACK_BLOCK.get(), new Item.Properties()));
}
