package com.github.fly6ird.futuremite.recipe;

import com.github.fly6ird.futuremite.items.NetheriteItems;
import net.minecraft.Item;
import net.minecraft.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmithingRecipeManager {
    public static final SmithingRecipeManager instance = new SmithingRecipeManager();

    public final List<SmithingRecipe> smithingRecipes = new ArrayList<>();

    private SmithingRecipeManager() {
        this.registerDefaults();
    }

    public SmithingRecipe findRecipe(ItemStack[] inputSlots) {
        for (SmithingRecipe smithingRecipe : this.smithingRecipes) {
            if (smithingRecipe.matches(inputSlots)) {
                return smithingRecipe;
            }
        }
        return null;
    }

    public void register(SmithingRecipe recipe) {
        this.smithingRecipes.add(recipe);
    }

    public boolean isItemValidForSlot(int slotIndex, ItemStack itemStack) {
        if (slotIndex < 0 || slotIndex >= 3 || itemStack == null) {
            return false;
        }

        for (SmithingRecipe smithingRecipe : this.smithingRecipes) {
            if (smithingRecipe.matchesInput(slotIndex, itemStack)) {
                return true;
            }
        }

        return false;
    }

    private void registerDefaults() {
        this.registerUpgrade(new ItemStack(Item.helmetIron), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheriteHelmet));
        this.registerUpgrade(new ItemStack(Item.plateIron), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheriteChestplate));
        this.registerUpgrade(new ItemStack(Item.legsIron), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheriteLeggings));
        this.registerUpgrade(new ItemStack(Item.bootsIron), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheriteBoots));

        this.registerUpgrade(new ItemStack(Item.swordIron), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheriteSword));
        this.registerUpgrade(new ItemStack(Item.pickaxeIron), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheritePickaxe));
        this.registerUpgrade(new ItemStack(Item.axeIron), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheriteAxe));
        this.registerUpgrade(new ItemStack(Item.shovelIron), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheriteShovel));
        this.registerUpgrade(new ItemStack(Item.hoeIron), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheriteHoe));

        this.registerUpgrade(new ItemStack(Item.battleAxeIron), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheriteBattleAxe));
        this.registerUpgrade(new ItemStack(Item.warHammerIron), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheriteWarHammer));
        this.registerUpgrade(new ItemStack(Item.mattockIron), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheriteMattock));
        this.registerUpgrade(new ItemStack(Item.scytheIron), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheriteScythe));
        this.registerUpgrade(new ItemStack(Item.daggerIron), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheriteDagger));
        this.registerUpgrade(new ItemStack(Item.hatchetIron), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheriteHatchet));
        this.registerUpgrade(new ItemStack(Item.shears), new ItemStack(NetheriteItems.netheriteIngot), new ItemStack(NetheriteItems.netheriteShears));
    }

    private void registerUpgrade(ItemStack base, ItemStack ingredient, ItemStack output) {
        this.register(new SmithingRecipe(
                Arrays.asList(new ItemStack(NetheriteItems.netheriteUpgradeTemplate), base, ingredient),
                output,
                1
        ));
    }
}
