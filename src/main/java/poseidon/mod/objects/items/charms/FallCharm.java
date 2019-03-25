package poseidon.mod.objects.items.charms;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;
import poseidon.mod.Main;
import poseidon.mod.objects.tools.ToolHoe;

public class FallCharm extends ToolHoe {

	public FallCharm(String name, ToolMaterial tool) {
		super(name, tool);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

		if(entityIn != null && entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityIn;

			if(player.getHeldItemMainhand().getItem() == stack.getItem() || player.getHeldItemOffhand().getItem() == stack.getItem()) {
				
				Main.proxy.generateCharmParticleFall(player);
				
			}
		}
		
	}
	
}
