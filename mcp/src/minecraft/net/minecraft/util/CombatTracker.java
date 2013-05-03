package net.minecraft.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class CombatTracker
{
    private final List field_94556_a = new ArrayList();
    private final EntityLiving field_94554_b;
    private int field_94555_c = 0;
    private boolean field_94552_d = false;
    private boolean field_94553_e = false;
    private String field_94551_f;

    public CombatTracker(EntityLiving par1EntityLiving)
    {
        this.field_94554_b = par1EntityLiving;
    }

    public void func_94545_a()
    {
        this.func_94542_g();

        if (this.field_94554_b.isOnLadder())
        {
            int i = this.field_94554_b.worldObj.getBlockId(MathHelper.floor_double(this.field_94554_b.posX), MathHelper.floor_double(this.field_94554_b.boundingBox.minY), MathHelper.floor_double(this.field_94554_b.posZ));

            if (i == Block.ladder.blockID)
            {
                this.field_94551_f = "ladder";
            }
            else if (i == Block.vine.blockID)
            {
                this.field_94551_f = "vines";
            }
        }
        else if (this.field_94554_b.isInWater())
        {
            this.field_94551_f = "water";
        }
    }

    public void func_94547_a(DamageSource par1DamageSource, int par2, int par3)
    {
        this.func_94549_h();
        this.func_94545_a();
        CombatEntry combatentry = new CombatEntry(par1DamageSource, this.field_94554_b.ticksExisted, par2, par3, this.field_94551_f, this.field_94554_b.fallDistance);
        this.field_94556_a.add(combatentry);
        this.field_94555_c = this.field_94554_b.ticksExisted;
        this.field_94553_e = true;
        this.field_94552_d |= combatentry.func_94559_f();
    }

    public String func_94546_b()
    {
        if (this.field_94556_a.size() == 0)
        {
            return this.field_94554_b.func_96090_ax() + " died";
        }
        else
        {
            CombatEntry combatentry = this.func_94544_f();
            CombatEntry combatentry1 = (CombatEntry)this.field_94556_a.get(this.field_94556_a.size() - 1);
            String s = "";
            String s1 = combatentry1.func_94558_h();
            Entity entity = combatentry1.func_94560_a().getEntity();

            if (combatentry != null && combatentry1.func_94560_a() == DamageSource.fall)
            {
                String s2 = combatentry.func_94558_h();

                if (combatentry.func_94560_a() != DamageSource.fall && combatentry.func_94560_a() != DamageSource.outOfWorld)
                {
                    if (s2 != null && (s1 == null || !s2.equals(s1)))
                    {
                        Entity entity1 = combatentry.func_94560_a().getEntity();
                        ItemStack itemstack = entity1 instanceof EntityLiving ? ((EntityLiving)entity1).getHeldItem() : null;

                        if (itemstack != null && itemstack.hasDisplayName())
                        {
                            s = StatCollector.translateToLocalFormatted("death.fell.assist.item", new Object[] {this.field_94554_b.func_96090_ax(), s1, itemstack.getDisplayName()});
                        }
                        else
                        {
                            s = StatCollector.translateToLocalFormatted("death.fell.assist", new Object[] {this.field_94554_b.func_96090_ax(), s2});
                        }
                    }
                    else if (s1 != null)
                    {
                        ItemStack itemstack1 = entity instanceof EntityLiving ? ((EntityLiving)entity).getHeldItem() : null;

                        if (itemstack1 != null && itemstack1.hasDisplayName())
                        {
                            s = StatCollector.translateToLocalFormatted("death.fell.finish.item", new Object[] {this.field_94554_b.func_96090_ax(), s1, itemstack1.getDisplayName()});
                        }
                        else
                        {
                            s = StatCollector.translateToLocalFormatted("death.fell.finish", new Object[] {this.field_94554_b.func_96090_ax(), s1});
                        }
                    }
                    else
                    {
                        s = StatCollector.translateToLocalFormatted("death.fell.killer", new Object[] {this.field_94554_b.func_96090_ax()});
                    }
                }
                else
                {
                    s = StatCollector.translateToLocalFormatted("death.fell.accident." + this.func_94548_b(combatentry), new Object[] {this.field_94554_b.func_96090_ax()});
                }
            }
            else
            {
                s = combatentry1.func_94560_a().getDeathMessage(this.field_94554_b);
            }

            return s;
        }
    }

    public EntityLiving func_94550_c()
    {
        EntityLiving entityliving = null;
        EntityPlayer entityplayer = null;
        int i = 0;
        int j = 0;
        Iterator iterator = this.field_94556_a.iterator();

        while (iterator.hasNext())
        {
            CombatEntry combatentry = (CombatEntry)iterator.next();

            if (combatentry.func_94560_a().getEntity() instanceof EntityPlayer && (entityplayer == null || combatentry.func_94563_c() > j))
            {
                j = combatentry.func_94563_c();
                entityplayer = (EntityPlayer)combatentry.func_94560_a().getEntity();
            }

            if (combatentry.func_94560_a().getEntity() instanceof EntityLiving && (entityliving == null || combatentry.func_94563_c() > i))
            {
                i = combatentry.func_94563_c();
                entityliving = (EntityLiving)combatentry.func_94560_a().getEntity();
            }
        }

        if (entityplayer != null && j >= i / 3)
        {
            return entityplayer;
        }
        else
        {
            return entityliving;
        }
    }

    private CombatEntry func_94544_f()
    {
        CombatEntry combatentry = null;
        CombatEntry combatentry1 = null;
        byte b0 = 0;
        float f = 0.0F;

        for (int i = 0; i < this.field_94556_a.size(); ++i)
        {
            CombatEntry combatentry2 = (CombatEntry)this.field_94556_a.get(i);
            CombatEntry combatentry3 = i > 0 ? (CombatEntry)this.field_94556_a.get(i - 1) : null;

            if ((combatentry2.func_94560_a() == DamageSource.fall || combatentry2.func_94560_a() == DamageSource.outOfWorld) && combatentry2.func_94561_i() > 0.0F && (combatentry == null || combatentry2.func_94561_i() > f))
            {
                if (i > 0)
                {
                    combatentry = combatentry3;
                }
                else
                {
                    combatentry = combatentry2;
                }

                f = combatentry2.func_94561_i();
            }

            if (combatentry2.func_94562_g() != null && (combatentry1 == null || combatentry2.func_94563_c() > b0))
            {
                combatentry1 = combatentry2;
            }
        }

        if (f > 5.0F && combatentry != null)
        {
            return combatentry;
        }
        else if (b0 > 5 && combatentry1 != null)
        {
            return combatentry1;
        }
        else
        {
            return null;
        }
    }

    private String func_94548_b(CombatEntry par1CombatEntry)
    {
        return par1CombatEntry.func_94562_g() == null ? "generic" : par1CombatEntry.func_94562_g();
    }

    private void func_94542_g()
    {
        this.field_94551_f = null;
    }

    private void func_94549_h()
    {
        int i = this.field_94552_d ? 300 : 100;

        if (this.field_94553_e && this.field_94554_b.ticksExisted - this.field_94555_c > i)
        {
            this.field_94556_a.clear();
            this.field_94553_e = false;
            this.field_94552_d = false;
        }
    }
}
