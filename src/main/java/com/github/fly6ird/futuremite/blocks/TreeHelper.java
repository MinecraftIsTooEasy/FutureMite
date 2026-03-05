package com.github.fly6ird.futuremite.blocks;

import com.github.fly6ird.futuremite.FutureMITEStart;
import com.github.fly6ird.futuremite.items.ItemModLeaves;

import moddedmite.rustedironcore.api.block.DoorBlock;
import moddedmite.rustedironcore.api.item.DoorItem;

import net.minecraft.*;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;

import static com.github.fly6ird.futuremite.blocks.Blocks.getNextBlockID;
import static net.xiaoyu233.fml.reload.utils.IdUtil.getNextItemID;

public class TreeHelper {
    public final String id;

    public final BlockModLog Log;
    public final BlockModWoodPlanks Planks;
    public final BlockModLeaves Leaves;
    public final Block Stairs;
    public final BlockModWoodSlab SingleSlab;
    public final BlockDoubleSlab DoubleSlab;
    public final BlockModSapling Sapling = new BlockModSapling(getNextBlockID(), this);
    public final DoorBlock Door = new DoorBlock(getNextBlockID(), Material.wood, () -> this.ItemDoor);
    public final DoorItem ItemDoor = new DoorItem(getNextItemID(), Material.wood, () -> this.Door);
    public final BlockModTrapDoor TrapDoor;
    public final BlockStrippedLog StrippedLog;
    public final BlockStrippedWood StrippedWood;

    public TreeHelper(String id) {
        this.id = id;
        this.Log = new BlockModLog(getNextBlockID(), id);
        this.Planks = new BlockModWoodPlanks(getNextBlockID(), id);
        this.Stairs = (new BlockModStairs(getNextBlockID(), this.Planks, 0));
        this.SingleSlab = (new BlockModWoodSlab(getNextBlockID(), this.Planks, 0, id));
        this.DoubleSlab = (new BlockDoubleSlab(getNextBlockID(), this.SingleSlab));
        this.TrapDoor = (new BlockModTrapDoor(getNextBlockID(), id, Planks));
        this.Leaves = new BlockModLeaves(getNextBlockID(), id, this);
        this.StrippedLog = new BlockStrippedLog(getNextBlockID(), id);
        this.StrippedWood = new BlockStrippedWood(getNextBlockID(), id);
    }

    public void registerRecipes(RecipeRegistryEvent register) {
        register.registerShapedRecipe(new ItemStack(Planks, 4), true, "A", 'A', Log);
        register.registerShapedRecipe(new ItemStack(Planks, 4), true, "A", 'A', StrippedLog);
        register.registerShapedRecipe(new ItemStack(Stairs, 4), true, "A  ", "AA ", "AAA", 'A', new ItemStack(Planks));
        register.registerShapedRecipe(new ItemStack(SingleSlab, 6), true, "AAA", 'A', new ItemStack(Planks));
        TrapDoor.registerRecipe(register);

        register.registerShapedRecipe(new ItemStack(this.ItemDoor, 1), true, new Object[]{"AA", "AA", "AA", Character.valueOf('A'), new ItemStack((this.Planks), 1)});

        // Peeled logs → Peeled wood (2x2 round logs combined)
        register.registerShapedRecipe(new ItemStack(StrippedWood, 3), true, "AA ", "AA ", "   ", 'A', Item.getItem(StrippedLog));
        register.registerShapedRecipe(new ItemStack(StrippedWood, 3), true, " AA", " AA", "   ", 'A', Item.getItem(StrippedLog));
        register.registerShapedRecipe(new ItemStack(StrippedWood, 3), true, "   ", "AA ", "AA ", 'A', Item.getItem(StrippedLog));
        register.registerShapedRecipe(new ItemStack(StrippedWood, 3), true, "   ", " AA", " AA", 'A', Item.getItem(StrippedLog));
    }

    //注册物品事件
    public void registerItemBlocks(ItemRegistryEvent registryEvent) {
        registryEvent.register(FutureMITEStart.NameSpaceCompact, "futuremite:doors/" + id, "doors." + id, this.ItemDoor);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "futuremite:planks/" + id, "planks." + id, this.Planks);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, this.DoubleSlab);
        registerModItemBlocks(registryEvent, this.SingleSlab, id);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "futuremite:doors/" + id, id + "_door", this.Door);

        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, id, "log." + id + "_log", this.Log); this.Log.setUnlocalizedName("log." + id + "_log");

        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "stripped_" + id, "log.stripped_" + id + "_log", this.StrippedLog);

        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "futuremite:log/stripped_" + id + "_side", "log.stripped_" + id + "_wood", this.StrippedWood);
        registerModItemBlocks(registryEvent, this.Leaves, "leaves." + id);
        registerModItemBlocks(registryEvent, this.Stairs, "stairs." + id);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, this.TrapDoor);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "futuremite:sapling/" + id + "_sapling", id + "_sapling", this.Sapling);

        Item.itemsList[this.SingleSlab.blockID] = (new ItemSlab(this.SingleSlab, this.DoubleSlab, false));
        Item.itemsList[this.DoubleSlab.blockID] = (new ItemSlab(this.SingleSlab, this.DoubleSlab, true));
        Item.itemsList[this.Leaves.blockID] = (new ItemModLeaves(this.Leaves));
    }

    public void registerModItemBlocks(ItemRegistryEvent registryEvent, Block block, String name) {
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, block);
        block.setUnlocalizedName(name);
    }
}
