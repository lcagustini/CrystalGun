package torresmon235.crystalgun.registration;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import torresmon235.crystalgun.blocks.BlockCGCauldron;
import torresmon235.crystalgun.blocks.BlockCGSponge;
import torresmon235.crystalgun.blocks.BlockCoreExtractor;
import torresmon235.crystalgun.blocks.BlockCrystalBlock;
import torresmon235.crystalgun.blocks.BlockMagicalConveyor;
import torresmon235.crystalgun.blocks.BlockMagicalFilter;
import torresmon235.crystalgun.blocks.BlockMagicalSorter;
import torresmon235.crystalgun.blocks.BlockMagicalSpring;
import torresmon235.crystalgun.common.CrystalGunMain;
import torresmon235.crystalgun.items.ItemCrystalBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RegistryBlocks 
{
	public static Block CoreExtractor;
	public static Block CrystalBlock;
	public static Block CGSponge;
	public static Block CGCauldron;
	public static Block MagicalConveyor;
	public static Block MagicalSpring;
	public static Block MagicalFilter;
	public static Block MagicalSorter;
	
	public RegistryBlocks()
	{
		CoreExtractor = (new BlockCoreExtractor(CrystalGunMain.CoreExtractorID, 9, torresmon235.crystalgun.tileentities.TileEntityCoreExtractor.class)).setHardness(3F)
				.setResistance(30F).setStepSound(Block.soundStoneFootstep).setBlockName("CoreExtractor");
		LanguageRegistry.addName(CoreExtractor, "Core Extractor");
		GameRegistry.registerBlock(CoreExtractor, "CoreExtractor");
		
		CrystalBlock = new BlockCrystalBlock(CrystalGunMain.CrystalBlockID);
		GameRegistry.registerBlock(CrystalBlock, ItemCrystalBlock.class, "CrystalBlock");
		LanguageRegistry.addName(new ItemStack(CrystalBlock, 1, 2), "Air Crystal Block");
		LanguageRegistry.addName(new ItemStack(CrystalBlock, 1, 1), "Fire Crystal Block");
		LanguageRegistry.addName(new ItemStack(CrystalBlock, 1, 6), "Grass Crystal Block");
		LanguageRegistry.addName(new ItemStack(CrystalBlock, 1, 3), "Ice Crystal Block");
		LanguageRegistry.addName(new ItemStack(CrystalBlock, 1, 5), "Life Crystal Block");
		LanguageRegistry.addName(new ItemStack(CrystalBlock, 1, 7), "Poison Crystal Block");
		LanguageRegistry.addName(new ItemStack(CrystalBlock, 1, 4), "Sand Crystal Block");
		LanguageRegistry.addName(new ItemStack(CrystalBlock, 1, 0), "Water Crystal Block");
		LanguageRegistry.addName(new ItemStack(CrystalBlock, 1, 8), "Healing Crystal Block");
		
		CGSponge = new BlockCGSponge(CrystalGunMain.CGSpongeID).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setBlockName("CGSponge");
		LanguageRegistry.addName(CGSponge, "Sponge");
		GameRegistry.registerBlock(CGSponge, "Sponge");
		
		CGCauldron = new BlockCGCauldron(CrystalGunMain.CGCauldronID).setHardness(2.0F).setBlockName("CGCauldron").setRequiresSelfNotify();
		LanguageRegistry.addName(CGCauldron, "Metal Pot");
		GameRegistry.registerBlock(CGCauldron, "MetalPot");
		
		MagicalConveyor = new BlockMagicalConveyor(CrystalGunMain.MagicalConveyorID).setHardness(0.8F).setBlockName("MagicalConveyor");
		LanguageRegistry.addName(MagicalConveyor, "Magical Conveyor");
		GameRegistry.registerBlock(MagicalConveyor, "MagicalConveyor");
		
		MagicalSpring = new BlockMagicalSpring(CrystalGunMain.MagicalSpringID).setHardness(0.8F).setBlockName("MagicalSpring");
		LanguageRegistry.addName(MagicalSpring, "Magical Spring");
		GameRegistry.registerBlock(MagicalSpring, "MagicalSpring");
		
		MagicalFilter = new BlockMagicalFilter(CrystalGunMain.MagicalFilterID).setHardness(0.8F).setBlockName("MagicalFilter");
		LanguageRegistry.addName(MagicalFilter, "Magical Filter");
		GameRegistry.registerBlock(MagicalFilter, "MagicalFilter");
		
		//MagicalSorter = new BlockMagicalSorter(CrystalGunMain.MagicalSorterID).setHardness(0.8F).setBlockName("MagicalSorter");
		//LanguageRegistry.addName(MagicalSorter, "Magical Sorter");
		//GameRegistry.registerBlock(MagicalSorter, "MagicalSorter");
	}
}
