package com.github.fly6ird.futuremite.blocks;

import net.minecraft.Block;
import net.minecraft.BlockConstants;
import net.minecraft.Material;

public class BlockTransparentSimple extends Block {
    public BlockTransparentSimple(int id, Material material) {
        super(id, material, new BlockConstants().setNeverHidesAdjacentFaces());
    }
}
