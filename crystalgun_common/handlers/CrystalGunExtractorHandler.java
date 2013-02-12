package torresmon235.crystalgun.handlers;

import java.util.ArrayList;
import java.util.Iterator;

import torresmon235.crystalgun.common.CrystalGunMain;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CrystalGunExtractorHandler 
{
	public static ArrayList ingredient = new ArrayList();
	public static ArrayList result = new ArrayList();
	
	public static void addRecipe(Item input, ItemStack output)
	{
		ingredient.add(input);
		result.add(output);
	}
	
	public static Entity getResult(World world, ItemStack itemstack, double x, double y, double z)
	{
		EntityItem entity1 = null;
		
		for(int i = 0; i < result.size(); i++)
		{
			if(itemstack.getItem() == ingredient.get(i))
			{
				ItemStack item1 = new ItemStack(((ItemStack) result.get(i)).getItem(), ((ItemStack) result.get(i)).stackSize, ((ItemStack) result.get(i)).getItemDamage());
				itemstack.stackSize--;
				entity1 = new EntityItem(world, x, y, z, item1);
			}
		}
		return entity1;
	}
}
