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
package torresmon235.crystalgun.handlers;

import net.minecraft.client.Minecraft;
import torresmon235.crystalgun.common.CrystalGunMain;
import torresmon235.crystalgun.entities.ParticleAir;
import torresmon235.crystalgun.entities.ParticleFire;
import torresmon235.crystalgun.entities.ParticleGrass;
import torresmon235.crystalgun.entities.ParticleHealing;
import torresmon235.crystalgun.entities.ParticleIce;
import torresmon235.crystalgun.entities.ParticleLife;
import torresmon235.crystalgun.entities.ParticlePoison;
import torresmon235.crystalgun.entities.ParticleSand;
import torresmon235.crystalgun.entities.ParticleWater;

public class CrystalGunParticleHandler 
{
	public static void spawnParticle(String string, double x, double y, double z, double mx, double my, double mz, int red, int green, int blue)
	{
		if(string == "Air")
		{
			CrystalGunMain.mc.effectRenderer.addEffect(new ParticleAir(Minecraft.getMinecraft().theWorld, x, y, z, mx, my, mz, red, green, blue));
		}
		if(string == "Fire")
		{
			CrystalGunMain.mc.effectRenderer.addEffect(new ParticleFire(Minecraft.getMinecraft().theWorld, x, y, z, mx, my, mz, red, green, blue));
		}
		if(string == "Grass")
		{
			CrystalGunMain.mc.effectRenderer.addEffect(new ParticleGrass(Minecraft.getMinecraft().theWorld, x, y, z, mx, my, mz, red, green, blue));
		}
		if(string == "Ice")
		{
			CrystalGunMain.mc.effectRenderer.addEffect(new ParticleIce(Minecraft.getMinecraft().theWorld, x, y, z, mx, my, mz, red, green, blue));
		}
		if(string == "Life")
		{
			CrystalGunMain.mc.effectRenderer.addEffect(new ParticleLife(Minecraft.getMinecraft().theWorld, x, y, z, mx, my, mz, red, green, blue));
		}
		if(string == "Poison")
		{
			CrystalGunMain.mc.effectRenderer.addEffect(new ParticlePoison(Minecraft.getMinecraft().theWorld, x, y, z, mx, my, mz, red, green, blue));
		}
		if(string == "Sand")
		{
			CrystalGunMain.mc.effectRenderer.addEffect(new ParticleSand(Minecraft.getMinecraft().theWorld, x, y, z, mx, my, mz, red, green, blue));
		}
		if(string == "Water")
		{
			CrystalGunMain.mc.effectRenderer.addEffect(new ParticleWater(Minecraft.getMinecraft().theWorld, x, y, z, mx, my, mz, red, green, blue));
		}
		if(string == "Healing")
		{
			CrystalGunMain.mc.effectRenderer.addEffect(new ParticleHealing(Minecraft.getMinecraft().theWorld, x, y, z, mx, my, mz, red, green, blue));
		}
	}
}
