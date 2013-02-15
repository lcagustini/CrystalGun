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

import java.util.Random;

import cpw.mods.fml.client.registry.RenderingRegistry;

import torresmon235.crystalgun.common.CrystalGunMain;
import torresmon235.crystalgun.handlers.CrystalGunExtractorHandler;
import torresmon235.crystalgun.handlers.CrystalGunParticleHandler;
import torresmon235.crystalgun.library.RenderID;
import torresmon235.crystalgun.tileentities.TileEntityCoreExtractor;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityLavaFX;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCoreExtractor extends BlockContainer
{
	public BlockCoreExtractor(int i, int j, Class class1) 
	{
		super(i, j, Material.rock);
		this.setLightValue(0.4F);
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.5F, 1F);
		anEntityClass = class1;
	}
    
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
        int rand = par5Random.nextInt(6);
        
        switch(rand)
        {
        case 3:par1World.spawnParticle("smoke", (double)par2 + par5Random.nextFloat(), (double)par3 + par5Random.nextFloat(), (double)par4 + par5Random.nextFloat(), 0.0D, 0.0D, 0.0D);
        case 4:par1World.spawnParticle("smoke", (double)par2 + par5Random.nextFloat(), (double)par3 + par5Random.nextFloat(), (double)par4 + par5Random.nextFloat(), 0.0D, 0.0D, 0.0D);
        }
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
    {
    	ItemStack stack = entityplayer.getCurrentEquippedItem();
    	if(!world.isRemote)
    	{
    		if(stack != null)
    		{
    			EntityItem item = (EntityItem) CrystalGunExtractorHandler.getResult(world, stack, x + 0.5, y + 1, z + 0.5);
    			if(item != null)
    			{
    				for(int i = 0; i < 4; i++)
    				{
    					CrystalGunParticleHandler.spawnParticle("Grass", x + 0.5, y + 0.5, z + 0.5, 0, 0, 0, 6, 255, 0);
    				}
    				world.playSoundEffect(x, y, z, "crystalgun.craft", 0.7565F, 1.0F + (float)Math.random() / 2);
    				world.spawnEntityInWorld(item);
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	return CrystalGunMain.CoreExtractorItem.itemID;
    }

	public boolean isOpaqueCube() 
	{
		return false;
	}

	public boolean renderAsNormalBlock() 
	{
		return false;
	}

	public int getRenderType() 
	{
		return RenderingRegistry.getNextAvailableRenderId();
	}
	
	public boolean hasTileEntity()
	{
		return true;
	}

	public TileEntity createNewTileEntity(World var1)
	{
		return new TileEntityCoreExtractor();
	}

	public boolean blockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
	{

	int p = MathHelper.floor_double((double)((par5EntityPlayer.rotationYaw * 4F) / 360F) + 0.5D) & 3; //this is a smart equation

	byte byte0 = 3;
          
          
                if (p == 0)
                {
                        byte0 = 4;
                }
                if (p == 1)
                {
                        byte0 = 3;
                }
                if (p == 2)
                {
                        byte0 = 2;
                }
                if (p == 3)
                {
                        byte0 = 1;
                }

                par1World.setBlockMetadataWithNotify(par2, par3, par4, byte0);
          
                return true;
	}
	
	private Class anEntityClass;
}