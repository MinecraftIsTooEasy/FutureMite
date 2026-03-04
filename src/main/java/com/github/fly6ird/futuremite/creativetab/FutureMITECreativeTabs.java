package com.github.fly6ird.futuremite.creativetab;

import com.github.fly6ird.futuremite.blocks.Blocks;
import com.github.fly6ird.futuremite.items.Items;

import huix.glacier.api.extension.creativetab.GlacierCreativeTabs;

public class FutureMITECreativeTabs {

    public static FutureMITECreativeItemTab tabItem = new FutureMITECreativeItemTab();
    public static FutureMITECreativeBlockTab tabBlock = new FutureMITECreativeBlockTab();

    public static class FutureMITECreativeItemTab extends GlacierCreativeTabs {
        public FutureMITECreativeItemTab() {
            super("FutureMITE_Item");
        }

        @Override
        public int getTabIconItemIndex() {
            return Items.prismarineCrystals.itemID;
        }
    }

    public static class FutureMITECreativeBlockTab extends GlacierCreativeTabs {
        public FutureMITECreativeBlockTab() {
            super("FutureMITE_Block");
        }

        @Override
        public int getTabIconItemIndex() {
            return Blocks.campfire.blockID;
        }
    }
}