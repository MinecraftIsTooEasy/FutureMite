package com.github.fly6ird.futuremite.blocks;

import net.minecraft.BlockFenceGate;
import net.minecraft.Icon;
import net.minecraft.IconRegister;

public class BlockTextureFenceGate extends BlockFenceGate {
    public BlockTextureFenceGate(int id) {
        super(id);
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return this.blockIcon;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(this.getTextureName());
    }
}
