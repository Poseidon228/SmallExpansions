package poseidon.mod.objects.items.general.test;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import poseidon.mod.objects.items.general.ItemBase;
import poseidon.mod.objects.items.wand.WandAbility;

public class SpellTest extends ItemBase {

	public SpellTest(String name, int size) {
		super(name, size);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		ItemStack stack = playerIn.getHeldItem(handIn);
		
		int slot = playerIn.inventory.getSlotFor(stack);
		System.out.println(slot);
		
		if(slot == 0) { WandAbility.wind(1, playerIn, worldIn);}
		if(slot == 1) { WandAbility.wind2(1, playerIn, worldIn); }
		if(slot == 2) { WandAbility.earth(1, playerIn, worldIn); }
		if(slot == 3) { WandAbility.earth2(1, playerIn, worldIn); }
		if(slot == 4) { WandAbility.explosion(1, playerIn, worldIn); }
		if(slot == 5) { WandAbility.inferno(1, playerIn, worldIn); }
		if(slot == 6) { WandAbility.inferno2(1, playerIn, worldIn); }
		if(slot == 7) { WandAbility.fire(1, playerIn, worldIn); }
		if(slot == 8) { WandAbility.fire2(1,playerIn, worldIn); }
		
		
		return new ActionResult(EnumActionResult.SUCCESS, stack);
	}
	
}
