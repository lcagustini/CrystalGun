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
package torresmon235.crystalgun.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelIronTurret extends ModelBase
{
  //fields
    ModelRenderer Base1;
    ModelRenderer Base2;
    ModelRenderer Head;
    ModelRenderer Pedestal1;
    ModelRenderer Pedestal2;
    ModelRenderer Base3;
  
  public ModelIronTurret()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Base1 = new ModelRenderer(this, 0, 13);
      Base1.addBox(0F, 0F, 0F, 10, 1, 14);
      Base1.setRotationPoint(-5F, 23F, -7F);
      Base1.setTextureSize(128, 64);
      Base1.mirror = true;
      setRotation(Base1, 0F, 0F, 0F);
      Base2 = new ModelRenderer(this, 0, 28);
      Base2.addBox(0F, 0F, 0F, 14, 1, 10);
      Base2.setRotationPoint(-7F, 23F, -5F);
      Base2.setTextureSize(128, 64);
      Base2.mirror = true;
      setRotation(Base2, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 52, 0);
      Head.addBox(-2.5F, -5F, -2.5F, 5, 5, 5);
      Head.setRotationPoint(0F, 14F, -1F);
      Head.setTextureSize(128, 64);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Pedestal1 = new ModelRenderer(this, 48, 0);
      Pedestal1.addBox(-0.5F, 0F, 0F, 1, 8, 1);
      Pedestal1.setRotationPoint(0F, 17F, 2.5F);
      Pedestal1.setTextureSize(128, 64);
      Pedestal1.mirror = true;
      setRotation(Pedestal1, -0.7330383F, 0F, 0F);
      Pedestal2 = new ModelRenderer(this, 48, 9);
      Pedestal2.addBox(-0.5F, 0F, 0F, 1, 5, 1);
      Pedestal2.setRotationPoint(0F, 14F, -1.5F);
      Pedestal2.setTextureSize(128, 64);
      Pedestal2.mirror = true;
      setRotation(Pedestal2, 0.7330383F, 0F, 0F);
      Base3 = new ModelRenderer(this, 0, 0);
      Base3.addBox(0F, 0F, 0F, 12, 1, 12);
      Base3.setRotationPoint(-6F, 23F, -6F);
      Base3.setTextureSize(128, 64);
      Base3.mirror = true;
      setRotation(Base3, 0F, 0F, 0F);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
    super.render(par1Entity, par2, par3, par4, par5, par6, par7);
    setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    Base1.render(par7);
    Base2.render(par7);
    Head.render(par7);
    Pedestal1.render(par7);
    Pedestal2.render(par7);
    Base3.render(par7);
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
