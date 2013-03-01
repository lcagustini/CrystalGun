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

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import torresmon235.crystalgun.common.CrystalGunMain;
import torresmon235.crystalgun.library.GuiID;
import torresmon235.crystalgun.tileentities.TileEntityMagicalSorter;

public class BlockMagicalSorter extends BlockContainer
{
	public BlockMagicalSorter(int par1)
	{
		super(par1, Material.wood);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        this.setLightValue(0.2F);
		this.setCreativeTab(CrystalGunMain.crystalGunTab);
		this.blockIndexInTexture = 25;
	}
	
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
        int rand = par5Random.nextInt(6);
        
        if(par1World.getBlockMetadata(par2, par3, par4) <= 4)
        {
        	switch(rand)
        	{
        	case 4:par1World.spawnParticle("reddust", (double)par2 + par5Random.nextFloat(), (double)par3 + (par5Random.nextFloat()/2), (double)par4 + par5Random.nextFloat(), -110.0D, 99.0D, 0.0D);
        	}
        }
    }
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) 
    {
		try
		{
			if(!world.isRemote)
			{
				EntityLiving mob = (EntityLiving) entity;

				if(((TileEntityMagicalSorter)world.getBlockTileEntity(x, y, z)).entityFall(mob))
				{
					mob.setPosition(x + 0.5, y - 2, z + 0.5);
				}
				else
				{
					mob.motionX *= 1.358;
					mob.motionY *= 1.358;
					mob.motionZ *= 1.358;
				}
			}
		}
		catch(ClassCastException e)
		{
			entity.motionX *= 1.358;
			entity.motionY *= 1.358;
			entity.motionZ *= 1.358;
		}
    }
	
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) 
    {
    	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
    {
		if(!world.isRemote)
		{
			entityplayer.openGui(CrystalGunMain.instance, GuiID.MagicalSorter, world, x, y, z);
		}
		return true;
    }

	public void addCollidingBlockToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
    {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
    }
	
	public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public boolean renderAsNormalBlock()
    {
        return false;
    }

	public boolean hasTileEntity()
	{
		return true;
	}

	public TileEntity createNewTileEntity(World var1)
	{
		return new TileEntityMagicalSorter();
	}
	
	@Override
	public String getTextureFile()
	{
		return "/torresmon235/crystalgun/textures/blocks.png";
	}
}
