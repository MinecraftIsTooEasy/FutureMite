package com.github.fly6ird.futuremite.blocks;

import net.minecraft.BlockButton;
import net.minecraft.Icon;
import net.minecraft.IconRegister;
import net.minecraft.ItemBlock;
import net.minecraft.Material;

public class BlockModButton extends BlockButton {
    private final boolean wooden;

    public BlockModButton(int id, boolean wooden) {
        super(id, wooden);
        this.wooden = wooden;
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return this.blockIcon;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(this.getTextureName());
    }

    @Override
    public void addItemBlockMaterials(ItemBlock item_block) {
        item_block.addMaterial(this.wooden ? Material.wood : Material.stone);
    }
}
