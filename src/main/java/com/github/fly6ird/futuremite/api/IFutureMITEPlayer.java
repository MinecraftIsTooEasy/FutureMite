package com.github.fly6ird.futuremite.api;


import com.github.fly6ird.futuremite.gui.grindstone.GrindStoneSlots;
import com.github.fly6ird.futuremite.tileentities.TileEntitySmithingTable;

public interface IFutureMITEPlayer {
    void futureMITE$displayGUIGrindstone(int paramInt1, int paramInt2, int paramInt3, GrindStoneSlots paramBarrelSlots);

    void futureMITE$displayGUISmithing(TileEntitySmithingTable tileEntity);
}
