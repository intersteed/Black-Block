package io.github.intersteed.blackblock.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class RegisterProviders {

    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        BBLanguageProvider languageProvider = new BBLanguageProvider(output);

        gen.addProvider(event.includeClient(), languageProvider);
    }

}
