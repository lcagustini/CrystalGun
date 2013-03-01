//Copyright (C) 2013  torresmon235
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.
package torresmon235.crystalgun.api;

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
