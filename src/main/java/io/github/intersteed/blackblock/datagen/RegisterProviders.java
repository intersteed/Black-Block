package io.github.intersteed.blackblock.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class RegisterProviders {

    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        BBLanguageProvider languageProvider = new BBLanguageProvider(output);
        BBBlockStateProvider blockStateProvider = new BBBlockStateProvider(output, existingFileHelper);
        BBItemModelProvider itemModelProvider = new BBItemModelProvider(output, existingFileHelper);

        gen.addProvider(event.includeClient(), languageProvider);
        gen.addProvider(event.includeServer(), blockStateProvider);
        gen.addProvider(event.includeClient(), itemModelProvider);
    }

}
