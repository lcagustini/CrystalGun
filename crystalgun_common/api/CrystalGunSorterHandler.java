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

import java.util.ArrayList;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;

public class CrystalGunSorterHandler 
{
	private static ArrayList stringEntity = new ArrayList();
	private static ArrayList entities = new ArrayList();
	
	public static void addEntity(String sentity, Class entity)
	{
		stringEntity.add(sentity);
		entities.add(entity);
	}
	
	public static Class getEntity(String sentity)
	{
		for(int i = 0; i < entities.size(); i++)
		{
			if(sentity.equals(stringEntity.get(i)))
			{
				return (Class) entities.get(i);
			}
		}
		return null;
	}
}
