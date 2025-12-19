package io.github.intersteed.blackblock.datagen;


import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

import static io.github.intersteed.blackblock.blocks.RegisterBlocks.THE_BLACK_BLOCK_ITEM;

public class BBRecipeProvider extends RecipeProvider {
    public BBRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, THE_BLACK_BLOCK_ITEM.get())
                .requires(Items.DIRT)
                .unlockedBy("has_dirt", has(Items.DIRT))
                .save(recipeOutput);
    }
}
