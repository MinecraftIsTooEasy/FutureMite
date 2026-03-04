package com.github.fly6ird.futuremite.tileentities;

import com.github.fly6ird.futuremite.blocks.BlockCampfire;
import net.minecraft.*;

import java.util.Random;

import static com.github.fly6ird.futuremite.blocks.BlockCampfire.updateCampfireBlockState;

public class TileEntityCampfire extends TileEntity {

    // 每 tick -1，6000 tick = 5分钟（默认值），12000 tick = 10分钟（上限）
    public static final int DEFAULT_BURN_TIME = 6000;
    public static final int MAX_BURN_TIME     = 12000;

    private ItemStack[] burnItemStacks = new ItemStack[4];
    private int[]       burnFoodTime   = new int[4];
    private int         burnTime       = DEFAULT_BURN_TIME;

    protected static final Random RAND = new Random();

    public TileEntityCampfire() {}

    public TileEntityCampfire(Block block) {
        this.setBlock(block);
    }

    @Override
    public void updateEntity()
    {
        Block currentBlock = this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord);

        if (!(currentBlock instanceof BlockCampfire)) return;

        boolean isActive = ((BlockCampfire) currentBlock).getIsActive();

        if (!isActive) return;

        if (this.burnTime > 0)
        {
            --this.burnTime;

            for (int i = 0; i < burnItemStacks.length; i++)
            {
                if (burnItemStacks[i] == null) continue;

                if (burnFoodTime[i] > 0)
                {
                    --burnFoodTime[i];
                }
                else if (!isCookedItemStack(burnItemStacks[i]))
                {
                    burnItemStacks[i] = getCookFood(burnItemStacks[i]);
                    burnFoodTime[i] = 60; // 熟了显示 3s
                }
                else
                {
                    popItem(burnItemStacks[i], this.worldObj, this.xCoord, this.yCoord, this.zCoord);
                    burnItemStacks[i] = null;
                }
            }
        }
        else
        {
            // 燃料耗尽，自动熄灭
            if (!this.worldObj.isRemote) {
                updateCampfireBlockState(false, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }
    }

    /**
     * 添加燃烧时长。成功返回 true，已满上限返回 false。
     */
    public boolean addBurnTime(int tick)
    {
        if (burnTime >= MAX_BURN_TIME) return false;

        this.burnTime = Math.min(burnTime + tick, MAX_BURN_TIME);

        if (this.worldObj != null && !this.worldObj.isRemote)
        {
            this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
        }

        return true;
    }

    public int getBurnTime() {
        return this.burnTime;
    }

    public int getMaxBurnTime() {
        return MAX_BURN_TIME;
    }

    // 烹饪队列
    public boolean joinCookQueue(ItemStack itemStack)
    {
        for (int i = 0; i < this.burnItemStacks.length; i++)
        {
            if (burnItemStacks[i] == null)
            {
                burnItemStacks[i] = itemStack;
                burnFoodTime[i]   = 400; // 烧 20s
                return true;
            }
        }

        return false;
    }

    public ItemStack[] getBurnItemStacks() {
        return burnItemStacks;
    }

    public int[] getBurnFoodTime() {
        return burnFoodTime;
    }

    public ItemStack getCookFood(ItemStack food)
    {
        if (food != null && food.getItem() instanceof ItemMeat && !((ItemMeat) food.getItem()).is_cooked)
        {
            ItemStack result = FurnaceRecipes.smelting().getSmeltingResult(food, 1);

            if (result != null) return new ItemStack(result.itemID, 1);
        }

        return null;
    }

    public boolean isCookedItemStack(ItemStack stack) {
        return stack != null && stack.getItem() instanceof ItemMeat && ((ItemMeat) stack.getItem()).is_cooked;
    }

    public void popItems()
    {
        for (int slot = 0; slot < 4; ++slot)
        {
            if (burnItemStacks[slot] != null)
            {
                popItem(burnItemStacks[slot], getWorldObj(), xCoord, yCoord, zCoord);
                burnItemStacks[slot] = null;
            }
        }
    }

    public static void popItem(ItemStack stack, World world, int x, int y, int z)
    {
        if (stack == null || stack.stackSize <= 0) return;

        EntityItem entityitem = new EntityItem(world,
                x + RAND.nextDouble() * 0.75 + 0.125,
                y + RAND.nextDouble() * 0.375 + 0.5,
                z + RAND.nextDouble() * 0.75 + 0.125, stack);
        entityitem.motionX = RAND.nextGaussian() * 0.05;
        entityitem.motionY = RAND.nextGaussian() * 0.05 + 0.2;
        entityitem.motionZ = RAND.nextGaussian() * 0.05;

        if (!world.isRemote) world.spawnEntityInWorld(entityitem);

        if (stack.getItem() instanceof ItemMeat && ((ItemMeat) stack.getItem()).is_cooked)
        {
            EntityXPOrb xpOrb = new EntityXPOrb(world,
                    x + RAND.nextDouble() * 0.75 + 0.125,
                    y + RAND.nextDouble() * 0.375 + 0.5,
                    z + RAND.nextDouble() * 0.75 + 0.125,
                    stack.getExperienceReward());
            xpOrb.motionX = RAND.nextGaussian() * 0.05;
            xpOrb.motionY = RAND.nextGaussian() * 0.05 + 0.2;
            xpOrb.motionZ = RAND.nextGaussian() * 0.05;

            if (!world.isRemote) world.spawnEntityInWorld(xpOrb);
        }
    }

    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 5, tag);
    }

    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);

        tag.setInteger("BurnTime", this.burnTime);
        NBTTagList list = new NBTTagList();
        for (int i = 0; i < this.burnItemStacks.length; ++i)
        {
            if (this.burnItemStacks[i] != null)
            {
                NBTTagCompound entry = new NBTTagCompound();
                entry.setByte("Index", (byte) i);
                this.burnItemStacks[i].writeToNBT(entry);
                entry.setInteger("BurnFoodTime", this.burnFoodTime[i]);
                list.appendTag(entry);
            }
        }

        tag.setTag("Contains", list);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);

        this.burnItemStacks = new ItemStack[4];
        this.burnFoodTime   = new int[4];
        NBTTagList list = tag.getTagList("Contains");

        for (int i = 0; i < list.tagCount(); ++i)
        {
            NBTTagCompound entry = (NBTTagCompound) list.tagAt(i);
            byte index = entry.getByte("Index");
            if (index >= 0 && index < this.burnItemStacks.length)
            {
                this.burnItemStacks[index] = ItemStack.loadItemStackFromNBT(entry);
                this.burnFoodTime[index]   = entry.getInteger("BurnFoodTime");
            }
        }
        if (tag.hasKey("BurnTime")) {
            this.burnTime = tag.getInteger("BurnTime");
        }
    }
}