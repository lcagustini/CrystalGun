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

import net.minecraftforge.client.MinecraftForgeClient;
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
import torresmon235.crystalgun.handlers.CrystalGunClientTickHandler;
import torresmon235.crystalgun.models.ModelIronTurret;
import torresmon235.crystalgun.models.ModelStoneTurret;
import torresmon235.crystalgun.models.ModelWoodenTurret;
import torresmon235.crystalgun.render.RenderCauldron;
import torresmon235.crystalgun.render.RenderCoreExtractor;
import torresmon235.crystalgun.render.RenderCrystalGun;
import torresmon235.crystalgun.render.RenderSprite;
import torresmon235.crystalgun.render.RenderTurret;
import torresmon235.crystalgun.tileentities.TileEntityCoreExtractor;
import torresmon235.crystalgun.turrets.TurretIron;
import torresmon235.crystalgun.turrets.TurretStone;
import torresmon235.crystalgun.turrets.TurretWooden;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CrystalGunClientProxy extends CrystalGunCommonProxy
{
	@Override
	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture("/torresmon235/crystalgun/textures/blocks.png");
		MinecraftForgeClient.preloadTexture("/torresmon235/crystalgun/textures/coreextractor.png");

		RenderingRegistry.registerEntityRenderingHandler(EntityFire.class, new RenderSprite(7));
		RenderingRegistry.registerEntityRenderingHandler(ParticleFire.class, new RenderSprite(26));
		RenderingRegistry.registerEntityRenderingHandler(EntityAir.class, new RenderSprite(8));
		RenderingRegistry.registerEntityRenderingHandler(ParticleAir.class, new RenderSprite(26));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrass.class, new RenderSprite(20));
		RenderingRegistry.registerEntityRenderingHandler(ParticleGrass.class, new RenderSprite(26));
		RenderingRegistry.registerEntityRenderingHandler(EntityIce.class, new RenderSprite(9));
		RenderingRegistry.registerEntityRenderingHandler(ParticleIce.class, new RenderSprite(26));
		RenderingRegistry.registerEntityRenderingHandler(EntityLife.class, new RenderSprite(11));
		RenderingRegistry.registerEntityRenderingHandler(ParticleLife.class, new RenderSprite(26));
		RenderingRegistry.registerEntityRenderingHandler(EntityPoison.class, new RenderSprite(23));
		RenderingRegistry.registerEntityRenderingHandler(ParticlePoison.class, new RenderSprite(26));
		RenderingRegistry.registerEntityRenderingHandler(EntitySand.class, new RenderSprite(10));
		RenderingRegistry.registerEntityRenderingHandler(ParticleSand.class, new RenderSprite(26));
		RenderingRegistry.registerEntityRenderingHandler(EntityWater.class, new RenderSprite(6));
		RenderingRegistry.registerEntityRenderingHandler(ParticleWater.class, new RenderSprite(26));
		RenderingRegistry.registerEntityRenderingHandler(EntityHealing.class, new RenderSprite(34));
		RenderingRegistry.registerEntityRenderingHandler(ParticleHealing.class, new RenderSprite(26));
		
		RenderingRegistry.registerEntityRenderingHandler(TurretWooden.class, new RenderTurret(new ModelWoodenTurret(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(TurretStone.class, new RenderTurret(new ModelStoneTurret(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(TurretIron.class, new RenderTurret(new ModelIronTurret(), 0.3F));
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCoreExtractor.class, new RenderCoreExtractor());
		RenderingRegistry.registerBlockHandler(new RenderCauldron());
		
		MinecraftForgeClient.registerItemRenderer(CrystalGunMain.CrystalGun.itemID, new RenderCrystalGun("/torresmon235/crystalgun/textures/crystalguns/crystalgun.png"));
		MinecraftForgeClient.registerItemRenderer(CrystalGunMain.CrystalGunAir.itemID, new RenderCrystalGun("/torresmon235/crystalgun/textures/crystalguns/airgun.png"));
		MinecraftForgeClient.registerItemRenderer(CrystalGunMain.CrystalGunFire.itemID, new RenderCrystalGun("/torresmon235/crystalgun/textures/crystalguns/firegun.png"));
		MinecraftForgeClient.registerItemRenderer(CrystalGunMain.CrystalGunGrass.itemID, new RenderCrystalGun("/torresmon235/crystalgun/textures/crystalguns/grassgun.png"));
		MinecraftForgeClient.registerItemRenderer(CrystalGunMain.CrystalGunHealing.itemID, new RenderCrystalGun("/torresmon235/crystalgun/textures/crystalguns/healinggun.png"));
		MinecraftForgeClient.registerItemRenderer(CrystalGunMain.CrystalGunIce.itemID, new RenderCrystalGun("/torresmon235/crystalgun/textures/crystalguns/icegun.png"));
		MinecraftForgeClient.registerItemRenderer(CrystalGunMain.CrystalGunLife.itemID, new RenderCrystalGun("/torresmon235/crystalgun/textures/crystalguns/lifegun.png"));
		MinecraftForgeClient.registerItemRenderer(CrystalGunMain.CrystalGunPoison.itemID, new RenderCrystalGun("/torresmon235/crystalgun/textures/crystalguns/poisongun.png"));
		MinecraftForgeClient.registerItemRenderer(CrystalGunMain.CrystalGunSand.itemID, new RenderCrystalGun("/torresmon235/crystalgun/textures/crystalguns/sandgun.png"));
		MinecraftForgeClient.registerItemRenderer(CrystalGunMain.CrystalGunWater.itemID, new RenderCrystalGun("/torresmon235/crystalgun/textures/crystalguns/watergun.png"));

		TickRegistry.registerTickHandler(new CrystalGunClientTickHandler(), Side.CLIENT);
	}
}
