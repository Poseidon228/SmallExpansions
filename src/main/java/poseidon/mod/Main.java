package poseidon.mod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import poseidon.mod.client.keybinds.Keybinds;
import poseidon.mod.networking.packets.PacketHandler;
import poseidon.mod.objects.items.RecipeHandler;
import poseidon.mod.proxy.CommonProxy;
import poseidon.mod.tabs.AristoisItems;
import poseidon.mod.tabs.AristoisMaterials;
import poseidon.mod.tabs.AristoisTools;
import poseidon.mod.util.Reference;
import poseidon.mod.util.handlers.KeyInputHandler;
import poseidon.mod.util.handlers.RegistryHandler;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	@Instance
	public static Main instance;
	
	public static SimpleNetworkWrapper network;
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	public static CommonProxy proxy;
	
	public static final CreativeTabs ARISTOISITEMS = new AristoisItems("aristoisitems");
	

    public static final String NETWORK_CHANNEL_NAME = Reference.MODID;
    public static FMLEventChannel channel;
    
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		RegistryHandler.preInitRegistries();
		Keybinds.register();
		MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
		PacketHandler.registerMessages("psm");
//		proxy.preInit(event);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		RegistryHandler.initRegistries();
		RecipeHandler.registerCrafting();
		RecipeHandler.registerSmelting();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		RegistryHandler.postInitRegistries();
//		proxy.postInit(event);
	}
	
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event) {RegistryHandler.onServerInit(event);}
	
}