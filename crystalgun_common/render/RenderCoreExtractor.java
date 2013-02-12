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

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import torresmon235.crystalgun.models.ModelCoreExtractor;
import torresmon235.crystalgun.tileentities.TileEntityCoreExtractor;

public class RenderCoreExtractor extends TileEntitySpecialRenderer 
{
	public RenderCoreExtractor() 
	{
		model = new ModelCoreExtractor();
	}

	public void renderAModelAt(TileEntityCoreExtractor var1, double d, double d1, double d2, float f) 
	{
		bindTextureByName("/torresmon235/crystalgun/textures/coreextractor.png"); //texture
		GL11.glPushMatrix(); //start
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F); //size
		GL11.glScalef(1.0F, -1F, -1F); //if you read this comment out this line and you can see what happens
		model.renderModel(0.0625F); //renders and yes 0.0625 is a random number
		GL11.glPopMatrix(); //end
	}

	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) 
	{
		renderAModelAt((TileEntityCoreExtractor) var1, var2, var4, var6, var8); //where to render
	}

	private ModelCoreExtractor model;
}