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

import torresmon235.crystalgun.common.CrystalGunMain;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TurretStone extends TurretParent implements IRangedAttackMob
{
    private EntityAIArrowAttack field_85037_d = new EntityAIArrowAttack(this, 0F, 6, 24.0F);
	
	public TurretStone(World world)
	{
		super(world);
		this.texture = "/torresmon235/crystalgun/textures/turrets/stone.png";
        this.tasks.addTask(2, new EntityAIWatchClosest2(this, EntityMob.class, 24.0F, 0.02F));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityMob.class, 24.0F, 0, false));
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
	
	public boolean isAIEnabled()
    {
        return true;
    }

	public int getMaxHealth() 
	{
		return 14;
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
			EntityArrow var2 = new EntityArrow(this.worldObj, this, par1EntityLiving, 1.789F, 9F);
			this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
			this.worldObj.spawnEntityInWorld(var2);
		}
	}
	
	public EntityItem dropItem(int i, int j)
    {
            return dropItemWithOffset(i, j, 0.0F);
    }

    public EntityItem dropItemWithOffset(int i, int j, float f)
    {
            int k = 302;
            return entityDropItem(new ItemStack(i, j, k), f);
    }
	
	public String getTexture()
    {
		return "/torresmon235/crystalgun/textures/turrets/stone.png";
    }
}
