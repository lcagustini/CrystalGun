package torresmon235.crystalgun.entities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ParticleLife extends EntityFX
{
	private Tessellator tessellator1 = Tessellator.instance;
	
	public static int red;
	public static int green;
	public static int blue;
	
	public ParticleLife(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, int redColor, int greenColor, int blueColor)
	{
		super(par1World, par2, par4, par6, par8, par10, par12);
		red = redColor;
		green = greenColor;
		blue = blueColor;
		this.particleMaxAge = 24;
		this.setParticleTextureIndex(26);
	}
	@Override
	public int getFXLayer()
	{
		return 1;
	}
	
	public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
	{
		tessellator1.draw();
		tessellator1.startDrawingQuads();
		tessellator1.setBrightness(getBrightnessForRender(par2));
		Minecraft mc = FMLClientHandler.instance().getClient();
		int tex = mc.renderEngine.getTexture("/torresmon235/crystalgun/textures/items.png");
		mc.renderEngine.bindTexture(tex);
		float f = (float)(getParticleTextureIndex() % 16) / 16F;
		float f1 = f + 0.0624375F;
		float f2 = (float)(getParticleTextureIndex() / 16) / 16F;
		float f3 = f2 + 0.0624375F;
		float f4 = 0.1F * particleScale;
		float f5 = (float)((prevPosX + (posX - prevPosX) * (double)par2) - interpPosX);
		float f6 = (float)((prevPosY + (posY - prevPosY) * (double)par2) - interpPosY);
		float f7 = (float)((prevPosZ + (posZ - prevPosZ) * (double)par2) - interpPosZ);
		tessellator1.setColorOpaque(red, green, blue);
		tessellator1.addVertexWithUV(f5 - par3 * f4 - par6 * f4, f6 - par4 * f4, f7 - par5 * f4 - par7 * f4, f1, f3);
		tessellator1.addVertexWithUV((f5 - par3 * f4) + par6 * f4, f6 + par4 * f4, (f7 - par5 * f4) + par7 * f4, f1, f2);
		tessellator1.addVertexWithUV(f5 + par3 * f4 + par6 * f4, f6 + par4 * f4, f7 + par5 * f4 + par7 * f4, f, f2);
		tessellator1.addVertexWithUV((f5 + par3 * f4) - par6 * f4, f6 - par4 * f4, (f7 + par5 * f4) - par7 * f4, f, f3);
		super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
	}
	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if (this.particleAge++ >= this.particleMaxAge)
		{
			this.setDead();
		}
		
		if(this.particleAge == 8) this.setParticleTextureIndex(27);
		if(this.particleAge == 17) this.setParticleTextureIndex(28);
		
		this.motionY += 0.004D;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		
		if (this.posY == this.prevPosY)
		{
			this.motionX *= 1.1D;
			this.motionZ *= 1.1D;
		}
		
		this.motionX *= 0.9599999785423279D;
		this.motionY *= 0.9599999785423279D;
		this.motionZ *= 0.9599999785423279D;

		if (this.onGround)
		{
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
		}
	}
}