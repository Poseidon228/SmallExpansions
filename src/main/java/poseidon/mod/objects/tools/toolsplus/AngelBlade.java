package poseidon.mod.objects.tools.toolsplus;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import poseidon.mod.Main;
import poseidon.mod.init.ItemInit;
import poseidon.mod.objects.items.wand.BlockHelper;
import poseidon.mod.objects.tools.ToolSword;
import poseidon.mod.util.handlers.SoundsHandler;
import poseidon.mod.util.interfaces.IHasModel;

public class AngelBlade extends ToolSword implements IHasModel {
	
	NBTTagCompound nbt;
	
	public AngelBlade(String name, ToolMaterial material) {
		super(name, material);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this,  0, "inventory");
	}
	

	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundsHandler.MARAUDER, SoundCategory.AMBIENT, 1.0F, 1.0F);
		getNBT(stack);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

		if(stack.hasTagCompound()) {
			NBTTagCompound nbt2 = stack.getTagCompound();
			int dur = nbt2.getInteger("Durability");
			if(dur == 1) {
				System.out.println("Activated: " + stack.getTagCompound().getInteger("Durability"));
				//Skill activated
				if(entityIn instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) entityIn;
					BlockPos pos = player.getPosition();
					BlockPos check = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
					BlockPos check2 = new BlockPos(pos.getX(), pos.getY() - 2, pos.getZ());
					
					IBlockState iBlock = worldIn.getBlockState(check);
					Block block = iBlock.getBlock();
					IBlockState iBlock2 = worldIn.getBlockState(check2);
					Block block2 = iBlock2.getBlock();
					
					if(block != null && block.getDefaultState() == Blocks.AIR.getDefaultState()) {
						stack.getTagCompound().setInteger("Durability", 2);
						System.out.println("Sky!");
						//Teleported in the sky
					}
					
				}
			}
			
			if(nbt2.getInteger("Durability") == 2) {
				System.out.println("lol");
				if(entityIn instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) entityIn;
					BlockPos pos2 = player.getPosition();
					BlockPos pos = player.getPosition();
					
					BlockPos check1 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
					
					IBlockState iBlock1 = worldIn.getBlockState(check1);
					Block block1 = iBlock1.getBlock();
					
					if(block1 != null && block1.getDefaultState() != Blocks.AIR.getDefaultState()) {
						System.out.println("Ground!");
						nbt2.setInteger("Durability", 0);	
						player.inventory.armorItemInSlot(2).shrink(1);
					}
				
				}
			}
		}
	}



	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack heldStack = playerIn.getHeldItem(handIn);
		BlockHelper.earthParticle(playerIn, worldIn);

			if(playerIn.isSneaking()) {
				
				if(!heldStack.hasTagCompound()) {
					getNBT(heldStack);
					heldStack.getTagCompound().setInteger("Durability", 1);
					} else {
					heldStack.getTagCompound().setInteger("Durability", 1);
				}
				
				double y = playerIn.posY;
	
				ItemStack stack = new ItemStack(Items.ELYTRA);
				ItemStack stack2 = new ItemStack(Items.ELYTRA);
				stack2.damageItem(420, playerIn);
				
				if(playerIn.inventory.armorItemInSlot(2) != null && playerIn.inventory.armorItemInSlot(2) == stack) {
					

					playerIn.inventory.armorInventory.set(2, stack2);
					worldIn.playSound(playerIn, new BlockPos(playerIn.posX, playerIn.posY, playerIn.posZ), SoundEvents.ENTITY_ENDERDRAGON_GROWL, SoundCategory.WEATHER, 0.5F, 1.0F);
					//getOthers(playerIn, worldIn);
					playerIn.serverPosX = (long) playerIn.posX;
					playerIn.serverPosY = (long) ((long) playerIn.posY + 200.0D);
					playerIn.serverPosZ = (long) playerIn.posZ;
					playerIn.setPosition(playerIn.posX, playerIn.posY + 200.0D, playerIn.posZ);

					} else if(playerIn.inventory.armorItemInSlot(2) != null && !(playerIn.inventory.armorItemInSlot(2) == stack)) {
						
					playerIn.inventory.armorInventory.set(2, stack2);
					worldIn.playSound(playerIn, new BlockPos(playerIn.posX, playerIn.posY, playerIn.posZ), SoundEvents.ENTITY_ENDERDRAGON_GROWL, SoundCategory.WEATHER, 0.5F, 1.0F);
					playerIn.sendStatusMessage(new TextComponentTranslation(TextFormatting.RED + "An elytra has been added to your inventory", new Object[0]), true);
					//getOthers(playerIn, worldIn);
					playerIn.setPosition(playerIn.posX, playerIn.posY + 200.0D, playerIn.posZ);
					playerIn.serverPosX = (long) playerIn.posX;
					playerIn.serverPosY = (long) ((long) playerIn.posY + 200.0D);
					playerIn.serverPosZ = (long) playerIn.posZ;
					
					
				}

				heldStack.damageItem(200, playerIn);

			}

		return new ActionResult(EnumActionResult.SUCCESS, heldStack);
		
	}
	
	private void getOthers(EntityPlayer player, World world) {
		AxisAlignedBB axis = new AxisAlignedBB(player.posX + 5.0D, player.posY - 3.0D, player.posZ - 5.0D, player.posX - 5.0D, player.posY + 3.0D, player.posZ + 5.0D);
		List<Entity> playerList = world.getEntitiesWithinAABBExcludingEntity(player, axis);
		
		for(int i = 0; i < playerList.size(); i++) {
			Entity playerIns = playerList.get(i);
			if(playerIns instanceof EntityPlayer) {
				EntityPlayer playerIn = (EntityPlayer) playerIns;
				playerIn.setPosition(playerIn.posX, playerIn.posY + 200.0D, playerIn.posZ);
				playerIn.serverPosX = (long) playerIn.posX;
				playerIn.serverPosY = (long) ((long) playerIn.posY + 200.0D);
				playerIn.serverPosZ = (long) playerIn.posZ;
				world.playSound(playerIn, new BlockPos(playerIn.posX, playerIn.posY, playerIn.posZ), SoundEvents.ENTITY_ENDERDRAGON_GROWL, SoundCategory.WEATHER, 0.5F, 1.0F);
			}
		}
		
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		target.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 100, 10));
		Random rn = new Random();
		int maximum = 100;
		int minimum = 1;
		int range = maximum - minimum + 1;		
		int randomNum2 = rn.nextInt(range) + minimum;
		
		if(randomNum2 < 5) {
			target.onKillCommand();
		}
		if(randomNum2 >= 5 && randomNum2 < 20) {
			 target.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 400, 100));
		}
		if(randomNum2 >= 20 && randomNum2 < 40) {
			target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 400, 100));
		}
		if(randomNum2 >= 40 && randomNum2 < 45) {
			target.setFire(100);
		}
		if(randomNum2 >= 45 && randomNum2 < 60) {
			knockB(target, attacker);
		}
		
		if(randomNum2 <= 50) {
			return true;
		}
		stack.damageItem(1, attacker);
		return true;
	}
	
	private void knockB(EntityLivingBase target, EntityLivingBase attacker) {
		
		Vec3d look = attacker.getLookVec().normalize();
		double knockback = 20.5;
		target.addVelocity(look.x * knockback, look.y * knockback * 10, look.z * knockback);
		
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

		stack.setTagCompound(nbt);
	}
	
	
	

	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(TextFormatting.WHITE + "Sneak and right click to open a rift in the sky");
	}
	
}
