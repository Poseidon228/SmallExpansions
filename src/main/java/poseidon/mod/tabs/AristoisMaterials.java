package poseidon.mod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import poseidon.mod.init.ItemInit;

public class AristoisMaterials extends CreativeTabs {

	public AristoisMaterials(String label) {
		super(label);

	}
	
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.OBSIDIAN_INGOT);
	}
	
}
