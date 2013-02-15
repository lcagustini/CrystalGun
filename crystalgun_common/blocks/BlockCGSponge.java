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
package torresmon235.crystalgun.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import torresmon235.crystalgun.common.CrystalGunMain;
import torresmon235.crystalgun.tileentities.TileEntitySponge;

public class BlockCGSponge extends BlockContainer
{
	public BlockCGSponge(int par1)
    {
        super(par1, Material.sponge);
        this.blockIndexInTexture = 48;
		this.setCreativeTab(CrystalGunMain.crystalGunTab);
    }
	
    public boolean hasTileEntity()
	{
		return true;
	}
    
    public void onNeighborBlockChange(World world, int x, int y, int z, int id)
    {
    	TileEntity TE = world.getBlockTileEntity(x, y, z);
    	if(TE instanceof TileEntitySponge)
    	{
    		((TileEntitySponge)TE).removeWater(world, x, y, z);
    	}
    }
    
    public void onBlockAdded(World world, int x, int y, int z)
    {
    	TileEntity TE = world.getBlockTileEntity(x, y, z);
    	if(TE instanceof TileEntitySponge)
    	{
    		((TileEntitySponge)TE).removeWater(world, x, y, z);
    	}
    }
    
	public TileEntity createNewTileEntity(World var1)
	{
		return new TileEntitySponge(3);
	}
}
