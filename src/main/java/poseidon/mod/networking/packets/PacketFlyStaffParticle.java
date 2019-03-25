package poseidon.mod.networking.packets;

import java.util.Random;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
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
import poseidon.mod.init.ItemInit;

public class PacketFlyStaffParticle  implements IMessage
{


    public PacketFlyStaffParticle()
    {
        //noinspection MethodCallSideOnly

    }

    @Override
    public void fromBytes(ByteBuf buf) {
    	
    }

    @Override
    public void toBytes(ByteBuf buf) {
    	
    }

    public static class Handler implements IMessageHandler<PacketFlyStaffParticle, IMessage>
    {
        @Override
        public IMessage onMessage(PacketFlyStaffParticle message, MessageContext ctx)
        {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> handle(message, ctx));
            return null;
        }

        private void handle(PacketFlyStaffParticle message, MessageContext ctx)
        {
        	

			
        }
    }
}
