package poseidon.mod.client.keybinds;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinds {
	
	public static KeyBinding elytraBoost;
	public static final String elytraboost = "Velocity Boost";
	
	public static KeyBinding healPlayer;
	public static final String healplayer = "Quick Heal";
	
	public static void register() {
		elytraBoost = new KeyBinding("Elytra Boost", 47, "key.categories.movement");
		ClientRegistry.registerKeyBinding(elytraBoost);
		

	}
	
}
