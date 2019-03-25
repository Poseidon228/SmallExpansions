package poseidon.mod.objects.tools;

import net.minecraft.item.ItemSword;
import poseidon.mod.Main;
import poseidon.mod.init.ItemInit;
import poseidon.mod.util.interfaces.IHasModel;

public class ToolSword extends ItemSword implements IHasModel {
	
	public ToolSword(String name, ToolMaterial Material) {
		super(Material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setMaxStackSize(1);
		ItemInit.ITEMS.add(this);
		setCreativeTab(Main.ARISTOISITEMS);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this,  0, "inventory");
	}


	
	
}
