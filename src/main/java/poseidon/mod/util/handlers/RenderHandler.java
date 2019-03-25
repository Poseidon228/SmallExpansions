package poseidon.mod.util.handlers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import poseidon.mod.entity.EntityCastiel;
import poseidon.mod.entity.EntitySteve;
import poseidon.mod.entity.render.living.RenderCastiel;
import poseidon.mod.entity.render.living.RenderSteve;

public class RenderHandler {
	
	public static void registerEntityRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySteve.class, new IRenderFactory<EntitySteve>() {
			@Override
			public Render<? super EntitySteve> createRenderFor(RenderManager manager) {
				return new RenderSteve(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityCastiel.class, new IRenderFactory<EntityCastiel>() {
			@Override
			public Render<? super EntityCastiel> createRenderFor(RenderManager manager) {
				return new RenderCastiel(manager);
			}
		});
	}
	
}
