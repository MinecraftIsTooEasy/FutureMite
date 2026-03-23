package com.github.fly6ird.futuremite.recipe;

import net.minecraft.ItemStack;
import net.minecraft.NBTTagCompound;

import java.util.ArrayList;
import java.util.List;

public class SmithingRecipe {
    private final List<ItemStack> recipeInput;
    private final ItemStack recipeOutput;
    private final int inheritSlotIndex;

    public SmithingRecipe(List<ItemStack> recipeInput, ItemStack recipeOutput, int inheritSlotIndex) {
        this.recipeInput = new ArrayList<>();
        for (ItemStack stack : recipeInput) {
            this.recipeInput.add(stack.copy());
        }
        this.recipeOutput = recipeOutput.copy();
        this.inheritSlotIndex = inheritSlotIndex;
    }

    public boolean matchesInput(int inputIndex, ItemStack itemStack) {
        return inputIndex >= 0
                && inputIndex < this.recipeInput.size()
                && this.matches(this.recipeInput.get(inputIndex), itemStack);
    }

    public boolean matches(ItemStack[] inputSlots) {
        for (int i = 0; i < 3; ++i) {
            ItemStack current = inputSlots[i];
            if (i >= this.recipeInput.size()) {
                if (current != null) {
                    return false;
                }
                continue;
            }
            if (!this.matches(this.recipeInput.get(i), current)) {
                return false;
            }
        }
        return true;
    }

    public ItemStack createOutput(ItemStack[] inputSlots) {
        ItemStack output = this.recipeOutput.copy();
        if (this.inheritSlotIndex < 0 || this.inheritSlotIndex >= inputSlots.length) {
            return output;
        }

        ItemStack inherited = inputSlots[this.inheritSlotIndex];
        if (inherited == null) {
            return output;
        }

        if (inherited.isItemDamaged()) {
            output.setItemDamage(inherited.getItemDamage());
        }
        if (inherited.getItem().hasQuality()) {
            output.setQuality(inherited.getQuality());
        }
        if (inherited.hasTagCompound()) {
            output.setTagCompound((NBTTagCompound) inherited.getTagCompound().copy());
        }
        return output;
    }

    public void consume(ItemStack[] contents) {
        if (!this.matches(contents)) {
            return;
        }

        for (int i = 0; i < this.recipeInput.size(); ++i) {
            ItemStack current = contents[i];
            ItemStack required = this.recipeInput.get(i);
            current.stackSize -= required.stackSize;
            if (current.stackSize <= 0) {
                contents[i] = null;
            }
        }
    }

    private boolean matches(ItemStack required, ItemStack current) {
        if (required == null || current == null || required.itemID != current.itemID) {
            return false;
        }
        if (required.getHasSubtypes() && required.getItemSubtype() != current.getItemSubtype()) {
            return false;
        }
        return current.stackSize >= required.stackSize;
    }
}
