package poseidon.mod.objects.items.general.finisheditems;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;
import poseidon.mod.objects.items.general.ItemBase;
import poseidon.mod.util.handlers.SoundsHandler;

public class Stasis extends ItemBase {

	NBTTagCompound nbt;
	static World world;
	
	public Stasis(String name, int size) {
		super(name, size);
	}
	
//	@Override
//	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
//		EntityPlayer entity = (EntityPlayer) entityIn;
//		World world = entity.getEntityWorld();
//	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		player.playSound(SoundsHandler.STASIS, 2.0F, 1.0F);
		worldIn.playSound(player, pos, SoundsHandler.STASIS, SoundCategory.AMBIENT, 1.0F, 1.0F);
		return EnumActionResult.SUCCESS;
	}
	
	public static void playSound(EntityPlayer player) {
		
		getWorld(player);
		//if(!world.isRemote) {
			world.playSound(player.posX, player.posY, player.posZ, SoundsHandler.STASIS, SoundCategory.AMBIENT, 2.0F, 2.0F, true);
		//}
		
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(entityIn != null && entityIn instanceof EntityPlayer) {
			EntityPlayer playerIn = (EntityPlayer) entityIn;
			double x = playerIn.posX;
			double y = playerIn.posY;
			double z = playerIn.posZ;
			if(stack.hasTagCompound()) {
				if(stack.getTagCompound().getBoolean("Activated") == true) {
					worldIn.playSound(playerIn, x, y, z, SoundsHandler.STASIS, SoundCategory.AMBIENT, 1.0F, 1.0F);
				}
			}
		}
	}
	
	private static void getWorld(EntityPlayer player) {
		world = player.world;
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		//getNBT(stack);
		worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundsHandler.MARAUDER, SoundCategory.AMBIENT, 1.0F, 1.0F);
	}
	
	private void getNBT(ItemStack stack) {
		if(stack.hasTagCompound()) {
			nbt = stack.getTagCompound();
			} else {
			nbt = new NBTTagCompound();
		} //Gets The compound which holds keys!
		if(nbt.hasKey("Activated")) {
			nbt.setBoolean("Activated", nbt.getBoolean("Activated"));
			} else {
			nbt.setBoolean("Activated", false);
		}
		stack.setTagCompound(nbt);
	}
	
	
	
}
