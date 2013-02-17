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
package torresmon235.crystalgun.handlers;

import java.util.ArrayList;
import java.util.Iterator;

import torresmon235.crystalgun.common.CrystalGunMain;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CrystalGunExtractorHandler 
{
	public static ArrayList ingredient = new ArrayList();
	public static ArrayList result = new ArrayList();
	
	public static void addRecipe(ItemStack input, ItemStack output)
	{
		ingredient.add(input);
		result.add(output);
	}
	
	public static void addRecipe(Item input, ItemStack output)
	{
		ingredient.add(new ItemStack(input, 1));
		result.add(output);
	}
	
	public static boolean spawnResult(World world, ItemStack itemstack, double x, double y, double z)
	{
		EntityItem entity1 = null;
		boolean spawned = false;
		
		for(int i = 0; i < result.size(); i++)
		{
			if(itemstack.getItem() == ((ItemStack)ingredient.get(i)).getItem() && itemstack.getItemDamage() == ((ItemStack)ingredient.get(i)).getItemDamage())
			{
				ItemStack item1 = new ItemStack(((ItemStack) result.get(i)).getItem(), ((ItemStack) result.get(i)).stackSize, ((ItemStack) result.get(i)).getItemDamage());
				itemstack.stackSize--;
				entity1 = new EntityItem(world, x, y, z, item1);
				if(world.spawnEntityInWorld(entity1)) spawned = true;
			}
		}
		return spawned;
	}
}
