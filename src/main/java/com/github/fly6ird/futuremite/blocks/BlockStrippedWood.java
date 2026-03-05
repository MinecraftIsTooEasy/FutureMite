package com.github.fly6ird.futuremite.blocks;

import com.github.fly6ird.futuremite.creativetab.FutureMITECreativeTabs;

import net.minecraft.Block;
import net.minecraft.BlockConstants;
import net.minecraft.Material;

public class BlockStrippedWood extends Block {
    protected BlockStrippedWood(int par1) {
        super(par1, Material.wood, new BlockConstants());
        modifyMinHarvestLevel(1);
        setHardness(1.0F);
        setStepSound(Blocks.stepSoundWood);
        this.setCreativeTab(FutureMITECreativeTabs.tabBlock);
    }

    protected BlockStrippedWood(int par1, String id) {
        super(par1, Material.wood, new BlockConstants());
        modifyMinHarvestLevel(1);
        setHardness(1.0F);
        setStepSound(Blocks.stepSoundWood);
        this.setCreativeTab(FutureMITECreativeTabs.tabBlock);
        this.setTextureName("futuremite:log/stripped_" + id + "_side");
        this.setUnlocalizedName("log.stripped_" + id + "_wood");
    }
}
