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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import torresmon235.crystalgun.common.CrystalGunMain;
import torresmon235.crystalgun.handlers.CrystalGunCauldronHandler;
import torresmon235.crystalgun.library.RenderID;
import torresmon235.crystalgun.tileentities.TileEntityCGCauldron;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockCGCauldron extends BlockContainer
{
    public BlockCGCauldron(int par1)
    {
        super(par1, Material.iron);
        this.blockIndexInTexture = 32;
    }
    
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    { 	
    	if(!world.isRemote)
    	{
    		((TileEntityCGCauldron)world.getBlockTileEntity(x, y, z)).effectEntry(world, x, y, z, entity);
    	}
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return par1 == 1 ? 16 : (par1 == 0 ? 33 : 32);
    }

    /**
     * if the specified block is in the given AABB, add its collision bounding box to the given list
     */
    public void addCollidingBlockToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
        super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        float var8 = 0.125F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, var8, 1.0F, 1.0F);
        super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var8);
        super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        this.setBlockBounds(1.0F - var8, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        this.setBlockBounds(0.0F, 0.0F, 1.0F - var8, 1.0F, 1.0F, 1.0F);
        super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        this.setBlockBoundsForItemRender();
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return RenderID.Cauldron;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            ItemStack var10 = par5EntityPlayer.inventory.getCurrentItem();

            if (var10 == null)
            {
                return true;
            }
            else
            {
                int var11 = par1World.getBlockMetadata(par2, par3, par4);
            	TileEntityCGCauldron te = (TileEntityCGCauldron) par1World.getBlockTileEntity(par2, par3, par4);

                if (var10.itemID == Item.bucketLava.itemID)
                {
                    if (var11 < 3)
                    {
                        if (!par5EntityPlayer.capabilities.isCreativeMode)
                        {
                            par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.bucketEmpty));
                        }

                        if(var11 != 0)
                        {
                        	if(Math.floor(Math.random()*4) == 2) te.addEffect(true, par2, par3, par4);
                        }
                        
                        par1World.setBlockMetadataWithNotify(par2, par3, par4, 3);
                    }

                    return true;
                }
                else
                {
                    if (var10.itemID == Item.glassBottle.itemID)
                    {
                        if (var11 > 0)
                        {
                    		ItemStack var12 = null;
                    		
                    		if(te.potion.tagCount() > 0)
                    		{
                    			NBTTagCompound item = new NBTTagCompound();
                    			
                    			var12 = new ItemStack(Item.potion, 1, 8195);
                    			item.setTag("CustomPotionEffects", te.potion);
                            	var12.setTagCompound(item);
                    		}
                        	                                                        
                            if(te.potion.tagCount() > 0)
                            {
                            	if (!par5EntityPlayer.inventory.addItemStackToInventory(var12))
                                {
                                    par1World.spawnEntityInWorld(new EntityItem(par1World, (double)par2 + 0.5D, (double)par3 + 1.5D, (double)par4 + 0.5D, var12));
                                }
                            	
                                else if (par5EntityPlayer instanceof EntityPlayerMP)
                                {
                                    ((EntityPlayerMP)par5EntityPlayer).sendContainerToPlayer(par5EntityPlayer.inventoryContainer);
                                }
                            	
                            	--var10.stackSize;
                            }
                            
                            if (var10.stackSize <= 0)
                            {
                                par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                            }
                            
                            if(te.potion.tagCount() > 0)
                            {
                            	par1World.setBlockMetadataWithNotify(par2, par3, par4, var11 - 1);
                            }
                        }
                    }
                    
                    if(par1World.getBlockMetadata(par2, par3, par4) == 0)
                    {
                    	te.potion = new NBTTagList();
                    	te.Buffer.clear();
                    	te.effectsnumber = 0;
                    }
                    return true;
                }
            }
        }
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return CrystalGunMain.CauldronItem.itemID;
    }

    @SideOnly(Side.CLIENT)
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return CrystalGunMain.CauldronItem.itemID;
    }

    public boolean hasTileEntity()
    {
    	return true;
    }
    
	public TileEntity createNewTileEntity(World var1) 
	{
		return new TileEntityCGCauldron();
	}
	
	@Override
	public String getTextureFile()
	{
		return "/torresmon235/crystalgun/textures/blocks.png";
	}
}
