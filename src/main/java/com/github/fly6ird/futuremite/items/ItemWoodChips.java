package com.github.fly6ird.futuremite.items;

import com.github.fly6ird.futuremite.creativetab.FutureMITECreativeTabs;

import huix.glacier.api.extension.item.IFuelItem;

import net.minecraft.Item;
import net.minecraft.Material;

public class ItemWoodChips extends Item implements IFuelItem {
    protected ItemWoodChips(int id, Material material, String texture) {
        super(id, material, texture);
        this.setCreativeTab(FutureMITECreativeTabs.tabItem);
    }

    @Override
    public int getHeatLevel() {
        return 1;
    }

    @Override
    public int getBurnTime() {
        return 50;
    }
}
