package torresmon235.crystalgun.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWoodenTurret extends ModelBase
{
  //fields
    ModelRenderer Head;
    ModelRenderer Base1;
    ModelRenderer Base2;
    ModelRenderer Base3;
    ModelRenderer Base4;
    ModelRenderer Base5;
    ModelRenderer Arm;
  
  public ModelWoodenTurret()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Head = new ModelRenderer(this, 40, 13);
      Head.addBox(-2F, -4F, -2F, 4, 4, 4);
      Head.setRotationPoint(0F, 12F, 0F);
      Head.setTextureSize(128, 64);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Base1 = new ModelRenderer(this, 44, 0);
      Base1.addBox(0F, 0F, 0F, 12, 1, 10);
      Base1.setRotationPoint(-6F, 23F, -5F);
      Base1.setTextureSize(128, 64);
      Base1.mirror = true;
      setRotation(Base1, 0F, 0F, 0F);
      Base2 = new ModelRenderer(this, 0, 0);
      Base2.addBox(0F, 0F, 0F, 10, 1, 12);
      Base2.setRotationPoint(-5F, 23F, -6F);
      Base2.setTextureSize(128, 64);
      Base2.mirror = true;
      setRotation(Base2, 0F, 0F, 0F);
      Base3 = new ModelRenderer(this, 0, 13);
      Base3.addBox(0F, 0F, 0F, 6, 1, 6);
      Base3.setRotationPoint(-3F, 22F, -3F);
      Base3.setTextureSize(128, 64);
      Base3.mirror = true;
      setRotation(Base3, 0F, 0F, 0F);
      Base4 = new ModelRenderer(this, 24, 13);
      Base4.addBox(0F, 0F, 0F, 4, 1, 2);
      Base4.setRotationPoint(-2F, 21F, -1F);
      Base4.setTextureSize(128, 64);
      Base4.mirror = true;
      setRotation(Base4, 0F, 0F, 0F);
      Base5 = new ModelRenderer(this, 24, 16);
      Base5.addBox(0F, 0F, 0F, 2, 1, 4);
      Base5.setRotationPoint(-1F, 21F, -2F);
      Base5.setTextureSize(128, 64);
      Base5.mirror = true;
      setRotation(Base5, 0F, 0F, 0F);
      Arm = new ModelRenderer(this, 36, 13);
      Arm.addBox(0F, 0F, 0F, 1, 9, 1);
      Arm.setRotationPoint(-0.5F, 12F, -0.5F);
      Arm.setTextureSize(128, 64);
      Arm.mirror = true;
      setRotation(Arm, 0F, 0F, 0F);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
	super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
	Head.render(par7);
	Base1.render(par7);
    Base2.render(par7);
    Base3.render(par7);
    Base4.render(par7);
    Base5.render(par7);
    Arm.render(par7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
	  super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
  }
}
