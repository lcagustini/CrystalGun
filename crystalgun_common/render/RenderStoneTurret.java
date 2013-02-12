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
package torresmon235.crystalgun.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import torresmon235.crystalgun.models.ModelStoneTurret;
import torresmon235.crystalgun.turrets.TurretStone;

public class RenderStoneTurret extends RenderLiving
{
	protected ModelStoneTurret model;
 
	public RenderStoneTurret (ModelStoneTurret modelTutorial, float f)
	{
		super(modelTutorial, f);
		model = ((ModelStoneTurret)mainModel);
	}
 
	public void renderStoneTurret(TurretStone entity, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
 
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderStoneTurret((TurretStone)par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderStoneTurret((TurretStone)par1Entity, par2, par4, par6, par8, par9);
    }
}