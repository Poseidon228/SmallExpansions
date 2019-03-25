package poseidon.mod.objects.items.general.finisheditems;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import poseidon.mod.objects.items.general.ItemBase;
import poseidon.mod.util.handlers.SoundsHandler;

public class ItemTeleport extends ItemBase {

	public ItemTeleport(String name, int size) {
		super(name, 64);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		RayTraceResult pos = playerIn.rayTrace(100,20);
		Random rand = new Random();
		double x = pos.getBlockPos().getX();
		double y = pos.getBlockPos().getY() + 1;
		double z = pos.getBlockPos().getZ();
		playerIn.setPosition(x, y, z);
		playerIn.serverPosX = (long) x;
		playerIn.serverPosY = (long) y;
		playerIn.serverPosZ = (long) z;
	
		worldIn.playSound((EntityPlayer)null, x, y, z, SoundsHandler.TELEPORT, SoundCategory.AMBIENT, 1.0F, 1.0F);
	
		for (int i = 0; i < 1000; ++i)
	    {
			double d0 = rand.nextGaussian() * 0.02D;
	    	double d1 = rand.nextGaussian() * 0.02D;
	    	double d2 = rand.nextGaussian() * 0.02D;
	    	double d3 = 10.0D;
	    	
	    	worldIn.spawnParticle(EnumParticleTypes.PORTAL, x + (double)(rand.nextFloat() * playerIn.width * 2.0F) - (double)playerIn.width - d0 * 10.0D, y + (double)(rand.nextFloat() * (playerIn.height - 2.4D)) - d1 * 10.0D, z + (double)rand.nextFloat() * playerIn.width * 2.0F - (double)playerIn.width - d2 * 10.0D, d0, d1, d2);
			worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, x + (double)(rand.nextFloat() * playerIn.width * 2.0F) - (double)playerIn.width - d0 * 10.0D, y + (double)(rand.nextFloat() * (playerIn.height - 1.2D)) - d1 * 10.0D, z + (double)rand.nextFloat() * playerIn.width * 2.0F - (double)playerIn.width - d2 * 10.0D, d0, d1, d2);
	    }
		
		ItemStack heldStack = playerIn.getHeldItem(handIn);
		playerIn.getCooldownTracker().setCooldown(heldStack.getItem(), 20);
		heldStack.shrink(1);
		
		return new ActionResult(EnumActionResult.SUCCESS, heldStack);
	}
	
}
