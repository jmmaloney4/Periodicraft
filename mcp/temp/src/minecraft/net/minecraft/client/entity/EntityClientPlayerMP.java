package net.minecraft.client.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet11PlayerPosition;
import net.minecraft.network.packet.Packet12PlayerLook;
import net.minecraft.network.packet.Packet13PlayerLookMove;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.network.packet.Packet19EntityAction;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet205ClientCommand;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.stats.StatBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Session;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityClientPlayerMP extends EntityPlayerSP {

   public NetClientHandler field_71174_a;
   private double field_71179_j;
   private double field_71177_cg;
   private double field_71178_ch;
   private double field_71175_ci;
   private float field_71176_cj;
   private float field_71172_ck;
   private boolean field_71173_cl = false;
   private boolean field_71170_cm = false;
   private boolean field_71171_cn = false;
   private int field_71168_co = 0;
   private boolean field_71169_cp = false;


   public EntityClientPlayerMP(Minecraft p_i3101_1_, World p_i3101_2_, Session p_i3101_3_, NetClientHandler p_i3101_4_) {
      super(p_i3101_1_, p_i3101_2_, p_i3101_3_, 0);
      this.field_71174_a = p_i3101_4_;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      return false;
   }

   public void func_70691_i(int p_70691_1_) {}

   public void func_70071_h_() {
      if(this.field_70170_p.func_72899_e(MathHelper.func_76128_c(this.field_70165_t), 0, MathHelper.func_76128_c(this.field_70161_v))) {
         super.func_70071_h_();
         this.func_71166_b();
      }
   }

   public void func_71166_b() {
      boolean var1 = this.func_70051_ag();
      if(var1 != this.field_71171_cn) {
         if(var1) {
            this.field_71174_a.func_72552_c(new Packet19EntityAction(this, 4));
         } else {
            this.field_71174_a.func_72552_c(new Packet19EntityAction(this, 5));
         }

         this.field_71171_cn = var1;
      }

      boolean var2 = this.func_70093_af();
      if(var2 != this.field_71170_cm) {
         if(var2) {
            this.field_71174_a.func_72552_c(new Packet19EntityAction(this, 1));
         } else {
            this.field_71174_a.func_72552_c(new Packet19EntityAction(this, 2));
         }

         this.field_71170_cm = var2;
      }

      double var3 = this.field_70165_t - this.field_71179_j;
      double var5 = this.field_70121_D.field_72338_b - this.field_71177_cg;
      double var7 = this.field_70161_v - this.field_71175_ci;
      double var9 = (double)(this.field_70177_z - this.field_71176_cj);
      double var11 = (double)(this.field_70125_A - this.field_71172_ck);
      boolean var13 = var3 * var3 + var5 * var5 + var7 * var7 > 9.0E-4D || this.field_71168_co >= 20;
      boolean var14 = var9 != 0.0D || var11 != 0.0D;
      if(this.field_70154_o != null) {
         this.field_71174_a.func_72552_c(new Packet13PlayerLookMove(this.field_70159_w, -999.0D, -999.0D, this.field_70179_y, this.field_70177_z, this.field_70125_A, this.field_70122_E));
         var13 = false;
      } else if(var13 && var14) {
         this.field_71174_a.func_72552_c(new Packet13PlayerLookMove(this.field_70165_t, this.field_70121_D.field_72338_b, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A, this.field_70122_E));
      } else if(var13) {
         this.field_71174_a.func_72552_c(new Packet11PlayerPosition(this.field_70165_t, this.field_70121_D.field_72338_b, this.field_70163_u, this.field_70161_v, this.field_70122_E));
      } else if(var14) {
         this.field_71174_a.func_72552_c(new Packet12PlayerLook(this.field_70177_z, this.field_70125_A, this.field_70122_E));
      } else {
         this.field_71174_a.func_72552_c(new Packet10Flying(this.field_70122_E));
      }

      ++this.field_71168_co;
      this.field_71173_cl = this.field_70122_E;
      if(var13) {
         this.field_71179_j = this.field_70165_t;
         this.field_71177_cg = this.field_70121_D.field_72338_b;
         this.field_71178_ch = this.field_70163_u;
         this.field_71175_ci = this.field_70161_v;
         this.field_71168_co = 0;
      }

      if(var14) {
         this.field_71176_cj = this.field_70177_z;
         this.field_71172_ck = this.field_70125_A;
      }

   }

   public EntityItem func_71040_bB(boolean p_71040_1_) {
      int var2 = p_71040_1_?3:4;
      this.field_71174_a.func_72552_c(new Packet14BlockDig(var2, 0, 0, 0, 0));
      return null;
   }

   public void func_71012_a(EntityItem p_71012_1_) {}

   public void func_71165_d(String p_71165_1_) {
      this.field_71174_a.func_72552_c(new Packet3Chat(p_71165_1_));
   }

   public void func_71038_i() {
      super.func_71038_i();
      this.field_71174_a.func_72552_c(new Packet18Animation(this, 1));
   }

   public void func_71004_bE() {
      this.field_71174_a.func_72552_c(new Packet205ClientCommand(1));
   }

   protected void func_70665_d(DamageSource p_70665_1_, int p_70665_2_) {
      if(!this.func_85032_ar()) {
         this.func_70606_j(this.func_70630_aN() - p_70665_2_);
      }
   }

   public void func_71053_j() {
      this.field_71174_a.func_72552_c(new Packet101CloseWindow(this.field_71070_bA.field_75152_c));
      this.func_92015_f();
   }

   public void func_92015_f() {
      this.field_71071_by.func_70437_b((ItemStack)null);
      super.func_71053_j();
   }

   public void func_71150_b(int p_71150_1_) {
      if(this.field_71169_cp) {
         super.func_71150_b(p_71150_1_);
      } else {
         this.func_70606_j(p_71150_1_);
         this.field_71169_cp = true;
      }

   }

   public void func_71064_a(StatBase p_71064_1_, int p_71064_2_) {
      if(p_71064_1_ != null) {
         if(p_71064_1_.field_75972_f) {
            super.func_71064_a(p_71064_1_, p_71064_2_);
         }

      }
   }

   public void func_71167_b(StatBase p_71167_1_, int p_71167_2_) {
      if(p_71167_1_ != null) {
         if(!p_71167_1_.field_75972_f) {
            super.func_71064_a(p_71167_1_, p_71167_2_);
         }

      }
   }

   public void func_71016_p() {
      this.field_71174_a.func_72552_c(new Packet202PlayerAbilities(this.field_71075_bZ));
   }

   public boolean func_71066_bF() {
      return true;
   }
}
