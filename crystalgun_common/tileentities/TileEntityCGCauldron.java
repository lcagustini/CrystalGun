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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import torresmon235.crystalgun.handlers.CrystalGunCauldronHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityCGCauldron extends TileEntity
{
	public ArrayList Buffer = new ArrayList();
	public NBTTagList potion = new NBTTagList();
	public int effectsnumber = 0;
	public boolean add = false;
	
	public TileEntityCGCauldron()
	{
		
	}
	
	public void effectEntry(World world, int x, int y, int z, Entity entity)
	{
		if(world.getBlockMetadata(x, y, z) > 0)
		{
			if(entity instanceof EntityItem)
			{	
				ItemStack itemstack = ((EntityItem)entity).func_92014_d();
				ArrayList result = CrystalGunCauldronHandler.getResult(itemstack);

				if(!result.isEmpty())
				{
					if((Integer)result.get(0) == 0)
					{
						if(!Buffer.isEmpty())
						{
							int ID = (Integer) Buffer.get(0);
							int Amp = (Integer) Buffer.get(1);
							int Dur = (Integer) Buffer.get(2);
							if(Amp > 0 && Amp < 6) Amp += (Integer) result.get(1);
							if(Dur > 0 && Dur < 14400) Dur += (Integer) result.get(2);
							Buffer.clear();
							Buffer.add(ID);
							Buffer.add(Amp);
							Buffer.add(Dur);
							result.clear();
							add = true;
						}
					}
					else if((Integer)result.get(0) > 0)
					{
						if(!Buffer.isEmpty()) addEffect(false, x, y, z);
						Buffer.clear();
						for(int i = 0; i <= 2; i++) Buffer.add(result.get(i));
						result.clear();
						add = true;
					}
				}
				else if(itemstack.getItem() == Item.bone) 
				{
					addEffect(false, x, y, z);
					add = true;
				}
				else add = false;

				if(add)
				{
					entity.setDead();
					itemstack.stackSize--;
					EntityItem item = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, itemstack);
					world.spawnEntityInWorld(item);
					add = false;
				}
			}
		}
	}
	
	public void addEffect(boolean noRandomNeg, int x, int y, int z)
    {
    	Random random = new Random();
    	NBTTagCompound nbt = new NBTTagCompound();
    	
		if(effectsnumber > 1 || noRandomNeg)
		{
			if(random.nextInt(4) == 1 || noRandomNeg)
			{
				addNegEffect();
			}
		}
		else
		{
			int ID = (Integer) Buffer.get(0);
			int Amp = 1;
			int Dur = (Integer) Buffer.get(2);

			nbt.setByte("Id", (byte) ID);
			nbt.setByte("Amplifier", (byte) (Amp -1));
			nbt.setInteger("Duration", Dur);
			nbt.setBoolean("Ambient", false);
			potion.appendTag(nbt);
			effectsnumber++;
		}
		Minecraft.getMinecraft().theWorld.playSound(x, y, z, "random.fizz", 1, 0, true);
		Buffer.clear();
    }
	
	public void addNegEffect()
    {
		Random random = new Random();
    	NBTTagCompound nbt = new NBTTagCompound();
    	
		ArrayList neg = new ArrayList<Integer>(Arrays.asList(2, 4, 7, 9, 15, 17, 18, 19, 20));
		nbt.setByte("Id", (byte) ((int)((Integer) neg.get(random.nextInt(9)))));
		nbt.setByte("Amplifier", (byte) 0);
		nbt.setInteger("Duration", random.nextInt(400)+440);
		nbt.setBoolean("Ambient", false);
		potion.appendTag(nbt);
		effectsnumber++;
    }
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
		super.readFromNBT(par1NBTTagCompound);
		
		Buffer.clear();
		Buffer.add(par1NBTTagCompound.getInteger("ID"));
		Buffer.add(par1NBTTagCompound.getInteger("Amp"));
		Buffer.add(par1NBTTagCompound.getInteger("Dur"));
		potion = par1NBTTagCompound.getTagList("potion");
		effectsnumber = par1NBTTagCompound.getInteger("effectsnumber");
		add = par1NBTTagCompound.getBoolean("add");
    }
	
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
		super.writeToNBT(par1NBTTagCompound);
		int ID = (Integer) Buffer.get(0);
		int Amp = (Integer) Buffer.get(1);
		int Dur = (Integer) Buffer.get(2);
		
		par1NBTTagCompound.setInteger("ID", ID);
		par1NBTTagCompound.setInteger("Amp", Amp);
		par1NBTTagCompound.setInteger("Dur", Dur);
		par1NBTTagCompound.setTag("potion", potion);
		par1NBTTagCompound.setInteger("effectsnumber", effectsnumber);
		par1NBTTagCompound.setBoolean("add", add);
	}
}
