package torresmon235.crystalgun.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CrystalGunCreativeTab extends CreativeTabs
{
	public CrystalGunCreativeTab(String label) 
	{
	    super(label);
	}
	@Override
	public ItemStack getIconItemStack() 
	{
	    return new ItemStack(CrystalGunMain.CrystalGun);
	}
}
