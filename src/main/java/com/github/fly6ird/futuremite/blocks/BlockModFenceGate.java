package com.github.fly6ird.futuremite.blocks;

import com.github.fly6ird.futuremite.creativetab.FutureMITECreativeTabs;
import net.minecraft.*;

public class BlockModFenceGate extends BlockFenceGate {
    private final BlockModWoodPlanks planks;

    public BlockModFenceGate(int par1, String id, BlockModWoodPlanks planks) {
        super(par1);
        this.planks = planks;
        this.setHardness(2.0F).setResistance(5.0F)
            .setStepSound(soundWoodFootstep)
            .setUnlocalizedName("fence_gates." + id)
            .setCreativeTab(FutureMITECreativeTabs.tabBlock);
    }

    @Override
    public Icon getIcon(int side, int meta) {
        return planks.getIcon(side, 0);
    }
}
