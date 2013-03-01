package torresmon235.crystalgun.registration;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import torresmon235.crystalgun.api.CrystalGunCauldronHandler;

public class RegistryCauldronRecipes 
{
	public RegistryCauldronRecipes()
	{
		CrystalGunCauldronHandler.addRecipe(Item.sugar, 1, 1, 3600);
		CrystalGunCauldronHandler.addRecipe(Item.goldNugget, 2, 1, 3600);
		CrystalGunCauldronHandler.addRecipe(Item.carrot, 3, 1, 3600);
		CrystalGunCauldronHandler.addRecipe(Item.wheat, 4, 1, 3600);
		CrystalGunCauldronHandler.addRecipe(Item.blazePowder, 5, 1, 3600);
		CrystalGunCauldronHandler.addRecipe(Item.speckledMelon, 6, 1, 1);
		CrystalGunCauldronHandler.addRecipe(Item.fermentedSpiderEye, 7, 1, 1);
		CrystalGunCauldronHandler.addRecipe(Item.stick, 8, 1, 1000);
		CrystalGunCauldronHandler.addRecipe(Item.rottenFlesh, 9, 1, 900);
		CrystalGunCauldronHandler.addRecipe(Item.ghastTear, 10, 1, 900);
		CrystalGunCauldronHandler.addRecipe(Item.appleGold, 11, 1, 900);
		CrystalGunCauldronHandler.addRecipe(Item.magmaCream, 12, 1, 3600);
		CrystalGunCauldronHandler.addRecipe(Item.fishRaw, 13, 1, 3600);
		CrystalGunCauldronHandler.addRecipe(new ItemStack(Block.glass, 1), 14, 1, 3600);
		CrystalGunCauldronHandler.addRecipe(new ItemStack(Block.sand, 1), 15, 1, 3600);
		CrystalGunCauldronHandler.addRecipe(Item.goldenCarrot, 16, 1, 3600);
		CrystalGunCauldronHandler.addRecipe(Item.gunpowder, 18, 1, 3600);
		CrystalGunCauldronHandler.addRecipe(Item.spiderEye, 19, 1, 900);
		CrystalGunCauldronHandler.addRecipe(Item.redstone, 0, 0, 800);
		CrystalGunCauldronHandler.addRecipe(Item.lightStoneDust, 0, 1, 0);
	}
}
