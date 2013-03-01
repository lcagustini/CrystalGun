package torresmon235.crystalgun.tileentities;

import torresmon235.crystalgun.api.CrystalGunSorterHandler;
import torresmon235.crystalgun.common.CrystalGunMain;
import net.minecraft.entity.EntityLiving;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMagicalSorter extends TileEntity
{
	public String sentity;
	
	public TileEntityMagicalSorter()
	{
		
	}
	
	public boolean entityFall(EntityLiving entity)
	{
		if(entity.getClass().equals(CrystalGunSorterHandler.getEntity(sentity)))
		{
			return false;
		}
		return true;
	}
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
		super.readFromNBT(par1NBTTagCompound);
		
		sentity = par1NBTTagCompound.getString("sentity");
    }
	
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
		super.writeToNBT(par1NBTTagCompound);
		
		par1NBTTagCompound.setString("sentity", sentity);
    }
}
