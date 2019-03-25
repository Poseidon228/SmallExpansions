package poseidon.mod.objects.items.general.usableitems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import poseidon.mod.client.commands.util.Heal;
import poseidon.mod.objects.items.general.ItemBase;

public class HealWart extends ItemBase {
	
	public HealWart(String name, int size) {
		super(name, size);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		
		Heal.healPlayer(playerIn, 2);
		stack.shrink(1);
		
		return new ActionResult(EnumActionResult.SUCCESS, stack);
		
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		if(entityIn != null && entityIn instanceof EntityPlayer) {
			
			EntityPlayer player = (EntityPlayer) entityIn;
			float health = player.getHealth();
			
			if(health < 5.0F) {
				
				stack.shrink(1);
				player.heal(5.0F);
				
			}
			
		}
		
	}
	
}
