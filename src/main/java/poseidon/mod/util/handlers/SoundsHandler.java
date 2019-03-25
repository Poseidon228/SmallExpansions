package poseidon.mod.util.handlers;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import poseidon.mod.util.Reference;

public class SoundsHandler {
	
	public static SoundEvent IMMIGRANT_MUSIC;
	public static SoundEvent STASIS, CHESTSOLD, BADISLAND, DANGER, OUTPOST, MARAUDER, TELEPORT, CHECKPOINT, MIRROR;
	
	public static void registerSounds() {
		STASIS = registerSound("item.effects.stasis");
		OUTPOST = registerSound("item.effects.outpost");
		MARAUDER = registerSound("item.effects.marauder");
		CHESTSOLD = registerSound("item.effects.chestsold");
		BADISLAND = registerSound("item.effects.badisland");
		DANGER = registerSound("item.effects.danger");
		IMMIGRANT_MUSIC = registerSound("item.effects.immigrant");
		TELEPORT = registerSound("item.effects.teleport");
		CHECKPOINT = registerSound("item.effects.checkpoint");
		MIRROR = registerSound("item.effects.mirror");
	}
	
	private static SoundEvent registerSound(String name) {
		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
	
	
}
