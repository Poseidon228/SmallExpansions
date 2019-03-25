package poseidon.mod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import poseidon.mod.objects.items.charms.DepthCharm;
import poseidon.mod.objects.items.charms.FireCharm;
import poseidon.mod.objects.items.charms.GlideCharm;
import poseidon.mod.objects.items.charms.ProjCharm;
import poseidon.mod.objects.items.general.ItemBase;
import poseidon.mod.objects.items.general.ItemEffect;
import poseidon.mod.objects.items.general.ItemMaterial;
import poseidon.mod.objects.items.general.ItemSpawn;
import poseidon.mod.objects.items.general.finisheditems.FlyStaff;
import poseidon.mod.objects.items.general.finisheditems.ItemTeleport;
import poseidon.mod.objects.items.general.finisheditems.Stasis;
import poseidon.mod.objects.items.general.finisheditems.WayPoint;
import poseidon.mod.objects.items.general.test.ProjectTileShield;
import poseidon.mod.objects.items.general.usableitems.HealWart;
import poseidon.mod.objects.items.general.usableitems.Rift;
import poseidon.mod.objects.tools.Multi;
import poseidon.mod.objects.tools.ToolAxe;
import poseidon.mod.objects.tools.ToolHoe;
import poseidon.mod.objects.tools.ToolPickaxe;
import poseidon.mod.objects.tools.ToolSpade;
import poseidon.mod.objects.tools.ToolSword;
import poseidon.mod.objects.tools.toolsplus.InfernoFork;
import poseidon.mod.util.Reference;

public class ItemInit {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	/*
	 *  WOOD(0, 59, 2.0F, 0.0F, 15),
     *  STONE(1, 131, 4.0F, 1.0F, 5),
     *  IRON(2, 250, 6.0F, 2.0F, 14),
     *  DIAMOND(3, 1561, 8.0F, 3.0F, 10),
     *  GOLD(0, 32, 12.0F, 0.0F, 22);
	 */
	
	//Materials		(name, harvest, uses, eff, damage, enchant)
	public static final ToolMaterial VELOCITY = EnumHelper.addToolMaterial("velocity", 1, 100, 2.0F, 1.0F, 20);
	
	public static final ToolMaterial FIRECHARM = EnumHelper.addToolMaterial("firecharm", 0, 2000, 0.0F, 0.0F, 0);
	public static final ToolMaterial FALLCHARM = EnumHelper.addToolMaterial("fallcharm", 0, 10, 0.0F, 0.0F, 0);
	public static final ToolMaterial DEPTCHARM = EnumHelper.addToolMaterial("deptcharm", 0, 1000, 0.0F, 0.0F, 0);
	public static final ToolMaterial PROJCHARM = EnumHelper.addToolMaterial("projcharm", 0, 100, 0.0F, 0.0F, 0);
	public static final ToolMaterial FLIDCHARM = EnumHelper.addToolMaterial("glidcharm", 0, 500, 0.0F, 0.0F, 0);
	
	public static final ToolMaterial OBSIDIAN_TOOL = EnumHelper.addToolMaterial("obsidian_tool", 2, 890, 6.0F, 2.0F, 10);
	public static final ToolMaterial DRILL = EnumHelper.addToolMaterial("drill", 2, 900, 6.0F, 2.0F, 4);
	public static final ToolMaterial EMERALD = EnumHelper.addToolMaterial("emerald", 3, 1200, 7.0F, 4.0F, 12);
	public static final ToolMaterial INFERNO = EnumHelper.addToolMaterial("inferno", 0, 90, 1.0F, 1.0F, 10);
	public static final ToolMaterial CREATIVE_TOOLM = EnumHelper.addToolMaterial("creative", 3, 999999999, 9999999999999.0F, 999999999.0F, 24);
	
	//Multi Tools																	(name, harvest, uses, eff, damage, enchant)
		public static final ToolMaterial WOOD_MULTI = EnumHelper.addToolMaterial("wood_multi", 0, 178, 2.0F, 0.0F, 15);
		public static final ToolMaterial STONE_MULTI = EnumHelper.addToolMaterial("stone_multi", 1, 392, 4.0F, 1.0F, 5);
		public static final ToolMaterial IRON_MULTI = EnumHelper.addToolMaterial("iron_multi", 2, 734, 6.0F, 2.0F, 14);
		public static final ToolMaterial GOLD_MULTI = EnumHelper.addToolMaterial("gold_multi", 0, 120, 12.0F, 0.0F, 22);
		public static final ToolMaterial DIAMOND_MULTI = EnumHelper.addToolMaterial("diamond_multi", 3, 4623, 8.0F, 3.0F, 10);
		public static final ToolMaterial OBSIDIAN_MULTI = EnumHelper.addToolMaterial("obsidian_multi", 2, 2670, 6.0F, 2.0F, 10);
		public static final ToolMaterial EMERALD_MULTI = EnumHelper.addToolMaterial("emerald_multitool", 3, 3560, 13.0F, 4.0F, 12);
		
	public static final ArmorMaterial COPPER_ARMOUR = EnumHelper.addArmorMaterial("copper_armour", Reference.MODID + ":copper", 15, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F);	


	//Tools
	public static final Item WOOD_MULTITOOL = new Multi("wood_multitool", WOOD_MULTI);
	public static final Item STONE_MULTITOOL = new Multi("stone_multitool", STONE_MULTI);
	public static final Item IRON_MULTITOOL = new Multi("iron_multitool", IRON_MULTI);
	public static final Item GOLD_MULTITOOL = new Multi("gold_multitool", GOLD_MULTI);
	public static final Item DIAMOND_MULTITOOL = new Multi("diamond_multitool", DIAMOND_MULTI);
	
	public static final Item OBSIDIAN_MULTITOOL = new Multi("obsidian_multitool", OBSIDIAN_MULTI);
	public static final Item EMERALD_MULTITOOL = new Multi("emerald_multitool", EMERALD_MULTI);
	
	public static final Item OBSIDIAN_SWORD = new ToolSword("obsidian_sword", OBSIDIAN_TOOL);
	public static final Item OBSIDIAN_PICKAXE = new ToolPickaxe("obsidian_pickaxe", OBSIDIAN_TOOL);	
	public static final Item OBSIDIAN_AXE = new ToolAxe("obsidian_axe", OBSIDIAN_TOOL);
	public static final Item OBSIDIAN_SPADE = new ToolSpade("obsidian_spade", OBSIDIAN_TOOL);
	public static final Item OBSIDIAN_HOE = new ToolHoe("obsidian_hoe", OBSIDIAN_TOOL);
	
	public static final Item EMERALD_SWORD = new ToolSword("emerald_sword", EMERALD);
	public static final Item EMERALD_PICKAXE = new ToolPickaxe("emerald_pickaxe", EMERALD);
	public static final Item EMERALD_AXE = new ToolAxe("emerald_axe", EMERALD);
	public static final Item EMERALD_SPADE = new ToolSpade("emerald_spade", EMERALD);
	public static final Item EMERALD_HOE = new ToolHoe("emerald_hoe", EMERALD);
	
	public static final Item WAYPOINT = new WayPoint("checkpoint_marker", 1);
	public static final Item INFERNO_FORK = new InfernoFork("inferno_rod", 1);
	public static final Item VELOCITYCHANGER = new FlyStaff("velocity_changer");
	public static final Item STASIS = new Stasis("stasis", 16);
	public static final Item RIFT = new Rift("rift_pearl");
	
	public static final Item CONCENTRATED_NETHER_WART = new HealWart("concentrated_nether_wart", 64);

	
	public static final Item EMPOWERED_GUNPOWDER = new ItemEffect("empowered_gunpowder", 64);
	public static final Item CHARGED_FIREBALL = new ItemBase("charged_fireball", 64);
	
	public static final Item ELYTRON_DUST = new ItemBase("elytron_dust", 64);
	public static final Item FLY_ESSENCE = new ItemEffect("fly_essence", 64);
	
	public static final Item OBSIDIAN_INGOT = new ItemMaterial("obsidian_ingot", 64);
	public static final Item TELEPORT_COMPONENT = new ItemTeleport("ender_power", 1);

	public static final Item FIRE_PROTECTION_CHARM = new FireCharm("fire_protection_charm", FIRECHARM);
	public static final Item PROJECTILE_CHARM = new ProjCharm("projectile_protection_charm", PROJCHARM);
	public static final Item DEPTH_STRIDER_CHARM = new DepthCharm("depth_strider_charm", DEPTCHARM);
	public static final Item FALL_CHARM = new GlideCharm("slowfall_charm", FIRECHARM);
	
	public static final Item PROJECTILE_SHIELD = new ProjectTileShield("projectile_shield", 64);
	public static final Item BOUNCERS = new ItemBase("bouncers", 64);
	public static final Item WING = new ItemBase("wing", 64);
	public static final Item BUNDLE_FEATHER = new ItemBase("bundle_of_feathers", 64);
	public static final Item EXPERIENCE_SPAWNER = new ItemSpawn("experience_spawner", 64);
	
	
}
