package poseidon.mod.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import poseidon.mod.Main;
import poseidon.mod.entity.EntityCastiel;
import poseidon.mod.entity.EntitySteve;
import poseidon.mod.objects.entities.LightningEgg;
import poseidon.mod.util.Reference;

public class EntityInit {
	
	public static void registerEntities() {
		registerEntity("steve", EntitySteve.class, Reference.ENTITY_STEVE, 50, 30000000, 600000);
		registerEntity("castiel", EntityCastiel.class, Reference.ENTITY_CASTIEL, 50, 30000000, 100000);
		registerEntity("poweredgunpowder", LightningEgg.class, Reference.ENTITY_GUNPOWDER, 128, 1, 1);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
	
}
