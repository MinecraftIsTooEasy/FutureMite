package com.github.fly6ird.futuremite.blocks;

import com.github.fly6ird.futuremite.api.IFutureMITEPlayer;
import com.github.fly6ird.futuremite.tileentities.TileEntitySmithingTable;
import net.minecraft.Block;
import net.minecraft.BlockConstants;
import net.minecraft.BlockHardness;
import net.minecraft.EntityItem;
import net.minecraft.EntityPlayer;
import net.minecraft.EnumFace;
import net.minecraft.Icon;
import net.minecraft.IconRegister;
import net.minecraft.ITileEntityProvider;
import net.minecraft.ItemStack;
import net.minecraft.Material;
import net.minecraft.NBTTagCompound;
import net.minecraft.TileEntity;
import net.minecraft.World;

public class BlockSmithingTable extends Block implements ITileEntityProvider {
    private Icon sideIcon;
    private Icon topIcon;
    private Icon bottomIcon;
    private Icon frontIcon;

    public BlockSmithingTable(int blockId) {
        super(blockId, Material.anvil, new BlockConstants());
        this.setMaxStackSize(1);
        this.setHardness(BlockHardness.planks);
        this.setResistance(10.0F);
        this.setStepSound(Block.soundWoodFootstep);
        this.setUnlocalizedName("smithing_table");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntitySmithingTable();
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int blockId, int metadata) {
        TileEntitySmithingTable tileEntity = (TileEntitySmithingTable) world.getBlockTileEntity(x, y, z);
        if (tileEntity != null) {
            for (int j = 0; j < tileEntity.getSizeInventory(); ++j) {
                ItemStack stackInSlot = tileEntity.getStackInSlot(j);
                if (stackInSlot == null) {
                    continue;
                }

                float offsetX = world.rand.nextFloat() * 0.8F + 0.1F;
                float offsetY = world.rand.nextFloat() * 0.8F + 0.1F;
                float offsetZ = world.rand.nextFloat() * 0.8F + 0.1F;

                while (stackInSlot.stackSize > 0) {
                    int dropCount = world.rand.nextInt(21) + 10;
                    if (dropCount > stackInSlot.stackSize) {
                        dropCount = stackInSlot.stackSize;
                    }

                    stackInSlot.stackSize -= dropCount;
                    EntityItem entityItem = new EntityItem(world, x + offsetX, y + offsetY, z + offsetZ,
                            new ItemStack(stackInSlot.itemID, dropCount, stackInSlot.getItemSubtype()));

                    if (stackInSlot.isItemDamaged()) {
                        entityItem.getEntityItem().setItemDamage(stackInSlot.getItemDamage());
                    }
                    if (stackInSlot.getItem().hasQuality()) {
                        entityItem.getEntityItem().setQuality(stackInSlot.getQuality());
                    }
                    if (stackInSlot.hasTagCompound()) {
                        entityItem.getEntityItem().setTagCompound((NBTTagCompound) stackInSlot.getTagCompound().copy());
                    }

                    float motionScale = 0.05F;
                    entityItem.motionX = world.rand.nextGaussian() * motionScale;
                    entityItem.motionY = world.rand.nextGaussian() * motionScale + 0.2F;
                    entityItem.motionZ = world.rand.nextGaussian() * motionScale;
                    world.spawnEntityInWorld(entityItem);
                }
            }

            world.func_96440_m(x, y, z, metadata);
        }

        super.breakBlock(world, x, y, z, blockId, metadata);
        world.removeBlockTileEntity(x, y, z);
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return switch (side) {
            case 1 -> this.topIcon;
            case 0 -> this.bottomIcon;
            case 2 -> this.frontIcon;
            case 3, 4, 5 -> this.sideIcon;
            default -> super.getIcon(side, metadata);
        };
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.sideIcon = iconRegister.registerIcon("futuremite:smithing_table_side");
        this.topIcon = iconRegister.registerIcon("futuremite:smithing_table_top");
        this.bottomIcon = iconRegister.registerIcon("futuremite:smithing_table_bottom");
        this.frontIcon = iconRegister.registerIcon("futuremite:smithing_table_front");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, EnumFace face, float offsetX, float offsetY, float offsetZ) {
        if (!world.isAirOrPassableBlock(x, y + 1, z, false)) {
            return false;
        }

        if (player.onServer()) {
            TileEntitySmithingTable tileEntity = (TileEntitySmithingTable) world.getBlockTileEntity(x, y, z);
            if (tileEntity != null) {
                ((IFutureMITEPlayer) player).futureMITE$displayGUISmithing(tileEntity);
            }
        }
        return true;
    }
}
