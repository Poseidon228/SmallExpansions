package poseidon.mod.proxy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import poseidon.mod.Main;
import poseidon.mod.networking.MessageToServer;
import poseidon.mod.objects.items.RecipeHandler;

public class CommonProxy {
	
	public void registerItemRenderer(Item item, int meta, String id) {}
	public void registerVariantRenderer(Item item, int meta, String filename, String id) {}

	public void preInit(FMLPreInitializationEvent event) {
        registerSimpleNetworking();
	}
	
	public void init(FMLInitializationEvent event) {
		RecipeHandler.registerCrafting();
		RecipeHandler.registerSmelting();
	}

	public void postInit(FMLPostInitializationEvent event) {
		
	}

	
	
	protected void registerSimpleNetworking() {
		Main.network = NetworkRegistry.INSTANCE.newSimpleChannel(Main.NETWORK_CHANNEL_NAME);

		int packetId = 0;
		// register messages from client to server
        Main.network.registerMessage(MessageToServer.Handler.class, MessageToServer.class, packetId++, Side.SERVER);

	}
	
    public EntityPlayer getPlayerEntityFromContext(MessageContext ctx)
    {
        return ctx.getServerHandler().player;
    }
	
    public void damageStack(ItemStack stack, Entity entity) {}
    public void generateFlyStaffParticles(Entity theEntity) {}
    public void generateRiftParticleTakeOff(Entity theEntity) {}
    public void generateRiftParticleOnUpdate(Entity theEntity) {}
    public void generateTrail(Entity entity) {}
    public void generateCharmParticleGlide(Entity theEntity) {}
    public void generateCharmParticleDepth(Entity entity) {}
    public void generateCharmParticleProj(Entity entity) {}
    public void generateCharmParticleFire(Entity entity) {}
    public void generateCharmParticleFall(Entity theEntity) {}
    
}
