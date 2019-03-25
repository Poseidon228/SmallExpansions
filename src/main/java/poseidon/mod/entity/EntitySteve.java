package poseidon.mod.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntitySteve  extends EntityCreature {
	
	public EntitySteve(World worldin) {
		super(worldin);
		this.setSize(0.6F, 1.95F);
	}
	
	@Override
	protected void initEntityAI() {

	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
	}
	
	@Override
	public float getEyeHeight() {
		return 1.0F;
	}
	/*
	@Override
	protected ResourceLocation getLootTable() {
		return LootTableHandler.CASTIEL;
	}
	*/
	
	@Override
	protected SoundEvent getAmbientSound() {
		return super.getAmbientSound();
	}

	
	@Override
	protected SoundEvent getDeathSound() {
		return super.getDeathSound();
	}
	
}
