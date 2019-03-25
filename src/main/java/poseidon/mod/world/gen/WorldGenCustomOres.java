package poseidon.mod.world.gen;

import java.util.Random;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import poseidon.mod.init.BlockInit;

public class WorldGenCustomOres implements IWorldGenerator {

	/*private WorldGenerator platinum_ore;
	private WorldGenerator petrolium_ore;
	private WorldGenerator aluminium_ore;*/
	
	
	public WorldGenCustomOres() {
	    //oil_ore_nether = new WorldGenMinable(BlockInit.OIL_ORE.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.NETHERRACK));
		//platinum_ore = new WorldGenMinable(BlockInit.PLATINUM_ORE.getDefaultState(), 3);
		//petrolium_ore = new WorldGenMinable(BlockInit.PETROLIUM_ORE.getDefaultState(), 12);
		//aluminium_ore = new WorldGenMinable(BlockInit.ALUMINIUM_ORE.getDefaultState(), 8);
	}
		

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.getDimension()) {
		
		case 0:
		
		//	runGenerator(angel_iron_ore, world, random, chunkX, chunkZ, 9, 0, 15);

			//runGenerator(platinum_ore, world, random, chunkX, chunkZ, 2, 0, 10);
			//runGenerator(petrolium_ore, world, random, chunkX, chunkZ, 3, 20, 40);
			//runGenerator(aluminium_ore, world, random, chunkX, chunkZ, 5, 60, 80);
			
			break;
			
			
		case 1:
		
			break;
			
			
		case -1:
			
			
		 	break;
		
		}
	
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {
		
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		int heightDiff = maxHeight - minHeight + 1;
		
		for(int i = 0; i < chance; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x, y ,z));
		}
		
	}
	
}
