package com.github.fly6ird.futuremite.blocks;

import net.minecraft.IBlockAccess;
import net.minecraft.Material;

public class BlockBoundedSimple extends BlockSimple {
    private final float minX;
    private final float minY;
    private final float minZ;
    private final float maxX;
    private final float maxY;
    private final float maxZ;

    public BlockBoundedSimple(int id, Material material, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        super(id, material);
        this.minX = minX;
        this.minY = minY;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
        this.setBlockBoundsForCurrentThread(minX, minY, minZ, maxX, maxY, maxZ);
    }

    @Override
    public void setBlockBoundsBasedOnStateAndNeighbors(IBlockAccess block_access, int x, int y, int z) {
        this.setBlockBoundsForCurrentThread(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ);
    }

    @Override
    public void setBlockBoundsForItemRender(int item_damage) {
        this.setBlockBoundsForCurrentThread(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ);
    }

    @Override
    public boolean isStandardFormCube(boolean[] is_standard_form_cube, int metadata) {
        return false;
    }
}
