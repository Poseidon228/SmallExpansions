package poseidon.mod.objects.items;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import poseidon.mod.init.ItemInit;

public class RecipeHandler {
	
	public static void registerCrafting() {
						
		GameRegistry.addShapedRecipe(new ResourceLocation("psm:projectile_charm"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.PROJECTILE_CHARM), 
				new Object[] {"SIS", "IOI", "SIS", 'I', Items.DIAMOND, 'O', Items.ARROW, 'S', Item.getItemFromBlock(Blocks.STONE)});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("psm:stasis"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.DEPTH_STRIDER_CHARM), 
				new Object[] {"SIS", "IOI", "SIS", 'I', Items.DIAMOND, 'O', Items.GOLDEN_CARROT, 'S', Item.getItemFromBlock(Blocks.STONE)});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("psm:stasis"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.FALL_CHARM), 
				new Object[] {"SIS", "IOI", "SIS", 'I', Items.DIAMOND, 'O', Items.RABBIT_FOOT, 'S', Item.getItemFromBlock(Blocks.STONE)});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("psm:stasis"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.FIRE_PROTECTION_CHARM), 
				new Object[] {"SIS", "IOI", "SIS", 'I', Items.DIAMOND, 'O', Items.MAGMA_CREAM, 'S', Item.getItemFromBlock(Blocks.STONE)});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("psm:stasis"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.STASIS), 
				new Object[] {" I ", "IOI", " I ", 'I', Items.DIAMOND, 'O', Items.ENDER_EYE});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("psm:teleport_component"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.TELEPORT_COMPONENT), 
				new Object[]{"EIE", "IBI", "EIE", 'I', Items.DIAMOND, 'E', Items.ENDER_PEARL, 'B', Items.BLAZE_POWDER});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("psm:flyessence"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.FLY_ESSENCE), 
				new Object[]{"PGP", "DTD", "PGP", 'P', Items.DIAMOND, 'G', Items.GLOWSTONE_DUST, 'D', Items.EMERALD, 'T', Items.FEATHER});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("psm:chargedfireball"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.CHARGED_FIREBALL), 
				new Object[]{"PGP", "DTD", "PGP", 'P', Items.DIAMOND, 'G', Items.GUNPOWDER, 'D', Items.EMERALD, 'T', Item.getItemFromBlock(Blocks.TNT)});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("psm:velocity_changer"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.VELOCITYCHANGER),
				new Object[] {"DFD", " E ", " E ", 'D', Items.GOLD_INGOT, 'F', ItemInit.WING, 'E', Items.STICK});
				
		GameRegistry.addShapelessRecipe(new ResourceLocation("psm:empowered_gunpowder"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.EMPOWERED_GUNPOWDER),
				new Ingredient[] {Ingredient.fromItem(Items.GUNPOWDER), Ingredient.fromItem(Items.GLOWSTONE_DUST), Ingredient.fromItem(Items.REDSTONE)});
				
		GameRegistry.addShapelessRecipe(new ResourceLocation("psm:elytron_dust"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.ELYTRON_DUST, 4),
				new Ingredient[] {Ingredient.fromItem(Items.QUARTZ), Ingredient.fromItem(Items.FEATHER), Ingredient.fromItem(Items.BLAZE_POWDER)});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("psm:rift_pearl"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.RIFT), 
				new Object[] {"EHE", "HTH", "EHE", 'E', Items.ENDER_EYE, 'T', ItemInit.TELEPORT_COMPONENT, 'H', ItemInit.FLY_ESSENCE});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("psm:waypoint"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.WAYPOINT), 
				new Object[] {"DTD", " S ", " E ", 'E', Items.DIAMOND, 'D', ItemInit.FLY_ESSENCE, 'T', ItemInit.TELEPORT_COMPONENT, 'S', Items.STICK});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("psm:inferno_rod"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.INFERNO_FORK),
				new Object[] {"DFD", " B ", " E ", 'D', ItemInit.EMPOWERED_GUNPOWDER, 'F', Items.FIRE_CHARGE, 'B', Items.BLAZE_ROD, 'E', Items.DIAMOND});

		GameRegistry.addShapedRecipe(new ResourceLocation("psm:fall_charm"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.FALL_CHARM),
				new Object[] {"DF ", "   ", "   ", 'D', Items.REDSTONE, 'F', Items.STICK});

		GameRegistry.addShapelessRecipe(new ResourceLocation("psm:projectile_shield"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.PROJECTILE_SHIELD, 4), 
				new Ingredient[] {Ingredient.fromItem(Items.PAPER), Ingredient.fromItem(Items.IRON_INGOT), Ingredient.fromItem(Items.FLINT)});
		
		GameRegistry.addShapelessRecipe(new ResourceLocation("psm:bouncers"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.BOUNCERS, 4), 
				new Ingredient[] {Ingredient.fromItem(Items.PAPER), Ingredient.fromItem(Items.FEATHER), Ingredient.fromItem(Items.RABBIT_FOOT)});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("psm:bundle_of_feathers"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.BUNDLE_FEATHER),
				new Object[] {"DDD", "DDD", "DDD", 'D', Items.FEATHER});

		GameRegistry.addShapedRecipe(new ResourceLocation("psm:wing"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.WING),
				new Object[] {"FGF", "QEQ", "FGF", 'G', ItemInit.BUNDLE_FEATHER, 'F', ItemInit.FLY_ESSENCE, 'Q', Items.QUARTZ, 'E', Items.ENDER_EYE});

		GameRegistry.addShapedRecipe(new ResourceLocation("psm:concentrated_nether_wart"), new ResourceLocation("psm:supernatural_items"), new ItemStack(ItemInit.CONCENTRATED_NETHER_WART),
				new Object [] {"NNN", "GGG", " P ", 'N', Items.NETHER_WART, 'G', Items.GLOWSTONE_DUST, 'P', Items.GLASS_BOTTLE});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("psm:experience_spawner"), new ResourceLocation("psm:supernatural_itesm"), new ItemStack(ItemInit.EXPERIENCE_SPAWNER),
				new Object[] {"GOG", "DID", "GOG", 'O', ItemInit.OBSIDIAN_INGOT, 'G', Items.GLOWSTONE_DUST, 'D', Items.DIAMOND, 'I', Items.FIREWORK_CHARGE});
		
		//parts

		registerToolCrafting(ItemInit.OBSIDIAN_PICKAXE, ItemInit.OBSIDIAN_AXE, ItemInit.OBSIDIAN_SPADE, ItemInit.OBSIDIAN_HOE, ItemInit.OBSIDIAN_SWORD,
							 ItemInit.EMERALD_PICKAXE, ItemInit.EMERALD_AXE, ItemInit.EMERALD_SPADE, ItemInit.EMERALD_HOE, ItemInit.EMERALD_SWORD,
							 ItemInit.DIAMOND_MULTITOOL, ItemInit.GOLD_MULTITOOL, ItemInit.IRON_MULTITOOL, ItemInit.WOOD_MULTITOOL, ItemInit.STONE_MULTITOOL, 
							 ItemInit.OBSIDIAN_MULTITOOL, ItemInit.EMERALD_MULTITOOL
							 );
		
		registerArmourCrafting();
	}
	
	public static void registerSmelting() {

		GameRegistry.addSmelting(Blocks.OBSIDIAN, new ItemStack(ItemInit.OBSIDIAN_INGOT), 2.0F);
	}

	private static void registerToolCrafting(
		               	   	  	 	 	     Item obsidianpick, Item obsidianaxe, Item obsidianspade, Item obsidianhoe, Item obsidiansword,
											 Item emeraldpick, Item emeraldaxe, Item emeraldspade, Item emeraldhoe, Item emeraldsword,
											 Item diamondmult, Item goldmult, Item ironmult, Item woodmult, Item stonemult, Item obsmult, Item ememult
											 ) {
		
		GameRegistry.addShapedRecipe(new ResourceLocation("" + diamondmult.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(diamondmult), 
				new Object[]{"XXX", "XIX", "XIX", 'X', Items.DIAMOND, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + goldmult.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(goldmult), 
				new Object[]{"XXX", "XIX", "XIX", 'X', Items.GOLD_INGOT, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + ironmult.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(ironmult), 
				new Object[]{"XXX", "XIX", "XIX", 'X', Items.IRON_INGOT, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + woodmult.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(woodmult), 
				new Object[]{"XXX", "XIX", "XIX", 'X', Item.getItemFromBlock(Blocks.PLANKS), 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + stonemult.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(stonemult), 
				new Object[]{"XXX", "XIX", "XIX", 'X', Item.getItemFromBlock(Blocks.COBBLESTONE), 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + obsmult.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(obsmult), 
				new Object[]{"XXX", "XIX", "XIX", 'X', ItemInit.OBSIDIAN_INGOT, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + ememult.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(ememult), 
				new Object[]{"XXX", "XIX", "XIX", 'X', Items.EMERALD, 'I', Items.STICK});

		GameRegistry.addShapedRecipe(new ResourceLocation("" + obsidianpick.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(obsidianpick), 
				new Object[]{"XXX", " I ", " I ", 'X', ItemInit.OBSIDIAN_INGOT, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + obsidianaxe.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(obsidianaxe), 
				new Object[]{" XX", " IX", " I ", 'X', ItemInit.OBSIDIAN_INGOT, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + obsidianspade.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(obsidianspade), 
				new Object[]{" X ", " I ", " I ", 'X', ItemInit.OBSIDIAN_INGOT, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + obsidianhoe.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(obsidianhoe),
				new Object[]{" XX", " I ", " I ", 'X', ItemInit.OBSIDIAN_INGOT, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + obsidiansword.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(obsidiansword),
				new Object[]{" X ", " X ", " I ", 'X', ItemInit.OBSIDIAN_INGOT, 'I', Items.STICK});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("" + emeraldpick.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(emeraldpick), 
				new Object[]{"XXX", " I ", " I ", 'X', Items.EMERALD, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + emeraldaxe.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(emeraldaxe), 
				new Object[]{" XX", " IX", " I ", 'X', Items.EMERALD, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + emeraldspade.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(emeraldspade), 
				new Object[]{" X ", " I ", " I ", 'X', Items.EMERALD, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + emeraldhoe.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(emeraldhoe),
				new Object[]{" XX", " I ", " I ", 'X', Items.EMERALD, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + emeraldsword.getRegistryName()), new ResourceLocation("psm:aristois_tools"), new ItemStack(emeraldsword),
				new Object[]{" X ", " X ", " I ", 'X', Items.EMERALD, 'I', Items.STICK});
		
		
	}
	
	private static void registerArmourCrafting(){


		
	}
	
	
}
