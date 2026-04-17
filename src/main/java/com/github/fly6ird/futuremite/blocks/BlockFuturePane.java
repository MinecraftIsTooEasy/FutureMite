package com.github.fly6ird.futuremite.blocks;

import net.minecraft.AxisAlignedBB;
import net.minecraft.BlockPane;
import net.minecraft.Entity;
import net.minecraft.World;
import net.minecraft.Material;

public class BlockFuturePane extends BlockPane {
    public BlockFuturePane(int id, String faceTexture, String edgeTexture, Material material, boolean canDropItself) {
        super(id, faceTexture, edgeTexture, material, canDropItself);
    }

    @Override
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public boolean isSolid(boolean[] is_solid, int metadata) {
        return false;
    }

    @Override
    public Object getCollisionBounds(World world, int x, int y, int z, Entity entity) {
        AxisAlignedBB[] bb = new AxisAlignedBB[3];
        int index = 0;
        boolean north = this.canThisPaneConnectToThisBlockID(world.getBlockId(x, y, z - 1));
        boolean south = this.canThisPaneConnectToThisBlockID(world.getBlockId(x, y, z + 1));
        boolean west = this.canThisPaneConnectToThisBlockID(world.getBlockId(x - 1, y, z));
        boolean east = this.canThisPaneConnectToThisBlockID(world.getBlockId(x + 1, y, z));
        if ((!west || !east) && (west || east || north || south)) {
            if (west && !east) {
                bb[index++] = AxisAlignedBB.getBoundingBoxFromPool(0.0, 0.0, 0.4375, 0.5, 1.0, 0.5625);
            } else if (!west && east) {
                bb[index++] = AxisAlignedBB.getBoundingBoxFromPool(0.5, 0.0, 0.4375, 1.0, 1.0, 0.5625);
            }
        } else {
            bb[index++] = AxisAlignedBB.getBoundingBoxFromPool(0.0, 0.0, 0.4375, 1.0, 1.0, 0.5625);
        }
        if ((!north || !south) && (west || east || north || south)) {
            if (north && !south) {
                bb[index++] = AxisAlignedBB.getBoundingBoxFromPool(0.4375, 0.0, 0.0, 0.5625, 1.0, 0.5);
            } else if (!north && south) {
                bb[index++] = AxisAlignedBB.getBoundingBoxFromPool(0.4375, 0.0, 0.5, 0.5625, 1.0, 1.0);
            }
        } else {
            bb[index++] = AxisAlignedBB.getBoundingBoxFromPool(0.4375, 0.0, 0.0, 0.5625, 1.0, 1.0);
        }
        return bb;
    }
}
