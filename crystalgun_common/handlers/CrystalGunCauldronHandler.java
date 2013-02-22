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

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CrystalGunCauldronHandler 
{
	public static ArrayList Ingredient = new ArrayList();
	public static ArrayList ID = new ArrayList();
	public static ArrayList Amp = new ArrayList();
	public static ArrayList Dur = new ArrayList();

	public static void addRecipe(ItemStack input, int Id, int amp, int dur)
	{
		Ingredient.add(input);
		ID.add(Id);
		Amp.add(amp);
		Dur.add(dur);
	}
	
	public static void addRecipe(Item input, int Id, int amp, int dur)
	{
		Ingredient.add(new ItemStack(input, 1));
		ID.add(Id);
		Amp.add(amp);
		Dur.add(dur);
	}
	
	public static ArrayList getResult(ItemStack itemstack)
	{
		ArrayList result = new ArrayList();
		for(int i = 0; i < Ingredient.size(); i++)
		{
			if(itemstack.getItem() == ((ItemStack)Ingredient.get(i)).getItem() && itemstack.getItemDamage() == ((ItemStack)Ingredient.get(i)).getItemDamage())
			{
				result.add(ID.get(i));
				result.add(Amp.get(i));
				result.add(Dur.get(i));
			}
		}
		return result;
	}
}
