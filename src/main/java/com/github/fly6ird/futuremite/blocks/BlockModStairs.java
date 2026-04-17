package com.github.fly6ird.futuremite.blocks;

import com.github.fly6ird.futuremite.creativetab.FutureMITECreativeTabs;

import net.minecraft.Block;
import net.minecraft.BlockStairs;

public class BlockModStairs extends BlockStairs {
    private final int stairModelMetadata;

    protected BlockModStairs(int par1, Block par2Block, int par3) {
        super(par1, par2Block, par3);
        this.stairModelMetadata = par3;
        this.setUnlocalizedName("stairs");
        this.setCreativeTab(FutureMITECreativeTabs.tabBlock);
    }

    @Override
    public float getBlockHardness(int metadata) {
        return this.modelBlock.getBlockHardness(this.stairModelMetadata);
    }
}
