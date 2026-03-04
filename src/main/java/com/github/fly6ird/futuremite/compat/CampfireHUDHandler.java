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

    /** 与 joinCookQueue 里初始值保持一致 */
    private static final int COOK_TIME_TOTAL = 400;

    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return currenttip;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        Block block = accessor.getBlock();

        if (!(block instanceof BlockCampfire)) return currenttip;

        NBTTagCompound tag = accessor.getNBTData();

        if (tag == null) return currenttip;

        int burnTime = tag.getInteger("BurnTime");
        int totalSec = Math.max(0, (int) Math.round(burnTime / 20.0));
        int min = totalSec / 60;
        int sec = totalSec % 60;

        String timeStr = min + ":" + (sec < 10 ? "0" + sec : String.valueOf(sec));
        currenttip.add(EnumChatFormatting.RESET + StatCollector.translateToLocal("campfire.burntime") + ": " + timeStr);

        boolean hasFood = false;

        for (int i = 0; i < 4; i++)
        {
            String key = "FoodItem" + i;
            if (!tag.hasKey(key)) continue;
            hasFood = true;

            String  itemName = tag.getString("FoodItem" + i);
            int     foodTime = tag.getInteger("FoodTime" + i);
            boolean cooked   = tag.getBoolean("FoodCooked" + i);

            if (cooked)
            {
                currenttip.add(EnumChatFormatting.GREEN + itemName + " \u2713 " + StatCollector.translateToLocal("campfire.food.cooked"));
            }
            else
            {
                int remainSec = (int) Math.ceil(foodTime / 20.0);
                int pct = (int) Math.round((1.0 - (double) foodTime / COOK_TIME_TOTAL) * 100);

                pct = Math.max(0, Math.min(100, pct));
                // 颜色随进度变化：0-49% 黄，50-79% 金，80-99% 绿
                EnumChatFormatting barColor;
                if (pct >= 80)      barColor = EnumChatFormatting.GREEN;
                else if (pct >= 50) barColor = EnumChatFormatting.GOLD;
                else                barColor = EnumChatFormatting.YELLOW;
                currenttip.add(EnumChatFormatting.WHITE + itemName + "  " + barColor + pct + "%" + EnumChatFormatting.GRAY + " (" + remainSec + "s)");
            }
        }

        if (!hasFood && ((BlockCampfire) block).getIsActive())
        {
            currenttip.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("campfire.food.empty"));
        }

        return currenttip;
    }


    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }

    @Override
    public NBTTagCompound getNBTData(ServerPlayer player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z) {
        if (!(te instanceof TileEntityCampfire)) return tag;
        TileEntityCampfire campfire = (TileEntityCampfire) te;

        tag.setInteger("BurnTime", campfire.getBurnTime());

        ItemStack[] stacks   = campfire.getBurnItemStacks();
        int[]       foodTime = campfire.getBurnFoodTime();

        for (int i = 0; i < stacks.length; i++) {
            if (stacks[i] == null) continue;
            tag.setString ("FoodItem"   + i, stacks[i].getDisplayName());
            tag.setInteger("FoodTime"   + i, foodTime[i]);
            tag.setBoolean("FoodCooked" + i, campfire.isCookedItemStack(stacks[i]));
        }
        return tag;
    }

    public static void register() {
        callbackRegister(ModuleRegistrar.instance());
    }

    public static void callbackRegister(IWailaRegistrar registrar) {
        IWailaDataProvider instance = new CampfireHUDHandler();
        registrar.registerBodyProvider(instance, BlockCampfire.class);
        registrar.registerNBTProvider (instance, BlockCampfire.class);
    }
}
