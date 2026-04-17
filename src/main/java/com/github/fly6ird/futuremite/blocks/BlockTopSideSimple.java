package com.github.fly6ird.futuremite.blocks;

import net.minecraft.Icon;
import net.minecraft.IconRegister;
import net.minecraft.Material;

public class BlockTopSideSimple extends BlockSimple {
    private final String textureBase;
    private Icon sideIcon;
    private Icon topIcon;

    public BlockTopSideSimple(int id, Material material, String textureBase) {
        super(id, material);
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
