package com.github.fly6ird.futuremite.mixins.entity;

import com.github.fly6ird.futuremite.entities.EntityNewBoat;
import com.github.fly6ird.futuremite.entities.EntityNewBoatWithChest;
import net.minecraft.*;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayer.class)
public abstract class EntityPlayerMPMixin extends EntityPlayer {

    @Redirect(method = "onUpdate", at = @At(value = "FIELD", target = "Lnet/minecraft/ServerPlayer;ridingEntity:Lnet/minecraft/Entity;", opcode = Opcodes.GETFIELD))
    private Entity redirectRidingEntityCheck(ServerPlayer instance) {
        // 替换原判断逻辑
        if (ridingEntity instanceof EntityNewBoatWithChest || ridingEntity instanceof EntityNewBoat || ridingEntity instanceof EntityBoat)
            return new EntityBoat(this.getWorld());

        return ridingEntity;
    }


    public EntityPlayerMPMixin(World par1World, String par2Str) {
        super(par1World, par2Str);
    }

    @Shadow
    public NetServerHandler playerNetServerHandler;

    @Override
    public INetworkManager getNetManager() {
        return this.playerNetServerHandler.getNetManager();
    }

    @Override
    public void sendChatToPlayer(ChatMessageComponent par1ChatMessageComponent) {
        this.playerNetServerHandler.sendPacketToPlayer(new Packet3Chat(par1ChatMessageComponent));
    }

    @Override
    public ChunkCoordinates getPlayerCoordinates() {
        return new ChunkCoordinates(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY + 0.5), MathHelper.floor_double(this.posZ));
    }
}
