package poseidon.mod.entity.render.item;

import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEntityGunpowder extends RenderEntity {

	public RenderEntityGunpowder(RenderManager renderer) {
		super(renderer);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("psm:textures/entity/poweredgunpowder");
	}
	
}
