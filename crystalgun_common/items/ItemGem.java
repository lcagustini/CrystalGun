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

import java.util.List;

import torresmon235.crystalgun.common.CrystalGunMain;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGem extends Item 
{
	public ItemGem(int par1) 
	{
		super(par1);
		setItemName("Gem");
		setCreativeTab(CrystalGunMain.crystalGunTab);
		setHasSubtypes(true);
	}
	
	@Override
	public String getTextureFile()
	{
		return "/torresmon235/crystalgun/textures/items.png";
	}

	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i)
	{
		switch(i)
		{
		case 0:return 35;
		case 1:return 36;
		case 2:return 37;
		case 3:return 38;
		case 4:return 39;
		case 5:return 40;
		case 6:return 41;
		case 7:return 42;
		case 8:return 43;
		}
		return 0;
	}

	public String getItemNameIS(ItemStack is)
	{
		switch(is.getItemDamage())
		{
		case 0:return "Saphire";
		case 1:return "Ruby";
		case 2:return "Opal";
		case 3:return "Aquamarine";
		case 4:return "Topaz";
		case 5:return "Tourmaline";
		case 6:return "Peridot";
		case 7:return "Amethyst";
		case 8:return "SpessartiteGarnet";
		}
		return "Gem";
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab, List itemList)
	{
		for(int i = 0; i <= 8; i++)
		{
			itemList.add(new ItemStack(itemID,1,i));
		}
	}
}