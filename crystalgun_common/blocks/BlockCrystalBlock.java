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

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import torresmon235.crystalgun.common.CrystalGunMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCrystalBlock extends Block
{

	public BlockCrystalBlock(int par1) 
	{
		super(par1, Material.glass);
		this.setLightOpacity(3);
		this.setHardness(1F);
		this.setResistance(7F);
		this.setStepSound(Block.soundGlassFootstep);
		this.setCreativeTab(CrystalGunMain.crystalGunTab);
	}
	
	public int getRenderBlockPass()
    {
        return 1;
    }
	
	public int getBlockTextureFromSideAndMetadata(int i, int j)
	{
		switch(j)
		{
		case 0:return 7;
		case 1:return 1;
		case 2:return 0;
		case 3:return 3;
		case 4:return 6;
		case 5:return 4;
		case 6:return 2;
		case 7:return 5;
		case 8:return 8;
		default:return 0;
		}
	}
	
	public int damageDropped(int i)
	{
		return i;
	}
	
	public boolean isOpaqueCube() 
	{
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int var4 = 0; var4 <= 8; ++var4)
		{
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}
	
	@Override
	public String getTextureFile()
	{
		return "/torresmon235/crystalgun/textures/blocks.png";
	}
}
