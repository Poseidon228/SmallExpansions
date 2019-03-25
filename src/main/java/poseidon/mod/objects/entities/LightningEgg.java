package poseidon.mod.objects.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class LightningEgg extends EntityThrowable
{
    public LightningEgg(World worldIn)
    {
        super(worldIn);
    }

    public LightningEgg(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public LightningEgg(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public static void registerFixesEgg(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "ThrownEgg");
    }
    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onImpact(RayTraceResult result) {
    	


        if (!this.world.isRemote)
        {


                	BlockPos pos = result.getBlockPos();
        			double x = pos.getX();
        			double y = pos.getY();
        			double z = pos.getZ();
        			Entity bolt = new EntityLightningBolt(this.world, x, y, z, false);
        			this.world.addWeatherEffect(bolt);
                
            

            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
    }
}
