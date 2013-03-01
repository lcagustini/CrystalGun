package torresmon235.crystalgun.registration;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import torresmon235.crystalgun.api.CrystalGunExtractorHandler;

public class RegistryExtractorRecipes 
{
	public RegistryExtractorRecipes()
	{
		CrystalGunExtractorHandler.addRecipe(Item.coal, new ItemStack(RegistryItems.Crystal, 1, 1));
		CrystalGunExtractorHandler.addRecipe(Item.blazePowder, new ItemStack(RegistryItems.Crystal, 1, 1));
		CrystalGunExtractorHandler.addRecipe(Item.rottenFlesh, new ItemStack(RegistryItems.Crystal, 1, 7));
		CrystalGunExtractorHandler.addRecipe(Item.spiderEye, new ItemStack(RegistryItems.Crystal, 1, 7));
		CrystalGunExtractorHandler.addRecipe(Item.bucketWater, new ItemStack(RegistryItems.Crystal, 1, 0));
		CrystalGunExtractorHandler.addRecipe(Item.bucketWater, new ItemStack(Item.bucketEmpty, 1));
		CrystalGunExtractorHandler.addRecipe(Item.feather, new ItemStack(RegistryItems.Crystal, 1, 2));
		CrystalGunExtractorHandler.addRecipe(new ItemStack(Block.blockSnow).getItem() , new ItemStack(RegistryItems.Crystal, 1, 3));
		CrystalGunExtractorHandler.addRecipe(new ItemStack(Block.ice).getItem(), new ItemStack(RegistryItems.Crystal, 1, 3));
		CrystalGunExtractorHandler.addRecipe(new ItemStack(Block.sand).getItem(), new ItemStack(RegistryItems.Crystal, 1, 4));
		CrystalGunExtractorHandler.addRecipe(Item.appleRed, new ItemStack(RegistryItems.Crystal, 1, 5));
		CrystalGunExtractorHandler.addRecipe(Item.seeds, new ItemStack(RegistryItems.Crystal, 1, 6));
		CrystalGunExtractorHandler.addRecipe(Item.cookie, new ItemStack(RegistryItems.Crystal, 1, 8));
		CrystalGunExtractorHandler.addRecipe(RegistryItems.CrystalGunAir, new ItemStack(RegistryItems.CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(RegistryItems.CrystalGunFire, new ItemStack(RegistryItems.CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(RegistryItems.CrystalGunWater, new ItemStack(RegistryItems.CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(RegistryItems.CrystalGunIce, new ItemStack(RegistryItems.CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(RegistryItems.CrystalGunSand, new ItemStack(RegistryItems.CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(RegistryItems.CrystalGunLife, new ItemStack(RegistryItems.CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(RegistryItems.CrystalGunGrass, new ItemStack(RegistryItems.CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(RegistryItems.CrystalGunPoison, new ItemStack(RegistryItems.CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(RegistryItems.ConductiveIron, new ItemStack(RegistryItems.IronBrain, 1));
		CrystalGunExtractorHandler.addRecipe(RegistryItems.ConductiveGold, new ItemStack(RegistryItems.GoldenBrain, 1));
		CrystalGunExtractorHandler.addRecipe(RegistryItems.ConductiveDiamond, new ItemStack(RegistryItems.DiamondBrain, 1));
		for(int i = 0; i <= 8; i++)
		{
			CrystalGunExtractorHandler.addRecipe(new ItemStack(RegistryItems.ShinyCrystal, 1, i), new ItemStack(RegistryItems.Gem, 1, i));
		}
	}
}
