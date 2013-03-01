package torresmon235.crystalgun.registration;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import torresmon235.crystalgun.common.CrystalGunMain;
import torresmon235.crystalgun.items.ItemCrystal;
import torresmon235.crystalgun.items.ItemGem;
import torresmon235.crystalgun.items.ItemShinyCrystal;
import torresmon235.crystalgun.items.armor.ItemAquamarineBoots;
import torresmon235.crystalgun.items.armor.ItemOpalLeggings;
import torresmon235.crystalgun.items.armor.ItemRubyChestplate;
import torresmon235.crystalgun.items.armor.ItemSaphireHelmet;
import torresmon235.crystalgun.items.crystalguns.ItemCrystalGun;
import torresmon235.crystalgun.items.crystalguns.ItemCrystalGunAir;
import torresmon235.crystalgun.items.crystalguns.ItemCrystalGunFire;
import torresmon235.crystalgun.items.crystalguns.ItemCrystalGunGrass;
import torresmon235.crystalgun.items.crystalguns.ItemCrystalGunHealing;
import torresmon235.crystalgun.items.crystalguns.ItemCrystalGunIce;
import torresmon235.crystalgun.items.crystalguns.ItemCrystalGunLife;
import torresmon235.crystalgun.items.crystalguns.ItemCrystalGunPoison;
import torresmon235.crystalgun.items.crystalguns.ItemCrystalGunSand;
import torresmon235.crystalgun.items.crystalguns.ItemCrystalGunWater;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RegistryItems 
{
	public static Item ConductiveIron;
	public static Item ConductiveGold;
	public static Item ConductiveDiamond;
	public static Item Gem;
	public static Item ShinyCrystal;
	public static Item Crystal;
	public static Item CoreExtractorItem;
	public static Item CauldronItem;
	public static Item IronBrain;
	public static Item GoldenBrain;
	public static Item DiamondBrain;
	public static Item MotionCore;
	
	public static Item CrystalGun;
	public static Item CrystalGunWater;
	public static Item CrystalGunFire;
	public static Item CrystalGunSand;
	public static Item CrystalGunAir;
	public static Item CrystalGunIce;
	public static Item CrystalGunLife;
	public static Item CrystalGunGrass;
	public static Item CrystalGunPoison;
	public static Item CrystalGunHealing;
	
	public static Item SaphireHelmet;
	public static Item RubyChestplate;
	public static Item OpalLeggings;
	public static Item AquamarineBoots;
	
	public static int[] gemsReduc = new int[] {15, 23, 20, 15};
	static EnumArmorMaterial GemsMaterial = EnumHelper.addArmorMaterial("Gems", 60, gemsReduc, 16);
	
	public RegistryItems()
	{
		
	}
	
	public static void RegistryGenericItems()
	{
		Crystal = new ItemCrystal(CrystalGunMain.CrystalID);
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 0), "Water Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 1), "Fire Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 2), "Air Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 3), "Ice Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 4), "Sand Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 5), "Life Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 6), "Grass Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 7), "Poison Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 8), "Healing Crystal");
		
		CoreExtractorItem = new ItemReed(CrystalGunMain.CoreExtractorItemID, RegistryBlocks.CoreExtractor).setIconIndex(25).setItemName("CoreExtractorItem")
				.setCreativeTab(CrystalGunMain.crystalGunTab).setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(CoreExtractorItem, "Core Extractor");
		
		IronBrain = new Item(CrystalGunMain.IronBrainID).setIconIndex(29).setItemName("IronBrain").setCreativeTab(CrystalGunMain.crystalGunTab)
				.setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(IronBrain, "Iron Brain");
		
		GoldenBrain = new Item(CrystalGunMain.GoldenBrainID).setIconIndex(30).setItemName("GoldenBrain").setCreativeTab(CrystalGunMain.crystalGunTab)
				.setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(GoldenBrain, "Golden Brain");
		
		DiamondBrain = new Item(CrystalGunMain.DiamondBrainID).setIconIndex(31).setItemName("DiamondBrain").setCreativeTab(CrystalGunMain.crystalGunTab)
				.setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(DiamondBrain, "Diamond Brain");
		
		ConductiveIron = new Item(CrystalGunMain.ConductiveIronID).setIconIndex(44).setItemName("ConductiveIron").setCreativeTab(CrystalGunMain.crystalGunTab)
				.setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(ConductiveIron, "Conductive Iron");
		
		ConductiveGold = new Item(CrystalGunMain.ConductiveGoldID).setIconIndex(45).setItemName("ConductiveGold").setCreativeTab(CrystalGunMain.crystalGunTab)
				.setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(ConductiveGold, "Conductive Gold");
		
		ConductiveDiamond = new Item(CrystalGunMain.ConductiveDiamondID).setIconIndex(46).setItemName("ConductiveDiamond").setCreativeTab(CrystalGunMain.crystalGunTab)
				.setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(ConductiveDiamond, "Conductive Diamond");
		
		Gem = new ItemGem(CrystalGunMain.GemID);
		LanguageRegistry.addName(new ItemStack(Gem, 1, 0), "Saphire");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 1), "Ruby");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 2), "Opal");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 3), "Aquamarine");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 4), "Topaz");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 5), "Tourmaline");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 6), "Peridot");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 7), "Amethyst");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 8), "Spessartite Garnet");
		
		ShinyCrystal = new ItemShinyCrystal(CrystalGunMain.ShinyCrystalID);
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 0), "Shiny Water Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 1), "Shiny Fire Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 2), "Shiny Air Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 3), "Shiny Ice Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 4), "Shiny Sand Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 5), "Shiny Life Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 6), "Shiny Grass Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 7), "Shiny Poison Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 8), "Shiny Healing Crystal");
		
		SaphireHelmet = new ItemSaphireHelmet(CrystalGunMain.SaphireHelmetID, GemsMaterial, 0, 0).setIconIndex(51).setItemName("SaphireHelmet").setCreativeTab(CrystalGunMain.crystalGunTab);
		LanguageRegistry.addName(SaphireHelmet, "Saphire Helmet");

		RubyChestplate = new ItemRubyChestplate(CrystalGunMain.RubyChestplateID, GemsMaterial, 0, 1).setIconIndex(50).setItemName("RubyChestplate").setCreativeTab(CrystalGunMain.crystalGunTab);
		LanguageRegistry.addName(RubyChestplate, "Ruby Chestplate");
		
		OpalLeggings = new ItemOpalLeggings(CrystalGunMain.OpalLeggingsID, GemsMaterial, 0, 2).setIconIndex(49).setItemName("OpalLeggings").setCreativeTab(CrystalGunMain.crystalGunTab);
		LanguageRegistry.addName(OpalLeggings, "Opal Leggings");
		
		AquamarineBoots = new ItemAquamarineBoots(CrystalGunMain.AquamarineBootsID, GemsMaterial, 0, 3).setIconIndex(48).setItemName("AquamarineBoots").setCreativeTab(CrystalGunMain.crystalGunTab);
		LanguageRegistry.addName(AquamarineBoots, "Aquamarine Boots");
		
		CauldronItem = new ItemReed(CrystalGunMain.CauldronItemID, RegistryBlocks.CGCauldron).setIconIndex(52).setItemName("CauldronItem")
				.setCreativeTab(CrystalGunMain.crystalGunTab).setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(CauldronItem, "Metal Pot");
		
		MotionCore = new Item(CrystalGunMain.MotionCoreID).setIconIndex(53).setItemName("MotionCore").setCreativeTab(CrystalGunMain.crystalGunTab)
				.setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(MotionCore, "Motion Core");
	}
	
	public static void RegistryCrystalGuns()
	{
		CrystalGun = new ItemCrystalGun(CrystalGunMain.CrystalGunID).setItemName("CrystalGun").setIconIndex(12);
		LanguageRegistry.addName(CrystalGun, "Crystal Gun");
		
		CrystalGunWater = new ItemCrystalGunWater(CrystalGunMain.CrystalGunWaterID).setEffect("Fire", 12, 0, 0, 0).setName("Water Cannon").setColor(0, 97, 194)
				.setItemName("CrystalGunWater").setIconIndex(13);
		LanguageRegistry.addName(CrystalGunWater, "Crystal Gun");
		
		CrystalGunFire = new ItemCrystalGunFire(CrystalGunMain.CrystalGunFireID).setEffect("Fire", 5, 4, 0, 0).setName("Flame Burst").setColor(181, 15, 0)
				.setItemName("CrystalGunFire").setIconIndex(14);
		LanguageRegistry.addName(CrystalGunFire, "Crystal Gun");
		
		CrystalGunAir = new ItemCrystalGunAir(CrystalGunMain.CrystalGunAirID).setEffect("Knockback", 3, 6, 0, 0).setName("Wind Blast").setColor(166, 166, 166)
				 .setItemName("CrystalGunAir").setIconIndex(15);
		LanguageRegistry.addName(CrystalGunAir, "Crystal Gun");
		
		CrystalGunSand = new ItemCrystalGunSand(CrystalGunMain.CrystalGunSandID).setEffect("Potion", 3, 15, 120, 10).setName("Sand Burst").setColor(158, 153, 0)
				.setItemName("CrystalGunSand").setIconIndex(17);
		LanguageRegistry.addName(CrystalGunSand, "Crystal Gun");
		
		CrystalGunIce = new ItemCrystalGunIce(CrystalGunMain.CrystalGunIceID).setEffect("Potion", 3, 2, 200, 6).setName("Frozen Blast").setColor(20, 202, 252)
				.setItemName("CrystalGunIce").setIconIndex(16);
		LanguageRegistry.addName(CrystalGunIce, "Crystal Gun");
		
		CrystalGunLife = new ItemCrystalGunLife(CrystalGunMain.CrystalGunLifeID).setEffect("Heal", 16, 16, 0, 0).setName("Life Drain").setColor(194, 10, 172)
				.setItemName("CrystalGunLife").setIconIndex(18);
		LanguageRegistry.addName(CrystalGunLife, "Crystal Gun");
		
		CrystalGunGrass = new ItemCrystalGunGrass(CrystalGunMain.CrystalGunGrassID).setEffect("Potion", 4, 9, 400, 5).setName("Grass Canon").setColor(6, 255, 0)
				.setItemName("CrystalGunGrass").setIconIndex(21);
		LanguageRegistry.addName(CrystalGunGrass, "Crystal Gun");
		
		CrystalGunPoison = new ItemCrystalGunPoison(CrystalGunMain.CrystalGunPoisonID).setEffect("Potion", 2, 20, 100, 2).setName("Poison Blast").setColor(91, 53, 122)
				.setItemName("CrystalGunPoison").setIconIndex(24);
		LanguageRegistry.addName(CrystalGunPoison, "Crystal Gun");
		
		CrystalGunHealing = new ItemCrystalGunHealing(CrystalGunMain.CrystalGunHealingID).setEffect("Potion", 0, 10, 48, 2).setName("Healing Power").setColor(255, 124, 41)
				.setItemName("CrystalGunHealing").setIconIndex(33);
		LanguageRegistry.addName(CrystalGunHealing, "Crystal Gun");
	}
}
