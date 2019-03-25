package poseidon.mod.objects.items.general.finisheditems;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import poseidon.mod.Main;
import poseidon.mod.init.ItemInit;
import poseidon.mod.networking.packets.PacketHandler;
import poseidon.mod.networking.packets.PacketFlyStaffParticle;
import poseidon.mod.objects.items.general.ItemBase;
import poseidon.mod.objects.items.wand.WandAbility;
import poseidon.mod.objects.tools.ToolSword;

public class FlyStaff extends ToolSword {

	NBTTagCompound nbt;
	ItemStack ammo = null;
	float force = 1.0F;
	boolean warn = true;
	int count = 0;
	
	public FlyStaff(String name) {
		super(name, ItemInit.WOOD_MULTI);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		getNBT(stack);
	}
	
	private void getNBT(ItemStack stack) {
		if(stack.hasTagCompound()) {
			nbt = stack.getTagCompound();
			} else {
			nbt = new NBTTagCompound();
		} //Gets The compound which holds keys!
		if(nbt.hasKey("Durability")) {
			nbt.setInteger("Durability", nbt.getInteger("Durability"));
			} else {
			nbt.setInteger("Durability", 0);
		} //Gets the key .. if not exists it creates one (if it was taken out of the tab)
		if(nbt.hasKey("Activated")) {
			nbt.setBoolean("Activated", nbt.getBoolean("Activated"));
			} else {
			nbt.setBoolean("Activated", true);
		}
		if(nbt.hasKey("Warning")) {
			nbt.setBoolean("Warning", nbt.getBoolean("Warning"));
			} else {
			nbt.setBoolean("Warning", false);
		}
		stack.setTagCompound(nbt);
	}
	
	private void getAmmo(EntityPlayer player) {
		
		ItemStack ammo1 = new ItemStack(ItemInit.ELYTRON_DUST);
		ItemStack ammo2 = new ItemStack(Items.GUNPOWDER);
		ItemStack ammo3 = new ItemStack(Items.GLOWSTONE_DUST);
		ItemStack ammo4 = new ItemStack(ItemInit.EMPOWERED_GUNPOWDER);
		
		int slot1 = player.inventory.getSlotFor(ammo1);
		int slot2 = player.inventory.getSlotFor(ammo2);
		int slot3 = player.inventory.getSlotFor(ammo3);
		

		
		for(int i = 0; i < 36; i ++) {
			ItemStack check = player.inventory.getStackInSlot(i);
			if(check.getItem() == ammo1.getItem()) {
				ammo = ammo1;
				force = 9.0F;
				return;
			}
			if(check.getItem() == ammo2.getItem()) {
				ammo = ammo2;
				force = 4.0F;
				return;
			}
			if(check.getItem() == ammo3.getItem()) {
				ammo = ammo3;
				force = 1.0F;
				return;
			}
			if(check.getItem() == ammo4.getItem()) {
				ammo = ammo4;
				force = 11.0F;
				return;
			}
		}
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) {
		
		ItemStack heldItem = player.getHeldItem(handIn);
		ItemStack ammo1 = new ItemStack(ItemInit.ELYTRON_DUST);
		ItemStack ammo2 = new ItemStack(Items.GUNPOWDER);
		ItemStack ammo3 = new ItemStack(Items.GLOWSTONE_DUST);
		
		
		getAmmo(player);
		
		

			if(ammo != null && player.inventory.hasItemStack(ammo)) {
				if(!player.isElytraFlying()) {
					Main.proxy.generateTrail(player);
				    float yaw = player.rotationYaw;
				    float pitch = player.rotationPitch;
				    float f = 9.0F;
				    double motionX = (double)(-MathHelper.sin(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * force);
				    double motionZ = (double)(MathHelper.cos(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * force);
				    double motionY = (double)(-MathHelper.sin((pitch) / 180.0F * (float)Math.PI) * force);
				    player.setVelocity(motionX, motionY, motionZ);
				   	
				   	
				   	player.playSound(SoundEvents.ENTITY_FIREWORK_LAUNCH, 1.0F, 1.0F);
		
					heldItem.damageItem(1, player);
					int slot = player.inventory.getSlotFor(ammo);
					player.inventory.getStackInSlot(slot).shrink(1);
		
				}
			   	
			}
			
			
			if(ammo != null && player.inventory.hasItemStack(ammo)) {
				if(player.isElytraFlying()) {
					Main.proxy.generateTrail(player);
					
					double camX = player.getLookVec().x;
				    double camY = player.getLookVec().y;
				    double camZ = player.getLookVec().z;
					
				    double velocityAddedX = camX * force;
				    double velocityAddedY = camY * force;
				    double velocityAddedZ = camZ * force;
				     
				    double currentVelocityX = player.motionX + velocityAddedX;
				    double currentVelocityY = player.motionY + velocityAddedY;
				    double currentVelocityZ = player.motionZ + velocityAddedZ;
				    
					heldItem.damageItem(1, player);
					int slot = player.inventory.getSlotFor(ammo);
					player.inventory.getStackInSlot(slot).shrink(1);
				    
				    player.setVelocity(currentVelocityX, currentVelocityY, currentVelocityZ);
				    worldIn.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_FIREWORK_LAUNCH, SoundCategory.AMBIENT, 3.0F, 1.0F);
		
				}
			}
		
		
		return new ActionResult(EnumActionResult.SUCCESS, heldItem);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(entityIn != null && entityIn instanceof EntityPlayer) {
			EntityPlayer playerIn = (EntityPlayer) entityIn;
			if(playerIn.inventory.hasItemStack(stack) && playerIn.getHeldItemMainhand() == stack) {
				Main.proxy.generateFlyStaffParticles(playerIn);
			}
			
			if(stack.hasTagCompound()) {
				
				for(int i = 0; i < 36; i ++) {
					ItemStack check = playerIn.inventory.getStackInSlot(i);
					
					if(check.getItem() == ItemInit.FALL_CHARM) {
						stack.getTagCompound().setBoolean("Warning", false);
						count++;
						warn = false;
					}
					if(check.getItem() == ItemInit.BOUNCERS) {
						stack.getTagCompound().setBoolean("Warning", false);
						warn = false;
						count++;
					}
				}
				
				if(count == 0) {
					stack.getTagCompound().setBoolean("Warning", true);
				}
			}
			
			count = 0;
		}
    		
	}
	
	private void trail(EntityPlayer player, World world) {
		
		Vec3d dir = player.getLook(1.0F).normalize();
		BlockPos pos = player.getPosition();
		
		double t = 0;
		double tm = 6000;
		double x = 0;
		double y = 0;
		double z = 0;
		
		
		while(tm > 1) {
			
		
			
			t += 0.5;
			x = dir.x * t + pos.getX();
			y = dir.y * t  + 1.5D + pos.getY();
			z = dir.z * t + pos.getZ();
			pos.add(x,y,z);
			world.spawnParticle(EnumParticleTypes.LAVA, x, y, z, 0, 0, 0);
			pos.subtract(new Vec3i(x,y,z));
		
			
			tm--;
			
		}
		particle3b(player, world, new BlockPos(x, y, z), dir);
		
		
   }
		
	private void particle3b(EntityPlayer player, World world, BlockPos pos, Vec3d dir) {

		BlockPos pos2 = pos;
		
		double t = 0;
		double tm = 6000;
		
		
		while(tm > 1) {
			
		
			
			t += 0.5;
			double x = dir.x * t + pos.getX();
			double y = dir.y * t  + 1.5D + pos.getY();
			double z = dir.z * t + pos.getZ();
			pos.add(x,y,z);
			world.spawnParticle(EnumParticleTypes.LAVA, x, y, z, 0, 0, 0);
			pos.subtract(new Vec3i(x,y,z));
			
			tm--;
			
		}
	}
	
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(TextFormatting.WHITE + "Boosts flight when using the elytra");
		if(stack.hasTagCompound()) {
			if(stack.getTagCompound().getBoolean("Warning") == true) {
				tooltip.add(TextFormatting.RED + "Warning: " + TextFormatting.WHITE + "Fall Damage");
			}
		}
	}
	
}
