package poseidon.mod.objects.block.modblocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import poseidon.mod.objects.block.BlockBase;

public class WitchedBlock extends BlockBase {
	
	public WitchedBlock(String name, Material material, float light, float hard, float res, int harvest) {
		super(name, material, 2.0f, hard, res, harvest);
		setTickRandomly(true);
	}
	
	@Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
        if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
        {
            entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 4.0F);
        }

        super.onEntityWalk(worldIn, pos, entityIn);
    }
	
	@Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		
		List<Entity> playerList = worldIn.getEntitiesWithinAABB(null, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 20.0D, pos.getY() + 20.0D, pos.getZ() + 20.0D));

		List<Entity> playerList2 = worldIn.getEntitiesWithinAABB(null, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() - 20.0D, pos.getY()+ 20.0D, pos.getZ() + 20.0D));
		List<Entity> playerList3 = worldIn.getEntitiesWithinAABB(null, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 20.0D, pos.getY()+ 20.0D, pos.getZ() - 20.0D));
		List<Entity> playerList4 = worldIn.getEntitiesWithinAABB(null, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() - 20.0D, pos.getY()+ 20.0D, pos.getZ() - 20.0D));
		
		List<Entity> playerList5 = worldIn.getEntitiesWithinAABB(null, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 20.0D, pos.getY()- 20.0D, pos.getZ() + 20.0D));
		List<Entity> playerList6 = worldIn.getEntitiesWithinAABB(null, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() - 20.0D, pos.getY()- 20.0D, pos.getZ() + 20.0D));
		List<Entity> playerList7 = worldIn.getEntitiesWithinAABB(null, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 20.0D, pos.getY()- 20.0D, pos.getZ() - 20.0D));
		List<Entity> playerList8 = worldIn.getEntitiesWithinAABB(null, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() - 20.0D, pos.getY()- 20.0D, pos.getZ() - 20.0D));
		System.out.println(playerList);
		collideWithEntities(playerList, playerList2, playerList3, playerList4, playerList5, playerList6, playerList7, playerList8, worldIn);
		
    }
	
    private void collideWithEntities(List<Entity> list1, List<Entity> list2, List<Entity> list3, List<Entity> list4, List<Entity> list5, List<Entity> list6, List<Entity> list7, List<Entity> list8, World worldIn)
    {
    	EntityZombie player = new EntityZombie(worldIn);
        double d0 = (player.getEntityBoundingBox().minX + player.getEntityBoundingBox().maxX) / 2.0D;
        double d1 = (player.getEntityBoundingBox().minZ + player.getEntityBoundingBox().maxZ) / 2.0D;

        for (Entity entity : list1)
        {
            if (entity instanceof EntityLivingBase)
            {
                double d2 = entity.posX - d0;
                double d3 = entity.posZ - d1;
                double d4 = d2 * d2 + d3 * d3 / 5;
                entity.addVelocity(d2 / d4 * 10.0D, 0.20000000298023224D, d3 / d4 * 10.0D);

            }
        }
        
        for (Entity entity : list2)
        {
            if (entity instanceof EntityLivingBase)
            {
                double d2 = entity.posX - d0;
                double d3 = entity.posZ - d1;
                double d4 = d2 * d2 + d3 * d3 / 5;
                entity.addVelocity(d2 / d4 * 10.0D, 0.20000000298023224D, d3 / d4 * 10.0D);

            }
        }
        
        for (Entity entity : list3)
        {
            if (entity instanceof EntityLivingBase)
            {
                double d2 = entity.posX - d0;
                double d3 = entity.posZ - d1;
                double d4 = d2 * d2 + d3 * d3 / 5;
                entity.addVelocity(d2 / d4 * 10.0D, 0.20000000298023224D, d3 / d4 * 10.0D);

            }
        }
        
        for (Entity entity : list4)
        {
            if (entity instanceof EntityLivingBase)
            {
                double d2 = entity.posX - d0;
                double d3 = entity.posZ - d1;
                double d4 = d2 * d2 + d3 * d3 / 5;
                entity.addVelocity(d2 / d4 * 10.0D, 0.20000000298023224D, d3 / d4 * 10.0D);

            }
        }
        
        for (Entity entity : list5)
        {
            if (entity instanceof EntityLivingBase)
            {
                double d2 = entity.posX - d0;
                double d3 = entity.posZ - d1;
                double d4 = d2 * d2 + d3 * d3 / 5;
                entity.addVelocity(d2 / d4 * 10.0D, 0.20000000298023224D, d3 / d4 * 10.0D);

            }
        }
        
        for (Entity entity : list6)
        {
            if (entity instanceof EntityLivingBase)
            {
                double d2 = entity.posX - d0;
                double d3 = entity.posZ - d1;
                double d4 = d2 * d2 + d3 * d3 / 5;
                entity.addVelocity(d2 / d4 * 10.0D, 0.20000000298023224D, d3 / d4 * 10.0D);

            }
        }
        
        for (Entity entity : list7)
        {
            if (entity instanceof EntityLivingBase)
            {
                double d2 = entity.posX - d0;
                double d3 = entity.posZ - d1;
                double d4 = d2 * d2 + d3 * d3 / 5;
                entity.addVelocity(d2 / d4 * 10.0D, 0.20000000298023224D, d3 / d4 * 10.0D);

            }
        }
        
        for (Entity entity : list8)
        {
            if (entity instanceof EntityLivingBase)
            {
                double d2 = entity.posX - d0;
                double d3 = entity.posZ - d1;
                double d4 = d2 * d2 + d3 * d3 / 5;
                entity.addVelocity(d2 / d4 * 10.0D, 0.20000000298023224D, d3 / d4 * 10.0D);

            }
        }
        
        
    }
	
}
