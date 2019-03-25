package poseidon.mod.objects.items.general.test;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import poseidon.mod.init.ItemInit;
import poseidon.mod.objects.tools.ToolHoe;
import poseidon.mod.util.handlers.SoundsHandler;

public class Mirror extends ToolHoe {

	public Mirror(String name, int size) {
		super(name, ItemInit.WOOD_MULTI);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		return EnumActionResult.PASS;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
//		BlockPos pos = new BlockPos(worldIn.getTopSolidOrLiquidBlock(playerIn.getPosition()));
//		double x = pos.getX();
//		double y = pos.getY();
//		double z = pos.getZ();
//		
//		playerIn.attemptTeleport(x, y, z);
//		
//		worldIn.playSound(playerIn, playerIn.getPosition(), SoundsHandler.MIRROR, SoundCategory.AMBIENT, 1.0F, 1.0F);
//		playerIn.getCooldownTracker().setCooldown(this, 100);
//		playerIn.getHeldItem(handIn).damageItem(1, playerIn);
		getTop(playerIn.getPosition(), worldIn, playerIn);
		return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}
	
	private void getTop(BlockPos playerPos, World worldIn, EntityPlayer player) {
		
		double x = playerPos.getX();
		double y = playerPos.getY() + 3.0D;
		double z = playerPos.getZ();
		
		for(double i = 0; i < 300; i++) {
			BlockPos newPos = new BlockPos(x, y + i, z);
			IBlockState state = worldIn.getBlockState(newPos);
			Block block = state.getBlock();
			System.out.println("check1: " + block);
			
			if(block.getDefaultState() == Blocks.AIR.getDefaultState()) {
				BlockPos newPos2 = new BlockPos(x, y + i + 1.0D, z);
				IBlockState state2 = worldIn.getBlockState(newPos2);
				Block block2 = state2.getBlock();
				
				System.out.println("check2: " + block2);
				
				if(block2.getDefaultState() == Blocks.AIR.getDefaultState()) {
					BlockPos newPos3 = new BlockPos(x, y + i - 1.0D, z);
					IBlockState state3 = worldIn.getBlockState(newPos3);
					Block block3 = state3.getBlock();
					System.out.println("check3: " + block3);
					
					if(!(block3.getDefaultState() == Blocks.AIR.getDefaultState())) {
						player.attemptTeleport(x, y + i, z);
						System.out.println("check4: " + block);
						return;
					}
				}
			}
		}
		
	}
	
}
