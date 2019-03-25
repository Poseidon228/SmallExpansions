package poseidon.mod.objects.block.modblocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import poseidon.mod.Main;
import poseidon.mod.init.BlockInit;
import poseidon.mod.init.ItemInit;
import poseidon.mod.util.interfaces.IHasModel;

public class ItemCustomDropped extends Block implements IHasModel {
	
	Random rn = new Random();
	
	int lootKind;
	int itemnumber;
	int lootChoice;
	
	private Item item1;
	private Item item2;
	private Item item3;
	private Item item4;
	private Item item5;
	private Item item6;
	private Item item7;
	private Item item8;
	private Item item9;
	private Item item10;
	private Item item11;
	private Item item12;
	private Item item13;
	private Item item14;
	private Item item15;
	
	private int randomNumber;
	
	
	public ItemCustomDropped(String name, Material material, float light, float hard, float res, int harvest
						,Item item1c, Item item2c, Item item3c, Item item4c, Item item5c, Item item6c, Item item7c, Item item8c, Item item9c, Item item10c, Item item11c, Item item12c, Item item13c, Item item14c, Item item15c) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.ARISTOISITEMS);
		
		setHarvestLevel("pickaxe", harvest);
		
		//Functions
		setLightLevel(light);
		setHardness(hard);
		setResistance(res);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
		this.item2 = item2c;
		this.item1 = item1c;
		this.item3 = item3c;
		this.item4 = item4c;
		this.item5 = item5c;
		this.item6 = item6c;
		this.item7 = item7c;
		this.item8 = item8c;
		this.item9 = item9c;
		this.item10 = item10c;
		this.item11 = item11c;
		this.item12 = item12c;
		this.item13 = item13c;
		this.item14 = item14c;
		this.item15 = item15c;

	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
		
		Item[] items = new Item[]{item1, item2, item3, item4, item6, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15}; //Setting LootArray
		getItemNumber();
		
		
//		itemnumber = lootKind = lootChoice;
//		
		itemnumber = randomNumber;
		ItemStack giveItem = new ItemStack(items[itemnumber]);
		Item giveitem = giveItem.getItem();
		
		return giveitem;
		
		
	}
	
	
	private void getItemNumber() {
		int maximum = 15;
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
