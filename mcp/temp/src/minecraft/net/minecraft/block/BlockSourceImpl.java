package net.minecraft.block;

import net.minecraft.dispenser.IBlockSource;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSourceImpl implements IBlockSource {

   private final World field_82627_a;
   private final int field_82625_b;
   private final int field_82626_c;
   private final int field_82624_d;


   public BlockSourceImpl(World p_i5025_1_, int p_i5025_2_, int p_i5025_3_, int p_i5025_4_) {
      this.field_82627_a = p_i5025_1_;
      this.field_82625_b = p_i5025_2_;
      this.field_82626_c = p_i5025_3_;
      this.field_82624_d = p_i5025_4_;
   }

   public World func_82618_k() {
      return this.field_82627_a;
   }

   public double func_82615_a() {
      return (double)this.field_82625_b + 0.5D;
   }

   public double func_82617_b() {
      return (double)this.field_82626_c + 0.5D;
   }

   public double func_82616_c() {
      return (double)this.field_82624_d + 0.5D;
   }

   public int func_82623_d() {
      return this.field_82625_b;
   }

   public int func_82622_e() {
      return this.field_82626_c;
   }

   public int func_82621_f() {
      return this.field_82624_d;
   }

   public int func_82620_h() {
      return this.field_82627_a.func_72805_g(this.field_82625_b, this.field_82626_c, this.field_82624_d);
   }

   public TileEntity func_82619_j() {
      return this.field_82627_a.func_72796_p(this.field_82625_b, this.field_82626_c, this.field_82624_d);
   }
}
