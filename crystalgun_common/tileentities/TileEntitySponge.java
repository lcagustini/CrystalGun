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
package torresmon235.crystalgun.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntitySponge extends TileEntity
{	
	private int range;
	
	public TileEntitySponge(int Range)
	{
		this.range = Range;
	}
	
	@Override
	public void updateEntity()
	{
		removeWater(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
	
	public void removeWater(World world, int x, int y, int z)
	{
		if(!world.isRemote)
    	{
			for(int j = -range; j <= range; j++)
			{
				for(int k = -range; k <= range; k++)
				{
					for(int i = -range; i <= range; i++)
					{
						if(this.worldObj.getBlockId(x + k, y + j, z + i) == 8 || this.worldObj.getBlockId(x + k, y + j, z + i) == 9) world.setBlock(x + k, y + j, z + i, 0);
					}
				}
			}
    	}
    }
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
		super.readFromNBT(par1NBTTagCompound);
    }
	
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
		super.writeToNBT(par1NBTTagCompound);
    }
}
