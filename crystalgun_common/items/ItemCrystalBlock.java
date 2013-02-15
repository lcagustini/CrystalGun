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
package torresmon235.crystalgun.items;

import torresmon235.crystalgun.common.CrystalGunMain;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCrystalBlock extends ItemBlock
{
	public ItemCrystalBlock(int par1)
	{
		super(par1);
		this.setMaxDamage(0); //Stops bad things from happening
		this.setHasSubtypes(true); //Tells it that it has metadata versions
	}
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int par1) //Gets the texture
	{
		return CrystalGunMain.CrystalBlock.getBlockTextureFromSideAndMetadata(2, par1);
	}
	public int getMetadata(int par1) //Returns the metadata value
	{
		return par1;
	}
	public String getItemNameIS(ItemStack is) //Get's the item incode name from an itemstack
	{
		String[] types = {"Water", "Fire", "Air", "Ice", "Sand", "Life", "Grass", "Poison", "Healing"};
		return types[is.getItemDamage()] + "CrystalBlock";
	}
}