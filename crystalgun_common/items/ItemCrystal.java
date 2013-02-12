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

public class ItemCrystal extends Item 
{
	public ItemCrystal(int par1) 
	{
		super(par1);
		setItemName("Crystal");
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
		}
		return 0;
	}

	public String getItemNameIS(ItemStack is)
	{
		switch(is.getItemDamage())
		{
		case 0:return "WaterCrystal";
		case 1:return "FireCrystal";
		case 2:return "AirCrystal";
		case 3:return "IceCrystal";
		case 4:return "SandCrystal";
		case 5:return "LifeCrystal";
		case 6:return "GrassCrystal";
		case 7:return "PoisonCrystal";
		}
		return "Crystal";
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab, List itemList)
	{
		for(int i = 0; i <= 7; i++)
		{
			itemList.add(new ItemStack(itemID,1,i));
		}
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
		if(entityplayer.inventory.consumeInventoryItem(CrystalGunMain.CrystalGun.itemID))
		{
			int meta = itemstack.getItemDamage();
			int index = 448 - itemstack.stackSize * 7;
			
			if(meta == 0) return new ItemStack(CrystalGunMain.CrystalGunWater, 1, index);
			if(meta == 1) return new ItemStack(CrystalGunMain.CrystalGunFire, 1, index);
			if(meta == 2) return new ItemStack(CrystalGunMain.CrystalGunAir, 1, index);
			if(meta == 3) return new ItemStack(CrystalGunMain.CrystalGunIce, 1, index);
			if(meta == 4) return new ItemStack(CrystalGunMain.CrystalGunSand, 1, index);
			if(meta == 5) return new ItemStack(CrystalGunMain.CrystalGunLife, 1, index);
			if(meta == 6) return new ItemStack(CrystalGunMain.CrystalGunGrass, 1, index);
			if(meta == 7) return new ItemStack(CrystalGunMain.CrystalGunPoison, 1, index);
		}
        return itemstack;
    }
}