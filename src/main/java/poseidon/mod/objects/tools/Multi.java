package poseidon.mod.objects.tools;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import poseidon.mod.Main;
import poseidon.mod.init.ItemInit;
import poseidon.mod.util.interfaces.IHasModel;

public class Multi extends ItemTool implements IHasModel {
	
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Block.REGISTRY);
	private final ToolMaterial material;
	private boolean chop;
	
	public Multi(String name, ToolMaterial material)
	{
		super(material, EFFECTIVE_ON);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHarvestLevel("pickaxe", material.getHarvestLevel());
		setCreativeTab(Main.ARISTOISITEMS);
		this.material = material;
		maxStackSize = 1;
		setMaxDamage(material.getMaxUses());
		ItemInit.ITEMS.add(this);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isFull3D(){ return true; }
	//public float getDamageVsEntity() { return this.material.getDamageVsEntity(); }
	
	@Override
	public boolean canHarvestBlock(IBlockState blockIn) {
        
		Block block = blockIn.getBlock();
		
		if(block != Blocks.BEDROCK) {
			return true;
		}
		return true;
		
		
	/*	
        if(block == BlockInit.ALUMINIUM_ORE) {
        	return this.material.getHarvestLevel() >= 1;
        } 
        if(block == BlockInit.OIL_ORE) {
        		return this.material.getHarvestLevel() >= block.getHarvestLevel(block.getDefaultState());
        	} else if(block == BlockInit.COPPER_ORE) {
        		return this.material.getHarvestLevel() >= 1;
        	} else if(block == BlockInit.PETROLIUM_ORE) {
        		return this.material.getHarvestLevel() >= 2;
        	} else if(block == BlockInit.PLATINUM_ORE) {
        		System.out.println("plat");
        		return true;
        		//return this.material.getHarvestLevel() >= 2;
        	} else {
		return true;
        
        	}
        	*/
    }
	
	
	

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}


	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos,
									EntityLivingBase entityLiving) {
    	super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    	if(worldIn.getBlockState(pos).getBlock() instanceof BlockLog) {
	    	int y = 0;
	    	IBlockState BROKEN  = null;
			BlockPos nextBlock = new BlockPos(pos.getX(), pos.getY()+1+y, pos.getZ());
			getLeaves(worldIn, nextBlock, BROKEN, pos, y);
			if(chop) {
				while(worldIn.getBlockState(nextBlock).getBlock() instanceof BlockLog) {
					IBlockState OLD = worldIn.getBlockState(nextBlock);
					if(worldIn.getBlockState(nextBlock) != BROKEN)
					BROKEN = worldIn.getBlockState(nextBlock);
					worldIn.destroyBlock(nextBlock, true);
					y++;
					nextBlock = new BlockPos(pos.getX(), pos.getY()+1+y, pos.getZ());
				}

			}
			return true;
    	} else {
    		return false;
    	}
    		
	}
	
	private void getLeaves(World worldIn, BlockPos nextBlock, IBlockState BROKEN, BlockPos pos, int y) {
		while(worldIn.getBlockState(nextBlock).getBlock() instanceof BlockLog) {
			if(worldIn.getBlockState(nextBlock) != BROKEN)
				BROKEN = worldIn.getBlockState(nextBlock);
			y++;
			nextBlock = new BlockPos(pos.getX(), pos.getY()+1+y, pos.getZ());
		}
		BlockPos newpos = new BlockPos(pos.getX(), pos.getY() + y + 1, pos.getZ());
		if(worldIn.getBlockState(newpos).getBlock() instanceof BlockLeaves) {
			chop = true;
		}
	}
	
	
	

	

}
