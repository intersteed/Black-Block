package io.github.intersteed.blackblock.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class BBLootTableProvider extends LootTableProvider {
    public BBLootTableProvider(PackOutput output,
                               CompletableFuture<HolderLookup.Provider> futureLookupProvider) {
        super(output,
                Set.of(),
                List.of(new SubProviderEntry(
                BBBlockLootSubProvider::new,
                LootContextParamSets.BLOCK)),
                futureLookupProvider);
    }
}
