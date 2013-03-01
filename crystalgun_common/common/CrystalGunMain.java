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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraftforge.common.Configuration;
import torresmon235.crystalgun.api.CrystalGunCauldronHandler;
import torresmon235.crystalgun.api.CrystalGunExtractorHandler;
import torresmon235.crystalgun.api.CrystalGunSorterHandler;
import torresmon235.crystalgun.handlers.CrystalGunClientPacketHandler;
import torresmon235.crystalgun.handlers.CrystalGunGuiHandler;
import torresmon235.crystalgun.handlers.CrystalGunServerPacketHandler;
import torresmon235.crystalgun.registration.RegistryBlocks;
import torresmon235.crystalgun.registration.RegistryCauldronRecipes;
import torresmon235.crystalgun.registration.RegistryCraftingRecipes;
import torresmon235.crystalgun.registration.RegistryEntities;
import torresmon235.crystalgun.registration.RegistryExtractorRecipes;
import torresmon235.crystalgun.registration.RegistryItems;
import torresmon235.crystalgun.render.RenderCoreExtractor;
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
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "crystalgun", name = "Crystal Gun", version = "0.8beta")
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
	public static int CrystalGunID;
	public static int CrystalGunWaterID;
	public static int CrystalGunFireID;
	public static int CrystalGunAirID;
	public static int CrystalGunSandID;
	public static int CrystalGunIceID;
	public static int CrystalGunLifeID;
	public static int CrystalGunGrassID;
	public static int CrystalGunPoisonID;
	public static int CrystalGunHealingID;
	public static int CoreExtractorID;
	public static int CoreExtractorItemID;
	public static int ShinyCrystalID;
	public static int GemID;
	public static int CrystalID;
	public static int IronBrainID;
	public static int GoldenBrainID;
	public static int DiamondBrainID;
	public static int ConductiveIronID;
	public static int ConductiveGoldID;
	public static int ConductiveDiamondID;
	public static int SaphireHelmetID;
	public static int RubyChestplateID;
	public static int OpalLeggingsID;
	public static int AquamarineBootsID;
	public static int CauldronItemID;
	public static int CrystalBlockID;
	public static int CGSpongeID;
	public static int CGCauldronID;
	public static int MagicalConveyorID;
	public static int MagicalSpringID;
	public static int MagicalFilterID;
	public static int MagicalSorterID;
	public static int MotionCoreID;
	public static boolean EggDrop;

	//Misc
	public static int startEntityId = 300;
	public static CreativeTabs crystalGunTab = new CrystalGunCreativeTab("crystalGunTab");
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) 
	{
		copyResource("/torresmon235/crystalgun/sounds/shot.ogg", mc.mcDataDir + "/resources/torresmon235/crystalgun/", "shot.ogg");
		copyResource("/torresmon235/crystalgun/sounds/craft.ogg", mc.mcDataDir + "/resources/torresmon235/crystalgun/", "craft.ogg");
		
		mc.installResource("sound3/crystalgun/shot.ogg", new File(mc.mcDataDir, "resources/torresmon235/crystalgun/shot.ogg"));
        mc.installResource("sound3/crystalgun/craft.ogg", new File(mc.mcDataDir, "resources/torresmon235/crystalgun/craft.ogg"));
		System.out.println("Crystal Gun Resources Installed");
		
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
        MotionCoreID = config.getItem("Motion Core ID", 13365).getInt();
        CoreExtractorID = config.getBlock("Core Extractor ID", 600).getInt();
        CrystalBlockID = config.getBlock("Crystal Block ID", 601).getInt();
        CGSpongeID = config.getBlock("Sponge ID", 602).getInt();
        CGCauldronID = config.getBlock("Metal Pot ID", 603).getInt();
        MagicalConveyorID = config.getBlock("Magical Conveyor ID", 604).getInt();
        MagicalSpringID = config.getBlock("Magical Spring ID", 605).getInt();
        MagicalFilterID = config.getBlock("Magical Filter ID", 606).getInt();
        MagicalSorterID = config.getBlock("Magical Sorter ID", 607).getInt();
        EggDrop = config.get(Configuration.CATEGORY_GENERAL, "Turrets should drop eggs", true).getBoolean(false);

        config.save();
        System.out.println("Crystal Gun Configuration Succesful");
	}

	@Init
	public void init(FMLInitializationEvent event) 
	{
		//Init
		proxy.init();
		
		//GUI
		NetworkRegistry.instance().registerGuiHandler(instance, new CrystalGunGuiHandler());

		//Creative Tab
		LanguageRegistry.instance().addStringLocalization("itemGroup.crystalGunTab", "en_US", "Crystal Gun");
		
		//Entities
		new RegistryEntities();

		//Blocks
		new RegistryBlocks();
		
		//Items
		RegistryItems.RegistryGenericItems();
		RegistryItems.RegistryCrystalGuns();
		
		//Recipes
		new RegistryCraftingRecipes();
		new RegistryExtractorRecipes();
		new RegistryCauldronRecipes();
		
		CrystalGunSorterHandler.addEntity("Creeper", EntityCreeper.class);
		CrystalGunSorterHandler.addEntity("Zombie", EntityZombie.class);
		
		//Render
		proxy.registerRenderThings();
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