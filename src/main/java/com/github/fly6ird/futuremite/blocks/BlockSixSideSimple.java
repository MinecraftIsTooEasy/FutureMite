package com.github.fly6ird.futuremite.blocks;

import net.minecraft.Icon;
import net.minecraft.IconRegister;
import net.minecraft.Material;

public class BlockSixSideSimple extends BlockSimple {
    private final String textureDown;
    private final String textureUp;
    private final String textureNorth;
    private final String textureSouth;
    private final String textureWest;
    private final String textureEast;
    private Icon iconDown;
    private Icon iconUp;
    private Icon iconNorth;
    private Icon iconSouth;
    private Icon iconWest;
    private Icon iconEast;

    public BlockSixSideSimple(int id, Material material, String textureDown, String textureUp, String textureNorth, String textureSouth, String textureWest, String textureEast) {
        super(id, material);
        this.textureDown = textureDown;
        this.textureUp = textureUp;
        this.textureNorth = textureNorth;
        this.textureSouth = textureSouth;
        this.textureWest = textureWest;
        this.textureEast = textureEast;
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        if (side == 0) {
            return this.iconDown;
        }
        if (side == 1) {
            return this.iconUp;
        }
        if (side == 2) {
            return this.iconNorth;
        }
        if (side == 3) {
            return this.iconSouth;
        }
        if (side == 4) {
            return this.iconWest;
        }
        return this.iconEast;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.iconDown = iconRegister.registerIcon("futuremite:" + this.textureDown);
        this.iconUp = iconRegister.registerIcon("futuremite:" + this.textureUp);
        this.iconNorth = iconRegister.registerIcon("futuremite:" + this.textureNorth);
        this.iconSouth = iconRegister.registerIcon("futuremite:" + this.textureSouth);
        this.iconWest = iconRegister.registerIcon("futuremite:" + this.textureWest);
        this.iconEast = iconRegister.registerIcon("futuremite:" + this.textureEast);
    }
}
