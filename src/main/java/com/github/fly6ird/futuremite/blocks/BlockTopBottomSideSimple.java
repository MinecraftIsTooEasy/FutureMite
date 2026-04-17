package com.github.fly6ird.futuremite.blocks;

import net.minecraft.Icon;
import net.minecraft.IconRegister;
import net.minecraft.Material;

public class BlockTopBottomSideSimple extends BlockSimple {
    private final String textureBase;
    private Icon sideIcon;
    private Icon topIcon;
    private Icon bottomIcon;

    public BlockTopBottomSideSimple(int id, Material material, String textureBase) {
        super(id, material);
        this.textureBase = textureBase;
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        if (side == 1) {
            return this.topIcon;
        }
        if (side == 0) {
            return this.bottomIcon;
        }
        return this.sideIcon;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.sideIcon = iconRegister.registerIcon("futuremite:" + this.textureBase + "_side");
        this.topIcon = iconRegister.registerIcon("futuremite:" + this.textureBase + "_top");
        this.bottomIcon = iconRegister.registerIcon("futuremite:" + this.textureBase + "_bottom");
    }
}
