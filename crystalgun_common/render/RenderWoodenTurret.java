package torresmon235.crystalgun.render;

import torresmon235.crystalgun.models.ModelWoodenTurret;
import torresmon235.crystalgun.turrets.TurretWooden;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderWoodenTurret extends RenderLiving
{
	protected ModelWoodenTurret model;
 
	public RenderWoodenTurret (ModelWoodenTurret modelTutorial, float f)
	{
		super(modelTutorial, f);
		model = ((ModelWoodenTurret)mainModel);
	}
 
	public void renderWoodenTurret(TurretWooden entity, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
 
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderWoodenTurret((TurretWooden)par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderWoodenTurret((TurretWooden)par1Entity, par2, par4, par6, par8, par9);
    }
}