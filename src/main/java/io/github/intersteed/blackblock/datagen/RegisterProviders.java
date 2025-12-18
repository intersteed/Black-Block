package io.github.intersteed.blackblock.datagen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public class RegisterProviders {

    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> futureLookupProvider = event.getLookupProvider();

        BBLanguageProvider languageProvider = new BBLanguageProvider(output);
        BBBlockStateProvider blockStateProvider = new BBBlockStateProvider(output, existingFileHelper);
        BBItemModelProvider itemModelProvider = new BBItemModelProvider(output, existingFileHelper);
        BBLootTableProvider lootTableProvider = new BBLootTableProvider(output, futureLookupProvider);

        gen.addProvider(event.includeClient(), languageProvider);
        gen.addProvider(event.includeClient(), blockStateProvider);
        gen.addProvider(event.includeClient(), itemModelProvider);
        gen.addProvider(event.includeServer(), lootTableProvider);
    }

}
