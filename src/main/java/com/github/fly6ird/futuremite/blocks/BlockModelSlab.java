package com.github.fly6ird.futuremite.blocks;

import com.github.fly6ird.futuremite.creativetab.FutureMITECreativeTabs;
import net.minecraft.Block;
import net.minecraft.BlockSlab;
import net.minecraft.Icon;
import net.minecraft.Material;

public class BlockModelSlab extends BlockSlab {
    protected final Block modelBlock;
    protected final int modelBlockMetadata;
    protected final String name;

    public BlockModelSlab(int id, Material material, Block block, int metadata, String name) {
        super(id, material);
        this.setUnlocalizedName("slab");
        this.modelBlock = block;
        this.modelBlockMetadata = metadata;
        this.name = name;
        this.setCreativeTab(FutureMITECreativeTabs.tabBuildingBlocks);
    }

    @Override
    public int getGroup() {
        return 2;
    }

    @Override
    public String[] getTypes() {
        return new String[]{"slab"};
    }

    @Override
    public boolean isValidMetadata(int metadata) {
        return metadata == 0 || metadata == 8;
    }

    @Override
    public int getBlockSubtypeUnchecked(int metadata) {
        return 0;
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return this.modelBlock.getIcon(side, this.modelBlockMetadata);
    }

    @Override
    public Block getModelBlock(int metadata) {
        return this.modelBlock;
    }

    @Override
    public float getBlockHardness(int metadata) {
        return this.modelBlock.getBlockHardness(this.modelBlockMetadata);
    }
}
