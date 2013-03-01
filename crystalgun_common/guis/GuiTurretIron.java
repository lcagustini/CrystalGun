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
package torresmon235.crystalgun.guis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import torresmon235.crystalgun.common.CrystalGunMain;
import torresmon235.crystalgun.turrets.TurretIron;

public class GuiTurretIron extends GuiScreen
{
	public final int xSizeOfTexture = 176;
	public final int ySizeOfTexture = 88;
	
	public static World world;
	public static double x;
	public static double y;
	public static double z;
	public static EntityPlayer owner;
	
	public GuiTurretIron(EntityPlayer player)
	{
		
	}
	
	@Override
	public void drawScreen(int x, int y, float f)
	{
		drawDefaultBackground();
		
		int var4 = this.mc.renderEngine.getTexture("/torresmon235/crystalgun/textures/irongui.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(var4);
		
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
		
		super.drawScreen(x, y, f);
	}
	
	public void initGui()
	{
		this.controlList.clear();
		
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		this.controlList.add(new GuiButton(0, posX+ 40, posY + 9, 100, 20, "All Mobs"));
		this.controlList.add(new GuiButton(1, posX+ 40, posY + 34, 100, 20, "Passive Only"));
		this.controlList.add(new GuiButton(2, posX+ 40, posY + 59, 100, 20, "Hostile Only"));
	}
	
	public void actionPerformed(GuiButton button)
	{
		Class target;
		if(button.displayString == "All Mobs")
		{
			target = EntityLiving.class;
		}
		else if(button.displayString == "Passive Only")
		{
			target = EntityAnimal.class;
		}
		else
		{
			target = EntityMob.class;
		}
		TurretIron turret = new TurretIron(world);
		turret.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(Minecraft.getMinecraft().theWorld.rand.nextFloat() * 360.0F), 0.0F);
		turret.rotationYawHead = turret.rotationYaw;
        turret.renderYawOffset = turret.rotationYaw;
		turret.initCreature();
		turret.setTargetAndOwner(target, owner);
		world.spawnEntityInWorld(turret);
		this.mc.thePlayer.closeScreen();
	}
	
	@Override
	protected void keyTyped(char par1, int par2)
	{
		super.keyTyped(par1, par2);
		TurretIron turret = new TurretIron(world);
		turret.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(Minecraft.getMinecraft().theWorld.rand.nextFloat() * 360.0F), 0.0F);
		turret.rotationYawHead = turret.rotationYaw;
        turret.renderYawOffset = turret.rotationYaw;
		turret.initCreature();
		turret.setTargetAndOwner(EntityMob.class, owner);
		world.spawnEntityInWorld(turret);
	}
}
