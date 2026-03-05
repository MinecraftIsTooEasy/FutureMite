package com.github.fly6ird.futuremite.blocks;

import com.github.fly6ird.futuremite.creativetab.FutureMITECreativeTabs;
import net.minecraft.*;

public class BlockStrippedLog extends BlockRotatedPillar {
    private Icon stripped_side;
    private Icon stripped_top;
    private final String id;

    protected BlockStrippedLog(int par1, String id) {
        super(par1, Material.wood);
        this.id = id;
        modifyMinHarvestLevel(1);
        setHardness(0.9F);
        setMaxStackSize(4);
        setStepSound(Blocks.stepSoundWood);
        this.setCreativeTab(FutureMITECreativeTabs.tabBlock);
        this.setTextureName("stripped_" + id);
        this.setUnlocalizedName("log.stripped_" + id + "_log");
    }

    @Override
    protected Icon getSideIcon(int par1) {
        return this.stripped_side;
    }

    @Override
    protected Icon getEndIcon(int par1) {
        return this.stripped_top;
    }

    @Override
    public String getMetadataNotes() {
        return "Bits 1 and 2 used for subtype, bit 4 set if aligned WE, and bit 8 set if aligned NS";
    }

    @Override
    public boolean isValidMetadata(int metadata) {
        return (metadata >= 0 && metadata < 16 && !BitHelper.isBitSet(metadata, 12));
    }

    @Override
    public int getBlockSubtypeUnchecked(int metadata) {
        return 0;
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.stripped_side = par1IconRegister.registerIcon("futuremite:log/stripped_" + id + "_side");
        this.stripped_top = par1IconRegister.registerIcon("futuremite:log/stripped_" + id + "_top");
    }

    @Override
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        if (info.wasExploded())
            return dropBlockAsEntityItem(info, Item.stick.itemID, 0, 1, 1.5F);
        return super.dropBlockAsEntityItem(info);
    }

    @Override
    public String getNameDisambiguationForReferenceFile(int metadata) {
        return "stripped_log";
    }
}