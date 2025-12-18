package io.github.intersteed.blackblock.datagen;

import io.github.intersteed.blackblock.BlackBlock;
import io.github.intersteed.blackblock.blocks.TheBlackBlock;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import static io.github.intersteed.blackblock.blocks.RegisterBlocks.THE_BLACK_BLOCK;

public class BBLanguageProvider extends LanguageProvider {

    public static final String ENGLISH = "en_us";

    public BBLanguageProvider(PackOutput output) {
        super(output, BlackBlock.MODID, ENGLISH);
    }

    @Override
    protected void addTranslations() {
        this.addDefaults();
        add(THE_BLACK_BLOCK.get(), TheBlackBlock.DISPLAY_NAME);
    }

    /**
     * These language translations came with the initial files.
     * I included them here just in case.
     */
    private void addDefaults() {
        add("itemGroup.blackblock", "Black Block Mod Tab");
        add("blackblock.configuration.title", "Black Block Configs");
        add("blackblock.configuration.section.blackblock.common.toml", "Black Block Configs");
        add("blackblock.configuration.section.blackblock.common.toml.title", "Black Block Configs");
        add("blackblock.configuration.items", "Item List");
    }
}
