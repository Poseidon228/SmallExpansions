package poseidon.mod.objects.block.modblocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import poseidon.mod.Main;
import poseidon.mod.init.BlockInit;
import poseidon.mod.init.ItemInit;
import poseidon.mod.util.interfaces.IHasModel;

public class ItemCustomDropped2 extends Block implements IHasModel {
	
	Random rn = new Random();
	
	int lootKind;
	int itemnumber;
	int lootChoice;
	
	private Item[] array;
	
	private int randomNumber;
	
	
	public ItemCustomDropped2(String name, Material material, float light, float hard, float res, int harvest, Item[] array) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.ARISTOISITEMS);
		
		setHarvestLevel("pickaxe", harvest);
		this.array = array;
		
		//Functions
		setLightLevel(light);
		setHardness(hard);
		setResistance(res);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		

	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
		int amount = array.length;
		getItemNumber(amount);
		
		
//		itemnumber = lootKind = lootChoice;
//		
		itemnumber = randomNumber;
		ItemStack giveItem = new ItemStack(array[itemnumber]);
		Item giveitem = giveItem.getItem();
		return giveitem;
		
		
	}
	
	
	private void getItemNumber(int amount) {
		int maximum = amount;
		int minimum = 1;
		
		int range = maximum - minimum + 1;
		
		randomNumber =  rn.nextInt(range) + minimum;
	}
	
	
	private void getNumber() {
		
		int maximum = 100;
		int minimum = 20;
		
		int range = maximum - minimum + 1;
		
		int randomNum =  rn.nextInt(range) + minimum;
		int randomNum2 =  rn.nextInt(range) + minimum;
		int randomNum3 =  rn.nextInt(range) + minimum;
		int randomNum4 =  rn.nextInt(range) + minimum;
		
		int rntotal = randomNum + randomNum3 + randomNum4;
		
		if(rntotal >= 240) {
				lootKind=12; /** Legendary */
			} else if(rntotal >= 200 && rntotal < 240) {
				lootKind=9; /** Epic */
			} else if(rntotal >= 140 && rntotal < 200) {
				lootKind=6; /** Rare */
			} else if(rntotal >= 90 && rntotal < 140) {
				lootKind=4; /** UnCommon */
			} else if(rntotal < 90) {
				lootKind=0; /** Common */
		}
		
		if(randomNum4 >= 66) {
			lootChoice = 3;
		} else if(randomNum4 >= 33) {
			lootChoice = 1;
		} else {
			lootChoice = 2;
	}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

