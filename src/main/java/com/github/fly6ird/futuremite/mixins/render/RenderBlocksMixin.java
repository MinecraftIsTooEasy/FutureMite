package com.github.fly6ird.futuremite.mixins.render;

import com.github.fly6ird.futuremite.api.EnumItemRenderType;
import com.github.fly6ird.futuremite.api.IRenderBlock;
import com.github.fly6ird.futuremite.blocks.BlockCampfire;
import com.github.fly6ird.futuremite.blocks.Blocks;
import com.github.fly6ird.futuremite.render.*;
import com.github.fly6ird.futuremite.tileentities.TileEntityGrindstone;

import net.minecraft.*;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({RenderBlocks.class})
public abstract class RenderBlocksMixin implements IRenderBlock {
    @Shadow
    private Icon overrideBlockTexture;

    @Shadow
    public IBlockAccess blockAccess;

    @Shadow
    public Icon getBlockIconFromSideAndMetadata(Block par1Block, int side, int metadata) {
        Icon par1Icon = par1Block.getIcon(side, metadata);
        return par1Icon != null ? par1Icon : ((TextureMap) Minecraft.theMinecraft.getTextureManager().getTexture(TextureMap.locationBlocksTexture)).getAtlasSprite("missingno");
    }

    @Unique
    private EnumItemRenderType renderItemType;  //0为物品栏  1为手持  2为凋落物

    @Unique
    RenderGrindstoneTileEntity grindStone = new RenderGrindstoneTileEntity();

    @Inject(method = {"renderItemIn3d"}, at = {@At("HEAD")}, cancellable = true)
    private static void register(int renderType, CallbackInfoReturnable<Boolean> cir) {
        if (renderType == RenderTypes.grindStoneRenderType)
            cir.setReturnValue(Boolean.TRUE);
    }

    @Inject(method = {"renderBlockAsItem"}, at = {@At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/Block;getRenderType()I")})
    private void register(Block par1Block, int par2, float par3, CallbackInfo ci) {
        int renderType = par1Block.getRenderType();

        if (renderType == RenderTypes.grindStoneRenderType) {
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            TileEntityRenderer.instance.renderTileEntityAt(new TileEntityGrindstone(), 0.0D, 0.0D, 0.0D, 0.0F);
            GL11.glEnable(32826);
        }
    }

    @Inject(method = "renderBlockByRenderType", at = @At("HEAD"), cancellable = true)
    public void renderBlockByRenderTypes(Block par1Block, int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {
        int RenderType = par1Block.getRenderType();
        if (RenderType == RenderTypes.chainRenderType) {
            Icon Photo = this.overrideBlockTexture == null ? this.getBlockIconFromSideAndMetadata(par1Block, 0, this.blockAccess.getBlockMetadata(x, y, z)) : this.overrideBlockTexture;
            RenderChain.instance.drawChain(par1Block, this.blockAccess.getBlockMetadata(x, y, z), x, y, z, Photo, this.blockAccess);
            cir.setReturnValue(true);
        }
        if (RenderType == RenderTypes.normalcampfireRenderType) {
            RenderNormalCampfire.instance.DrawRenderCampfire(par1Block, this.blockAccess.getBlockMetadata(x, y, z), x, y, z, this.blockAccess);
            cir.setReturnValue(true);
        }
        if (RenderType == RenderTypes.campfireRenderType) {
            if (par1Block instanceof BlockCampfire) {
                if (((BlockCampfire) par1Block).getIsActive())
                    RenderCampfire.instance.DrawRenderCampfire((BlockCampfire) par1Block, this.blockAccess.getBlockMetadata(x, y, z), x, y, z, this.blockAccess);
                else
                    RenderNormalCampfire.instance.DrawRenderCampfire(par1Block, this.blockAccess.getBlockMetadata(x, y, z), x, y, z, this.blockAccess);
                cir.setReturnValue(true);
            }

        }
        if (RenderType == RenderTypes.lanternRenderType) {
            RenderLantern.instance.DrawBlockLantern(par1Block, this.blockAccess.getBlockMetadata(x, y, z), x, y, z, this.blockAccess);
            cir.setReturnValue(true);
        }
    }

    @ModifyVariable(
            method = "renderCrossedSquares",
            at = @At("HEAD"),
            argsOnly = true,
            ordinal = 0
    )
    private Block modifyBlockForBigGrass(Block par1Block) {
        if (par1Block == Blocks.bigGrass || par1Block == Blocks.tallGrass) {
            return Blocks.tallGrass;
        }
        return par1Block;
    }

    @Override
    public void FutureMITE$setFlag(EnumItemRenderType type) {
        renderItemType = type;
    }

    @Override
    public EnumItemRenderType FutureMITE$getFlag() {
        return renderItemType;
    }
}