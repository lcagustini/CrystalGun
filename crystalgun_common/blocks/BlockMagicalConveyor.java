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

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import torresmon235.crystalgun.common.CrystalGunMain;

public class BlockMagicalConveyor extends Block
{	
	public BlockMagicalConveyor(int par1)
	{
		super(par1, Material.wood);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        this.setLightValue(0.2F);
		this.setCreativeTab(CrystalGunMain.crystalGunTab);
		this.blockIndexInTexture = 19;
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
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityliving)
	{
		int dir = (MathHelper.floor_double((double)(entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3)+3;
		if(dir > 4) dir -= 4;
		world.setBlockMetadata(x, y, z, dir);
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
		if(world.getBlockMetadata(x, y, z) <= 4)
		{
			int meta = world.getBlockMetadata(x, y, z);
			if((meta == 1) && entity.motionZ < 0.5) entity.addVelocity(0, 0, 0.215);
			else if((meta == 2) && entity.motionX > -0.5) entity.addVelocity(-0.215, 0, 0);
			else if((meta == 3) && entity.motionZ > -0.5) entity.addVelocity(0, 0, -0.215);
			else if((meta == 4) && entity.motionX < 0.5) entity.addVelocity(0.215, 0, 0);
		}
    }
	
	public int getBlockTextureFromSideAndMetadata(int side, int meta)
	{
		if(meta == 1) return 21;
		else if(meta == 2) return 22;
		else if(meta == 3) return 19;
		else return 20;
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

	@Override
	public String getTextureFile()
	{
		return "/torresmon235/crystalgun/textures/blocks.png";
	}
}
