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

public class ModelCoreExtractor extends ModelBase
{
  //fields
    public static ModelRenderer Base;
    public static ModelRenderer Crystal1;
    public static ModelRenderer Pillar1;
    public static ModelRenderer Pillar2;
    public static ModelRenderer Pillar3;
    public static ModelRenderer Pillar4;
  
  public ModelCoreExtractor()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(0F, 0F, 0F, 16, 1, 16);
      Base.setRotationPoint(-8F, 23F, -8F);
      Base.setTextureSize(64, 32);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Crystal1 = new ModelRenderer(this, 0, 17);
      Crystal1.addBox(-2F, -2F, -2F, 4, 4, 4);
      Crystal1.setRotationPoint(9.992007E-15F, 14F, 0F);
      Crystal1.setTextureSize(64, 32);
      Crystal1.mirror = true;
      setRotation(Crystal1, 0.9341126F, 1.566149F, 0.6366837F);
      Pillar1 = new ModelRenderer(this, 16, 17);
      Pillar1.addBox(0F, 0F, 0F, 2, 4, 2);
      Pillar1.setRotationPoint(-7F, 19F, 5F);
      Pillar1.setTextureSize(64, 32);
      Pillar1.mirror = true;
      setRotation(Pillar1, 0F, 0F, 0F);
      Pillar2 = new ModelRenderer(this, 16, 17);
      Pillar2.addBox(0F, 0F, 0F, 2, 4, 2);
      Pillar2.setRotationPoint(5F, 19F, 5F);
      Pillar2.setTextureSize(64, 32);
      Pillar2.mirror = true;
      setRotation(Pillar2, 0F, 0F, 0F);
      Pillar3 = new ModelRenderer(this, 16, 17);
      Pillar3.addBox(0F, 0F, 0F, 2, 4, 2);
      Pillar3.setRotationPoint(5F, 19F, -7F);
      Pillar3.setTextureSize(64, 32);
      Pillar3.mirror = true;
      setRotation(Pillar3, 0F, 0F, 0F);
      Pillar4 = new ModelRenderer(this, 16, 17);
      Pillar4.addBox(0F, 0F, 0F, 2, 4, 2);
      Pillar4.setRotationPoint(-7F, 19F, -7F);
      Pillar4.setTextureSize(64, 32);
      Pillar4.mirror = true;
      setRotation(Pillar4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Base.render(f5);
    Crystal1.render(f5);
    Pillar1.render(f5);
    Pillar2.render(f5);
    Pillar3.render(f5);
    Pillar4.render(f5);
  }

  
  public void renderModel(float f5)
  {
	  Base.render(f5);
	  Crystal1.render(f5);
	  Pillar1.render(f5);
	  Pillar2.render(f5);
	  Pillar3.render(f5);
	  Pillar4.render(f5);
  }

  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
