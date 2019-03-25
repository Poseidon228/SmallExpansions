package poseidon.mod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import poseidon.mod.client.enchantments.LavaWalker;
import poseidon.mod.client.enchantments.Slime;
import poseidon.mod.client.enchantments.Unbreakable;
import poseidon.mod.util.Reference;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class EnchantmentInit {

	public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();
	
	public static final Enchantment UNBREAKABLE = new Unbreakable();
	public static final Enchantment LAVA_WALKER = new LavaWalker();
	//public static final Enchantment SLIME = new Slime();
	
	private static boolean chop;
	
	@SubscribeEvent
	public static void UnbreakableFunction(LivingUpdateEvent event) {
		EntityLivingBase living = event.getEntityLiving();
		int level = EnchantmentHelper.getMaxEnchantmentLevel(UNBREAKABLE, living);
		BlockPos pos = living.getPosition();
		World world = event.getEntity().world;
		EntityPlayer player;
		
		if(event.getEntityLiving() instanceof EntityPlayer) { player = (EntityPlayer) event.getEntityLiving();
		
			NBTTagList enchlist2 = player.inventory.armorItemInSlot(0).getEnchantmentTagList();
		    for(int i = 0; i < enchlist2.tagCount(); i++) {
		    	if (enchlist2.getCompoundTagAt(i).getInteger("id") == 12) {
		    
		    		 if (living.onGround) {
		    	            float f = (float)Math.min(16, 2 + level);
		    	            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(0, 0, 0);

		    	            for (BlockPos.MutableBlockPos blockpos$mutableblockpos1 : BlockPos.getAllInBoxMutable(pos.add((double)(-f), -1.0D, (double)(-f)), pos.add((double)f, -1.0D, (double)f))) {
		    	                if (blockpos$mutableblockpos1.distanceSqToCenter(living.posX, living.posY, living.posZ) <= (double)(f * 4 * f)) {
		    	                    blockpos$mutableblockpos.setPos(blockpos$mutableblockpos1.getX(), blockpos$mutableblockpos1.getY() + 1, blockpos$mutableblockpos1.getZ());
		    	                    IBlockState iblockstate = world.getBlockState(blockpos$mutableblockpos);

		    	                    if (iblockstate.getMaterial() == Material.AIR) {
		    	                        IBlockState iblockstate1 = world.getBlockState(blockpos$mutableblockpos1);

		    	                        if (iblockstate1.getMaterial() == Material.LAVA && (iblockstate1.getBlock() == net.minecraft.init.Blocks.LAVA || iblockstate1.getBlock() == net.minecraft.init.Blocks.FLOWING_LAVA) && ((Integer)iblockstate1.getValue(BlockLiquid.LEVEL)).intValue() == 0 && world.mayPlace(Blocks.MAGMA, blockpos$mutableblockpos1, false, EnumFacing.DOWN, (Entity)null)) {
		    	                            world.setBlockState(blockpos$mutableblockpos1, Blocks.MAGMA.getDefaultState());
		    	                            player.setHealth(player.getHealth() + 1.0F);
		    	                            System.out.println("Armor: "+ player.inventory.armorItemInSlot(2));
		    	                           // world.scheduleUpdate(blockpos$mutableblockpos1.toImmutable(), Blocks.MAGMA.getDefaultState(), MathHelper.getInt(living.getRNG(), 60, 120));
		    	                        }
		    	                    }
		    	                }
		    	            }
		    	        }

		        }
		    }
		    
		    for(int a = 0; a < player.inventory.getSizeInventory(); a++) {
		    	
		    	ItemStack cuStack = player.inventory.getStackInSlot(a);
		    	NBTTagList enchlist = cuStack.getEnchantmentTagList();
			    for(int b = 0; b < enchlist.tagCount(); b++) {
			    	if (enchlist.getCompoundTagAt(b).getInteger("id") == 11) {
			    		cuStack.setItemDamage(-1);
			    	}
			    }
		    }
		    
		    //second 
		    
		    
		}
	}
	
	
	@SubscribeEvent
	public static void onEvent(BlockEvent.BreakEvent event) {
		
		EntityPlayer player = event.getPlayer();
		if(!(player == null)) {
			
			ItemStack stack = player.getHeldItemMainhand();
			NBTTagList enchlist2 = stack.getEnchantmentTagList();
		    for(int i = 0; i < enchlist2.tagCount(); i++) {
		    	if (enchlist2.getCompoundTagAt(i).getInteger("id") == 11) {
		    		
		    		int d = stack.getItemDamage();
		    		stack.setItemDamage(d - 1);

		    	}
		    	
		    
		    	
		    }
		}
	}
	

}
