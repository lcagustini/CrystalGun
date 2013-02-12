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

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import torresmon235.crystalgun.blocks.BlockCoreExtractor;
import torresmon235.crystalgun.entities.EntityAir;
import torresmon235.crystalgun.entities.EntityFire;
import torresmon235.crystalgun.entities.EntityGrass;
import torresmon235.crystalgun.entities.EntityIce;
import torresmon235.crystalgun.entities.EntityLife;
import torresmon235.crystalgun.entities.EntityPoison;
import torresmon235.crystalgun.entities.EntitySand;
import torresmon235.crystalgun.entities.EntityWater;
import torresmon235.crystalgun.entities.ParticleAir;
import torresmon235.crystalgun.entities.ParticleFire;
import torresmon235.crystalgun.entities.ParticleGrass;
import torresmon235.crystalgun.entities.ParticleIce;
import torresmon235.crystalgun.entities.ParticleLife;
import torresmon235.crystalgun.entities.ParticlePoison;
import torresmon235.crystalgun.entities.ParticleSand;
import torresmon235.crystalgun.entities.ParticleWater;
import torresmon235.crystalgun.handlers.CrystalGunClientPacketHandler;
import torresmon235.crystalgun.handlers.CrystalGunExtractorHandler;
import torresmon235.crystalgun.handlers.CrystalGunServerPacketHandler;
import torresmon235.crystalgun.items.ItemCrystal;
import torresmon235.crystalgun.items.ItemCrystalGun;
import torresmon235.crystalgun.items.ItemCrystalGunAir;
import torresmon235.crystalgun.items.ItemCrystalGunFire;
import torresmon235.crystalgun.items.ItemCrystalGunGrass;
import torresmon235.crystalgun.items.ItemCrystalGunIce;
import torresmon235.crystalgun.items.ItemCrystalGunLife;
import torresmon235.crystalgun.items.ItemCrystalGunPoison;
import torresmon235.crystalgun.items.ItemCrystalGunSand;
import torresmon235.crystalgun.items.ItemCrystalGunWater;
import torresmon235.crystalgun.render.RenderCoreExtractor;
import torresmon235.crystalgun.tileentities.TileEntityCoreExtractor;
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
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "crystalgun", name = "Crystal Gun", version = "0.3beta")
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
	public int CoreExtractorID;
	public int CoreExtractorItemID;
	public int CrystalID;
	public int IronBrainID;
	public int GoldenBrainID;
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
	
	//Blocks
	public static Block CoreExtractor;
	
	//Items
	public static Item Crystal;
	public static Item CoreExtractorItem;
	public static Item IronBrain;
	public static Item GoldenBrain;
	
	public static int startEntityId = 300;
	public static CreativeTabs crystalGunTab = new CrystalGunCreativeTab("crystalGunTab");
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) 
	{
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        
        config.load();
        
        CrystalGunID = config.getItem("Crystal Gun ID", 600).getInt();
        CrystalGunWaterID = config.getItem("Crystal Gun ID (Water)", 601).getInt();
        CrystalGunFireID = config.getItem("Crystal Gun ID (Fire)", 602).getInt();
        CrystalGunSandID = config.getItem("Crystal Gun ID (Sand)", 603).getInt();
        CrystalGunAirID = config.getItem("Crystal Gun ID (Ait)", 604).getInt();
        CrystalGunIceID = config.getItem("Crystal Gun ID (Ice)", 605).getInt();
        CrystalGunLifeID = config.getItem("Crystal Gun ID (Life)", 606).getInt();
        CrystalGunGrassID = config.getItem("Crystal Gun ID (Grass)", 607).getInt();
        CrystalGunPoisonID = config.getItem("Crystal Gun ID (Poison)", 608).getInt();
        CrystalID = config.getItem("Crystals ID", 609).getInt();
        CoreExtractorItemID = config.getItem("Core Extractor ID (Item)", 610).getInt();
        IronBrainID = config.getItem("Iron Brain ID", 611).getInt();
        GoldenBrainID = config.getItem("Golden Brain ID", 612).getInt();
        CoreExtractorID = config.getBlock("Core Extractor ID", 600).getInt();
        EggDrop = config.get(Configuration.CATEGORY_GENERAL, "Turrets should drop eggs", true).getBoolean(false);

        config.save();

        mc.installResource("sound3/crystalgun/shot.ogg", new File(mc.mcDataDir, "resources/torresmon235/crystalgun/shot.ogg"));
        mc.installResource("sound3/crystalgun/craft.ogg", new File(mc.mcDataDir, "resources/torresmon235/crystalgun/craft.ogg"));
	}

	@Init
	public void init(FMLInitializationEvent event) 
	{
		//Creative Tab
		LanguageRegistry.instance().addStringLocalization("itemGroup.crystalGunTab", "en_US", "Crystal Gun");
		
		//Render
		proxy.registerRenderThings();
		
		//TileEntities
		GameRegistry.registerTileEntity(TileEntityCoreExtractor.class, "CoreExtractor");
		
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
		
		EntityRegistry.registerModEntity(TurretWooden.class, "WoodenTurret", 17, this, 100, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.crystalgun.WoodenTurret.name", "Wooden Turret");
		registerEntityEgg(TurretWooden.class, 0xCC7700, 0xFFED8A);

		EntityRegistry.registerModEntity(TurretStone.class, "StoneTurret", 18, this, 100, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.crystalgun.StoneTurret.name", "Stone Turret");
		registerEntityEgg(TurretStone.class, 0x999999, 0xFFFFFF);

		//Blocks
		CoreExtractor = (new BlockCoreExtractor(CoreExtractorID, 9, torresmon235.crystalgun.tileentities.TileEntityCoreExtractor.class)).setHardness(3F)
				.setResistance(30F).setStepSound(Block.soundStoneFootstep).setBlockName("CoreExtractor");
		LanguageRegistry.addName(CoreExtractor, "Core Extractor");
		GameRegistry.registerBlock(CoreExtractor, "CoreExtractor");

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
		
		Crystal = new ItemCrystal(CrystalID);
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 0), "Water Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 1), "Fire Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 2), "Air Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 3), "Ice Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 4), "Sand Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 5), "Life Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 6), "Grass Crystal");
		LanguageRegistry.addName(new ItemStack(Crystal, 1, 7), "Poison Crystal");
		
		CoreExtractorItem = new ItemReed(CoreExtractorItemID, CoreExtractor).setIconIndex(25).setItemName("CoreExtractorItem")
				.setCreativeTab(CrystalGunMain.crystalGunTab).setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(CoreExtractorItem, "Core Extractor");
		
		IronBrain = new Item(IronBrainID).setIconIndex(29).setItemName("IronBrain").setCreativeTab(CrystalGunMain.crystalGunTab)
				.setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(IronBrain, "Iron Brain");
		
		GoldenBrain = new Item(GoldenBrainID).setIconIndex(30).setItemName("GoldenBrain").setCreativeTab(CrystalGunMain.crystalGunTab)
				.setTextureFile("/torresmon235/crystalgun/textures/items.png");
		LanguageRegistry.addName(GoldenBrain, "Golden Brain");
		
		//Recipes
		GameRegistry.addRecipe(new ItemStack(CoreExtractorItem, 1), new Object[] {"EIE", "GIG", "SSS", 'E', Item.emerald, 'I', Item.ingotIron, 'G', Item.ingotGold, 'S', Block.stone});
		GameRegistry.addRecipe(new ItemStack(Block.sponge), new Object[] {"YSY", "SBS", "YSY", 'Y', new ItemStack(Block.cloth, 1, 4), 'S', new ItemStack(Item.dyePowder, 1, 0), 'B', Item.bucketEmpty});
		GameRegistry.addRecipe(new ItemStack(CrystalGun, 1), new Object[] {"GI ", "IEI", "SIO", 'G', Block.glass, 'I', Item.ingotGold, 'E', Item.eyeOfEnder, 'S', Block.sponge, 'O', Block.obsidian});
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 301), new Object[] {"WBW", " W ", "WWW", 'W', Block.wood, 'B', IronBrain});
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 302), new Object[] {"SBS", " S ", "SSS", 'S', Block.stone, 'B', GoldenBrain});
		
		CrystalGunExtractorHandler.addRecipe(Item.coal, new ItemStack(Crystal, 1, 1));
		CrystalGunExtractorHandler.addRecipe(Item.blazePowder, new ItemStack(Crystal, 1, 1));
		CrystalGunExtractorHandler.addRecipe(Item.rottenFlesh, new ItemStack(Crystal, 1, 7));
		CrystalGunExtractorHandler.addRecipe(Item.spiderEye, new ItemStack(Crystal, 1, 7));
		CrystalGunExtractorHandler.addRecipe(Item.fishRaw, new ItemStack(Crystal, 1, 0));
		CrystalGunExtractorHandler.addRecipe(Item.feather, new ItemStack(Crystal, 1, 2));
		CrystalGunExtractorHandler.addRecipe(new ItemStack(Block.blockSnow).getItem() , new ItemStack(Crystal, 1, 3));
		CrystalGunExtractorHandler.addRecipe(new ItemStack(Block.ice).getItem(), new ItemStack(Crystal, 1, 3));
		CrystalGunExtractorHandler.addRecipe(new ItemStack(Block.sand).getItem(), new ItemStack(Crystal, 1, 4));
		CrystalGunExtractorHandler.addRecipe(Item.appleRed, new ItemStack(Crystal, 1, 5));
		CrystalGunExtractorHandler.addRecipe(Item.seeds, new ItemStack(Crystal, 1, 6));
		CrystalGunExtractorHandler.addRecipe(CrystalGunAir, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(CrystalGunFire, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(CrystalGunWater, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(CrystalGunIce, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(CrystalGunSand, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(CrystalGunLife, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(CrystalGunGrass, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(CrystalGunPoison, new ItemStack(CrystalGun, 1));
		CrystalGunExtractorHandler.addRecipe(Item.ingotIron, new ItemStack(IronBrain, 1));
		CrystalGunExtractorHandler.addRecipe(Item.ingotGold, new ItemStack(GoldenBrain, 1));
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
	
	@PostInit
	public static void postInit(FMLPostInitializationEvent event) 
	{

	}
}