package poseidon.mod.client.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;
import poseidon.mod.init.EnchantmentInit;
import poseidon.mod.util.Reference;

public class Slime extends Enchantment{
	 
		public Slime() {
			super(Rarity.UNCOMMON, EnumEnchantmentType.ARMOR_FEET, new EntityEquipmentSlot[] {EntityEquipmentSlot.FEET});
			this.setName("slime");
			this.setRegistryName(new ResourceLocation(Reference.MODID + ":slime"));
			EnchantmentInit.ENCHANTMENTS.add(this);
		}
		
		@Override
		public int getMinEnchantability(int enchantmentLevel) {
			return 5 * enchantmentLevel;
		}
		
		@Override
		public int getMaxEnchantability(int enchantmentLevel) {
			return this.getMinEnchantability(enchantmentLevel) + 1;
		}
		
		@Override
		public int getMaxLevel() {
			return 1;
		}
		
		@Override
		public boolean canApplyTogether(Enchantment ench) {
			return super.canApplyTogether(ench) && ench != Enchantments.FEATHER_FALLING;
		}
}
