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
package torresmon235.crystalgun.common;

import java.awt.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import torresmon235.crystalgun.blocks.BlockCGSponge;
import torresmon235.crystalgun.blocks.BlockCoreExtractor;
import torresmon235.crystalgun.blocks.BlockCrystalBlock;
import torresmon235.crystalgun.blocks.BlockCGCauldron;
import torresmon235.crystalgun.entities.EntityAir;
import torresmon235.crystalgun.entities.EntityFire;
import torresmon235.crystalgun.entities.EntityGrass;
import torresmon235.crystalgun.entities.EntityHealing;
import torresmon235.crystalgun.entities.EntityIce;
import torresmon235.crystalgun.entities.EntityLife;
import torresmon235.crystalgun.entities.EntityPoison;
import torresmon235.crystalgun.entities.EntitySand;
import torresmon235.crystalgun.entities.EntityWater;
import torresmon235.crystalgun.entities.particles.ParticleAir;
import torresmon235.crystalgun.entities.particles.ParticleFire;
import torresmon235.crystalgun.entities.particles.ParticleGrass;
import torresmon235.crystalgun.entities.particles.ParticleHealing;
import torresmon235.crystalgun.entities.particles.ParticleIce;
import torresmon235.crystalgun.entities.particles.ParticleLife;
import torresmon235.crystalgun.entities.particles.ParticlePoison;
import torresmon235.crystalgun.entities.particles.ParticleSand;
import torresmon235.crystalgun.entities.particles.ParticleWater;
import torresmon235.crystalgun.handlers.CrystalGunCauldronHandler;
import torresmon235.crystalgun.handlers.CrystalGunClientPacketHandler;
import torresmon235.crystalgun.handlers.CrystalGunExtractorHandler;
import torresmon235.crystalgun.handlers.CrystalGunGuiHandler;
import torresmon235.crystalgun.handlers.CrystalGunServerPacketHandler;
import torresmon235.crystalgun.items.ItemCrystal;
import torresmon235.crystalgun.items.ItemCrystalBlock;
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
import torresmon235.crystalgun.render.RenderCoreExtractor;
import torresmon235.crystalgun.tileentities.TileEntityCGCauldron;
import torresmon235.crystalgun.tileentities.TileEntityCoreExtractor;
import torresmon235.crystalgun.tileentities.TileEntitySponge;
import torresmon235.crystalgun.turrets.TurretIron;
import torresmon235.crystalgun.turrets.TurretStone;
import torresmon235.crystalgun.turrets.TurretWooden;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "crystalgun", name = "Crystal Gun", version = "0.6beta")
@NetworkMod(clientSideRequired = true, serverSideRequired = false,
clientPacketHandlerSpec =
@SidedPacketHandler(channels = {"CrystalGunMain"}, packetHandler = CrystalGunClientPacketHandler.class),
serverPacketHandlerSpec =
@SidedPacketHandler(channels = {"CrystalGunMain"}, packetHandler = CrystalGunServerPacketHandler.class))

public class CrystalGunMain
{
	@Instance("crystalgun")
	public static CrystalGunMain instance;
	
	@SidedProxy(clientSide="torresmon235.crystalgun.common.CrystalGunClientProxy", serverSide="torresmon235.crystalgun.common.CrystalGunCommonProxy")
	public static CrystalGunCommonProxy proxy;
	
    public static Minecraft mc = net.minecraft.client.Minecraft.getMinecraft();
	
    RenderCoreExtractor renderCore = new RenderCoreExtractor();

	//Config IDs
	public int CrystalGunID;
	public int CrystalGunWaterID;
	public int CrystalGunFireID;
	public int CrystalGunAirID;
	public int CrystalGunSandID;
	public int CrystalGunIceID;
	public int CrystalGunLifeID;
	public int CrystalGunGrassID;
	public int CrystalGunPoisonID;
	public int CrystalGunHealingID;
	public int CoreExtractorID;
	public int CoreExtractorItemID;
	public int ShinyCrystalID;
	public int GemID;
	public int CrystalID;
	public int IronBrainID;
	public int GoldenBrainID;
	public int DiamondBrainID;
	public int ConductiveIronID;
	public int ConductiveGoldID;
	public int ConductiveDiamondID;
	public int SaphireHelmetID;
	public int RubyChestplateID;
	public int OpalLeggingsID;
	public int AquamarineBootsID;
	public int CauldronItemID;
	public int CrystalBlockID;
	public int CGSpongeID;
	public int CGCauldronID;
	public static boolean EggDrop;
	
	//CrystalGuns
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
	
	//Blocks
	public static Block CoreExtractor;
	public static Block CrystalBlock;
	public static Block CGSponge;
	public static Block CGCauldron;
	
	//Items
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
	
	//Armor
	public static Item SaphireHelmet;
	public static Item RubyChestplate;
	public static Item OpalLeggings;
	public static Item AquamarineBoots;
	
	//Misc
	public static int startEntityId = 300;
	public static CreativeTabs crystalGunTab = new CrystalGunCreativeTab("crystalGunTab");
	public static int[] gemsReduc = new int[] {15, 23, 20, 15};
	static EnumArmorMaterial GemsMaterial = EnumHelper.addArmorMaterial("Gems", 60, gemsReduc, 16);
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) 
	{
		copyResource("/torresmon235/crystalgun/sounds/shot.ogg", mc.mcDataDir + "/resources/torresmon235/crystalgun/", "shot.ogg");
		copyResource("/torresmon235/crystalgun/sounds/craft.ogg", mc.mcDataDir + "/resources/torresmon235/crystalgun/", "craft.ogg");
		
		mc.installResource("sound3/crystalgun/shot.ogg", new File(mc.mcDataDir, "resources/torresmon235/crystalgun/shot.ogg"));
        mc.installResource("sound3/crystalgun/craft.ogg", new File(mc.mcDataDir, "resources/torresmon235/crystalgun/craft.ogg"));
		System.out.println("Resources installed");
		
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        
        config.load();
        
        CrystalGunID = config.getItem("Crystal Gun ID", 13330).getInt();
        CrystalGunWaterID = config.getItem("Crystal Gun ID (Water)", 13331).getInt();
        CrystalGunFireID = config.getItem("Crystal Gun ID (Fire)", 13332).getInt();
        CrystalGunSandID = config.getItem("Crystal Gun ID (Sand)", 13333).getInt();
        CrystalGunAirID = config.getItem("Crystal Gun ID (Ait)", 13334).getInt();
        CrystalGunIceID = config.getItem("Crystal Gun ID (Ice)", 13335).getInt();
        CrystalGunLifeID = config.getItem("Crystal Gun ID (Life)", 13336).getInt();
        CrystalGunGrassID = config.getItem("Crystal Gun ID (Grass)", 13337).getInt();
        CrystalGunPoisonID = config.getItem("Crystal Gun ID (Poison)", 13338).getInt();
        CrystalGunHealingID = config.getItem("Crystal Gun ID (Healing)", 13339).getInt();
        CrystalID = config.getItem("Crystals ID", 13350).getInt();
        CoreExtractorItemID = config.getItem("Core Extractor ID (Item)", 13351).getInt();
        IronBrainID = config.getItem("Iron Brain ID", 13352).getInt();
        GoldenBrainID = config.getItem("Golden Brain ID", 13353).getInt();
        DiamondBrainID = config.getItem("Diamond Brain ID", 13354).getInt();
        GemID = config.getItem("Gems ID", 13355).getInt();
        ConductiveIronID = config.getItem("Conductive Iron ID", 13356).getInt();
        ConductiveGoldID = config.getItem("Conductive Gold ID", 13357).getInt();
        ConductiveDiamondID = config.getItem("Conductive Diamond ID", 13358).getInt();
        ShinyCrystalID = config.getItem("Shiny Cristal ID", 13359).getInt();
        SaphireHelmetID = config.getItem("Saphire Helmet ID", 13360).getInt();
        RubyChestplateID = config.getItem("Ruby Chestplate ID", 13361).getInt();
        OpalLeggingsID = config.getItem("Opal Leggings ID", 13362).getInt();
        AquamarineBootsID = config.getItem("Aquarine Boots ID", 13363).getInt();
        CauldronItemID = config.getItem("Metal Pot ID (Item)", 13364).getInt();
        CoreExtractorID = config.getBlock("Core Extractor ID", 600).getInt();
        CrystalBlockID = config.getBlock("Crystal Block ID", 601).getInt();
        CGSpongeID = config.getBlock("Sponge ID", 602).getInt();
        CGCauldronID = config.getBlock("Metal Pot ID", 603).getInt();
        EggDrop = config.get(Configuration.CATEGORY_GENERAL, "Turrets should drop eggs", true).getBoolean(false);

        config.save();
        System.out.println("Configuration Succesful");
	}

	@Init
	public void init(FMLInitializationEvent event) 
	{
		//GUI
		NetworkRegistry.instance().registerGuiHandler(instance, new CrystalGunGuiHandler());

		//Creative Tab
		LanguageRegistry.instance().addStringLocalization("itemGroup.crystalGunTab", "en_US", "Crystal Gun");
		
		//TileEntities
		GameRegistry.registerTileEntity(TileEntityCoreExtractor.class, "CoreExtractor");
		GameRegistry.registerTileEntity(TileEntityCGCauldron.class, "CGCauldron");
		GameRegistry.registerTileEntity(TileEntitySponge.class, "CGSponge");

		//Entities
		EntityRegistry.registerModEntity(EntityFire.class, "Fire", 1, this, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleFire.class, "ParticleFire", 2, this, 100, 1, true);
		EntityRegistry.registerModEntity(EntityAir.class, "Air", 3, this, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleAir.class, "ParticleAir", 4, this, 100, 1, true);
		EntityRegistry.registerModEntity(EntityGrass.class, "Grass", 5, this, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleGrass.class, "ParticleGrass", 6, this, 100, 1, true);
		EntityRegistry.registerModEntity(EntityIce.class, "Ice", 7, this, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleIce.class, "ParticleIce", 8, this, 100, 1, true);
		EntityRegistry.registerModEntity(EntityLife.class, "Life", 9, this, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleLife.class, "ParticleLife", 10, this, 100, 1, true);
		EntityRegistry.registerModEntity(EntityPoison.class, "Poison", 11, this, 100, 1, true);
		EntityRegistry.registerModEntity(ParticlePoison.class, "ParticlePoison", 12, this, 100, 1, true);
		EntityRegistry.registerModEntity(EntitySand.class, "Sand", 13, this, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleSand.class, "ParticleSand", 14, this, 100, 1, true);
		EntityRegistry.registerModEntity(EntityWater.class, "Water", 15, this, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleWater.class, "ParticleWater", 16, this, 100, 1, true);
		EntityRegistry.registerModEntity(EntityHealing.class, "Healing", 20, this, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleHealing.class, "ParticleHealing", 21, this, 100, 1, true);
		
		EntityRegistry.registerModEntity(TurretWooden.class, "WoodenTurret", 17, this, 100, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.crystalgun.WoodenTurret.name", "Wooden Turret");
		registerEntityEgg(TurretWooden.class, 0xCC7700, 0xFFED8A);

		EntityRegistry.registerModEntity(TurretStone.class, "StoneTurret", 18, this, 100, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.crystalgun.StoneTurret.name", "Stone Turret");
		registerEntityEgg(TurretStone.class, 0x999999, 0xFFFFFF);
		
		EntityRegistry.registerModEntity(TurretIron.class, "IronTurret", 19, this, 100, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.crystalgun.IronTurret.name", "Iron Turret");
		registerEntityEgg(TurretIron.class, 0xF5F5F5, 0xBFBFBF);

		//Blocks
		CoreExtractor = (new BlockCoreExtractor(CoreExtractorID, 9, torresmon235.crystalgun.tileentities.TileEntityCoreExtractor.class)).setHardness(3F)
				.setResistance(30F).setStepSound(Block.soundStoneFootstep).setBlockName("CoreExtractor");
		LanguageRegistry.addName(CoreExtractor, "Core Extractor");
		GameRegistry.registerBlock(CoreExtractor, "CoreExtractor");
		
		CrystalBlock = new BlockCrystalBlock(CrystalBlockID);
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
		
		CGSponge = new BlockCGSponge(CGSpongeID).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setBlockName("CGSponge");
		LanguageRegistry.addName(CGSponge, "Sponge");
		GameRegistry.registerBlock(CGSponge, "Sponge");
		
		CGCauldron = new BlockCGCauldron(CGCauldronID).setHardness(2.0F).setBlockName("CGCauldron").setRequiresSelfNotify();
		LanguageRegistry.addName(CGCauldron, "Metal Pot");
		GameRegistry.registerBlock(CGCauldron, "Metal Pot");
		
		//Items
		CrystalGun = new ItemCrystalGun(CrystalGunID).setItemName("CrystalGun").setIconIndex(12);
		LanguageRegistry.addName(CrystalGun, "Crystal Gun");
		
		CrystalGunWater = new ItemCrystalGunWater(CrystalGunWaterID).setEffect("Fire", 12, 0, 0, 0).setName("Water Cannon").setColor(0, 97, 194)
				.setItemName("CrystalGunWater").setIconIndex(13);
		LanguageRegistry.addName(CrystalGunWater, "Crystal Gun");
		
		CrystalGunFire = new ItemCrystalGunFire(CrystalGunFireID).setEffect("Fire", 5, 4, 0, 0).setName("Flame Burst").setColor(181, 15, 0)
				.setItemName("CrystalGunFire").setIconIndex(14);
		LanguageRegistry.addName(CrystalGunFire, "Crystal Gun");
		
		CrystalGunAir = new ItemCrystalGunAir(CrystalGunAirID).setEffect("Knockback", 3, 6, 0, 0).setName("Wind Blast").setColor(166, 166, 166)
				 .setItemName("CrystalGunAir").setIconIndex(15);
		LanguageRegistry.addName(CrystalGunAir, "Crystal Gun");
		
		CrystalGunSand = new ItemCrystalGunSand(CrystalGunSandID).setEffect("Potion", 3, 15, 120, 10).setName("Sand Burst").setColor(158, 153, 0)
				.setItemName("CrystalGunSand").setIconIndex(17);
		LanguageRegistry.addName(CrystalGunSand, "Crystal Gun");
		
		CrystalGunIce = new ItemCrystalGunIce(CrystalGunIceID).setEffect("Potion", 3, 2, 200, 6).setName("Frozen Blast").setColor(20, 202, 252)
				.setItemName("CrystalGunIce").setIconIndex(16);
		LanguageRegistry.addName(CrystalGunIce, "Crystal Gun");
		
		CrystalGunLife = new ItemCrystalGunLife(CrystalGunLifeID).setEffect("Heal", 16, 16, 0, 0).setName("Life Drain").setColor(194, 10, 172)
				.setItemName("CrystalGunLife").setIconIndex(18);
		LanguageRegistry.addName(CrystalGunLife, "Crystal Gun");
		
		CrystalGunGrass = new ItemCrystalGunGrass(CrystalGunGrassID).setEffect("Potion", 4, 9, 400, 5).setName("Grass Canon").setColor(6, 255, 0)
				.setItemName("CrystalGunGrass").setIconIndex(21);
		LanguageRegistry.addName(CrystalGunGrass, "Crystal Gun");
		
		CrystalGunPoison = new ItemCrystalGunPoison(CrystalGunPoisonID).setEffect("Potion", 2, 20, 100, 2).setName("Poison Blast").setColor(91, 53, 122)
				.setItemName("CrystalGunPoison").setIconIndex(24);
		LanguageRegistry.addName(CrystalGunPoison, "Crystal Gun");
		
		CrystalGunHealing = new ItemCrystalGunHealing(CrystalGunHealingID).setEffect("Potion", 0, 10, 48, 2).setName("Healing Power").setColor(255, 124, 41)
				.setItemName("CrystalGunHealing").setIconIndex(33);
		LanguageRegistry.addName(CrystalGunHealing, "Crystal Gun");
		
		Crystal = new ItemCrystal(CrystalID);
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 0), "Water Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 1), "Fire Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 2), "Air Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 3), "Ice Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 4), "Sand Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 5), "Life Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 6), "Grass Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 7), "Poison Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 8), "Healing Crystal");
		
		CoreExtractorItem = new ItemReed(CoreExtractorItemID, CoreExtractor).setIconIndex(25).setItemName("CoreExtractorItem")
				.setCreativeTab(CrystalGunMain.crystalGunTab).setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(CoreExtractorItem, "Core Extractor");
		
		IronBrain = new Item(IronBrainID).setIconIndex(29).setItemName("IronBrain").setCreativeTab(CrystalGunMain.crystalGunTab)
				.setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(IronBrain, "Iron Brain");
		
		GoldenBrain = new Item(GoldenBrainID).setIconIndex(30).setItemName("GoldenBrain").setCreativeTab(CrystalGunMain.crystalGunTab)
				.setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(GoldenBrain, "Golden Brain");
		
		DiamondBrain = new Item(DiamondBrainID).setIconIndex(31).setItemName("DiamondBrain").setCreativeTab(CrystalGunMain.crystalGunTab)
				.setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(DiamondBrain, "Diamond Brain");
		
		ConductiveIron = new Item(ConductiveIronID).setIconIndex(44).setItemName("ConductiveIron").setCreativeTab(CrystalGunMain.crystalGunTab)
				.setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(ConductiveIron, "Conductive Iron");
		
		ConductiveGold = new Item(ConductiveGoldID).setIconIndex(45).setItemName("ConductiveGold").setCreativeTab(CrystalGunMain.crystalGunTab)
				.setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(ConductiveGold, "Conductive Gold");
		
		ConductiveDiamond = new Item(ConductiveDiamondID).setIconIndex(46).setItemName("ConductiveDiamond").setCreativeTab(CrystalGunMain.crystalGunTab)
				.setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(ConductiveDiamond, "Conductive Diamond");
		
		Gem = new ItemGem(GemID);
		LanguageRegistry.addName(new ItemStack(Gem, 1, 0), "Saphire");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 1), "Ruby");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 2), "Opal");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 3), "Aquamarine");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 4), "Topaz");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 5), "Tourmaline");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 6), "Peridot");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 7), "Amethyst");
		LanguageRegistry.addName(new ItemStack(Gem, 1, 8), "Spessartite Garnet");
		
		ShinyCrystal = new ItemShinyCrystal(ShinyCrystalID);
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 0), "Shiny Water Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 1), "Shiny Fire Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 2), "Shiny Air Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 3), "Shiny Ice Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 4), "Shiny Sand Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 5), "Shiny Life Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 6), "Shiny Grass Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 7), "Shiny Poison Crystal");
		LanguageRegistry.addName(new ItemStack(ShinyCrystal, 1, 8), "Shiny Healing Crystal");
		
		SaphireHelmet = new ItemSaphireHelmet(SaphireHelmetID, GemsMaterial, 0, 0).setIconIndex(51).setItemName("SaphireHelmet").setCreativeTab(CrystalGunMain.crystalGunTab);
		LanguageRegistry.addName(SaphireHelmet, "Saphire Helmet");

		RubyChestplate = new ItemRubyChestplate(RubyChestplateID, GemsMaterial, 0, 1).setIconIndex(50).setItemName("RubyChestplate").setCreativeTab(CrystalGunMain.crystalGunTab);
		LanguageRegistry.addName(RubyChestplate, "Ruby Chestplate");
		
		OpalLeggings = new ItemOpalLeggings(OpalLeggingsID, GemsMaterial, 0, 2).setIconIndex(49).setItemName("OpalLeggings").setCreativeTab(CrystalGunMain.crystalGunTab);
		LanguageRegistry.addName(OpalLeggings, "Opal Leggings");
		
		AquamarineBoots = new ItemAquamarineBoots(AquamarineBootsID, GemsMaterial, 0, 3).setIconIndex(48).setItemName("AquamarineBoots").setCreativeTab(CrystalGunMain.crystalGunTab);
		LanguageRegistry.addName(AquamarineBoots, "Aquamarine Boots");
		
		CauldronItem = new ItemReed(CauldronItemID, CGCauldron).setIconIndex(52).setItemName("CauldronItem")
				.setCreativeTab(CrystalGunMain.crystalGunTab).setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(CauldronItem, "Metal Pot");
		
		//Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(ConductiveIron, 1), new Object[] {Item.ingotIron, Item.redstone});
		GameRegistry.addShapelessRecipe(new ItemStack(ConductiveGold, 1), new Object[] {Item.ingotGold, Item.redstone});
		GameRegistry.addShapelessRecipe(new ItemStack(ConductiveDiamond, 1), new Object[] {Item.diamond, Item.redstone});
		GameRegistry.addRecipe(new ItemStack(CoreExtractorItem, 1), new Object[] {"EIE", "GIG", "SSS", 'E', Item.emerald, 'I', Item.ingotIron, 'G', Item.ingotGold, 'S', Block.stone});
		GameRegistry.addRecipe(new ItemStack(CGSponge), new Object[] {"YSY", "SBS", "YSY", 'Y', new ItemStack(Block.cloth, 1, 4), 'S', new ItemStack(Item.dyePowder, 1, 0), 'B', Item.bucketEmpty});
		GameRegistry.addRecipe(new ItemStack(CrystalGun, 1), new Object[] {"GI ", "IEI", "SIO", 'G', Block.glass, 'I', Item.ingotGold, 'E', Item.eyeOfEnder, 'S', CGSponge, 'O', Block.obsidian});
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 301), new Object[] {"WBW", " W ", "WWW", 'W', Block.wood, 'B', IronBrain});
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 302), new Object[] {"SBS", " S ", "QQQ", 'S', Block.stone, 'B', GoldenBrain, 'Q', Block.stoneBrick});
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 303), new Object[] {"IBI", " S ", "QIQ", 'S', Item.stick, 'B', DiamondBrain, 'I', Item.ingotIron, 'Q', Block.blockSteel});
		GameRegistry.addRecipe(new ItemStack(SaphireHelmet, 1), new Object[] {"GGG", "GAG", "GGG", 'G', new ItemStack(Gem, 1, 0), 'A', Item.helmetDiamond});
		GameRegistry.addRecipe(new ItemStack(RubyChestplate, 1), new Object[] {"GGG", "GAG", "GGG", 'G', new ItemStack(Gem, 1, 1), 'A', Item.plateDiamond});
		GameRegistry.addRecipe(new ItemStack(OpalLeggings, 1), new Object[] {"GGG", "GAG", "GGG", 'G', new ItemStack(Gem, 1, 2), 'A', Item.legsDiamond});
		GameRegistry.addRecipe(new ItemStack(AquamarineBoots, 1), new Object[] {"GGG", "GAG", "GGG", 'G', new ItemStack(Gem, 1, 3), 'A', Item.bootsDiamond});
		GameRegistry.addRecipe(new ItemStack(CauldronItem, 1), new Object[] {"I I", "GOG", "III", 'G', new ItemStack(Gem, 1, 4), 'I', Item.ingotIron, 'O', Block.obsidian});
		for(int i = 0; i <= 8; i++)
		{
			GameRegistry.addRecipe(new ItemStack(CrystalBlock, 1, i), new Object[] {"CC", "CC", 'C', new ItemStack(Crystal, 1, i)});
			GameRegistry.addRecipe(new ItemStack(Crystal, 4, i), new Object[] {"C", 'C', new ItemStack(CrystalBlock, 1, i)});
		}
		for(int i = 0; i <= 8; i++)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(ShinyCrystal, 1, i), new Object[] {new ItemStack(Crystal, 1, i), Item.diamond});
		}
		
		CrystalGunExtractorHandler.addRecipe(Item.coal, new ItemStack(Crystal, 1, 1));
		CrystalGunExtractorHandler.addRecipe(Item.blazePowder, new ItemStack(Crystal, 1, 1));
		CrystalGunExtractorHandler.addRecipe(Item.rottenFlesh, new ItemStack(Crystal, 1, 7));
		CrystalGunExtractorHandler.addRecipe(Item.spiderEye, new ItemStack(Crystal, 1, 7));
		CrystalGunExtractorHandler.addRecipe(Item.bucketWater, new ItemStack(Crystal, 1, 0));
		CrystalGunExtractorHandler.addRecipe(Item.bucketWater, new ItemStack(Item.bucketEmpty, 1));
		CrystalGunExtractorHandler.addRecipe(Item.feather, new ItemStack(Crystal, 1, 2));
		CrystalGunExtractorHandler.addRecipe(new ItemStack(Block.blockSnow).getItem() , new ItemStack(Crystal, 1, 3));
		CrystalGunExtractorHandler.addRecipe(new ItemStack(Block.ice).getItem(), new ItemStack(Crystal, 1, 3));
		CrystalGunExtractorHandler.addRecipe(new ItemStack(Block.sand).getItem(), new ItemStack(Crystal, 1, 4));
		CrystalGunExtractorHandler.addRecipe(Item.appleRed, new ItemStack(Crystal, 1, 5));
		CrystalGunExtractorHandler.addRecipe(Item.seeds, new ItemStack(Crystal, 1, 6));
		CrystalGunExtractorHandler.addRecipe(Item.cookie, new ItemStack(Crystal, 1, 8));
		CrystalGunExtractorHandler.addRecipe(CrystalGunAir, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(CrystalGunFire, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(CrystalGunWater, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(CrystalGunIce, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(CrystalGunSand, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(CrystalGunLife, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(CrystalGunGrass, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(CrystalGunPoison, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(ConductiveIron, new ItemStack(IronBrain, 1));
		CrystalGunExtractorHandler.addRecipe(ConductiveGold, new ItemStack(GoldenBrain, 1));
		CrystalGunExtractorHandler.addRecipe(ConductiveDiamond, new ItemStack(DiamondBrain, 1));
		for(int i = 0; i <= 8; i++)
		{
			CrystalGunExtractorHandler.addRecipe(new ItemStack(ShinyCrystal, 1, i), new ItemStack(Gem, 1, i));
		}
		
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

		//Render
		proxy.registerRenderThings();
	}
	
	public static int getUniqueEntityId() 
	{
		do 
		{
		   startEntityId++;
		} 
		while (EntityList.getStringFromID(startEntityId) != null);
		
		return startEntityId;
	}
	
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) 
	{
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
	
	public void copyResource(String input, String outputDirectory, String outputFile)
	{
		if((new File(outputDirectory)).mkdirs())
		{
			System.out.println("Created Directory");
		}
		InputStream stream = CrystalGunMain.class.getResourceAsStream(input);
	    if (stream == null) 
	    {
	        System.out.println("Resources copying failed");
	    }
	    OutputStream resStreamOut;
	    int readBytes;
	    byte[] buffer = new byte[4096];
	    try 
	    {
	        resStreamOut = new FileOutputStream(new File(outputDirectory + outputFile));
	        while ((readBytes = stream.read(buffer)) > 0) 
	        {
	            resStreamOut.write(buffer, 0, readBytes);
	        }
	    } 
	    catch (IOException e1) 
	    {
	        e1.printStackTrace();
	    }
	}
	
	@PostInit
	public static void postInit(FMLPostInitializationEvent event) 
	{
		System.out.println(CrystalGunExtractorHandler.result.size() + " Extractor Recipes Loaded");
		System.out.println(CrystalGunCauldronHandler.Ingredient.size() + " Cauldron Recipes Loaded");
	}
}