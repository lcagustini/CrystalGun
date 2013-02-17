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

public class ItemShinyCrystal extends Item 
{
	public ItemShinyCrystal(int par1) 
	{
		super(par1);
		setItemName("ShinyCristal");
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
		case 0:return 0;
		case 1:return 1;
		case 2:return 2;
		case 3:return 3;
		case 4:return 4;
		case 5:return 5;
		case 6:return 19;
		case 7:return 22;
		case 8:return 32;
		}
		return 0;
	}

	public String getItemNameIS(ItemStack is)
	{
		switch(is.getItemDamage())
		{
		case 0:return "ShinyWaterCrystal";
		case 1:return "ShinyFireCrystal";
		case 2:return "ShinyAirCrystal";
		case 3:return "ShinyIceCrystal";
		case 4:return "ShinySandCrystal";
		case 5:return "ShinyLifeCrystal";
		case 6:return "ShinyGrassCrystal";
		case 7:return "ShinyPoisonCrystal";
		case 8:return "ShinyHealingCrystal";
		}
		return "ShinyCristal";
	}
	
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
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