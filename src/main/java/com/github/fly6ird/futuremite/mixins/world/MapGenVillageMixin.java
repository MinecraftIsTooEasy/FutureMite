package com.github.fly6ird.futuremite.mixins.world;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.MapGenVillage;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = MapGenVillage.class, priority = 999)

public class MapGenVillageMixin {
    @WrapOperation(method = "canSpawnStructureAtCoords",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/World;getDayOfWorld()I"))
    private int redirectGetDayOfWorld(World instance, Operation<Integer> original) {
        if (instance.getDayOfWorld() > 32) {
            return 1000;  // 返回一个大于60的值，这样 if 判断就不会为 true
        } else
            return original.call(instance);
    }

    /*@Redirect(method = "canSpawnStructureAtCoords",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/WorldInfo;getVillageConditions()B"))
    private byte getVillageConditions(WorldInfo instance) {
        return WorldInfo.getVillagePrerequisites();  // 生成村庄不再需要工具
    }*/

}
