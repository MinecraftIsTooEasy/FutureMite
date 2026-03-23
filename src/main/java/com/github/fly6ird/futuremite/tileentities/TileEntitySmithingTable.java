package com.github.fly6ird.futuremite.tileentities;

import com.github.fly6ird.futuremite.blocks.BlockSmithingTable;
import com.github.fly6ird.futuremite.recipe.SmithingRecipe;
import com.github.fly6ird.futuremite.recipe.SmithingRecipeManager;
import net.minecraft.EntityPlayer;
import net.minecraft.IInventory;
import net.minecraft.ItemStack;
import net.minecraft.NBTTagCompound;
import net.minecraft.NBTTagList;
import net.minecraft.TileEntity;

import java.util.Arrays;

public class TileEntitySmithingTable extends TileEntity implements IInventory {
    public final ItemStack[] contents = new ItemStack[4];
    public int build_time;
    public SmithingRecipe current_recipe;

    public int getBuildProgressScaled(int scaled) {
        return this.contents[3] == null ? 0 : scaled;
    }

    @Override
    public void updateEntity() {
    }

    public void consumeResult() {
        SmithingRecipe recipe = SmithingRecipeManager.instance.findRecipe(this.contents);
        if (recipe == null) {
            this.refreshOutput();
            return;
        }

        recipe.consume(this.contents);
        this.refreshOutput();
        this.onInventoryChanged();
    }

    private void clearBuildTime() {
        this.build_time = 0;
    }

    private void refreshOutput() {
        this.current_recipe = SmithingRecipeManager.instance.findRecipe(this.contents);
        this.contents[3] = this.current_recipe == null ? null : this.current_recipe.createOutput(this.contents);
        this.clearBuildTime();
    }

    @Override
    public int getSizeInventory() {
        return this.contents.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return this.contents[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if (this.contents[i] == null) {
            return null;
        }

        ItemStack itemStack;
        if (this.contents[i].stackSize <= j) {
            itemStack = this.contents[i];
            this.contents[i] = null;
        } else {
            itemStack = this.contents[i].splitStack(j);
            if (this.contents[i].stackSize <= 0) {
                this.contents[i] = null;
            }
        }

        if (i < 3) {
            this.refreshOutput();
        }
        this.onInventoryChanged();
        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if (this.contents[i] == null) {
            return null;
        }

        ItemStack stack = this.contents[i];
        this.contents[i] = null;
        return stack;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {
        this.contents[i] = itemStack;
        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }

        if (i < 3) {
            this.refreshOutput();
        }
        this.onInventoryChanged();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return entityPlayer.getWorld().getBlock(this.xCoord, this.yCoord, this.zCoord) instanceof BlockSmithingTable
                && entityPlayer.getWorld().getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) instanceof TileEntitySmithingTable
                && entityPlayer.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        NBTTagList tagList = nbtTagCompound.getTagList("Items");
        Arrays.fill(this.contents, null);

        for (int i = 0; i < tagList.tagCount(); ++i) {
            NBTTagCompound tagAt = (NBTTagCompound) tagList.tagAt(i);
            int slot = tagAt.getByte("Slot");
            if (slot >= 0 && slot < 3) {
                this.contents[slot] = ItemStack.loadItemStackFromNBT(tagAt);
            }
        }

        this.refreshOutput();
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
        NBTTagList nbtTagList = new NBTTagList();

        for (int i = 0; i < 3; ++i) {
            if (this.contents[i] != null) {
                NBTTagCompound slotTag = new NBTTagCompound();
                slotTag.setByte("Slot", (byte) i);
                this.contents[i].writeToNBT(slotTag);
                nbtTagList.appendTag(slotTag);
            }
        }
        nbtTagCompound.setTag("Items", nbtTagList);
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return i < 3 && SmithingRecipeManager.instance.isItemValidForSlot(i, itemStack);
    }

    @Override
    public void destroyInventory() {
        Arrays.fill(this.contents, null);
        this.current_recipe = null;
        this.clearBuildTime();
    }
}
