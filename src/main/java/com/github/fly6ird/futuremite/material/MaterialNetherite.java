package com.github.fly6ird.futuremite.material;

import com.github.fly6ird.futuremite.items.NetheriteItems;
import huix.glacier.api.extension.material.IArmorMaterial;
import huix.glacier.api.extension.material.IArrowMaterial;
import huix.glacier.api.extension.material.IRepairableMaterial;
import huix.glacier.api.extension.material.IToolMaterial;
import net.minecraft.EnumEquipmentMaterial;
import net.minecraft.Item;
import net.minecraft.Material;

public class MaterialNetherite extends Material implements IArmorMaterial, IArrowMaterial, IRepairableMaterial, IToolMaterial {
    public MaterialNetherite(EnumEquipmentMaterial enumCraftingMaterial) {
        super(enumCraftingMaterial);
        this.setRequiresTool().setMetal(false).setMinHarvestLevel(5);
    }

    @Override
    public float getChanceOfRecovery() {
        return 0.7F;
    }

    @Override
    public float getDamageVsEntity() {
        return 7.0F;
    }

    @Override
    public int getProtection() {
        return 12;
    }

    @Override
    public Item getRepairItem() {
        return NetheriteItems.netheriteNugget;
    }

    @Override
    public float getHarvestEfficiency() {
        return 4.0F;
    }
}
