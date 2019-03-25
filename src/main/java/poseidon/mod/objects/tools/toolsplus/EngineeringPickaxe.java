package poseidon.mod.objects.tools.toolsplus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import poseidon.mod.Main;
import poseidon.mod.init.ItemInit;
import poseidon.mod.util.interfaces.IHasModel;

public class EngineeringPickaxe extends ItemTool implements IHasModel {

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Block.REGISTRY);
	public final List<BlockPos> logs = new ArrayList<BlockPos>();
	NBTTagCompound nbt;
	private boolean chop;
	
	public EngineeringPickaxe(String name, ToolMaterial material) {
		super(material, EFFECTIVE_ON);
		setUnlocalizedName(name);
		setRegistryName(name);
		setMaxStackSize(1);
		setCreativeTab(Main.ARISTOISITEMS);
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
		return super.canHarvestBlock(state, stack);
	}
	
//	@Override
//	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
//		if(!stack.hasTagCompound()) {
//			getNBT(stack);
//		}
//	}
	
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
	/*
	private void getNBT(ItemStack stack) {
		if(!stack.hasTagCompound()) {
			nbt = new NBTTagCompound();
		}
		if(nbt.hasKey("x")) {
			nbt.setInteger("x", nbt.getInteger("x"));
			} else {
			nbt.setInteger("x", 0);
		}
		
		if(nbt.hasKey("y")) {
			nbt.setInteger("y", nbt.getInteger("y"));
			} else {
			nbt.setInteger("y", 0);
		}
		if(nbt.hasKey("z")) {
			nbt.setInteger("z", nbt.getInteger("z"));
			} else {
			nbt.setInteger("z", 0);
		}
		stack.setTagCompound(nbt);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack heldItem = player.getHeldItem(hand);
		if(!heldItem.hasTagCompound() && heldItem.getTagCompound().hasKey("x") && heldItem.getTagCompound().hasKey("y") && heldItem.getTagCompound().hasKey("z")) {
			getNBT(heldItem);
		}
		
		if(heldItem.getTagCompound().getInteger("x") != 0 && heldItem.getTagCompound().getInteger("y") != 0 && heldItem.getTagCompound().getInteger("z") != 0) {
			
			int x = heldItem.getTagCompound().getInteger("x");
			int y = heldItem.getTagCompound().getInteger("y");
			int z = heldItem.getTagCompound().getInteger("z");
			
			int x2 = pos.getX();
			int y2 = pos.getY();
			int z2 = pos.getZ();
			
			BlockPos position1 = new BlockPos(x, y, z);
			BlockPos position2 = new BlockPos(x2, y2, z2);
			
			removeBlocks(position1, position2, worldIn, player);
			
			heldItem.getTagCompound().setInteger("x", 0);
			heldItem.getTagCompound().setInteger("y", 0);
			heldItem.getTagCompound().setInteger("z", 0);
			
			
		} else {
		
//		if(heldItem.getTagCompound().getInteger("x") == 0 && heldItem.getTagCompound().getInteger("z") == 0 && heldItem.getTagCompound().getInteger("z") == 0) {
			
			//get new coords
			
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			
			heldItem.getTagCompound().setInteger("x", x);
			heldItem.getTagCompound().setInteger("y", y);
			heldItem.getTagCompound().setInteger("z", z);
			
		}
		
		
		return EnumActionResult.SUCCESS;
	}
	
	private void removeBlocks(BlockPos pos1, BlockPos pos2, World world, EntityPlayer player) {
		
		Iterable<BlockPos> positions = BlockPos.getAllInBox(pos1, pos2);
		 
		for(Iterator<BlockPos> i = positions.iterator(); i.hasNext(); ) {
			
	           Block te = world.getBlockState(i.next()).getBlock();
	           
	           if (te instanceof BlockLog) {
	               if (!logs.contains(i.next())) {
	                   logs.add(i.next());
	               }
	           }
	    }
	
		validate(pos1, pos2, world, player);
		
	}
	
	private void validate(BlockPos pos1, BlockPos pos2, World world, EntityPlayer player) {
	
		Iterator<BlockPos> it = logs.listIterator();
		while(it.hasNext()) {

			world.destroyBlock(it.next(), true);
			
		}
	
	}
	
	
	public void addInformation(ItemStack stack, World world, List<String> addlore, ITooltipFlag advanced) {
		
		if(stack.hasTagCompound()) {
			if(stack.getTagCompound().getInteger("X") == 0) {
				
			}
		}
		
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("x") && stack.getTagCompound().hasKey("y") && stack.getTagCompound().hasKey("z")) {
			addlore.add(""  + TextFormatting.DARK_BLUE + "X" + TextFormatting.RESET + TextFormatting.BLUE + ": " 
							+ TextFormatting.RESET + TextFormatting.WHITE +  Integer.toString(stack.getTagCompound().getInteger("x"))
							+ TextFormatting.DARK_BLUE + "Y" + TextFormatting.RESET + TextFormatting.BLUE + ": " 
							+ TextFormatting.RESET + TextFormatting.WHITE +  Integer.toString(stack.getTagCompound().getInteger("y"))
							+ TextFormatting.DARK_BLUE + "Z" + TextFormatting.RESET + TextFormatting.BLUE + ": " 
							+ TextFormatting.RESET + TextFormatting.WHITE +  Integer.toString(stack.getTagCompound().getInteger("z"))
					);
		}
		
		

		
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("Level")) {
			addlore.add("" + TextFormatting.GOLD + "Level" + TextFormatting.RESET + TextFormatting.WHITE + ": " + TextFormatting.DARK_RED + Integer.toString(stack.getTagCompound().getInteger("Level")));
		}
		
	}
	*/
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this,  0, "inventory");
	}

}
