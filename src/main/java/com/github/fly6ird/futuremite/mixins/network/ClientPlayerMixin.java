package com.github.fly6ird.futuremite.mixins.network;


import com.github.fly6ird.futuremite.api.IFutureMITEPlayer;
import com.github.fly6ird.futuremite.gui.grindstone.GrindStoneSlots;
import com.github.fly6ird.futuremite.gui.grindstone.GuiGrindStone;
import net.minecraft.AbstractClientPlayer;
import net.minecraft.ClientPlayer;
import net.minecraft.Minecraft;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({ClientPlayer.class})
public abstract class ClientPlayerMixin extends AbstractClientPlayer implements IFutureMITEPlayer {
    @Shadow
    protected Minecraft mc;

    public ClientPlayerMixin(World par1World, String par2Str) {
        super(par1World, par2Str);
    }

    @Override
    public void futureMITE$displayGUIGrindstone(int x, int y, int z, GrindStoneSlots slots) {
        this.mc.displayGuiScreen(new GuiGrindStone(this, x, y, z, slots));
    }


}
