package net.minecraft.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

public class EntityAIOcelotSit extends EntityAIBase {

   private final EntityOcelot field_75406_a;
   private final float field_75404_b;
   private int field_75405_c = 0;
   private int field_75402_d = 0;
   private int field_75403_e = 0;
   private int field_75400_f = 0;
   private int field_75401_g = 0;
   private int field_75407_h = 0;


   public EntityAIOcelotSit(EntityOcelot p_i3482_1_, float p_i3482_2_) {
      this.field_75406_a = p_i3482_1_;
      this.field_75404_b = p_i3482_2_;
      this.func_75248_a(5);
   }

   public boolean func_75250_a() {
      return this.field_75406_a.func_70909_n() && !this.field_75406_a.func_70906_o() && this.field_75406_a.func_70681_au().nextDouble() <= 0.006500000134110451D && this.func_75399_f();
   }

   public boolean func_75253_b() {
      return this.field_75405_c <= this.field_75403_e && this.field_75402_d <= 60 && this.func_75398_a(this.field_75406_a.field_70170_p, this.field_75400_f, this.field_75401_g, this.field_75407_h);
   }

   public void func_75249_e() {
      this.field_75406_a.func_70661_as().func_75492_a((double)((float)this.field_75400_f) + 0.5D, (double)(this.field_75401_g + 1), (double)((float)this.field_75407_h) + 0.5D, this.field_75404_b);
      this.field_75405_c = 0;
      this.field_75402_d = 0;
      this.field_75403_e = this.field_75406_a.func_70681_au().nextInt(this.field_75406_a.func_70681_au().nextInt(1200) + 1200) + 1200;
      this.field_75406_a.func_70907_r().func_75270_a(false);
   }

   public void func_75251_c() {
      this.field_75406_a.func_70904_g(false);
   }

   public void func_75246_d() {
      ++this.field_75405_c;
      this.field_75406_a.func_70907_r().func_75270_a(false);
      if(this.field_75406_a.func_70092_e((double)this.field_75400_f, (double)(this.field_75401_g + 1), (double)this.field_75407_h) > 1.0D) {
         this.field_75406_a.func_70904_g(false);
         this.field_75406_a.func_70661_as().func_75492_a((double)((float)this.field_75400_f) + 0.5D, (double)(this.field_75401_g + 1), (double)((float)this.field_75407_h) + 0.5D, this.field_75404_b);
         ++this.field_75402_d;
      } else if(!this.field_75406_a.func_70906_o()) {
         this.field_75406_a.func_70904_g(true);
      } else {
         --this.field_75402_d;
      }

   }

   protected boolean func_75399_f() {
      int var1 = (int)this.field_75406_a.field_70163_u;
      double var2 = 2.147483647E9D;

      for(int var4 = (int)this.field_75406_a.field_70165_t - 8; (double)var4 < this.field_75406_a.field_70165_t + 8.0D; ++var4) {
         for(int var5 = (int)this.field_75406_a.field_70161_v - 8; (double)var5 < this.field_75406_a.field_70161_v + 8.0D; ++var5) {
            if(this.func_75398_a(this.field_75406_a.field_70170_p, var4, var1, var5) && this.field_75406_a.field_70170_p.func_72799_c(var4, var1 + 1, var5)) {
               double var6 = this.field_75406_a.func_70092_e((double)var4, (double)var1, (double)var5);
               if(var6 < var2) {
                  this.field_75400_f = var4;
                  this.field_75401_g = var1;
                  this.field_75407_h = var5;
                  var2 = var6;
               }
            }
         }
      }

      return var2 < 2.147483647E9D;
   }

   protected boolean func_75398_a(World p_75398_1_, int p_75398_2_, int p_75398_3_, int p_75398_4_) {
      int var5 = p_75398_1_.func_72798_a(p_75398_2_, p_75398_3_, p_75398_4_);
      int var6 = p_75398_1_.func_72805_g(p_75398_2_, p_75398_3_, p_75398_4_);
      if(var5 == Block.field_72077_au.field_71990_ca) {
         TileEntityChest var7 = (TileEntityChest)p_75398_1_.func_72796_p(p_75398_2_, p_75398_3_, p_75398_4_);
         if(var7.field_70427_h < 1) {
            return true;
         }
      } else {
         if(var5 == Block.field_72052_aC.field_71990_ca) {
            return true;
         }

         if(var5 == Block.field_71959_S.field_71990_ca && !BlockBed.func_72229_a_(var6)) {
            return true;
         }
      }

      return false;
   }
}
