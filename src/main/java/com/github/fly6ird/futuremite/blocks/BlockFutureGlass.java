package com.github.fly6ird.futuremite.blocks;

import net.minecraft.BlockBreakable;
import net.minecraft.BlockConstants;
import net.minecraft.Material;

public class BlockFutureGlass extends BlockBreakable {
    public BlockFutureGlass(int id, String textureName) {
        super(id, textureName, Material.glass, false, new BlockConstants().setNeverHidesAdjacentFaces());
    }

    @Override
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public boolean isStandardFormCube(boolean[] is_standard_form_cube, int metadata) {
        return false;
    }
}
