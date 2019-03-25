package poseidon.mod.objects.items.general.throwable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import poseidon.mod.objects.entities.LightningEgg;
import poseidon.mod.objects.items.general.ItemBase;

public class PowGunpowder extends ItemBase {
	
	public PowGunpowder(String name, int size) {
		super(name, size);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		
		if (!worldIn.isRemote)
        {
            LightningEgg entityegg = new LightningEgg(worldIn, playerIn);
            entityegg.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 0.0F);
            worldIn.spawnEntity(entityegg);
        }
		
		
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
}
