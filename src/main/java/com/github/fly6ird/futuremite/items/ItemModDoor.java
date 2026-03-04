package com.github.fly6ird.futuremite.items;

import com.github.fly6ird.futuremite.blocks.BlockModWoodPlanks;

import com.github.fly6ird.futuremite.creativetab.FutureMITECreativeTabs;
import net.minecraft.Block;
import net.minecraft.ItemDoor;
import net.minecraft.ItemStack;
import net.minecraft.Material;

import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;

public class ItemModDoor extends ItemDoor {
    private final Block DoorBlock;
    private final BlockModWoodPlanks Planks;

    public ItemModDoor(int par1, Block doorBlock, String id) {
        this(par1, doorBlock, (BlockModWoodPlanks) null);
        this.setTextureName("futuremite:doors/" + id);
        this.setUnlocalizedName("doors." + id);
        this.setCreativeTab(FutureMITECreativeTabs.tabBlock);
    }

    public ItemModDoor(int par1, Block doorBlock, BlockModWoodPlanks planks) {
        super(par1, Material.wood);
        DoorBlock = doorBlock;
        Planks = planks;
        if (Planks != null) {
            this.setTextureName("futuremite:doors/" + Planks.id);
            this.setUnlocalizedName("doors." + Planks.id);
            this.setCreativeTab(FutureMITECreativeTabs.tabBlock);
        }
    }

    public void registerRecipe(RecipeRegistryEvent register) {
        register.registerShapedRecipe(new ItemStack(this, 1), true, new Object[]{"AA", "AA", "AA", Character.valueOf('A'), Planks});
    }

    public void registerRecipeWithVanilla(RecipeRegistryEvent register, int i) {
        register.registerShapedRecipe(new ItemStack(this, 1), true, new Object[]{"AA", "AA", "AA", Character.valueOf('A'), new ItemStack((Block.planks), 1, i)});
    }

    @Override
    public Block getBlock() {
        return DoorBlock;
    }
}
