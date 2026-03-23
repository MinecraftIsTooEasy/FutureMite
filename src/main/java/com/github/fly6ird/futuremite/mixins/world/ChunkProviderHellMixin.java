package com.github.fly6ird.futuremite.mixins.world;

import com.github.fly6ird.futuremite.blocks.Blocks;
import net.minecraft.Block;
import net.minecraft.ChunkProviderHell;
import net.minecraft.IChunkProvider;
import net.minecraft.World;
import net.minecraft.WorldGenMinable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(ChunkProviderHell.class)
public class ChunkProviderHellMixin {
    @Shadow
    private Random hellRNG;

    @Shadow
    private World worldObj;

    @Inject(method = "populate", at = @At(value = "INVOKE", target = "Lnet/minecraft/WorldInfo;getEarliestMITEReleaseRunIn()I", ordinal = 1, shift = At.Shift.BEFORE))
    private void injectNetheriteOre(IChunkProvider provider, int chunkX, int chunkZ, CallbackInfo ci) {
        int originX = chunkX * 16;
        int originZ = chunkZ * 16;

        WorldGenMinable netheriteGen = (new WorldGenMinable(Blocks.ancientDebris.blockID, 3, Block.netherrack.blockID))
                .setMinableBlockMetadata(0);
        int netheriteCount = this.hellRNG.nextInt(5) + 3;

        for (int i = 0; i < netheriteCount; ++i) {
            int x = originX + this.hellRNG.nextInt(16);
            int y = 8 + this.hellRNG.nextInt(255);
            int z = originZ + this.hellRNG.nextInt(16);
            netheriteGen.generate(this.worldObj, this.hellRNG, x, y, z);
        }
    }
}
