package com.github.fly6ird.futuremite;

import com.github.fly6ird.futuremite.material.EnumEquipmentMaterials;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.xiaoyu233.fml.util.EnumExtends;

public class EarlyRiser implements PreLaunchEntrypoint {

    public void onPreLaunch() {
        EnumEquipmentMaterials.register();

        EnumExtends.PARTICLE.addEnum("soul_fire_flame");
        EnumExtends.PARTICLE.addEnum("big_smoke");

    }
}
