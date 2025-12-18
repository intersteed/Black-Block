package io.github.intersteed.blackblock.datagen;

import io.github.intersteed.blackblock.BlackBlock;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static io.github.intersteed.blackblock.blocks.RegisterBlocks.THE_BLACK_BLOCK;
import static io.github.intersteed.blackblock.blocks.RegisterBlocks.THE_BLACK_BLOCK_ITEM;

public class BBItemModelProvider extends ItemModelProvider {

    public BBItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BlackBlock.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleBlockItem(THE_BLACK_BLOCK.get());
    }
}
