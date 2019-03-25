package poseidon.mod.proxy;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import poseidon.mod.util.Reference;
import poseidon.mod.util.handlers.SoundsHandler;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@Override
	public void registerVariantRenderer(Item item, int meta, String filename, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, filename), id));
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {

		super.preInit(event);
	}
	
	@Override
	public void init(FMLInitializationEvent event) {

	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
	
    @Override
    public EntityPlayer getPlayerEntityFromContext(MessageContext ctx) {
        return (ctx.side.isClient() ? Minecraft.getMinecraft().player : super.getPlayerEntityFromContext(ctx));
    }

    @Override
    public void damageStack(ItemStack stack, Entity entity) {
    	EntityPlayer playerIn = (EntityPlayer) entity;
    	
    	stack.damageItem(1, playerIn);
    }
    
    @Override
    public void generateFlyStaffParticles(Entity theEntity) {

    		EntityPlayer playerIn = (EntityPlayer) theEntity;
	    	
	        Random rand = new Random();
			double x = playerIn.posX;
			double y = playerIn.posY;
			double z = playerIn.posZ;
			double d0 = rand.nextGaussian() * 0.02D;
	    	double d1 = rand.nextGaussian() * 0.02D;
	    	double d2 = rand.nextGaussian() * 0.02D;
	    	double d3 = 10.0D;
	
			theEntity.world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, x + (double)(rand.nextFloat() * playerIn.width * 2.0F) - (double)playerIn.width - d0 * 10.0D, y + (double)(rand.nextFloat() * (playerIn.height - 2.4D)) - d1 * 10.0D, z + (double)rand.nextFloat() * playerIn.width * 2.0F - (double)playerIn.width - d2 * 10.0D, d0, d1, d2);
			theEntity.world.spawnParticle(EnumParticleTypes.CLOUD, x + (double)(rand.nextFloat() * playerIn.width * 2.0F) - (double)playerIn.width - d0 * 10.0D, y + (double)(rand.nextFloat() * (playerIn.height - 1.2D)) - d1 * 10.0D, z + (double)rand.nextFloat() * playerIn.width * 2.0F - (double)playerIn.width - d2 * 10.0D, d0, d1, d2);
	    
    }
    
    @Override
    public void generateRiftParticleOnUpdate(Entity theEntity) {
    	EntityPlayer playerIn = (EntityPlayer) theEntity;
        
        Random rand = new Random();
		double x = playerIn.posX;
		double y = playerIn.posY + 1.0D;
		double z = playerIn.posZ;
		double d0 = rand.nextGaussian() * 0.02D;
    	double d1 = rand.nextGaussian() * 0.02D;
    	double d2 = rand.nextGaussian() * 0.02D;
    	double d3 = 10.0D;
    	playerIn.world.spawnParticle(EnumParticleTypes.PORTAL, x + (double)(rand.nextFloat() * playerIn.width * 2.0F) - (double)playerIn.width - d0 * 10.0D, y + (double)(rand.nextFloat() * (playerIn.height - 2.4D)) - d1 * 10.0D, z + (double)rand.nextFloat() * playerIn.width * 2.0F - (double)playerIn.width - d2 * 10.0D, d0, d1, d2);
    	playerIn.world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, x + (double)(rand.nextFloat() * playerIn.width * 2.0F) - (double)playerIn.width - d0 * 10.0D, y + (double)(rand.nextFloat() * (playerIn.height - 1.2D)) - d1 * 10.0D, z + (double)rand.nextFloat() * playerIn.width * 2.0F - (double)playerIn.width - d2 * 10.0D, d0, d1, d2);
	
        
    }
    
    @Override
    public void generateRiftParticleTakeOff(Entity theEntity) {
    	EntityPlayer player = (EntityPlayer) theEntity;
    	ItemStack heldItem = player.getHeldItemMainhand();
        
		double t = 0;
		double tm = 0;
		while(tm < 4000) {
		BlockPos pos = player.getPosition();
		t += Math.PI /8;
    		for(double phi = 0; phi <= 2*Math.PI; phi += Math.PI/2) {
    			double x = 0.3*(4*Math.PI - t) * Math.cos(t + phi) + player.posX;
    			double y = 0.2*t + player.posY - 0.5;
    			double z = 0.3 * (4*Math.PI - t) * Math.sin(t + phi) + player.posZ;
    			pos.add(x,y,z);
    			player.world.spawnParticle(EnumParticleTypes.END_ROD, x, y, z, 0, 0, 0);
    			player.world.spawnParticle(EnumParticleTypes.END_ROD, x, y + 1.0, z, 0, 0, 0);
    			player.world.spawnParticle(EnumParticleTypes.END_ROD, x, y + 2.0, z, 0, 0, 0);
    			player.world.spawnParticle(EnumParticleTypes.END_ROD, x, y + 3.0, z, 0, 0, 0);
    			pos.subtract(new Vec3i(x,y,z));
			}
    		tm++;
		}
        
    }
    
    @Override
    public void generateTrail(Entity entity) {
    	EntityPlayer player = (EntityPlayer) entity;
    	
    	player.getEntityWorld().playSound(player, player.getPosition(), SoundsHandler.BADISLAND, SoundCategory.AMBIENT, 1.0F, 1.0F);
    	
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
			player.world.spawnParticle(EnumParticleTypes.LAVA, x, y, z, 0, 0, 0);
			pos.subtract(new Vec3i(x,y,z));
		
			
			tm--;
			
		}
    }
    
    @Override
    public void generateCharmParticleFall(Entity theEntity) {
    	
		EntityPlayer playerIn = (EntityPlayer) theEntity;
    	
        Random rand = new Random();
		double x = playerIn.posX;
		double y = playerIn.posY + 1.0D;
		double z = playerIn.posZ;
		double d0 = rand.nextGaussian() * 0.02D;
    	double d1 = rand.nextGaussian() * 0.02D;
    	double d2 = rand.nextGaussian() * 0.02D;
    	double d3 = 10.0D;

		theEntity.world.spawnParticle(EnumParticleTypes.PORTAL, x + (double)(rand.nextFloat() * playerIn.width * 2.0F) - (double)playerIn.width - d0 * 10.0D, y + (double)(rand.nextFloat() * (playerIn.height - 2.4D)) - d1 * 10.0D, z + (double)rand.nextFloat() * playerIn.width * 2.0F - (double)playerIn.width - d2 * 10.0D, d0, d1, d2);
		
    	
    }
    
    public void generateCharmParticleDepth(Entity theEntity) {
		EntityPlayer playerIn = (EntityPlayer) theEntity;
    	
        Random rand = new Random();
		double x = playerIn.posX;
		double y = playerIn.posY + 1.0D;
		double z = playerIn.posZ;
		double d0 = rand.nextGaussian() * 0.02D;
    	double d1 = rand.nextGaussian() * 0.02D;
    	double d2 = rand.nextGaussian() * 0.02D;
    	double d3 = 10.0D;

		theEntity.world.spawnParticle(EnumParticleTypes.WATER_DROP, x + (double)(rand.nextFloat() * playerIn.width * 2.0F) - (double)playerIn.width - d0 * 10.0D, y + (double)(rand.nextFloat() * (playerIn.height - 2.4D)) - d1 * 10.0D, z + (double)rand.nextFloat() * playerIn.width * 2.0F - (double)playerIn.width - d2 * 10.0D, d0, d1, d2);
		
    	
    }
    
    public void generateCharmParticleFire(Entity theEntity) {
		EntityPlayer playerIn = (EntityPlayer) theEntity;
    	
        Random rand = new Random();
		double x = playerIn.posX;
		double y = playerIn.posY + 1.0D;
		double z = playerIn.posZ;
		double d0 = rand.nextGaussian() * 0.02D;
    	double d1 = rand.nextGaussian() * 0.02D;
    	double d2 = rand.nextGaussian() * 0.02D;
    	double d3 = 10.0D;

		theEntity.world.spawnParticle(EnumParticleTypes.FLAME, x + (double)(rand.nextFloat() * playerIn.width * 2.0F) - (double)playerIn.width - d0 * 10.0D, y + (double)(rand.nextFloat() * (playerIn.height - 2.4D)) - d1 * 10.0D, z + (double)rand.nextFloat() * playerIn.width * 2.0F - (double)playerIn.width - d2 * 10.0D, d0, d1, d2);
		
    	
    }
    
    public void generateCharmParticleProj(Entity theEntity) {
		EntityPlayer playerIn = (EntityPlayer) theEntity;
    	
        Random rand = new Random();
		double x = playerIn.posX;
		double y = playerIn.posY + 1.0D;
		double z = playerIn.posZ;
		double d0 = rand.nextGaussian() * 0.02D;
    	double d1 = rand.nextGaussian() * 0.02D;
    	double d2 = rand.nextGaussian() * 0.02D;
    	double d3 = 10.0D;

		theEntity.world.spawnParticle(EnumParticleTypes.CRIT, x + (double)(rand.nextFloat() * playerIn.width * 2.0F) - (double)playerIn.width - d0 * 10.0D, y + (double)(rand.nextFloat() * (playerIn.height - 2.4D)) - d1 * 10.0D, z + (double)rand.nextFloat() * playerIn.width * 2.0F - (double)playerIn.width - d2 * 10.0D, d0, d1, d2);
		
    	
    }
    
    public void generateCharmParticleGlide(Entity theEntity) {
		EntityPlayer playerIn = (EntityPlayer) theEntity;
    	
        Random rand = new Random();
		double x = playerIn.posX;
		double y = playerIn.posY + 1.0D;
		double z = playerIn.posZ;
		double d0 = rand.nextGaussian() * 0.02D;
    	double d1 = rand.nextGaussian() * 0.02D;
    	double d2 = rand.nextGaussian() * 0.02D;
    	double d3 = 10.0D;

		theEntity.world.spawnParticle(EnumParticleTypes.CLOUD, x + (double)(rand.nextFloat() * playerIn.width * 2.0F) - (double)playerIn.width - d0 * 10.0D, y + (double)(rand.nextFloat() * (playerIn.height - 2.4D)) - d1 * 10.0D, z + (double)rand.nextFloat() * playerIn.width * 2.0F - (double)playerIn.width - d2 * 10.0D, d0, d1, d2);
		
    	
    }
    
}
