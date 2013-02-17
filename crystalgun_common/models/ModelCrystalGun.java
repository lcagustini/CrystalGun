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

public class ModelCrystalGun extends ModelBase
{
  //fields
    public ModelRenderer Barrel1;
    public ModelRenderer Edge1;
    public ModelRenderer Edge2;
    public ModelRenderer Edge3;
    public ModelRenderer Edge4;
    public ModelRenderer Edge5;
    public ModelRenderer Edge6;
    public ModelRenderer Edge7;
    public ModelRenderer Edge8;
    public ModelRenderer Back1;
    public ModelRenderer Back2;
    public ModelRenderer Back3;
    public ModelRenderer Back4;
    public ModelRenderer Barrel2;
    public ModelRenderer Edge9;
    public ModelRenderer Edge10;
    public ModelRenderer Edge11;
    public ModelRenderer Edge12;
    public ModelRenderer Charge;
  
  public ModelCrystalGun()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Barrel1 = new ModelRenderer(this, 0, 0);
      Barrel1.addBox(0F, 0F, 0F, 6, 6, 7);
      Barrel1.setRotationPoint(0F, -1F, 0F);
      Barrel1.setTextureSize(64, 32);
      Barrel1.mirror = true;
      setRotation(Barrel1, 0F, 0F, 0F);
      Edge1 = new ModelRenderer(this, 26, 0);
      Edge1.addBox(0F, 0F, 0F, 6, 1, 1);
      Edge1.setRotationPoint(0F, -2F, 0F);
      Edge1.setTextureSize(64, 32);
      Edge1.mirror = true;
      setRotation(Edge1, 0F, 0F, 0F);
      Edge2 = new ModelRenderer(this, 26, 2);
      Edge2.addBox(0F, 0F, 0F, 1, 6, 1);
      Edge2.setRotationPoint(-1F, -1F, 0F);
      Edge2.setTextureSize(64, 32);
      Edge2.mirror = true;
      setRotation(Edge2, 0F, 0F, 0F);
      Edge3 = new ModelRenderer(this, 26, 0);
      Edge3.addBox(0F, 0F, 0F, 6, 1, 1);
      Edge3.setRotationPoint(0F, 5F, 0F);
      Edge3.setTextureSize(64, 32);
      Edge3.mirror = true;
      setRotation(Edge3, 0F, 0F, 0F);
      Edge4 = new ModelRenderer(this, 26, 2);
      Edge4.addBox(0F, 0F, 0F, 1, 6, 1);
      Edge4.setRotationPoint(6F, -1F, 0F);
      Edge4.setTextureSize(64, 32);
      Edge4.mirror = true;
      setRotation(Edge4, 0F, 0F, 0F);
      Edge5 = new ModelRenderer(this, 50, 2);
      Edge5.addBox(0F, 0F, 0F, 1, 2, 1);
      Edge5.setRotationPoint(1F, 1F, 13F);
      Edge5.setTextureSize(64, 32);
      Edge5.mirror = true;
      setRotation(Edge5, 0F, 0F, 0F);
      Edge6 = new ModelRenderer(this, 50, 0);
      Edge6.addBox(0F, 0F, 0F, 2, 1, 1);
      Edge6.setRotationPoint(2F, 0F, 13F);
      Edge6.setTextureSize(64, 32);
      Edge6.mirror = true;
      setRotation(Edge6, 0F, 0F, 0F);
      Edge7 = new ModelRenderer(this, 50, 2);
      Edge7.addBox(0F, 0F, 0F, 1, 2, 1);
      Edge7.setRotationPoint(4F, 1F, 13F);
      Edge7.setTextureSize(64, 32);
      Edge7.mirror = true;
      setRotation(Edge7, 0F, 0F, 0F);
      Edge8 = new ModelRenderer(this, 50, 0);
      Edge8.addBox(0F, 0F, 0F, 2, 1, 1);
      Edge8.setRotationPoint(2F, 3F, 13F);
      Edge8.setTextureSize(64, 32);
      Edge8.mirror = true;
      setRotation(Edge8, 0F, 0F, 0F);
      Back1 = new ModelRenderer(this, 40, 2);
      Back1.addBox(0F, 0F, 0F, 1, 4, 1);
      Back1.setRotationPoint(5F, 0F, -1F);
      Back1.setTextureSize(64, 32);
      Back1.mirror = true;
      setRotation(Back1, 0F, 0F, 0F);
      Back2 = new ModelRenderer(this, 40, 0);
      Back2.addBox(0F, 0F, 0F, 4, 1, 1);
      Back2.setRotationPoint(1F, -1F, -1F);
      Back2.setTextureSize(64, 32);
      Back2.mirror = true;
      setRotation(Back2, 0F, 0F, 0F);
      Back3 = new ModelRenderer(this, 40, 0);
      Back3.addBox(0F, 0F, 0F, 4, 1, 1);
      Back3.setRotationPoint(1F, 4F, -1F);
      Back3.setTextureSize(64, 32);
      Back3.mirror = true;
      setRotation(Back3, 0F, 0F, 0F);
      Back4 = new ModelRenderer(this, 40, 2);
      Back4.addBox(0F, 0F, 0F, 1, 4, 1);
      Back4.setRotationPoint(0F, 0F, -1F);
      Back4.setTextureSize(64, 32);
      Back4.mirror = true;
      setRotation(Back4, 0F, 0F, 0F);
      Barrel2 = new ModelRenderer(this, 0, 13);
      Barrel2.addBox(0F, 0F, 0F, 4, 4, 6);
      Barrel2.setRotationPoint(1F, 0F, 7F);
      Barrel2.setTextureSize(64, 32);
      Barrel2.mirror = true;
      setRotation(Barrel2, 0F, 0F, 0F);
      Edge9 = new ModelRenderer(this, 40, 2);
      Edge9.addBox(0F, 0F, 0F, 1, 4, 1);
      Edge9.setRotationPoint(5F, 0F, 7F);
      Edge9.setTextureSize(64, 32);
      Edge9.mirror = true;
      setRotation(Edge9, 0F, 0F, 0F);
      Edge10 = new ModelRenderer(this, 40, 0);
      Edge10.addBox(0F, 0F, 0F, 4, 1, 1);
      Edge10.setRotationPoint(1F, -1F, 7F);
      Edge10.setTextureSize(64, 32);
      Edge10.mirror = true;
      setRotation(Edge10, 0F, 0F, 0F);
      Edge11 = new ModelRenderer(this, 40, 0);
      Edge11.addBox(0F, 0F, 0F, 4, 1, 1);
      Edge11.setRotationPoint(1F, 4F, 7F);
      Edge11.setTextureSize(64, 32);
      Edge11.mirror = true;
      setRotation(Edge11, 0F, 0F, 0F);
      Edge12 = new ModelRenderer(this, 40, 2);
      Edge12.addBox(0F, 0F, 0F, 1, 4, 1);
      Edge12.setRotationPoint(0F, 0F, 7F);
      Edge12.setTextureSize(64, 32);
      Edge12.mirror = true;
      setRotation(Edge12, 0F, 0F, 0F);
      Charge = new ModelRenderer(this, 20, 13);
      Charge.addBox(0F, 0F, 0F, 2, 1, 3);
      Charge.setRotationPoint(2F, -2F, 2F);
      Charge.setTextureSize(64, 32);
      Charge.mirror = true;
      setRotation(Charge, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Barrel1.render(f5);
    Edge1.render(f5);
    Edge2.render(f5);
    Edge3.render(f5);
    Edge4.render(f5);
    Edge5.render(f5);
    Edge6.render(f5);
    Edge7.render(f5);
    Edge8.render(f5);
    Back1.render(f5);
    Back2.render(f5);
    Back3.render(f5);
    Back4.render(f5);
    Barrel2.render(f5);
    Edge9.render(f5);
    Edge10.render(f5);
    Edge11.render(f5);
    Edge12.render(f5);
    Charge.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
