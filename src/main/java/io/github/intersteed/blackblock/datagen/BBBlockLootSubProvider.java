package io.github.intersteed.blackblock.datagen;

import io.github.intersteed.blackblock.blocks.RegisterBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;

import static io.github.intersteed.blackblock.blocks.RegisterBlocks.THE_BLACK_BLOCK;

public class BBBlockLootSubProvider extends BlockLootSubProvider {

    protected BBBlockLootSubProvider(HolderLookup.Provider lookupProvider) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RegisterBlocks.DR.getEntries()
                .stream()
                .map(e -> (Block) e.value())
                .toList();
    }

    @Override
    protected void generate() {
        dropSelf(THE_BLACK_BLOCK.get());
    }


}
