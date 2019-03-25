package poseidon.mod.util.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import poseidon.mod.client.commands.util.Heal;
import poseidon.mod.client.keybinds.Keybinds;
import poseidon.mod.init.ItemInit;

public class KeyInputHandler {

//	int focus;
//	int hasLevel;
	
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.player;
		ItemStack power = new ItemStack(ItemInit.ELYTRON_DUST);
		
		if(Keybinds.elytraBoost.isPressed()) {
			
			if(player.inventory.hasItemStack(power)) {
				double camX = player.getLookVec().x;
			    double camY = player.getLookVec().y;
			    double camZ = player.getLookVec().z;
				
			    double velocityAddedX = camX * 4.0F;
			    double velocityAddedY = camY * 4.0F;
			    double velocityAddedZ = camZ * 4.0F;
			     
			    double currentVelocityX = player.motionX + velocityAddedX;
			    double currentVelocityY = player.motionY + velocityAddedY;
			    double currentVelocityZ = player.motionZ + velocityAddedZ;
			    
			    player.setVelocity(currentVelocityX, currentVelocityY, currentVelocityZ);
			    
			    if(player.inventory.hasItemStack(power)) {
			    	int slot = player.inventory.getSlotFor(power);
			    	player.inventory.getStackInSlot(slot).shrink(1);
			    }
			    
			}
		}

		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
