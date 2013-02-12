package torresmon235.crystalgun.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import torresmon235.crystalgun.common.CrystalGunMain;
import torresmon235.crystalgun.entities.EntitySand;
import torresmon235.crystalgun.interfaces.ICrystalGun;

public class ItemCrystalGunSand extends Item implements ICrystalGun
{
	public static ArrayList effects = new ArrayList();
	public static ArrayList potion = new ArrayList();
	public static ArrayList fireheal = new ArrayList();
	public static ArrayList effectsextra = new ArrayList();

	public static String name;
	
	public static int red;
	public static int green;
	public static int blue;

	public ItemCrystalGunSand(int par1)
	{
		super(par1);
		this.setCreativeTab(CrystalGunMain.crystalGunTab);
		this.bFull3D = true;
		this.setMaxDamage(447);
		this.setMaxStackSize(1);
	}
	
	@Override
	public String getTextureFile()
	{
		return "/torresmon235/crystalgun/textures/items.png";
	}
	
	public ItemCrystalGunSand setName(String string)
	{
		name = string;
		return this;
	}
	
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	if(name != null) par3List.add(name);
    	par3List.add(448 - par1ItemStack.getItemDamage() + " Shots");
    }

    public ItemCrystalGunSand setEffect(String effect, int damage, int k, int l, int j)
    {
		effects.add(effect);
		if(effect == "Potion")
		{
			potion.add(0, damage);
			potion.add(1, k);
			potion.add(2, l);
			potion.add(3, j);
			effectsextra.add(potion);
		}
		if(effect == "Fire" || effect == "Heal" || effect == "Knockback")
		{
			fireheal.add(0 ,damage);
			fireheal.add(1, k);
			effectsextra.add(fireheal);
		}
		else
		{
			System.out.println("Unsupported Effect");
		}
		return this;
	}
    
    public ItemCrystalGunSand setColor(int redColor, int greenColor, int blueColor)
    {
    	if(redColor != 0 || greenColor != 0 || blueColor != 0)
		{
			red = redColor;
			green = greenColor;
			blue = blueColor;
		}
		else
		{
			red = green = blue = 0;
		}
    	return this;
    }
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		world.playSoundAtEntity(entityplayer, "crystalgun.shot", 0.7565F, 1.0F + itemRand.nextFloat() / 2);
    	if(!world.isRemote)
    	{
    		EntitySand entity = new EntitySand(world, entityplayer, effects, effectsextra, red, green, blue);
    		world.spawnEntityInWorld(entity);
    		if(itemstack.getItemDamage() < 447) itemstack.damageItem(1, entityplayer);
    		else
    		{
    			itemstack.damageItem(1, entityplayer);
    			return new ItemStack(CrystalGunMain.CrystalGun, 1);
    		}
    	}
    	return itemstack;
	}
}
