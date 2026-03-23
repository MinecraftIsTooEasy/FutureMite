package com.github.fly6ird.futuremite.blocks;

import moddedmite.rustedironcore.api.util.FabricUtil;
import net.minecraft.Block;
import net.minecraft.BlockBreakInfo;
import net.minecraft.BlockConstants;
import net.minecraft.BlockHardness;
import net.minecraft.ItemIngot;
import net.minecraft.ItemRock;
import net.minecraft.Material;

public class BlockOreBlockExtend extends Block {

    public BlockOreBlockExtend(int blockId, Material material) {
        super(blockId, material, new BlockConstants());
        this.modifyMinHarvestLevel(1);
        if (FabricUtil.isModLoaded("vanilla_stack")) {
            this.setMaxStackSize(64);
        } else {
            this.setMaxStackSize(4);
        }
        this.setHardnessRelativeToWood(BlockHardness.log);
    }

    @Override
    public float getCraftingDifficultyAsComponent(int metadata) {
        return this.blockMaterial.isMetal()
                ? (ItemIngot.getCraftingDifficultyAsComponent(this.blockMaterial) * 9.0F)
                : (ItemRock.getCraftingDifficultyAsComponent(this.blockMaterial) * ((this.blockMaterial == Material.quartz) ? 4 : 9));
    }

    @Override
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        return super.dropBlockAsEntityItem(info);
    }
}
