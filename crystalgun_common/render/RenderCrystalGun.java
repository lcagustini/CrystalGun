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

import org.lwjgl.opengl.GL11;

import torresmon235.crystalgun.models.ModelCrystalGun;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;

public class RenderCrystalGun implements IItemRenderer 
{
	protected ModelCrystalGun model;
	private String texture;
	
	public RenderCrystalGun(String texture)
	{
		model = new ModelCrystalGun();
		this.texture = texture;
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	{
		switch(type)
		{
		case EQUIPPED:return true; 
		default:return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) 
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
	{
		switch(type)
		{
		case EQUIPPED:
		{
			GL11.glPushMatrix();
			ForgeHooksClient.bindTexture(texture, 0);
			GL11.glRotatef(-84F, 1, 0, 0);
			GL11.glRotatef(57F, 0, 1, 0);
			GL11.glRotatef(-94F, 0, 0, 1);
			GL11.glTranslatef(-0.25F, 0.067F, 0.379F);
			model.render((Entity)data[1], 0, 0, 0, 0, 0, 0.0625F);
			ForgeHooksClient.unbindTexture();
			GL11.glPopMatrix();
		}
		default:break;
		}
	}
}
