package com.github.fly6ird.futuremite.creativetab;

import com.github.fly6ird.futuremite.blocks.Blocks;
import com.github.fly6ird.futuremite.items.Items;

import huix.glacier.api.extension.creativetab.GlacierCreativeTabs;
import net.minecraft.CreativeTabs;

public class FutureMITECreativeTabs {

    public static FutureMITECreativeItemTab tabItem = new FutureMITECreativeItemTab();
    public static FutureMITECreativeBuildingTab tabBuildingBlocks = new FutureMITECreativeBuildingTab();
    public static FutureMITECreativeNaturalTab tabNaturalBlocks = new FutureMITECreativeNaturalTab();
    public static FutureMITECreativeFunctionalTab tabFunctionalBlocks = new FutureMITECreativeFunctionalTab();
    public static FutureMITECreativeRedstoneTab tabRedstoneBlocks = new FutureMITECreativeRedstoneTab();

    // Compatibility alias for existing registrations.
    public static CreativeTabs tabBlock = tabBuildingBlocks;

    public static class FutureMITECreativeItemTab extends GlacierCreativeTabs {
        public FutureMITECreativeItemTab() {
            super("FutureMITE_Item");
        }

        @Override
        public int getTabIconItemIndex() {
            return Items.prismarineCrystals.itemID;
        }
    }

    public static class FutureMITECreativeBuildingTab extends GlacierCreativeTabs {
        public FutureMITECreativeBuildingTab() {
            super("FutureMITE_Building_Blocks");
        }

        @Override
        public int getTabIconItemIndex() {
            return Blocks.netheriteBlock.blockID;
        }
    }

    public static class FutureMITECreativeNaturalTab extends GlacierCreativeTabs {
        public FutureMITECreativeNaturalTab() {
            super("FutureMITE_Natural_Blocks");
        }

        @Override
        public int getTabIconItemIndex() {
            return Blocks.sweetBerryBush.blockID;
        }
    }

    public static class FutureMITECreativeFunctionalTab extends GlacierCreativeTabs {
        public FutureMITECreativeFunctionalTab() {
            super("FutureMITE_Functional_Blocks");
        }

        @Override
        public int getTabIconItemIndex() {
            return Blocks.smithingTable.blockID;
        }
    }

    public static class FutureMITECreativeRedstoneTab extends GlacierCreativeTabs {
        public FutureMITECreativeRedstoneTab() {
            super("FutureMITE_Redstone_Blocks");
        }

        @Override
        public int getTabIconItemIndex() {
            return Blocks.soulTorch.blockID;
        }
    }
}
