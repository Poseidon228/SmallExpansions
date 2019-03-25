package poseidon.mod.entity.render.living;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import poseidon.mod.entity.EntityCastiel;
import poseidon.mod.entity.model.ModelCastiel;
import poseidon.mod.util.Reference;

public class RenderCastiel extends RenderLiving<EntityCastiel> {
		
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/castiel.png");
	
	public RenderCastiel(RenderManager manager) {
		super(manager, new ModelCastiel(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityCastiel entity) {
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityCastiel entityLiving, float a, float b, float c) {
		super.applyRotations(entityLiving , a, b, c);
	}
	
}
