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
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import torresmon235.crystalgun.common.CrystalGunMain;
import torresmon235.crystalgun.tileentities.TileEntityMagicalFilter;

public class BlockMagicalFilter extends BlockContainer
{	
	public BlockMagicalFilter(int par1)
	{
		super(par1, Material.wood);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        this.setLightValue(0.2F);
		this.setCreativeTab(CrystalGunMain.crystalGunTab);
		this.blockIndexInTexture = 24;
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

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
    {
		if(!world.isRemote)
		{
			((TileEntityMagicalFilter)world.getBlockTileEntity(x, y, z)).setSaved(entityplayer.getCurrentEquippedItem());
		}
		return true;
    }
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) 
    {
		try
    	{
			ItemStack item = ((EntityItem)entity).func_92014_d();
			TileEntityMagicalFilter te = (TileEntityMagicalFilter)world.getBlockTileEntity(x, y, z);
			if(!world.isRemote)
			{
				if(te.getSaved() != null)
				{
					if(item.getItem() == te.getSaved().getItem() && item.getItemDamage() == te.getSaved().getItemDamage())
					{
						entity.setDead();
						EntityItem spawn = new EntityItem(world, x + 0.5, y - 0.6, z + 0.5, item);
						spawn.motionX = spawn.motionY = spawn.motionZ = 0;
						world.spawnEntityInWorld(spawn);
						return;
					}
				}
				entity.motionX *= 1.358;
				entity.motionY *= 1.358;
				entity.motionZ *= 1.358;
			}
    	}
		catch(ClassCastException e)
		{
			
		}
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
		return new TileEntityMagicalFilter();
	}
	
	@Override
	public String getTextureFile()
	{
		return "/torresmon235/crystalgun/textures/blocks.png";
	}
}
