package com.github.fly6ird.futuremite.compat;

import com.github.fly6ird.futuremite.FutureMITEStart;
import com.github.fly6ird.futuremite.blocks.Blocks;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiWorldInteractionRecipe;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;

import net.minecraft.Block;
import net.minecraft.Item;
import net.minecraft.ItemAxe;
import net.minecraft.ItemStack;
import net.minecraft.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class FutureMITEEMIPlugin implements EmiPlugin {

    @Override
    public void register(EmiRegistry registry) {
        addStrippingRecipes(registry);
    }

    private void addStrippingRecipes(EmiRegistry registry)
    {
        List<EmiStack> axeStacks = new ArrayList<>();
        for (int i = 0; i < Item.itemsList.length; i++)
        {
            Item item = Item.itemsList[i];
            if (item == null) continue;
            boolean isAxe = item instanceof ItemAxe;
            if (isAxe)
            {
                ItemStack itemStack = new ItemStack(item, 1);
                EmiStack emi = EmiStack.of(itemStack);
                ItemStack damaged = new ItemStack(item, 1);
                damaged.setItemDamage(10);
                emi.setRemainder(EmiStack.of(damaged));
                axeStacks.add(emi);
            }
        }
        EmiIngredient axes = EmiIngredient.of(axeStacks);

        // Vanilla logs -> Stripped logs
        addStrippingRecipe(registry, axes,
                new ItemStack(Block.wood, 1, 0),
                new ItemStack(Blocks.oakLog, 1, 0),
                "oak_log");

        addStrippingRecipe(registry, axes,
                new ItemStack(Block.wood, 1, 1),
                new ItemStack(Blocks.spruceLog, 1, 0),
                "spruce_log");

        addStrippingRecipe(registry, axes,
                new ItemStack(Block.wood, 1, 2),
                new ItemStack(Blocks.birchLog, 1, 0),
                "birch_log");

        addStrippingRecipe(registry, axes,
                new ItemStack(Block.wood, 1, 3),
                new ItemStack(Blocks.jungleLog, 1, 0),
                "jungle_log");


        // Mod logs -> Stripped mod logs
        addStrippingRecipe(registry, axes,
                new ItemStack(Blocks.acacia.Log, 1, 0),
                new ItemStack(Blocks.acacia.Log, 1, 2),
                "acacia_log");

        addStrippingRecipe(registry, axes,
                new ItemStack(Blocks.darkOak.Log, 1, 0),
                new ItemStack(Blocks.darkOak.Log, 1, 2),
                "dark_oak_log");

        addStrippingRecipe(registry, axes,
                new ItemStack(Blocks.cherry.Log, 1, 0),
                new ItemStack(Blocks.cherry.Log, 1, 2),
                "cherry_log");
    }

    private void addStrippingRecipe(EmiRegistry registry, EmiIngredient axe,
                                     ItemStack input, ItemStack output, String id) {
        registry.addRecipe(EmiWorldInteractionRecipe.builder()
                .id(new ResourceLocation(FutureMITEStart.MOD_ID, "world/stripping/" + id))
                .leftInput(EmiStack.of(input))
                .rightInput(axe, true)
                .output(EmiStack.of(output))
                .build());
    }
}