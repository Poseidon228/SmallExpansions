package poseidon.mod.entity.render.living;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import poseidon.mod.entity.EntitySteve;
import poseidon.mod.entity.model.ModelSteve;
import poseidon.mod.util.Reference;

public class RenderSteve extends RenderLiving<EntitySteve> {
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/steve.png");

	public RenderSteve(RenderManager manager) {
	super(manager, new ModelSteve(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySteve entity) {
		return TEXTURES;
	}

	@Override
	protected void applyRotations(EntitySteve entityLiving, float a, float b, float c) {
		super.applyRotations(entityLiving , a, b, c);
	}

}
