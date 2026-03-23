package com.github.fly6ird.futuremite.material;

import com.chocohead.mm.api.ClassTinkerers;
import com.github.fly6ird.futuremite.FutureMITEStart;
import net.minecraft.EnumEquipmentMaterial;
import net.minecraft.EnumQuality;
import net.xiaoyu233.fml.util.EnumExtends;

public final class EnumEquipmentMaterials {
    private static final String NETHERITE_ENUM_NAME = FutureMITEStart.NameSpaceCompact + "_NETHERITE";

    private EnumEquipmentMaterials() {
    }

    public static void register() {
        EnumExtends.EQUIPMENT_MATERIAL.addEnum(NETHERITE_ENUM_NAME, () -> new Object[]{256.0F, 20, EnumQuality.legendary, "netherite"});
    }

    public static EnumEquipmentMaterial netherite() {
        return ClassTinkerers.getEnum(EnumEquipmentMaterial.class, NETHERITE_ENUM_NAME);
    }
}
