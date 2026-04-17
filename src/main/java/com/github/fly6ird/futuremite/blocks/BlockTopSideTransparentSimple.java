package com.github.fly6ird.futuremite.blocks;

import net.minecraft.Block;
import net.minecraft.BlockConstants;
import net.minecraft.Icon;
import net.minecraft.IconRegister;
import net.minecraft.Material;

public class BlockTopSideTransparentSimple extends Block {
    private final String textureBase;
    private Icon sideIcon;
    private Icon topIcon;

    public BlockTopSideTransparentSimple(int id, Material material, String textureBase) {
        super(id, material, new BlockConstants().setNeverHidesAdjacentFaces());
        this.textureBase = textureBase;
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return side == 0 || side == 1 ? this.topIcon : this.sideIcon;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.sideIcon = iconRegister.registerIcon("futuremite:" + this.textureBase + "_side");
        this.topIcon = iconRegister.registerIcon("futuremite:" + this.textureBase + "_top");
    }
}
