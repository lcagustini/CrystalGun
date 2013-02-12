package torresmon235.crystalgun.common;

import net.minecraftforge.client.MinecraftForgeClient;
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
import torresmon235.crystalgun.handlers.CrystalGunClientTickHandler;
import torresmon235.crystalgun.models.ModelStoneTurret;
import torresmon235.crystalgun.models.ModelWoodenTurret;
import torresmon235.crystalgun.render.RenderCoreExtractor;
import torresmon235.crystalgun.render.RenderSprite;
import torresmon235.crystalgun.render.RenderStoneTurret;
import torresmon235.crystalgun.render.RenderWoodenTurret;
import torresmon235.crystalgun.tileentities.TileEntityCoreExtractor;
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
		
		RenderingRegistry.registerEntityRenderingHandler(TurretWooden.class, new RenderWoodenTurret(new ModelWoodenTurret(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(TurretStone.class, new RenderStoneTurret(new ModelStoneTurret(), 0.3F));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCoreExtractor.class, new RenderCoreExtractor());
		
		TickRegistry.registerTickHandler(new CrystalGunClientTickHandler(), Side.CLIENT);
	}
}
