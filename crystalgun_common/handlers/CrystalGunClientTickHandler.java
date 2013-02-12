package torresmon235.crystalgun.handlers;

import java.util.EnumSet;

import torresmon235.crystalgun.models.ModelCoreExtractor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class CrystalGunClientTickHandler implements ITickHandler
{
    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {}

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData)
    {
        if (type.equals(EnumSet.of(TickType.RENDER)))
        {
            onRenderTick();
        }
        else if (type.equals(EnumSet.of(TickType.CLIENT)))
        {
            GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
            if (guiscreen != null)
            {
                onTickInGUI(guiscreen);
            } else {
                onTickInGame();
            }
        }
    }

    @Override
    public EnumSet<TickType> ticks()
    {
        return EnumSet.of(TickType.RENDER, TickType.CLIENT);
        // In my testing only RENDER, CLIENT, & PLAYER did anything on the client side.
        // Read 'cpw.mods.fml.common.TickType.java' for a full list and description of available types
    }

    @Override
    public String getLabel() { return null; }
    
    public ModelCoreExtractor model = new ModelCoreExtractor();

    public void onRenderTick()
    {
        model.Crystal1.rotateAngleX += 0.001F;
        model.Crystal1.rotateAngleY += 0.025F;
        model.Crystal1.rotateAngleZ += 0.012F;
    }

    public void onTickInGUI(GuiScreen guiscreen)
    {
        //System.out.println("onTickInGUI");
        //TODO: Your Code Here
    }

    public void onTickInGame()
    {
        //System.out.println("onTickInGame");
        //TODO: Your Code Here
    }
}