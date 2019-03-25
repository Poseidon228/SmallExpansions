package poseidon.mod.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import poseidon.mod.init.ItemInit;

public class EntityCastiel extends EntityCreature {
	
	public EntityCastiel(World worldin) {
		super(worldin);
		this.setSize(0.6F, 1.95F);
	}
	
	@Override
	protected void initEntityAI() {
		
	}
	
	@Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {

    }
	

	
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();

		/*
		 if (this.world.isRemote)
	        {
	            for (int i = 0; i < 20; ++i)
	            {
	                double d0 = this.rand.nextGaussian() * 0.02D;
	                double d1 = this.rand.nextGaussian() * 0.02D;
	                double d2 = this.rand.nextGaussian() * 0.02D;
	                double d3 = 10.0D;
	                this.world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width - d0 * 10.0D, this.posY + (double)(this.rand.nextFloat() * this.height) - d1 * 10.0D, this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width - d2 * 10.0D, d0, d1, d2);
	            }
	        }
	        */
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
	
	@Override
    protected boolean canDespawn()
    {
        return false;
    }
	
}
