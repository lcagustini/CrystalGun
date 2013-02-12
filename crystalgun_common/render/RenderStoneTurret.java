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