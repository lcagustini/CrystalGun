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
package torresmon235.crystalgun.items.armor;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.IArmorTextureProvider;
import net.minecraftforge.common.ISpecialArmor;

public class ItemOpalLeggings extends ItemArmor implements ISpecialArmor, IArmorTextureProvider
{

	public ItemOpalLeggings(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) 
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
	}

	@Override
	public String getArmorTextureFile(ItemStack itemstack) 
	{
		return "/torresmon235/crystalgun/textures/armor/gems2.png";
	}

	@Override
	public ArmorProperties getProperties(EntityLiving player, ItemStack armor, DamageSource source, double damage, int slot) 
	{
		int priority = 0;
		int absorbMax = 100;
		double absorbRatio = 0.2;
		
		if(source == DamageSource.explosion || source == DamageSource.explosion2) absorbRatio += 0.8645;
		else if(source == DamageSource.generic) absorbRatio += 0.4534;
		else if(source == DamageSource.wither) absorbRatio += 0.3634;
		
		return new ArmorProperties(priority, absorbRatio, absorbMax);
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) 
	{
		return 6;
	}

	@Override
	public void damageArmor(EntityLiving entity, ItemStack stack, DamageSource source, int damage, int slot) 
	{
		stack.damageItem(1, entity);
	}

	@Override
	public String getTextureFile()
	{
		return "/torresmon235/crystalgun/textures/items.png";
	}
}
