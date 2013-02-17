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

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import torresmon235.crystalgun.common.CrystalGunMain;
import torresmon235.crystalgun.entities.EntityPoison;
import torresmon235.crystalgun.interfaces.ICrystalGun;

public class ItemCrystalGunPoison extends Item implements ICrystalGun
{
	public static ArrayList effects = new ArrayList();
	public static ArrayList potion = new ArrayList();
	public static ArrayList fireheal = new ArrayList();
	public static ArrayList effectsextra = new ArrayList();

	public static String name;
	
	public static int red;
	public static int green;
	public static int blue;

	public ItemCrystalGunPoison(int par1)
	{
		super(par1);
		this.setCreativeTab(CrystalGunMain.crystalGunTab);
		this.bFull3D = true;
		this.setMaxDamage(447);
		this.setMaxStackSize(1);
	}
	
	@Override
	public String getTextureFile()
	{
		return "/torresmon235/crystalgun/textures/items.png";
	}
	
	public ItemCrystalGunPoison setName(String string)
	{
		name = string;
		return this;
	}
	
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	if(name != null) par3List.add(name);
    	par3List.add(448 - par1ItemStack.getItemDamage() + " Shots");
    }

    public ItemCrystalGunPoison setEffect(String effect, int damage, int k, int l, int j)
    {
		effects.add(effect);
		if(effect == "Potion")
		{
			potion.add(0, damage);
			potion.add(1, k);
			potion.add(2, l);
			potion.add(3, j);
			effectsextra.add(potion);
		}
		if(effect == "Fire" || effect == "Heal" || effect == "Knockback")
		{
			fireheal.add(0 ,damage);
			fireheal.add(1, k);
			effectsextra.add(fireheal);
		}
		else
		{
			System.out.println("Unsupported Effect");
		}
		return this;
	}
    
    public ItemCrystalGunPoison setColor(int redColor, int greenColor, int blueColor)
    {
    	if(redColor != 0 || greenColor != 0 || blueColor != 0)
		{
			red = redColor;
			green = greenColor;
			blue = blueColor;
		}
		else
		{
			red = green = blue = 0;
		}
    	return this;
    }
	
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }
    
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		world.playSoundAtEntity(entityplayer, "crystalgun.shot", 0.7565F, 0.0F + itemRand.nextFloat() / 6);
    	if(!world.isRemote)
    	{
    		EntityPoison entity = new EntityPoison(world, entityplayer, effects, effectsextra, red, green, blue);
    		world.spawnEntityInWorld(entity);
    		if(itemstack.getItemDamage() < 447) itemstack.damageItem(1, entityplayer);
    		else
    		{
    			itemstack.damageItem(1, entityplayer);
    			return new ItemStack(CrystalGunMain.CrystalGun, 1);
    		}
    	}
    	return itemstack;
	}
}
