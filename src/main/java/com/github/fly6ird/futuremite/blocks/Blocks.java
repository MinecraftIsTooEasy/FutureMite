package com.github.fly6ird.futuremite.blocks;

import com.github.fly6ird.futuremite.FutureMITEStart;
import com.github.fly6ird.futuremite.creativetab.FutureMITECreativeTabs;
import com.github.fly6ird.futuremite.items.ItemBigGrass;
import com.github.fly6ird.futuremite.items.Items;
import com.github.fly6ird.futuremite.sound.*;
import com.github.fly6ird.futuremite.world.gen.WorldGenBigCherryTree;
import com.github.fly6ird.futuremite.world.gen.WorldGenCherryTrees;
import moddedmite.rustedironcore.api.block.DoorBlock;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class Blocks extends Block {
    public static final StepSound stepSoundChain = new StepSoundChain("chain", 1.0f, 1.0f);
    public static final StepSound stepSoundWood = new StepSoundWood("wood", 1.0f, 1.0f);
    public static final StepSound stepSoundLantern = new StepSoundLantern("Lantern", 1.0f, 1.0f);
    public static final StepSound stepSoundSweetBerryBush = new StepSoundSweetBerryBush("sweetBerryBush", 1.0f, 1.0f);
    public static final StepSound stepSoundSlime = new StepSoundSliem("slime", 1.0f, 1.0f);

    public static final Block grindStone = new BlockGrindstone(getNextBlockID());
    public static final Block bigGrass = new BlockBigGrass(getNextBlockID(), "bigGrass").setHardness(0.02F).setCushioning(0.2F).setStepSound(soundGrassFootstep);
    public static final Block sweetBerryBush = new BlockSweetBerry(getNextBlockID());

    public static final Block copperChain = new BlockChain(getNextBlockID(), Material.copper);
    public static final Block silverChain = new BlockChain(getNextBlockID(), Material.silver);
    public static final Block goldenChain = new BlockChain(getNextBlockID(), Material.gold);
    public static final Block ironChain = new BlockChain(getNextBlockID(), Material.iron);
    public static final Block ancientChain = new BlockChain(getNextBlockID(), Material.ancient_metal);
    public static final Block mithrilChain = new BlockChain(getNextBlockID(), Material.mithril);
    public static final Block adamantiumChain = new BlockChain(getNextBlockID(), Material.adamantium);

    public static final Block campfire = new BlockCampfire(getNextBlockID(), 1.0f, true).setLightValue(0.6f);
    public static final Block extinguishedCampfire = new BlockCampfire(getNextBlockID(), 0f, false);
    public static final Block soulCampfire = new BlockCampfire(getNextBlockID(), 2.0f, true).setLightValue(0.6666f);

    //public static final Block normalCampfire = new BlockExtinguishedCampfire(getNextBlockID());

    public static final Block dirtPath = new BlockDirtPath(getNextBlockID());

    public static final Block soulTorch = new BlockSoulTorch(getNextBlockID());

    public static final Block copperLantern = new BlockLantern(getNextBlockID(),Material.copper);
    public static final Block silverLantern = new BlockLantern(getNextBlockID(),Material.silver);
    public static final Block goldenLantern = new BlockLantern(getNextBlockID(),Material.gold);
    public static final Block ironLantern = new BlockLantern(getNextBlockID(),Material.iron);
    public static final Block soulLantern = new BlockLantern(getNextBlockID(),Material.iron);
    public static final Block ancientLantern = new BlockLantern(getNextBlockID(),Material.ancient_metal);
    public static final Block mithrilLantern = new BlockLantern(getNextBlockID(),Material.mithril);
    public static final Block adamantiumLantern = new BlockLantern(getNextBlockID(),Material.adamantium);

    public static final Block seaLantern = new BlockSeaLantern(getNextBlockID());
    public static final PrismarineBlocks prismarineBlock = new PrismarineBlocks(getNextBlockID());

    public static final Block endStoneBrick = new BlockStone(getNextBlockID()).setHardness(0.8f);

    public static final Block endStoneBrickWall = new BlockWallExtend(getNextBlockID(), endStoneBrick);
    public static final Block stoneBrickWall = new BlockWallExtend(getNextBlockID(), Block.stoneBrick);
    public static final Block BrickWall = new BlockWallExtend(getNextBlockID(), Block.brick);

    public static final Block barrel = new BlockBarrel(getNextBlockID(), Material.wood, "barrel");

/*
    public static final Block birchDoor = new BlockModDoor(getNextBlockID(),"birch",Items.birchDoor);
    public static final Block jungleDoor = new BlockModDoor(getNextBlockID(),"jungle",Items.jungleDoor);
    public static final Block spruceDoor = new BlockModDoor(getNextBlockID(),"spruce",Items.spruceDoor);
*/

    public static final DoorBlock birchDoor = new DoorBlock(getNextBlockID(), Material.wood, () -> Items.birchDoor);
    public static final DoorBlock jungleDoor = new DoorBlock(getNextBlockID(), Material.wood, () -> Items.jungleDoor);
    public static final DoorBlock spruceDoor = new DoorBlock(getNextBlockID(), Material.wood, () -> Items.spruceDoor);

    public static final BlockWoodFenceExtend spruceFence = (new BlockWoodFenceExtend(getNextBlockID(), 1));
    public static final BlockWoodFenceExtend birchFence = (new BlockWoodFenceExtend(getNextBlockID(), 2));
    public static final BlockWoodFenceExtend jungleFence = (new BlockWoodFenceExtend(getNextBlockID(), 3));
    public static final BlockFenceGateExtend spruceFenceGate = new BlockFenceGateExtend(getNextBlockID(), 1);
    public static final BlockFenceGateExtend birchFenceGate = new BlockFenceGateExtend(getNextBlockID(), 2);
    public static final BlockFenceGateExtend jungleFenceGate = new BlockFenceGateExtend(getNextBlockID(), 3);

    /*    public static final BlockModLog birchLog = new BlockModLog(getNextBlockID(), "birch").setIsVanilla();
        public static final BlockModLog jungleLog = new BlockModLog(getNextBlockID(), "jungle").setIsVanilla();
        public static final BlockModLog oakLog = new BlockModLog(getNextBlockID(), "oak").setIsVanilla();
        public static final BlockModLog spruceLog = new BlockModLog(getNextBlockID(), "spruce").setIsVanilla();*/
    public static final TreeHelper acacia = new TreeHelper("acacia");
    public static final TreeHelper darkOak = new TreeHelper("dark_oak");
    public static final TreeHelper cherry = new TreeHelper("cherry").Sapling.setSmallTreeGenerator(new WorldGenCherryTrees(true, 4, 3, 3, false)).Sapling.setLargeTreeGenerator(new WorldGenBigCherryTree(true));

    public static final BlockModLog birchLog = new BlockModLog(getNextBlockID());
    public static final BlockModLog jungleLog = new BlockModLog(getNextBlockID());
    public static final BlockModLog oakLog = new BlockModLog(getNextBlockID());
    public static final BlockModLog spruceLog = new BlockModLog(getNextBlockID());
    public static final Block strippedBirchWood = new BlockStrippedWood(getNextBlockID());
    public static final Block strippedJungleWood = new BlockStrippedWood(getNextBlockID());
    public static final Block strippedOakWood = new BlockStrippedWood(getNextBlockID());
    public static final Block strippedSpruceWood = new BlockStrippedWood(getNextBlockID());


    public static final BlockModTrapDoor birchTrapDoor = (new BlockModTrapDoor(getNextBlockID(), "birch"));
    public static final BlockModTrapDoor jungleTrapDoor = (new BlockModTrapDoor(getNextBlockID(), "jungle"));
    public static final BlockModTrapDoor spruceTrapDoor = (new BlockModTrapDoor(getNextBlockID(), "spruce"));

    protected Blocks(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);

    }

    static {
        Item.itemsList[bigGrass.blockID] = (new ItemBigGrass(bigGrass));
/*        for (BlockModLog log : new BlockModLog[]{oakLog, birchLog, spruceLog, jungleLog}) {
            Item.itemsList[log.blockID] = (new ItemMultiTextureTileFuelBlock(log, log.getNames(), 1600));
        }*/

/*        for (BlockWoodWorkBench blockModLog : new BlockWoodWorkBench[]{oakWorkbench, birchWorkbench, jungleWorkbench, spruceWorkbench}) {
            String[] workbenchNameList = new String[8];
            for (int i = 0; i < workbenchNameList.length; i++)
                workbenchNameList[i] = ((i < 4) ? "flint" : "obsidian") + "." + blockModLog.Log.getName(i);
            Item.itemsList[blockModLog.blockID] = (new ItemMultiTextureTileFuelBlock(blockModLog, workbenchNameList, 1600));
        }*/
    }

    public static void registerItemBlocks(ItemRegistryEvent registryEvent) {
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, barrel);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, bigGrass);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, prismarineBlock);
        new ItemMultiTextureTile(prismarineBlock, prismarineBlock.getNames());
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "futuremite:sea_lantern", seaLantern);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, grindStone);

        String[] chainNames = {"copper_chain", "silver_chain", "golden_chain", "iron_chain", "ancient_chain", "mithril_chain", "adamantium_chain"};
        Block[] chains = {copperChain, silverChain, goldenChain, ironChain, ancientChain, mithrilChain, adamantiumChain};
        for (int chainIndex = 0; chainIndex < chains.length; chainIndex++)
            registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, chainNames[chainIndex], chains[chainIndex]);

        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "campfire", campfire);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "extinguished_Campfire", extinguishedCampfire);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "soul_campfire", soulCampfire);

        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "futuremite:soul_torch", "soul_torch", soulTorch);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "dirtPath", dirtPath);

        String[] lanternNames = {"copper_lantern", "silver_lantern", "golden_lantern", "iron_lantern", "soul_lantern", "ancient_lantern", "mithril_lantern", "adamantium_lantern"};
        Block[] lanterns = {copperLantern, silverLantern, goldenLantern, ironLantern, soulLantern, ancientLantern, mithrilLantern, adamantiumLantern};
        for (int lanternIndex = 0; lanternIndex < lanterns.length; lanternIndex++)
            registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, lanternNames[lanternIndex], lanterns[lanternIndex]);

        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "futuremite:end_stone_bricks", endStoneBrick.setCreativeTab(FutureMITECreativeTabs.tabBlock));
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "stonebrick", stoneBrickWall);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "brick", BrickWall);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "futuremite:end_stone_bricks", endStoneBrickWall);

        stoneBrickWall.setUnlocalizedName("stonebrickWall");
        grindStone.setUnlocalizedName("grindstone");
        endStoneBrick.setUnlocalizedName("end_stone_bricks");
        BrickWall.setUnlocalizedName("brickWall");
        endStoneBrickWall.setUnlocalizedName("endStoneBrickWall");
        seaLantern.setUnlocalizedName("sea_lantern");

        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, sweetBerryBush);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, dirtPath);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, soulTorch);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, endStoneBrick);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, endStoneBrickWall);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, stoneBrickWall);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, BrickWall);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "futuremite:doors/birch", "birch", birchDoor);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "futuremite:doors/jungle", "jungle", jungleDoor);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "futuremite:doors/spruce", "spruce", spruceDoor);
        for (Block fence : new Block[]{spruceFence, birchFence, jungleFence, spruceFenceGate, birchFenceGate, jungleFenceGate})
            registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, fence);
/*        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, birchLog);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, jungleLog);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, oakLog);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, spruceLog);*/
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, birchTrapDoor);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, jungleTrapDoor);
        registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, spruceTrapDoor);

        String[] vanillaLogNames = {"birch", "jungle", "oak", "spruce"};
        BlockModLog[] vanillaLogs = {birchLog, jungleLog, oakLog, spruceLog};
        Block[] strippedWoods = {strippedBirchWood, strippedJungleWood, strippedOakWood, strippedSpruceWood};
        for (int logIndex = 0; logIndex < vanillaLogs.length; logIndex++) {
            String name = vanillaLogNames[logIndex];
            registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "stripped_" + name, "log." + name + "_log", vanillaLogs[logIndex]);
            registryEvent.registerItemBlock(FutureMITEStart.NameSpaceCompact, "futuremite:log/stripped_" + name + "_side", "log.stripped_" + name + "_wood", strippedWoods[logIndex]);
        }

        acacia.registerItemBlocks(registryEvent);
        darkOak.registerItemBlocks(registryEvent);
        cherry.registerItemBlocks(registryEvent);
    }

    public static void registerRecipes(RecipeRegistryEvent register) {
        register.registerShapedRecipe(new ItemStack(seaLantern, 1), true, "ABA", "BBB", "ABA", 'A', Item.getItem(Items.prismarineShard.itemID), 'B', Item.getItem(Items.prismarineCrystals.itemID));

        for (int woodIndex = 0; woodIndex < 4; woodIndex++) {
            register.registerShapedRecipe(new ItemStack(barrel, 1), true, "ABA", "A A", "ABA", 'A', new ItemStack((Block.planks), 1, woodIndex), 'B', new ItemStack((Block.woodSingleSlab), 1, woodIndex));
            register.registerShapedRecipe(new ItemStack(campfire, 1), true, " A ", "ABA", "CCC", 'A', Item.getItem(Item.stick.itemID), 'B', Item.getItem(Item.coal.itemID), 'C', new ItemStack(Block.wood, 1, woodIndex));
            register.registerShapedRecipe(new ItemStack(campfire, 1), true, " A ", "ABA", "CCC", 'A', Item.getItem(Item.stick.itemID), 'B', new ItemStack(Item.coal, 1, 1), 'C', new ItemStack(Block.wood, 1, woodIndex));
            register.registerShapedRecipe(new ItemStack(soulCampfire, 1), true, " A ", "ABA", "CCC", 'A', Item.getItem(Item.stick.itemID), 'B', Item.getItem(Block.slowSand), 'C', new ItemStack(Block.wood, 1, woodIndex));
            register.registerShapedRecipe(new ItemStack(grindStone, 1), true, "ABA", "C C", "   ", 'A', Item.getItem(Item.stick.itemID), 'B', Item.getItem(Block.stoneSingleSlab), 'C', new ItemStack(Block.planks, 1, woodIndex));
            register.registerShapedRecipe(new ItemStack(grindStone, 1), true, "   ", "ABA", "C C", 'A', Item.getItem(Item.stick.itemID), 'B', Item.getItem(Block.stoneSingleSlab), 'C', new ItemStack(Block.planks, 1, woodIndex));
        }

        Block[] chainBlocks = {copperChain, silverChain, goldenChain, ironChain, ancientChain, mithrilChain, adamantiumChain};
        Item[] chainNuggets = {Item.copperNugget, Item.silverNugget, Item.goldNugget, Item.ironNugget, Item.ancientMetalNugget, Item.mithrilNugget, Item.adamantiumNugget};
        Item[] chainIngots = {Item.ingotCopper, Item.ingotSilver, Item.ingotGold, Item.ingotIron, Item.ingotAncientMetal, Item.ingotMithril, Item.ingotAdamantium};
        for (int chainIndex = 0; chainIndex < chainBlocks.length; chainIndex++) {
            Item nugget = Item.getItem(chainNuggets[chainIndex].itemID), ingot = Item.getItem(chainIngots[chainIndex].itemID);
            for (String col : new String[]{"A  |B  |A  ", " A | B | A ", "  A|  B|  A"}) {
                String[] rows = col.split("\\|");
                register.registerShapedRecipe(new ItemStack(chainBlocks[chainIndex], 16), true, rows[0], rows[1], rows[2], 'A', nugget, 'B', ingot);
            }
        }

        Item stick = Item.getItem(Item.stick.itemID), slowSand = Item.getItem(Block.slowSand);
        for (Object coalFuel : new Object[]{Item.getItem(Item.coal.itemID), new ItemStack(Item.coal, 1, 1)}) {
            for (String col : new String[]{"A  |B  |C  ", " A | B | C ", "  A|  B|  C"}) {
                String[] rows = col.split("\\|");
                register.registerShapedRecipe(new ItemStack(soulTorch, 4), true, rows[0], rows[1], rows[2], 'A', coalFuel, 'B', stick, 'C', slowSand);
            }
        }

        Item torchItem = Item.getItem(Blocks.torchWood);
        Block[] lanternBlocks = {copperLantern, silverLantern, goldenLantern, ironLantern, soulLantern, ancientLantern, mithrilLantern, adamantiumLantern};
        Item[] lanternNuggets = {Item.copperNugget, Item.silverNugget, Item.goldNugget, Item.ironNugget, Item.ironNugget, Item.ancientMetalNugget, Item.mithrilNugget, Item.adamantiumNugget};
        Object[] lanternTorches = {torchItem, torchItem, torchItem, Item.getItem(Block.torchWood), Item.getItem(Blocks.soulTorch), torchItem, torchItem, torchItem};
        for (int lanternIndex = 0; lanternIndex < lanternBlocks.length; lanternIndex++)
            register.registerShapedRecipe(new ItemStack(lanternBlocks[lanternIndex], 1), true, "AAA", "ABA", "AAA", 'A', Item.getItem(lanternNuggets[lanternIndex].itemID), 'B', lanternTorches[lanternIndex]);

        BlockModTrapDoor[] trapDoors = {birchTrapDoor, jungleTrapDoor, spruceTrapDoor};
        int[] trapDoorPlanks = {2, 3, 1};
        for (int trapIndex = 0; trapIndex < trapDoors.length; trapIndex++) {
            register.registerShapedRecipe(new ItemStack(trapDoors[trapIndex], 2), true, "AAA", "AAA", "   ", 'A', new ItemStack(Block.planks, 1, trapDoorPlanks[trapIndex]));
            register.registerShapedRecipe(new ItemStack(trapDoors[trapIndex], 2), true, "   ", "AAA", "AAA", 'A', new ItemStack(Block.planks, 1, trapDoorPlanks[trapIndex]));
        }

        Block[][] wallPairs = {{stoneBrickWall, Block.stoneBrick}, {BrickWall, Block.brick}, {endStoneBrickWall, endStoneBrick}};
        for (Block[] wallPair : wallPairs) {
            register.registerShapedRecipe(new ItemStack(wallPair[0], 8), true, "   ", "AAA", "AAA", 'A', Item.getItem(wallPair[1]));
            register.registerShapedRecipe(new ItemStack(wallPair[0], 8), true, "AAA", "AAA", "   ", 'A', Item.getItem(wallPair[1]));
        }

        for (String pattern : new String[]{"AA |AA |   ", " AA| AA|   ", "   |AA |AA ", "   | AA| AA"}) {
            String[] rows = pattern.split("\\|");
            register.registerShapedRecipe(new ItemStack(endStoneBrick, 4), true, rows[0], rows[1], rows[2], 'A', Item.getItem(Block.whiteStone));
        }

        //WoodWorkBench
/*        birchWorkbench.registerRecipe(register);
        jungleWorkbench.registerRecipe(register);
        spruceWorkbench.registerRecipe(register);
        oakWorkbench.registerRecipe(register);*/

        //0为 oak   1 spruce   2birch  3jungle
        BlockModLog[] vanillaLogs = {oakLog, spruceLog, birchLog, jungleLog};
        for (int woodIndex = 0; woodIndex < 4; woodIndex++)
            for (int metaIndex = 0; metaIndex < 4; metaIndex++)
                register.registerShapedRecipe(new ItemStack(planks, 4, woodIndex), true, "A", 'A', new ItemStack(vanillaLogs[woodIndex], 1, metaIndex));

        Block[] strippedWoods = {strippedBirchWood, strippedJungleWood, strippedOakWood, strippedSpruceWood};
        BlockModLog[] strippedLogs = {birchLog, jungleLog, oakLog, spruceLog};
        for (int logIndex = 0; logIndex < strippedWoods.length; logIndex++) {
            for (String pattern : new String[]{"AA |AA |   ", " AA| AA|   ", "   |AA |AA ", "   | AA| AA"}) {
                String[] rows = pattern.split("\\|");
                register.registerShapedRecipe(new ItemStack(strippedWoods[logIndex], 3), true, rows[0], rows[1], rows[2], 'A', Item.getItem(strippedLogs[logIndex]));
            }
        }

       /* register.registerShapedRecipe(new ItemStack(oakLog, 3, 2), true, new Object[]{"AA", "AA", Character.valueOf('A'), new ItemStack(wood, 1, 0)});
        register.registerShapedRecipe(new ItemStack(spruceLog, 3, 2), true, new Object[]{"AA", "AA", Character.valueOf('A'), new ItemStack(wood, 1, 1)});
        register.registerShapedRecipe(new ItemStack(birchLog, 3, 2), true, new Object[]{"AA", "AA", Character.valueOf('A'), new ItemStack(wood, 1, 2)});
        register.registerShapedRecipe(new ItemStack(jungleLog, 3, 2), true, new Object[]{"AA", "AA", Character.valueOf('A'), new ItemStack(wood, 1, 3)});

        for (int i = 0; i <= 1; i++) {
            register.registerShapedRecipe(new ItemStack(birchLog, 3, i + 2), true, new Object[]{"AA", "AA", Character.valueOf('A'), new ItemStack(birchLog, 1, i)});
            register.registerShapedRecipe(new ItemStack(jungleLog, 3, i + 2), true, new Object[]{"AA", "AA", Character.valueOf('A'), new ItemStack(jungleLog, 1, i)});
            register.registerShapedRecipe(new ItemStack(oakLog, 3, i + 2), true, new Object[]{"AA", "AA", Character.valueOf('A'), new ItemStack(oakLog, 1, i)});
            register.registerShapedRecipe(new ItemStack(spruceLog, 3, i + 2), true, new Object[]{"AA", "AA", Character.valueOf('A'), new ItemStack(spruceLog, 1, i)});
        }
        for (int i = 0; i < 4; i++) {
            register.registerShapedRecipe(new ItemStack(planks, 4, 0), true, "A", 'A', new ItemStack(oakLog, 1, i));
            register.registerShapedRecipe(new ItemStack(planks, 4, 1), true, "A", 'A', new ItemStack(spruceLog, 1, i));
            register.registerShapedRecipe(new ItemStack(planks, 4, 2), true, "A", 'A', new ItemStack(birchLog, 1, i));
            register.registerShapedRecipe(new ItemStack(planks, 4, 3), true, "A", 'A', new ItemStack(jungleLog, 1, i));
        }
*/
        birchTrapDoor.registerRecipeWithVanilla(register, 1);
        jungleTrapDoor.registerRecipeWithVanilla(register, 2);
        spruceTrapDoor.registerRecipeWithVanilla(register, 3);

        acacia.registerRecipes(register);
        darkOak.registerRecipes(register);
        cherry.registerRecipes(register);

        for (BlockFenceGateExtend fenceGate : new BlockFenceGateExtend[]{spruceFenceGate, birchFenceGate, jungleFenceGate})
            fenceGate.registerRecipe(register);
        for (BlockWoodFenceExtend woodFence : new BlockWoodFenceExtend[]{spruceFence, birchFence, jungleFence})
            woodFence.registerRecipe(register);
        register.registerShapedRecipe(new ItemStack(Block.fence, 3), true, "ABA", "ABA", 'A', new ItemStack(Block.planks, 1, 0), 'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(Block.fence, 2), true, "SSS", "SSS", 'S', Item.stick);
    }

    public static void furnaceRecipe() {
        FurnaceRecipes.smelting().addSmelting(sponge.blockID, new ItemStack(Item.itemsList[sponge.blockID], 1, 0));
    }

    public static int getNextBlockID() {
        return IdUtil.getNextBlockID();
    }
}
