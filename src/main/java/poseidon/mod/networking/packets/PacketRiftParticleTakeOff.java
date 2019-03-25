package poseidon.mod.networking.packets;

import java.util.Random;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketRiftParticleTakeOff implements IMessage {


	    public PacketRiftParticleTakeOff()
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

	    public static class Handler implements IMessageHandler<PacketRiftParticleTakeOff, IMessage>
	    {
	        @Override
	        public IMessage onMessage(PacketRiftParticleTakeOff message, MessageContext ctx)
	        {
	            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> handle(message, ctx));
	            return null;
	        }

	        private void handle(PacketRiftParticleTakeOff message, MessageContext ctx)
	        {
	            EntityPlayerMP player = ctx.getServerHandler().player;
	            World world = player.getEntityWorld();
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
		    			world.spawnParticle(EnumParticleTypes.END_ROD, x, y, z, 0, 0, 0);
		    			world.spawnParticle(EnumParticleTypes.END_ROD, x, y + 1.0, z, 0, 0, 0);
		    			world.spawnParticle(EnumParticleTypes.END_ROD, x, y + 2.0, z, 0, 0, 0);
		    			world.spawnParticle(EnumParticleTypes.END_ROD, x, y + 3.0, z, 0, 0, 0);
		    			pos.subtract(new Vec3i(x,y,z));
	    			}
		    		tm++;
	    		}
	            
	        }
	    }
	
}





























