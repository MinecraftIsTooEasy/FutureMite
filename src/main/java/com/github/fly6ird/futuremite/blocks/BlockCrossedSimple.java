package com.github.fly6ird.futuremite.blocks;

import net.minecraft.Block;
import net.minecraft.BlockConstants;
import net.minecraft.Material;

public class BlockCrossedSimple extends Block {
    public BlockCrossedSimple(int id, Material material) {
        super(id, material, new BlockConstants().setNotAlwaysLegal().setNeverHidesAdjacentFaces());
    }

    @Override
    public int getRenderType() {
        return 1;
    }

    @Override
    public boolean isSolid(boolean[] is_solid, int metadata) {
        return false;
    }

    @Override
    public boolean isStandardFormCube(boolean[] is_standard_form_cube, int metadata) {
        return false;
    }
}
