package net.minecraft.entity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.entity.EntityHanging;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumArt;
import net.minecraft.world.World;

public class EntityPainting extends EntityHanging {

   public EnumArt field_70522_e;


   public EntityPainting(World p_i3447_1_) {
      super(p_i3447_1_);
   }

   public EntityPainting(World p_i3448_1_, int p_i3448_2_, int p_i3448_3_, int p_i3448_4_, int p_i3448_5_) {
      super(p_i3448_1_, p_i3448_2_, p_i3448_3_, p_i3448_4_, p_i3448_5_);
      ArrayList var6 = new ArrayList();
      EnumArt[] var7 = EnumArt.values();
      int var8 = var7.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         EnumArt var10 = var7[var9];
         this.field_70522_e = var10;
         this.func_82328_a(p_i3448_5_);
         if(this.func_70518_d()) {
            var6.add(var10);
         }
      }

      if(!var6.isEmpty()) {
         this.field_70522_e = (EnumArt)var6.get(this.field_70146_Z.nextInt(var6.size()));
      }

      this.func_82328_a(p_i3448_5_);
   }

   @SideOnly(Side.CLIENT)
   public EntityPainting(World p_i3449_1_, int p_i3449_2_, int p_i3449_3_, int p_i3449_4_, int p_i3449_5_, String p_i3449_6_) {
      this(p_i3449_1_, p_i3449_2_, p_i3449_3_, p_i3449_4_, p_i3449_5_);
      EnumArt[] var7 = EnumArt.values();
      int var8 = var7.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         EnumArt var10 = var7[var9];
         if(var10.field_75702_A.equals(p_i3449_6_)) {
            this.field_70522_e = var10;
            break;
         }
      }

      this.func_82328_a(p_i3449_5_);
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74778_a("Motive", this.field_70522_e.field_75702_A);
      super.func_70014_b(p_70014_1_);
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      String var2 = p_70037_1_.func_74779_i("Motive");
      EnumArt[] var3 = EnumArt.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumArt var6 = var3[var5];
         if(var6.field_75702_A.equals(var2)) {
            this.field_70522_e = var6;
         }
      }

      if(this.field_70522_e == null) {
         this.field_70522_e = EnumArt.Kebab;
      }

      super.func_70037_a(p_70037_1_);
   }

   public int func_82329_d() {
      return this.field_70522_e.field_75703_B;
   }

   public int func_82330_g() {
      return this.field_70522_e.field_75704_C;
   }

   public void func_82331_h() {
      this.func_70099_a(new ItemStack(Item.field_77780_as), 0.0F);
   }
}
