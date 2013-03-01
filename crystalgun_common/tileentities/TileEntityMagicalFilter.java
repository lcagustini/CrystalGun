package torresmon235.crystalgun.tileentities;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMagicalFilter extends TileEntity
{
	public TileEntityMagicalFilter()
	{
		
	}
	
	private ItemStack saved;
	
	public ItemStack getSaved() 
	{
		return saved;
	}
	
	public void setSaved(ItemStack item)
	{
		saved = item;
	}
	
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
		super.writeToNBT(par1NBTTagCompound);
		
		if(saved != null)
		{
			par1NBTTagCompound.setInteger("itemid", saved.itemID);
			par1NBTTagCompound.setInteger("itemdmg", saved.getItemDamage());
		}
    }
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
		super.readFromNBT(par1NBTTagCompound);
		
		saved = new ItemStack(Item.wheat, 1, par1NBTTagCompound.getInteger("itemdmg"));
		saved.itemID = par1NBTTagCompound.getInteger("itemid");
    }
}
