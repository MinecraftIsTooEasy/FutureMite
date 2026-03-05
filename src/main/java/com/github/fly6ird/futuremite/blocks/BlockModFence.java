package com.github.fly6ird.futuremite.blocks;

import com.github.fly6ird.futuremite.creativetab.FutureMITECreativeTabs;
import net.minecraft.*;

public class BlockModFence extends BlockFence {
    private final BlockModWoodPlanks planks;

    public BlockModFence(int par1, String id, BlockModWoodPlanks planks) {
        super(par1, "futuremite:planks/" + id, Material.wood);
        this.planks = planks;
        this.setHardness(2.0F).setResistance(5.0F)
            .setStepSound(soundWoodFootstep)
            .setUnlocalizedName("fences." + id)
            .setCreativeTab(FutureMITECreativeTabs.tabBlock);
    }

    @Override
    public Icon getIcon(int side, int meta) {
        return planks.getIcon(side, 0);
    }
}
