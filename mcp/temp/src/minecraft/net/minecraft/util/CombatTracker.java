package net.minecraft.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.CombatEntry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;

public class CombatTracker {

   private final List field_94556_a = new ArrayList();
   private final EntityLiving field_94554_b;
   private int field_94555_c = 0;
   private boolean field_94552_d = false;
   private boolean field_94553_e = false;
   private String field_94551_f;


   public CombatTracker(EntityLiving p_i9020_1_) {
      this.field_94554_b = p_i9020_1_;
   }

   public void func_94545_a() {
      this.func_94542_g();
      if(this.field_94554_b.func_70617_f_()) {
         int var1 = this.field_94554_b.field_70170_p.func_72798_a(MathHelper.func_76128_c(this.field_94554_b.field_70165_t), MathHelper.func_76128_c(this.field_94554_b.field_70121_D.field_72338_b), MathHelper.func_76128_c(this.field_94554_b.field_70161_v));
         if(var1 == Block.field_72055_aF.field_71990_ca) {
            this.field_94551_f = "ladder";
         } else if(var1 == Block.field_71998_bu.field_71990_ca) {
            this.field_94551_f = "vines";
         }
      } else if(this.field_94554_b.func_70090_H()) {
         this.field_94551_f = "water";
      }

   }

   public void func_94547_a(DamageSource p_94547_1_, int p_94547_2_, int p_94547_3_) {
      this.func_94549_h();
      this.func_94545_a();
      CombatEntry var4 = new CombatEntry(p_94547_1_, this.field_94554_b.field_70173_aa, p_94547_2_, p_94547_3_, this.field_94551_f, this.field_94554_b.field_70143_R);
      this.field_94556_a.add(var4);
      this.field_94555_c = this.field_94554_b.field_70173_aa;
      this.field_94553_e = true;
      this.field_94552_d |= var4.func_94559_f();
   }

   public String func_94546_b() {
      if(this.field_94556_a.size() == 0) {
         return this.field_94554_b.func_96090_ax() + " died";
      } else {
         CombatEntry var1 = this.func_94544_f();
         CombatEntry var2 = (CombatEntry)this.field_94556_a.get(this.field_94556_a.size() - 1);
         String var3 = "";
         String var4 = var2.func_94558_h();
         Entity var5 = var2.func_94560_a().func_76346_g();
         if(var1 != null && var2.func_94560_a() == DamageSource.field_76379_h) {
            String var6 = var1.func_94558_h();
            if(var1.func_94560_a() != DamageSource.field_76379_h && var1.func_94560_a() != DamageSource.field_76380_i) {
               if(var6 != null && (var4 == null || !var6.equals(var4))) {
                  Entity var9 = var1.func_94560_a().func_76346_g();
                  ItemStack var8 = var9 instanceof EntityLiving?((EntityLiving)var9).func_70694_bm():null;
                  if(var8 != null && var8.func_82837_s()) {
                     var3 = StatCollector.func_74837_a("death.fell.assist.item", new Object[]{this.field_94554_b.func_96090_ax(), var4, var8.func_82833_r()});
                  } else {
                     var3 = StatCollector.func_74837_a("death.fell.assist", new Object[]{this.field_94554_b.func_96090_ax(), var6});
                  }
               } else if(var4 != null) {
                  ItemStack var7 = var5 instanceof EntityLiving?((EntityLiving)var5).func_70694_bm():null;
                  if(var7 != null && var7.func_82837_s()) {
                     var3 = StatCollector.func_74837_a("death.fell.finish.item", new Object[]{this.field_94554_b.func_96090_ax(), var4, var7.func_82833_r()});
                  } else {
                     var3 = StatCollector.func_74837_a("death.fell.finish", new Object[]{this.field_94554_b.func_96090_ax(), var4});
                  }
               } else {
                  var3 = StatCollector.func_74837_a("death.fell.killer", new Object[]{this.field_94554_b.func_96090_ax()});
               }
            } else {
               var3 = StatCollector.func_74837_a("death.fell.accident." + this.func_94548_b(var1), new Object[]{this.field_94554_b.func_96090_ax()});
            }
         } else {
            var3 = var2.func_94560_a().func_76360_b(this.field_94554_b);
         }

         return var3;
      }
   }

   public EntityLiving func_94550_c() {
      EntityLiving var1 = null;
      EntityPlayer var2 = null;
      int var3 = 0;
      int var4 = 0;
      Iterator var5 = this.field_94556_a.iterator();

      while(var5.hasNext()) {
         CombatEntry var6 = (CombatEntry)var5.next();
         if(var6.func_94560_a().func_76346_g() instanceof EntityPlayer && (var2 == null || var6.func_94563_c() > var4)) {
            var4 = var6.func_94563_c();
            var2 = (EntityPlayer)var6.func_94560_a().func_76346_g();
         }

         if(var6.func_94560_a().func_76346_g() instanceof EntityLiving && (var1 == null || var6.func_94563_c() > var3)) {
            var3 = var6.func_94563_c();
            var1 = (EntityLiving)var6.func_94560_a().func_76346_g();
         }
      }

      if(var2 != null && var4 >= var3 / 3) {
         return var2;
      } else {
         return var1;
      }
   }

   private CombatEntry func_94544_f() {
      CombatEntry var1 = null;
      CombatEntry var2 = null;
      byte var3 = 0;
      float var4 = 0.0F;

      for(int var5 = 0; var5 < this.field_94556_a.size(); ++var5) {
         CombatEntry var6 = (CombatEntry)this.field_94556_a.get(var5);
         CombatEntry var7 = var5 > 0?(CombatEntry)this.field_94556_a.get(var5 - 1):null;
         if((var6.func_94560_a() == DamageSource.field_76379_h || var6.func_94560_a() == DamageSource.field_76380_i) && var6.func_94561_i() > 0.0F && (var1 == null || var6.func_94561_i() > var4)) {
            if(var5 > 0) {
               var1 = var7;
            } else {
               var1 = var6;
            }

            var4 = var6.func_94561_i();
         }

         if(var6.func_94562_g() != null && (var2 == null || var6.func_94563_c() > var3)) {
            var2 = var6;
         }
      }

      if(var4 > 5.0F && var1 != null) {
         return var1;
      } else if(var3 > 5 && var2 != null) {
         return var2;
      } else {
         return null;
      }
   }

   private String func_94548_b(CombatEntry p_94548_1_) {
      return p_94548_1_.func_94562_g() == null?"generic":p_94548_1_.func_94562_g();
   }

   private void func_94542_g() {
      this.field_94551_f = null;
   }

   private void func_94549_h() {
      int var1 = this.field_94552_d?300:100;
      if(this.field_94553_e && this.field_94554_b.field_70173_aa - this.field_94555_c > var1) {
         this.field_94556_a.clear();
         this.field_94553_e = false;
         this.field_94552_d = false;
      }

   }
}
