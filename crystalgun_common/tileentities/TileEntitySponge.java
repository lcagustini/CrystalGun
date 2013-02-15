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

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntitySponge extends TileEntity
{
	public TileEntitySponge()
	{
		
	}
	
	@Override
	public void updateEntity()
	{
		if(!this.worldObj.isRemote)
    	{
			World world = this.worldObj;
			int x = this.xCoord;
			int y = this.yCoord;
			int z = this.zCoord;
			
			for(int j = -2; j <= 2; j++)
			{
				for(int k = -2; k <= 2; k++)
				{
					for(int i = -2; i <= 2; i++)
					{
						if(this.worldObj.getBlockId(x + k, y + j, z + i) == 8 || this.worldObj.getBlockId(x + k, y + j, z + i) == 9) world.setBlock(x + k, y + j, z + i, 0);
					}
				}
			}
    	}
	}
}
