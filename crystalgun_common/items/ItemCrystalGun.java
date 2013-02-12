package torresmon235.crystalgun.items;

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
		this.bFull3D = true;
		this.setMaxStackSize(1);
		this.setCreativeTab(CrystalGunMain.crystalGunTab);
	}
	
	@Override
	public String getTextureFile()
	{
		return "/torresmon235/crystalgun/textures/items.png";
	}
}
