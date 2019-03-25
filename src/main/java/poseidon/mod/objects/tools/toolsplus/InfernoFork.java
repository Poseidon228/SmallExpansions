package poseidon.mod.objects.tools.toolsplus;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import poseidon.mod.init.ItemInit;
import poseidon.mod.objects.items.wand.WandAbility;
import poseidon.mod.objects.tools.ToolSword;

public class InfernoFork extends ToolSword {

	public InfernoFork(String name, int size) {
		super(name, ItemInit.INFERNO);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack held = playerIn.getHeldItem(handIn);
		ItemStack ammo = new ItemStack(ItemInit.CHARGED_FIREBALL);
		ItemStack ammo2 = new ItemStack(Items.FIRE_CHARGE);
		ItemStack ammo3 = new ItemStack(Items.GUNPOWDER);
		
		int slot1 = playerIn.inventory.getSlotFor(ammo);
		int slot2 = playerIn.inventory.getSlotFor(ammo2);
		int slot3 = playerIn.inventory.getSlotFor(ammo3);
		

		
		for(int i = 0; i < 36; i ++) {
			ItemStack check = playerIn.inventory.getStackInSlot(i);
			if(check.getItem() == ammo.getItem()) {
				useAmmo1(playerIn, worldIn, held, ammo);
				return new ActionResult(EnumActionResult.SUCCESS, held);
			}
			if(check.getItem() == ammo2.getItem()) {
				useAmmo2(playerIn, worldIn, held, ammo2);
				return new ActionResult(EnumActionResult.SUCCESS, held);
			}
			if(check.getItem() == ammo3.getItem()) {
				useAmmo3(playerIn, worldIn, held, ammo3);
				return new ActionResult(EnumActionResult.SUCCESS, held);
			}
		}
		
		return new ActionResult(EnumActionResult.SUCCESS, held);
	}
		
	private void useAmmo1(EntityPlayer playerIn, World worldIn, ItemStack held, ItemStack ammo) {
		WandAbility.fire2(10, playerIn, worldIn);
		held.damageItem(1, playerIn);
		int slot = playerIn.inventory.getSlotFor(ammo);
		playerIn.inventory.getStackInSlot(slot).shrink(1);
	}
	
	private void useAmmo2(EntityPlayer playerIn, World worldIn, ItemStack held, ItemStack ammo2) {
		WandAbility.fire2(3, playerIn, worldIn);
		held.damageItem(1, playerIn);
		int slot = playerIn.inventory.getSlotFor(ammo2);
		playerIn.inventory.getStackInSlot(slot).shrink(1);
	}
	
	private void useAmmo3(EntityPlayer playerIn, World worldIn, ItemStack held, ItemStack ammo3) {
		WandAbility.explosion(3.0F, playerIn, worldIn);
		held.damageItem(1, playerIn);
		int slot = playerIn.inventory.getSlotFor(ammo3);
		playerIn.inventory.getStackInSlot(slot).shrink(1);
	}
}
