package com.github.fly6ird.futuremite.compat;

import com.github.fly6ird.futuremite.blocks.*;

import net.minecraft.Block;
import net.minecraft.EntityPlayer;

import tschipp.carryon.api.CarryOnPlugin;

public class FutureMITECarryOnPlugin implements CarryOnPlugin {

    @Override
    public boolean canCarryBlock(EntityPlayer player, Block block, int meta)
    {
        if (block instanceof BlockLantern)    return true;

        return false;
    }
}