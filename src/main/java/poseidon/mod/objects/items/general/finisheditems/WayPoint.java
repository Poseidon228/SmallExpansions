package poseidon.mod.objects.items.general.finisheditems;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import poseidon.mod.init.ItemInit;
import poseidon.mod.objects.tools.ToolSword;
import poseidon.mod.util.handlers.SoundsHandler;

public class WayPoint extends ToolSword {

	int durabilitystack;
	NBTTagCompound nbt;
	private boolean isActive = false;
	
	public WayPoint(String name, int size) {
		super(name, ItemInit.VELOCITY);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		double x = pos.getX();
		double y = pos.getY();
		double z = pos.getZ();
		
		player.sendStatusMessage(new TextComponentTranslation(TextFormatting.BLUE + "Position " + TextFormatting.RESET + 
																TextFormatting.DARK_BLUE + "[ " + TextFormatting.RESET +
																TextFormatting.GOLD + "X" + TextFormatting.RESET +
																TextFormatting.WHITE + ":" + TextFormatting.RESET + 
																TextFormatting.YELLOW + x + TextFormatting.RESET +
																TextFormatting.GRAY + "," + TextFormatting.RESET +
																TextFormatting.GOLD + "Y" + TextFormatting.RESET +
																TextFormatting.WHITE + ":" + TextFormatting.RESET +
																TextFormatting.YELLOW + y + TextFormatting.RESET +
																TextFormatting.GRAY + "," + TextFormatting.RESET +
																TextFormatting.GOLD + "Z" + TextFormatting.RESET + 
																TextFormatting.WHITE + ":" + TextFormatting.RESET + 
																TextFormatting.YELLOW + z + TextFormatting.RESET +
																TextFormatting.DARK_BLUE + " ]", new Object[0]), true
		);

	
		
		ItemStack stack = player.getHeldItem(hand);
		if(!stack.hasTagCompound()) {
			getNBT(stack);
			} else {
			stack.getTagCompound().setDouble("Coordinatesx", x);
			stack.getTagCompound().setDouble("Coordinatesy", y);
			stack.getTagCompound().setDouble("Coordinatesz", z);
		}
		
		
		return EnumActionResult.SUCCESS;
	}
	
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		
		if(target != null && target instanceof EntityPlayer) {
			EntityPlayer playerIn = (EntityPlayer) target;
			
			double one = stack.getTagCompound().getDouble("Coordinatesx");
			double two = stack.getTagCompound().getDouble("Coordinatesy");
			double tre = stack.getTagCompound().getDouble("Coordinatesz");
				
			BlockPos pos = new BlockPos(one, two, tre);
				
			double x = pos.getX();
			double y = pos.getY() + 1;
			double z = pos.getZ();
			//playerIn.setPosition(x, y, z);
			playerIn.attemptTeleport(x, y, z);
			playerIn.serverPosX = (long) x;
			playerIn.serverPosY = (long) y;
			playerIn.serverPosZ = (long) z;
			
			playerIn.playSound(SoundsHandler.CHECKPOINT, 1.0F, 1.0F);
			
			return false;
		}
		
		return true;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		
				
		
					double one = stack.getTagCompound().getDouble("Coordinatesx");
					double two = stack.getTagCompound().getDouble("Coordinatesy");
					double tre = stack.getTagCompound().getDouble("Coordinatesz");
						
					BlockPos pos = new BlockPos(one, two, tre);
						
					double x = pos.getX();
					double y = pos.getY() + 1;
					double z = pos.getZ();
					playerIn.attemptTeleport(x, y, z);
					playerIn.serverPosX = (long) x;
					playerIn.serverPosY = (long) y;
					playerIn.serverPosZ = (long) z;

//					worldIn.playSound((EntityPlayer)null, x, y, z, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.AMBIENT, 1.0F, 1.0F);
				
				worldIn.playSound(playerIn, x, y, z, SoundsHandler.CHECKPOINT, SoundCategory.WEATHER, 1.0F, 1.0F);
				
				playerIn.getCooldownTracker().setCooldown(this, 100);
				stack.damageItem(1, playerIn);

				return new ActionResult(EnumActionResult.SUCCESS, stack);
	}
			
	

	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(!stack.hasTagCompound()) {
			getNBT(stack);
		}
		


		
	}
	
	private void getNBT(ItemStack stack) {
		if(!stack.hasTagCompound()) {
			nbt = new NBTTagCompound();
		}
		if(nbt.hasKey("Coordinatesx")) {
			nbt.setDouble("Coordinatesx", nbt.getDouble("Coordinatesx"));
			} else {
			nbt.setDouble("Coordinatesx", 0);
		}
		if(nbt.hasKey("Coordinatesy")) {
			nbt.setDouble("Coordinatesy", nbt.getDouble("Coordinatesy"));
			} else {
			nbt.setDouble("Coordinatesy", 1);
		}
		if(nbt.hasKey("Coordinatesz")) {
			nbt.setDouble("Coordinatesz", nbt.getDouble("Coordinatesz"));
			} else {
			nbt.setDouble("Coordinatesz", 1);
		}

		stack.setTagCompound(nbt);
	}
	
	public void addInformation(ItemStack stack, World world, List<String> addlore, ITooltipFlag advanced) {

		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("Coordinatesx") && stack.getTagCompound().hasKey("Coordinatesy") && stack.getTagCompound().hasKey("Coordinatesz")) {
		addlore.add("" + TextFormatting.GOLD + "Saved Coordinates" + TextFormatting.RESET + TextFormatting.DARK_GRAY + "> " 
						+ TextFormatting.RESET + TextFormatting.GRAY + "X:" + TextFormatting.RESET + TextFormatting.RED + Double.toString(stack.getTagCompound().getDouble("Coordinatesx")) + TextFormatting.RESET + TextFormatting.WHITE + ","      
						+ TextFormatting.RESET + TextFormatting.GRAY + "Y:" + TextFormatting.RESET + TextFormatting.RED + Double.toString(stack.getTagCompound().getDouble("Coordinatesy")) + TextFormatting.RESET + TextFormatting.WHITE + "," 
						+ TextFormatting.RESET + TextFormatting.GRAY + "Z:" + TextFormatting.RESET + TextFormatting.RED + Double.toString(stack.getTagCompound().getDouble("Coordinatesz")));
		}
		


		

	}
	
}
