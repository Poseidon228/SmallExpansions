package poseidon.mod.util.handlers;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import poseidon.mod.client.commands.CommandDimension;
import poseidon.mod.client.commands.CommandFireball;
import poseidon.mod.client.commands.CommandFly;
import poseidon.mod.client.commands.CommandHeal;
import poseidon.mod.init.BlockInit;
import poseidon.mod.init.EnchantmentInit;
import poseidon.mod.init.EntityInit;
import poseidon.mod.init.ItemInit;
import poseidon.mod.util.interfaces.IHasModel;
import poseidon.mod.world.gen.WorldGenCustomOres;
import poseidon.mod.world.gen.WorldGenCustomStructures;

@EventBusSubscriber
public class RegistryHandler {
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
		
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));

	}
	
	@SubscribeEvent
	public static void onEnchantmentRegister(RegistryEvent.Register<Enchantment> event) {
		event.getRegistry().registerAll(EnchantmentInit.ENCHANTMENTS.toArray(new Enchantment[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for(Item item : ItemInit.ITEMS) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		for(Block block : BlockInit.BLOCKS) {
			if(block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
	}



	
//	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public static void jumpEvent(LivingJumpEvent event) {

		if(event.getEntity() != null && event.getEntity() instanceof EntityPlayer) {
			
			EntityPlayer player = (EntityPlayer) event.getEntity();
			ItemStack held = player.getHeldItemMainhand();
			ItemStack heldOff = player.getHeldItemOffhand();
			
			if(held.getItem() == new ItemStack(ItemInit.FALL_CHARM).getItem() || heldOff.getItem() == new ItemStack(ItemInit.FALL_CHARM).getItem()) {
				
				if(held.hasTagCompound() || heldOff.hasTagCompound()) {
					
					if(new ItemStack(ItemInit.FALL_CHARM).getItem() == player.getHeldItemMainhand().getItem()) {
						
						ItemStack remove = player.getHeldItemMainhand();
						
						if(remove.hasTagCompound()) {
							
							if(remove.getTagCompound().getBoolean("Activated")) {
								
								remove.getTagCompound().setBoolean("Activated", false);
								
							}
							
						}
						
					}
				
					if(new ItemStack(ItemInit.FALL_CHARM).getItem() == player.getHeldItemOffhand().getItem()) {
						
						ItemStack remove = player.getHeldItemOffhand();
						
						if(remove.hasTagCompound()) {
							
							if(remove.getTagCompound().getBoolean("Activated")) {
								
								remove.getTagCompound().setBoolean("Activated", false);
								
							}
							
						}
						
					}
					
				}
				
			}
			
		}
	}
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public static void knockEvent(LivingKnockBackEvent event) {
		if(event.getAttacker() != null && event.getEntity() != null && event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			
			if(event.getAttacker() instanceof EntitySkeleton) {
				ItemStack stack = new ItemStack(ItemInit.PROJECTILE_CHARM);
				
				for(int i = 0; i < 36; i ++) {
					ItemStack check = player.inventory.getStackInSlot(i);
					if(check.getItem() == stack.getItem()) {
						event.setStrength(0.0F);
						check.damageItem(1, player);
					}
				}
			}
			
			
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public static void charmEvent(LivingHurtEvent event) {

		if(event.getEntity() != null && event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();

			boolean con = false;
			ItemStack deptCharm = new ItemStack(ItemInit.DEPTH_STRIDER_CHARM);
			ItemStack projCharm = new ItemStack(ItemInit.PROJECTILE_CHARM);
			ItemStack stack = new ItemStack(ItemInit.PROJECTILE_SHIELD);
			
			for(int i = 0; i < 36; i ++) {
				ItemStack check = player.inventory.getStackInSlot(i);
				if(check.getItem() == projCharm.getItem() && event.getSource().getDamageType() == "arrow") {
					event.setAmount(0.0F);
					check.damageItem(1, player);
				}
				if(check.getItem() == stack.getItem() && event.getSource().getDamageType() == "arrow") {
					event.setAmount(0.0F);
					check.shrink(1);
				}
				if((check.getItem() == new ItemStack(ItemInit.FALL_CHARM).getItem()) && event.getSource().getDamageType() == "fall") {
					event.setAmount(0.0F);
					check.damageItem(10, player);
				}
				if(check.getItem() == new ItemStack(ItemInit.BOUNCERS).getItem() && event.getSource().getDamageType() == "fall") {
					event.setAmount(0.0F);
					player.setVelocity(player.motionX, player.motionY * 1.2F, player.motionZ);
					check.shrink(1);
				}
				if(check.getItem() == new ItemStack(ItemInit.FIRE_PROTECTION_CHARM).getItem() && (event.getSource().getDamageType() == "fire" || event.getSource().getDamageType() == "lava")) {
					event.setAmount(0.0F);
					check.damageItem(1, player);
				}
			}

			
		    for(int a = 0; a < player.inventory.getSizeInventory(); a++) {
		    	
		    	ItemStack cuStack = player.inventory.getStackInSlot(a);
		    	NBTTagList enchlist = cuStack.getEnchantmentTagList();
			    for(int b = 0; b < enchlist.tagCount(); b++) {
			    	if (enchlist.getCompoundTagAt(b).getInteger("id") == 13) {
			    		event.setAmount(0.0F);
			    	}
			    }
		    }
			
			
		}
	}
	
	@SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public static void onMyEvent(LivingDeathEvent event) {
		EntityPlayer player = null;
		EntityPlayer player2 = null;
		if(event.getEntity() instanceof EntityPlayer) {player = (EntityPlayer) event.getEntity();}
		if(event.getEntity() instanceof EntityPlayer) {player2 = (EntityPlayer) event.getEntity();}
		event.isCanceled();
		event.setCanceled(true);
		ItemStack stack = new ItemStack(ItemInit.STASIS);
		ItemStack stack2 = new ItemStack(ItemInit.RIFT);
		
		if(player != null && player instanceof EntityPlayer) {
			if(player.inventory.hasItemStack(stack)) {
			
				int slot = player.inventory.getSlotFor(stack);
	
				player.setHealth(player.getMaxHealth());
				player.inventory.getStackInSlot(slot).shrink(1);
				player.addExperience(1000);
				
				if(player.getEntityWorld() != null) {
					final World world = player.getEntityWorld();

				}
				
			}
			
			
		}
		
		


	}
	
	

		

	
	
	public static void preInitRegistries() {
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres() , 2);
		EntityInit.registerEntities();
		RenderHandler.registerEntityRenders();
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
		//DimensionInit.registerDimension();
	}
	
	public static void initRegistries() {
		SoundsHandler.registerSounds();

	}
	
	public static void postInitRegistries() {

	}
	
	public static void onServerInit(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandDimension());
		event.registerServerCommand(new CommandHeal());
		event.registerServerCommand(new CommandFireball());
		event.registerServerCommand(new CommandFly());
	}
	
}

