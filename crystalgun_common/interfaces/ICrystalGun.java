package torresmon235.crystalgun.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ICrystalGun
{
	/**
	 * Sets CrystalGun Effects on players. Supported Effects = Fire, Potion, Heal.
	 * Args:
	 * Effect;
	 * Damage;
	 * Effect Number;
	 * Fire Time, Potion ID or Heal Amount;
	 * Potion Time;
	 * Potion Amplifier;
	 */
	
	public Item setEffect(String effect, int damage, int k, int l, int j);
	
	/**
	 * Sets CrystalGun Effect name to mouse description.
	 * Args:
	 * Name;
	 */
	
	public Item setName(String string);
	
	/**
	 * Sets Particle Color when shooting
	 * Args:
	 * Red;
	 * Green;
	 * Blue;
	 */
	
	public Item setColor(int red, int green, int blue);
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer);
}
