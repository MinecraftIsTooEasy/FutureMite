package com.github.fly6ird.futuremite.items;

import com.github.fly6ird.futuremite.FutureMITEStart;
import com.github.fly6ird.futuremite.creativetab.FutureMITECreativeTabs;
import com.github.fly6ird.futuremite.material.Materials;
import net.minecraft.Block;
import net.minecraft.Item;
import net.minecraft.ItemAxe;
import net.minecraft.ItemBattleAxe;
import net.minecraft.ItemBoots;
import net.minecraft.ItemCuirass;
import net.minecraft.ItemDagger;
import net.minecraft.ItemHatchet;
import net.minecraft.ItemHelmet;
import net.minecraft.ItemHoe;
import net.minecraft.ItemIngot;
import net.minecraft.ItemLeggings;
import net.minecraft.ItemMattock;
import net.minecraft.ItemNugget;
import net.minecraft.ItemPickaxe;
import net.minecraft.ItemScythe;
import net.minecraft.ItemShears;
import net.minecraft.ItemShovel;
import net.minecraft.ItemStack;
import net.minecraft.ItemSword;
import net.minecraft.ItemWarHammer;
import net.minecraft.Material;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public final class NetheriteItems {
    public static final ItemIngot netheriteIngot = new NetheriteItemIngot(getNextItemID(), Materials.netherite);
    public static final ItemIngot netheriteNugget = new NetheriteItemNugget(getNextItemID(), Materials.netherite);

    public static final ItemHelmet netheriteHelmet = new NetheriteItemHelmet(getNextItemID(), Materials.netherite);
    public static final ItemCuirass netheriteChestplate = new NetheriteItemCuirass(getNextItemID(), Materials.netherite);
    public static final ItemLeggings netheriteLeggings = new NetheriteItemLeggings(getNextItemID(), Materials.netherite);
    public static final ItemBoots netheriteBoots = new NetheriteItemBoots(getNextItemID(), Materials.netherite);

    public static final ItemSword netheriteSword = new NetheriteItemSword(getNextItemID(), Materials.netherite);
    public static final ItemPickaxe netheritePickaxe = new NetheriteItemPickaxe(getNextItemID(), Materials.netherite);
    public static final ItemAxe netheriteAxe = new NetheriteItemAxe(getNextItemID(), Materials.netherite);
    public static final ItemShovel netheriteShovel = new NetheriteItemShovel(getNextItemID(), Materials.netherite);
    public static final ItemHoe netheriteHoe = new NetheriteItemHoe(getNextItemID(), Materials.netherite);

    public static final ItemBattleAxe netheriteBattleAxe = new NetheriteItemBattleAxe(getNextItemID(), Materials.netherite);
    public static final ItemWarHammer netheriteWarHammer = new NetheriteItemWarHammer(getNextItemID(), Materials.netherite);
    public static final ItemMattock netheriteMattock = new NetheriteItemMattock(getNextItemID(), Materials.netherite);
    public static final ItemScythe netheriteScythe = new NetheriteItemScythe(getNextItemID(), Materials.netherite);
    public static final ItemDagger netheriteDagger = new NetheriteItemDagger(getNextItemID(), Materials.netherite);
    public static final ItemHatchet netheriteHatchet = new NetheriteItemHatchet(getNextItemID(), Materials.netherite);
    public static final ItemShears netheriteShears = new NetheriteItemShears(getNextItemID(), Materials.netherite);

    public static final Item netheriteScrap = new NetheriteItem(getNextItemID(), Materials.netherite);
    public static final Item netheriteUpgradeTemplate = new NetheriteItem(getNextItemID(), Materials.netherite);

    private NetheriteItems() {
    }

    public static void registerItems(ItemRegistryEvent event) {
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:ingot/netherite_ingot", "netherite_ingot", netheriteIngot, FutureMITECreativeTabs.tabItem);
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:nugget/netherite_nugget", "netherite_nugget", netheriteNugget, FutureMITECreativeTabs.tabItem);

        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:armor/netherite_helmet", "netherite_helmet", netheriteHelmet, FutureMITECreativeTabs.tabItem);
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:armor/netherite_chestplate", "netherite_chestplate", netheriteChestplate, FutureMITECreativeTabs.tabItem);
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:armor/netherite_leggings", "netherite_leggings", netheriteLeggings, FutureMITECreativeTabs.tabItem);
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:armor/netherite_boots", "netherite_boots", netheriteBoots, FutureMITECreativeTabs.tabItem);

        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:tool/netherite_sword", "netherite_sword", netheriteSword, FutureMITECreativeTabs.tabItem);
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:tool/netherite_pickaxe", "netherite_pickaxe", netheritePickaxe, FutureMITECreativeTabs.tabItem);
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:tool/netherite_axe", "netherite_axe", netheriteAxe, FutureMITECreativeTabs.tabItem);
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:tool/netherite_shovel", "netherite_shovel", netheriteShovel, FutureMITECreativeTabs.tabItem);
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:tool/netherite_hoe", "netherite_hoe", netheriteHoe, FutureMITECreativeTabs.tabItem);

        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:tool/netherite_battle_axe", "netherite_battle_axe", netheriteBattleAxe, FutureMITECreativeTabs.tabItem);
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:tool/netherite_war_hammer", "netherite_war_hammer", netheriteWarHammer, FutureMITECreativeTabs.tabItem);
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:tool/netherite_mattock", "netherite_mattock", netheriteMattock, FutureMITECreativeTabs.tabItem);
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:tool/netherite_scythe", "netherite_scythe", netheriteScythe, FutureMITECreativeTabs.tabItem);
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:tool/netherite_dagger", "netherite_dagger", netheriteDagger, FutureMITECreativeTabs.tabItem);
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:tool/netherite_hatchet", "netherite_hatchet", netheriteHatchet, FutureMITECreativeTabs.tabItem);
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:tool/netherite_shears", "netherite_shears", netheriteShears, FutureMITECreativeTabs.tabItem);

        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:item/netherite_scrap", "netherite_scrap", netheriteScrap, FutureMITECreativeTabs.tabItem);
        event.register(FutureMITEStart.NameSpaceCompact, "futuremite:item/netherite_upgrade_smithing_template", "netherite_upgrade_smithing_template", netheriteUpgradeTemplate, FutureMITECreativeTabs.tabItem);
    }

    public static void registerRecipes(RecipeRegistryEvent register) {
        register.registerShapelessRecipe(new ItemStack(netheriteIngot, 1), true, new ItemStack(netheriteScrap, 4), new ItemStack(Item.ingotGold, 4));
        register.registerShapelessRecipe(new ItemStack(netheriteNugget, 9), true, netheriteIngot);
        register.registerShapedRecipe(new ItemStack(netheriteIngot, 1), true, "NNN", "NNN", "NNN", 'N', netheriteNugget);
        register.registerShapedRecipe(new ItemStack(netheriteUpgradeTemplate, 2), true, "DTD", "DND", "DDD", 'D', Item.diamond, 'T', netheriteUpgradeTemplate, 'N', Block.netherrack);
    }

    private static int getNextItemID() {
        return IdUtil.getNextItemID();
    }

    public static class NetheriteItem extends Item {
        protected NetheriteItem(int id, Material material) {
            super(id, String.valueOf(material));
        }
    }

    public static class NetheriteItemAxe extends ItemAxe {
        protected NetheriteItemAxe(int id, Material material) {
            super(id, material);
        }
    }

    public static class NetheriteItemShears extends ItemShears {
        protected NetheriteItemShears(int id, Material material) {
            super(id, material);
        }
    }

    public static class NetheriteItemHatchet extends ItemHatchet {
        protected NetheriteItemHatchet(int id, Material material) {
            super(id, material);
        }
    }

    public static class NetheriteItemDagger extends ItemDagger {
        protected NetheriteItemDagger(int id, Material material) {
            super(id, material);
        }
    }

    public static class NetheriteItemScythe extends ItemScythe {
        protected NetheriteItemScythe(int id, Material material) {
            super(id, material);
        }
    }

    public static class NetheriteItemMattock extends ItemMattock {
        protected NetheriteItemMattock(int id, Material material) {
            super(id, material);
        }
    }

    public static class NetheriteItemWarHammer extends ItemWarHammer {
        protected NetheriteItemWarHammer(int id, Material material) {
            super(id, material);
        }
    }

    public static class NetheriteItemBattleAxe extends ItemBattleAxe {
        protected NetheriteItemBattleAxe(int id, Material material) {
            super(id, material);
        }
    }

    public static class NetheriteItemHoe extends ItemHoe {
        protected NetheriteItemHoe(int id, Material material) {
            super(id, material);
        }
    }

    public static class NetheriteItemShovel extends ItemShovel {
        protected NetheriteItemShovel(int id, Material material) {
            super(id, material);
        }
    }

    public static class NetheriteItemPickaxe extends ItemPickaxe {
        protected NetheriteItemPickaxe(int id, Material material) {
            super(id, material);
        }
    }

    public static class NetheriteItemSword extends ItemSword {
        protected NetheriteItemSword(int id, Material material) {
            super(id, material);
        }
    }

    public static class NetheriteItemHelmet extends ItemHelmet {
        protected NetheriteItemHelmet(int id, Material material) {
            super(id, material, false);
        }
    }

    public static class NetheriteItemCuirass extends ItemCuirass {
        protected NetheriteItemCuirass(int id, Material material) {
            super(id, material, false);
        }
    }

    public static class NetheriteItemLeggings extends ItemLeggings {
        protected NetheriteItemLeggings(int id, Material material) {
            super(id, material, false);
        }
    }

    public static class NetheriteItemBoots extends ItemBoots {
        protected NetheriteItemBoots(int id, Material material) {
            super(id, material, false);
        }
    }

    public static class NetheriteItemIngot extends ItemIngot {
        protected NetheriteItemIngot(int id, Material material) {
            super(id, material);
        }
    }

    public static class NetheriteItemNugget extends ItemNugget {
        protected NetheriteItemNugget(int id, Material material) {
            super(id, material);
        }
    }
}
