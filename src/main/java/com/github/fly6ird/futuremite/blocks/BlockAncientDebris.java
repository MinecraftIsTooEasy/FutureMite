package com.github.fly6ird.futuremite.blocks;

import com.github.fly6ird.futuremite.material.Materials;
import net.minecraft.Block;
import net.minecraft.BlockOre;
import net.minecraft.Icon;
import net.minecraft.IconRegister;

public class BlockAncientDebris extends BlockOre {
    private Icon sideIcon;
    private Icon topIcon;

    public BlockAncientDebris(int blockId) {
        super(blockId, Materials.netherite, 4);
        this.setHardness(6.0F);
        this.setResistance(3.0F);
        this.setStepSound(Block.soundStoneFootstep);
        this.setUnlocalizedName("netherite_ore");
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return switch (side) {
            case 1 -> this.topIcon;
            case 0, 2, 3, 4, 5 -> this.sideIcon;
            default -> super.getIcon(side, metadata);
        };
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.sideIcon = iconRegister.registerIcon("futuremite:ancient_debris_side");
        this.topIcon = iconRegister.registerIcon("futuremite:ancient_debris_top");
    }
}
