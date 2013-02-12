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