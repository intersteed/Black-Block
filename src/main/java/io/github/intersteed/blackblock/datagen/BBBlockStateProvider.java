package io.github.intersteed.blackblock.datagen;

import io.github.intersteed.blackblock.BlackBlock;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import static io.github.intersteed.blackblock.blocks.RegisterBlocks.THE_BLACK_BLOCK;

public class BBBlockStateProvider extends BlockStateProvider {
    public BBBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BlackBlock.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(THE_BLACK_BLOCK.get());
    }
}
