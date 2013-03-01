package torresmon235.crystalgun.registration;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import torresmon235.crystalgun.common.CrystalGunMain;
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
import torresmon235.crystalgun.turrets.TurretIron;
import torresmon235.crystalgun.turrets.TurretStone;
import torresmon235.crystalgun.turrets.TurretWooden;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RegistryEntities
{
	public RegistryEntities()
	{
		EntityRegistry.registerModEntity(EntityFire.class, "Fire", 1, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleFire.class, "ParticleFire", 2, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(EntityAir.class, "Air", 3, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleAir.class, "ParticleAir", 4, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(EntityGrass.class, "Grass", 5, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleGrass.class, "ParticleGrass", 6, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(EntityIce.class, "Ice", 7, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleIce.class, "ParticleIce", 8, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(EntityLife.class, "Life", 9, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleLife.class, "ParticleLife", 10, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(EntityPoison.class, "Poison", 11, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(ParticlePoison.class, "ParticlePoison", 12, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(EntitySand.class, "Sand", 13, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleSand.class, "ParticleSand", 14, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(EntityWater.class, "Water", 15, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleWater.class, "ParticleWater", 16, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(EntityHealing.class, "Healing", 20, CrystalGunMain.instance, 100, 1, true);
		EntityRegistry.registerModEntity(ParticleHealing.class, "ParticleHealing", 21, CrystalGunMain.instance, 100, 1, true);

		EntityRegistry.registerModEntity(TurretWooden.class, "WoodenTurret", 17, CrystalGunMain.instance, 100, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.crystalgun.WoodenTurret.name", "Wooden Turret");
		registerEntityEgg(TurretWooden.class, 0xCC7700, 0xFFED8A);

		EntityRegistry.registerModEntity(TurretStone.class, "StoneTurret", 18, CrystalGunMain.instance, 100, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.crystalgun.StoneTurret.name", "Stone Turret");
		registerEntityEgg(TurretStone.class, 0x999999, 0xFFFFFF);

		EntityRegistry.registerModEntity(TurretIron.class, "IronTurret", 19, CrystalGunMain.instance, 100, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.crystalgun.IronTurret.name", "Iron Turret");
		registerEntityEgg(TurretIron.class, 0xF5F5F5, 0xBFBFBF);
	}
	
	public static int getUniqueEntityId() 
	{
		do 
		{
		   CrystalGunMain.startEntityId++;
		} 
		while (EntityList.getStringFromID(CrystalGunMain.startEntityId) != null);
		
		return CrystalGunMain.startEntityId;
	}
	
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) 
	{
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
}
