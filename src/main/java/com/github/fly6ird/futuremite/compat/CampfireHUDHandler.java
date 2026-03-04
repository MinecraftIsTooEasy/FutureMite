package com.github.fly6ird.futuremite.compat;


import com.github.fly6ird.futuremite.blocks.BlockCampfire;
import com.github.fly6ird.futuremite.tileentities.TileEntityCampfire;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import mcp.mobius.waila.api.impl.ModuleRegistrar;
import net.minecraft.*;

import java.util.List;

public class CampfireHUDHandler implements IWailaDataProvider {

    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        Block block = accessor.getBlock();
        if (block instanceof BlockCampfire) {
            TileEntity tileEntity = accessor.getTileEntity();
            if (tileEntity instanceof TileEntityCampfire) {
                int burntime = ((TileEntityCampfire) tileEntity).getBurnTime();

                int totalSeconds = Math.max(0, (int) Math.round(burntime / 20.0));
                int minutes = totalSeconds / 60;
                int seconds = totalSeconds % 60;
                String timeStr = minutes + ":" + (seconds < 10 ? "0" + seconds : String.valueOf(seconds));

                currenttip.add(EnumChatFormatting.RESET + StatCollector.translateToLocal("campfire.burntime") + ": " + timeStr);
            }
        }
        return currenttip;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }

    @Override
    public NBTTagCompound getNBTData(ServerPlayer player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z) {
        return null;
    }

    public static void register() {
        callbackRegister(ModuleRegistrar.instance());
    }

    public static void callbackRegister(IWailaRegistrar registrar) {
        IWailaDataProvider instance = new CampfireHUDHandler();
        registrar.registerBodyProvider(instance, BlockCampfire.class);
        //registrar.registerBodyProvider(instance, BlockExtinguishedCampfire.class);
    }
}
