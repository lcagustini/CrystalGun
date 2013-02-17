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
package torresmon235.crystalgun.items.crystalguns;

import torresmon235.crystalgun.common.CrystalGunMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCrystalGun extends Item
{
	public ItemCrystalGun(int par1)
	{
		super(par1);
		this.setMaxStackSize(1);
		this.bFull3D = true;
		this.setCreativeTab(CrystalGunMain.crystalGunTab);
	}
	
	@Override
	public String getTextureFile()
	{
		return "/torresmon235/crystalgun/textures/items.png";
	}
}
