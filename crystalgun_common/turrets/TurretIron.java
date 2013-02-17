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
package torresmon235.crystalgun.turrets;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import torresmon235.crystalgun.common.CrystalGunMain;
import torresmon235.crystalgun.guis.GuiTurretIron;
import torresmon235.crystalgun.library.GuiID;

public class TurretIron extends TurretParent implements IRangedAttackMob
{	
    private EntityAIArrowAttack field_85037_d = new EntityAIArrowAttack(this, 0F, 4, 32.0F);
    private EntityPlayer owner;
	
	public TurretIron(World world)
	{
		super(world);
		this.texture = "/torresmon235/crystalgun/textures/turrets/iron.png";
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
	}
	
	protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(13, new Byte((byte)0));
    }
	
	public void initCreature()
    {
		this.tasks.addTask(4, this.field_85037_d);
        this.func_82164_bB();
        this.func_82162_bC();
    }
	
	public void func_85036_m()
    {
        this.tasks.func_85156_a(this.field_85037_d);
        this.tasks.addTask(4, this.field_85037_d);
    }
	
	public void setTargetAndOwner(Class target, EntityPlayer entityplayer)
	{
		this.owner = entityplayer;
        this.tasks.addTask(2, new EntityAIWatchClosest2(this, target, 32.0F, 0.02F));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, target, 32.0F, 0, false));
        this.updateAITasks();
	}
	
	public boolean isAIEnabled()
    {
        return true;
    }

	public int getMaxHealth() 
	{
		return 20;
	}
	
	protected int decreaseAirSupply(int par1)
    {
        return par1;
    }
	
	protected void dropFewItems(boolean par1, int par2)
    {
		if(CrystalGunMain.EggDrop)
		{
			dropItem(Item.monsterPlacer.itemID, 1);
		}
    }

	public void attackEntityWithRangedAttack(EntityLiving par1EntityLiving)
    {
		if(par1EntityLiving.canEntityBeSeen(this))
		{
			EntityArrow var2 = new EntityArrow(this.worldObj, this, par1EntityLiving, 2.0075F, 9F);
			this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
			this.worldObj.spawnEntityInWorld(var2);
		}
	}
	
	public boolean interact(EntityPlayer entityplayer)
    {
		if(!entityplayer.worldObj.isRemote && (owner == null || owner.username == entityplayer.username))
		{
			GuiTurretIron.world = entityplayer.worldObj;
			GuiTurretIron.x = this.posX;
			GuiTurretIron.y = this.posY;
			GuiTurretIron.z = this.posZ;
			GuiTurretIron.owner = entityplayer;
			entityplayer.openGui(CrystalGunMain.instance, GuiID.TurretIron, this.worldObj, (int)Math.round(this.posX), (int)Math.round(this.posY), (int)Math.round(this.posZ));
			this.setDead();
		}
		return true;
    }
	
	public EntityItem dropItem(int i, int j)
    {
            return dropItemWithOffset(i, j, 0.0F);
    }

    public EntityItem dropItemWithOffset(int i, int j, float f)
    {
            int k = 303;
            return entityDropItem(new ItemStack(i, j, k), f);
    }
	
	public String getTexture()
    {
		return "/torresmon235/crystalgun/textures/turrets/iron.png";
    }
}
