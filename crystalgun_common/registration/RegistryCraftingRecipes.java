package torresmon235.crystalgun.registration;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegistryCraftingRecipes 
{
	public RegistryCraftingRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(RegistryItems.ConductiveIron, 1), new Object[] {Item.ingotIron, Item.redstone});
		GameRegistry.addShapelessRecipe(new ItemStack(RegistryItems.ConductiveGold, 1), new Object[] {Item.ingotGold, Item.redstone});
		GameRegistry.addShapelessRecipe(new ItemStack(RegistryItems.ConductiveDiamond, 1), new Object[] {Item.diamond, Item.redstone});
		GameRegistry.addRecipe(new ItemStack(RegistryItems.CoreExtractorItem, 1), new Object[] {"EIE", "GIG", "SSS", 'E', Item.emerald, 'I', Item.ingotIron, 'G', Item.ingotGold, 'S', Block.stone});
		GameRegistry.addRecipe(new ItemStack(RegistryBlocks.CGSponge), new Object[] {"YSY", "SBS", "YSY", 'Y', new ItemStack(Block.cloth, 1, 4), 'S', new ItemStack(Item.dyePowder, 1, 0), 'B', Item.bucketEmpty});
		GameRegistry.addRecipe(new ItemStack(RegistryItems.CrystalGun, 1), new Object[] {"GI ", "IEI", "SIO", 'G', Block.glass, 'I', Item.ingotGold, 'E', Item.eyeOfEnder, 'S', RegistryBlocks.CGSponge, 'O', Block.obsidian});
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 301), new Object[] {"WBW", " W ", "WWW", 'W', Block.wood, 'B', RegistryItems.IronBrain});
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 302), new Object[] {"SBS", " S ", "QQQ", 'S', Block.stone, 'B', RegistryItems.GoldenBrain, 'Q', Block.stoneBrick});
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 303), new Object[] {"IBI", " S ", "QIQ", 'S', Item.stick, 'B', RegistryItems.DiamondBrain, 'I', Item.ingotIron, 'Q', Block.blockSteel});
		GameRegistry.addRecipe(new ItemStack(RegistryItems.SaphireHelmet, 1), new Object[] {"GGG", "GAG", "GGG", 'G', new ItemStack(RegistryItems.Gem, 1, 0), 'A', Item.helmetDiamond});
		GameRegistry.addRecipe(new ItemStack(RegistryItems.RubyChestplate, 1), new Object[] {"GGG", "GAG", "GGG", 'G', new ItemStack(RegistryItems.Gem, 1, 1), 'A', Item.plateDiamond});
		GameRegistry.addRecipe(new ItemStack(RegistryItems.OpalLeggings, 1), new Object[] {"GGG", "GAG", "GGG", 'G', new ItemStack(RegistryItems.Gem, 1, 2), 'A', Item.legsDiamond});
		GameRegistry.addRecipe(new ItemStack(RegistryItems.AquamarineBoots, 1), new Object[] {"GGG", "GAG", "GGG", 'G', new ItemStack(RegistryItems.Gem, 1, 3), 'A', Item.bootsDiamond});
		GameRegistry.addRecipe(new ItemStack(RegistryItems.CauldronItem, 1), new Object[] {"I I", "GOG", "III", 'G', new ItemStack(RegistryItems.Gem, 1, 4), 'I', Item.ingotIron, 'O', Block.obsidian});
		GameRegistry.addRecipe(new ItemStack(RegistryItems.MotionCore, 1), new Object[] {"GPG", "GIG", "GPG", 'G', new ItemStack(RegistryItems.Gem, 1, 8), 'I', RegistryItems.IronBrain, 'P', new ItemStack(RegistryItems.Gem, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(RegistryBlocks.MagicalConveyor, 4), new Object[] {"WWW", "WCW", "WWW", 'W', Block.wood, 'C', RegistryItems.MotionCore});
		GameRegistry.addRecipe(new ItemStack(RegistryBlocks.MagicalSpring, 4), new Object[] {"WGW", "GCG", "WGW", 'W', Block.wood, 'C', RegistryItems.MotionCore, 'G', new ItemStack(RegistryItems.Gem, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(RegistryBlocks.MagicalFilter, 4), new Object[] {"WGW", "CWC", "WGW", 'W', Block.wood, 'C', RegistryItems.MotionCore, 'G', new ItemStack(RegistryItems.Gem, 1, 5)});
		for(int i = 0; i <= 8; i++)
		{
			GameRegistry.addRecipe(new ItemStack(RegistryBlocks.CrystalBlock, 1, i), new Object[] {"CC", "CC", 'C', new ItemStack(RegistryItems.Crystal, 1, i)});
			GameRegistry.addRecipe(new ItemStack(RegistryItems.Crystal, 4, i), new Object[] {"C", 'C', new ItemStack(RegistryBlocks.CrystalBlock, 1, i)});
			GameRegistry.addShapelessRecipe(new ItemStack(RegistryItems.ShinyCrystal, 1, i), new Object[] {new ItemStack(RegistryItems.Crystal, 1, i), Item.diamond});
		}
	}
}
