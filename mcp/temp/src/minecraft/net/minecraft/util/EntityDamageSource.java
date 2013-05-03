package net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;

public class EntityDamageSource extends DamageSource {

   protected Entity field_76386_o;


   public EntityDamageSource(String p_i3430_1_, Entity p_i3430_2_) {
      super(p_i3430_1_);
      this.field_76386_o = p_i3430_2_;
   }

   public Entity func_76346_g() {
      return this.field_76386_o;
   }

   public String func_76360_b(EntityLiving p_76360_1_) {
      ItemStack var2 = this.field_76386_o instanceof EntityLiving?((EntityLiving)this.field_76386_o).func_70694_bm():null;
      String var3 = "death.attack." + this.field_76373_n;
      String var4 = var3 + ".item";
      return var2 != null && var2.func_82837_s() && StatCollector.func_94522_b(var4)?StatCollector.func_74837_a(var4, new Object[]{p_76360_1_.func_96090_ax(), this.field_76386_o.func_96090_ax(), var2.func_82833_r()}):StatCollector.func_74837_a(var3, new Object[]{p_76360_1_.func_96090_ax(), this.field_76386_o.func_96090_ax()});
   }

   public boolean func_76350_n() {
      return this.field_76386_o != null && this.field_76386_o instanceof EntityLiving && !(this.field_76386_o instanceof EntityPlayer);
   }
}
