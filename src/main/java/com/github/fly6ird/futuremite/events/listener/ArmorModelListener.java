package com.github.fly6ird.futuremite.events.listener;

import com.github.fly6ird.futuremite.FutureMITEStart;
import com.github.fly6ird.futuremite.material.Materials;
import moddedmite.rustedironcore.api.event.listener.IArmorModelListener;
import net.minecraft.ItemArmor;
import net.minecraft.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class ArmorModelListener implements IArmorModelListener {
    private final Map<String, ResourceLocation> textureCache = new HashMap<>();

    @Override
    public ResourceLocation getArmorTexture(ItemArmor itemArmor, int slotIndex) {
        if (itemArmor.getArmorMaterial() != Materials.netherite) {
            return null;
        }

        String path = String.format("textures/models/armor/%s_layer_%d.png", itemArmor.getTextureFilenamePrefix(), slotIndex == 2 ? 2 : 1);
        ResourceLocation texture = this.textureCache.get(path);
        if (texture == null) {
            texture = new ResourceLocation(FutureMITEStart.MOD_ID, path);
            this.textureCache.put(path, texture);
        }
        return texture;
    }
}
