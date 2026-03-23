package com.github.fly6ird.futuremite.gui.smithing;

import com.github.fly6ird.futuremite.tileentities.TileEntitySmithingTable;
import net.minecraft.EntityPlayer;
import net.minecraft.GuiContainer;
import net.minecraft.I18n;
import net.minecraft.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiSmithingTable extends GuiContainer {
    private static final ResourceLocation SMITHING_TABLE_GUI = new ResourceLocation("futuremite", "textures/gui/container/smithing_table.png");

    private final TileEntitySmithingTable tileEntity;

    public GuiSmithingTable(EntityPlayer player, TileEntitySmithingTable smithingTableTile) {
        super(new ContainerSmithingTable(player, smithingTableTile));
        this.tileEntity = smithingTableTile;
        this.xSize = 198;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(SMITHING_TABLE_GUI);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

        int progress = this.tileEntity.getBuildProgressScaled(22);
        this.drawTexturedModalRect(x + 68, y + 49, 176, 0, progress, 16);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String title = I18n.getString("smithing.update");
        this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 4210752);
        this.fontRenderer.drawString(I18n.getString("container.inventory"), 7, 73, 4210752);
    }
}
