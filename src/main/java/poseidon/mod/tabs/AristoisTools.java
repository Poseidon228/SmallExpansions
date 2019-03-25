package poseidon.mod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import poseidon.mod.init.ItemInit;

public class AristoisTools extends CreativeTabs {

	public AristoisTools(String label) {
		super(label);

	}
	
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.DIAMOND_MULTITOOL);
	}

	
}
