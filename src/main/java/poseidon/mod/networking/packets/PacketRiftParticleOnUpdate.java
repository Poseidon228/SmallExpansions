package poseidon.mod.networking.packets;

import java.util.Random;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketRiftParticleOnUpdate implements IMessage {


	    public PacketRiftParticleOnUpdate()
	    {
	        //noinspection MethodCallSideOnly

	    }

	    @Override
	    public void fromBytes(ByteBuf buf)
	    {
	    	
	    }

	    @Override
	    public void toBytes(ByteBuf buf)
	    {
	    	
	    }

	    public static class Handler implements IMessageHandler<PacketRiftParticleOnUpdate, IMessage>
	    {
	        @Override
	        public IMessage onMessage(PacketRiftParticleOnUpdate message, MessageContext ctx)
	        {
	            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> handle(message, ctx));
	            return null;
	        }

	        private void handle(PacketRiftParticleOnUpdate message, MessageContext ctx)
	        {
	            EntityPlayerMP playerIn = ctx.getServerHandler().player;
	            World worldIn = playerIn.getEntityWorld();
	            ItemStack heldItem = playerIn.getHeldItemMainhand();
	            
	            Random rand = new Random();
				double x = playerIn.posX;
				double y = playerIn.posY + 1.0D;
				double z = playerIn.posZ;
				double d0 = rand.nextGaussian() * 0.02D;
		    	double d1 = rand.nextGaussian() * 0.02D;
		    	double d2 = rand.nextGaussian() * 0.02D;
		    	double d3 = 10.0D;
	    		worldIn.spawnParticle(EnumParticleTypes.PORTAL, x + (double)(rand.nextFloat() * playerIn.width * 2.0F) - (double)playerIn.width - d0 * 10.0D, y + (double)(rand.nextFloat() * (playerIn.height - 2.4D)) - d1 * 10.0D, z + (double)rand.nextFloat() * playerIn.width * 2.0F - (double)playerIn.width - d2 * 10.0D, d0, d1, d2);
	    		worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, x + (double)(rand.nextFloat() * playerIn.width * 2.0F) - (double)playerIn.width - d0 * 10.0D, y + (double)(rand.nextFloat() * (playerIn.height - 1.2D)) - d1 * 10.0D, z + (double)rand.nextFloat() * playerIn.width * 2.0F - (double)playerIn.width - d2 * 10.0D, d0, d1, d2);
			
	            
	        }
	    }
	
}





























