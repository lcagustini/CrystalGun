package torresmon235.crystalgun.render;

import org.lwjgl.opengl.GL11;

import torresmon235.crystalgun.library.RenderID;
import torresmon235.crystalgun.models.ModelCoreExtractor;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.ForgeHooksClient;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderTest implements ISimpleBlockRenderingHandler
{
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
    	   
    }

    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
    	ModelCoreExtractor model = new ModelCoreExtractor();
		GL11.glPushMatrix(); //start
    	ForgeHooksClient.bindTexture("/torresmon235/crystalgun/textures/coreextractor.png", 1); //texture
		//GL11.glTranslatef((float)renderer. + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F); //size
		GL11.glScalef(1.0F, -1F, -1F); //if you read this comment out this line and you can see what happens
		model.renderModel(0.0625F); //renders and yes 0.0625 is a random number
		ForgeHooksClient.unbindTexture();
		GL11.glPopMatrix();  
        return true;
    }

    public boolean shouldRender3DInInventory()
    {
         // This is where it asks if you want the renderInventory part called or not.
         return false; // Change to 'true' if you want the Inventory render to be called.
    }

    public int getRenderId()
    {
         // This is one place we need that renderId from earlier.
         return RenderID.CoreExtractor;
    }
}