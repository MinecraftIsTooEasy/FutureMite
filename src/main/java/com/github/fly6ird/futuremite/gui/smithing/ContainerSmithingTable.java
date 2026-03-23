package com.github.fly6ird.futuremite.gui.smithing;

import com.github.fly6ird.futuremite.recipe.SmithingRecipeManager;
import com.github.fly6ird.futuremite.tileentities.TileEntitySmithingTable;
import net.minecraft.Container;
import net.minecraft.EntityPlayer;
import net.minecraft.ICrafting;
import net.minecraft.IInventory;
import net.minecraft.ItemStack;
import net.minecraft.Slot;

import java.util.ArrayList;
import java.util.List;

public class ContainerSmithingTable extends Container {
    private static final int INPUT_SLOT_COUNT = 3;
    private static final int RESULT_SLOT_INDEX = 3;
    private static final int TILE_SLOT_COUNT = 4;

    private final TileEntitySmithingTable tileEntity;
    private int lastBuildTime = -1;

    public ContainerSmithingTable(EntityPlayer player, TileEntitySmithingTable tileEntity) {
        super(player);
        this.tileEntity = tileEntity;
        this.tileEntity.openChest();
        this.createSlots(player.inventory);
    }

    private void createSlots(IInventory playerInventory) {
        this.addSlotToContainer(new Slot(this.tileEntity, 0, 8, 48) {
            @Override
            public boolean isItemValid(ItemStack itemStack) {
                return ContainerSmithingTable.this.tileEntity.isItemValidForSlot(0, itemStack);
            }
        });
        this.addSlotToContainer(new Slot(this.tileEntity, 1, 26, 48) {
            @Override
            public boolean isItemValid(ItemStack itemStack) {
                return ContainerSmithingTable.this.tileEntity.isItemValidForSlot(1, itemStack);
            }
        });
        this.addSlotToContainer(new Slot(this.tileEntity, 2, 44, 48) {
            @Override
            public boolean isItemValid(ItemStack itemStack) {
                return ContainerSmithingTable.this.tileEntity.isItemValidForSlot(2, itemStack);
            }
        });
        this.addSlotToContainer(new Slot(this.tileEntity, RESULT_SLOT_INDEX, 98, 48) {
            @Override
            public boolean isItemValid(ItemStack itemStack) {
                return false;
            }

            @Override
            public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
                ContainerSmithingTable.this.tileEntity.consumeResult();
                super.onPickupFromSlot(entityPlayer, itemStack);
            }
        });

        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlotToContainer(new Slot(playerInventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }

        for (int hotbar = 0; hotbar < 9; ++hotbar) {
            this.addSlotToContainer(new Slot(playerInventory, hotbar, 8 + hotbar * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.tileEntity.isUseableByPlayer(entityPlayer);
    }

    @Override
    public void addCraftingToCrafters(ICrafting crafter) {
        super.addCraftingToCrafters(crafter);
        crafter.sendProgressBarUpdate(this, 0, this.tileEntity.build_time);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (Object crafterObj : this.crafters) {
            ICrafting crafter = (ICrafting) crafterObj;
            if (this.lastBuildTime != this.tileEntity.build_time) {
                crafter.sendProgressBarUpdate(this, 0, this.tileEntity.build_time);
            }
        }

        this.lastBuildTime = this.tileEntity.build_time;
    }

    @Override
    public void updateProgressBar(int id, int value) {
        if (id == 0) {
            this.tileEntity.build_time = value;
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {
        Slot slot = (Slot) this.inventorySlots.get(slotIndex);
        if (slot == null || !slot.getHasStack()) {
            return null;
        }

        ItemStack slotStack = slot.getStack();
        ItemStack originalStack = slotStack.copy();

        if (slotIndex == RESULT_SLOT_INDEX) {
            ItemStack resultToMove = slotStack.copy();
            if (!this.mergeItemStack(resultToMove, TILE_SLOT_COUNT, this.inventorySlots.size(), true)) {
                return null;
            }
            slot.onPickupFromSlot(entityPlayer, resultToMove);
            return originalStack;
        } else if (slotIndex < TILE_SLOT_COUNT) {
            if (!this.mergeItemStack(slotStack, TILE_SLOT_COUNT, this.inventorySlots.size(), false)) {
                return null;
            }
        } else if (!this.moveToInputSlot(slotStack)) {
            return null;
        }

        if (slotStack.stackSize <= 0) {
            slot.putStack(null);
        } else {
            slot.onSlotChanged();
        }

        if (slotStack.stackSize == originalStack.stackSize) {
            return null;
        }

        return originalStack;
    }

    public List<ItemStack> getInventory() {
        List<ItemStack> list = new ArrayList<>();
        for (Object slotObject : this.inventorySlots) {
            list.add(((Slot) slotObject).getStack());
        }
        return list;
    }

    private boolean moveToInputSlot(ItemStack itemStack) {
        for (int slotIndex = 0; slotIndex < INPUT_SLOT_COUNT; ++slotIndex) {
            if (SmithingRecipeManager.instance.isItemValidForSlot(slotIndex, itemStack)
                    && this.mergeItemStack(itemStack, slotIndex, slotIndex + 1, false)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        this.tileEntity.closeChest();
    }
}
