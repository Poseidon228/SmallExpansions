package poseidon.mod.objects.items.charms;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import poseidon.mod.Main;
import poseidon.mod.init.ItemInit;
import poseidon.mod.objects.tools.ToolHoe;

public class FireCharm extends ToolHoe {
	
	public FireCharm(String name, ToolMaterial tool) {
		super(name, tool);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		
		return new ActionResult(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
	}
	
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

		if(entityIn != null && entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityIn;

			if(player.getHeldItemMainhand().getItem() == stack.getItem() || player.getHeldItemOffhand().getItem() == stack.getItem()) {
				
				Main.proxy.generateCharmParticleFire(player);
				
			}
			
			if(stack.getItem() == ItemInit.FIRE_PROTECTION_CHARM) {
				if(player.isInLava()) {
					player.setHealth(player.getHealth() + 2.0F);
					stack.damageItem(1, player);
				}
			}
		}
		
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

		tooltip.add(TextFormatting.WHITE + "Provides immunity to lava & fire");
		
	}
	
}
