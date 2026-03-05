package com.github.fly6ird.futuremite.blocks;

import moddedmite.rustedironcore.api.block.WorkbenchBlock;
import net.minecraft.Block;
import net.minecraft.Icon;
import net.minecraft.IconRegister;
import net.minecraft.Material;

public class FMWorkBenchBlock extends WorkbenchBlock {

    private Icon workbench_icon_top;
    private final String logId;
    private final boolean isObsidian;

    public FMWorkBenchBlock(int id, Material material, float speedModifier, Material checkAgainst, String logId, boolean isObsidian) {
        super(id, material, speedModifier, checkAgainst);
        this.logId = logId;
        this.isObsidian = isObsidian;
    }

    @Override
    public Icon getIcon(int side, int metadata)
    {
        if (side == 0)
        {
            return Block.planks.getBlockTextureFromSide(side);
        }
        if (side == 1)
        {
            return this.workbench_icon_top;
        }
        if (side == 2 || side == 3)
        {
            return this.my_front_icon;
        }

        return this.my_side_icon;
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        if (logId != null)
        {
            this.workbench_icon_top = par1IconRegister.registerIcon(isObsidian ? "crafting_table/obsidian/top" : "crafting_table/flint/top");
            this.my_front_icon = par1IconRegister.registerIcon("futuremite:log/" + logId + "_side");
            this.my_side_icon  = par1IconRegister.registerIcon("futuremite:log/" + logId + "_side");
        }
    }
}