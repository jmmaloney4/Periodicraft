package net.minecraft.world;

import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet55BlockDestroy;
import net.minecraft.network.packet.Packet61DoorChange;
import net.minecraft.network.packet.Packet62LevelSound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.WorldServer;

public class WorldManager implements IWorldAccess {

   private MinecraftServer field_72783_a;
   private WorldServer field_72782_b;


   public WorldManager(MinecraftServer p_i3390_1_, WorldServer p_i3390_2_) {
      this.field_72783_a = p_i3390_1_;
      this.field_72782_b = p_i3390_2_;
   }

   public void func_72708_a(String p_72708_1_, double p_72708_2_, double p_72708_4_, double p_72708_6_, double p_72708_8_, double p_72708_10_, double p_72708_12_) {}

   public void func_72703_a(Entity p_72703_1_) {
      this.field_72782_b.func_73039_n().func_72786_a(p_72703_1_);
   }

   public void func_72709_b(Entity p_72709_1_) {
      this.field_72782_b.func_73039_n().func_72790_b(p_72709_1_);
   }

   public void func_72704_a(String p_72704_1_, double p_72704_2_, double p_72704_4_, double p_72704_6_, float p_72704_8_, float p_72704_9_) {
      this.field_72783_a.func_71203_ab().func_72393_a(p_72704_2_, p_72704_4_, p_72704_6_, p_72704_8_ > 1.0F?(double)(16.0F * p_72704_8_):16.0D, this.field_72782_b.field_73011_w.field_76574_g, new Packet62LevelSound(p_72704_1_, p_72704_2_, p_72704_4_, p_72704_6_, p_72704_8_, p_72704_9_));
   }

   public void func_85102_a(EntityPlayer p_85102_1_, String p_85102_2_, double p_85102_3_, double p_85102_5_, double p_85102_7_, float p_85102_9_, float p_85102_10_) {
      this.field_72783_a.func_71203_ab().func_72397_a(p_85102_1_, p_85102_3_, p_85102_5_, p_85102_7_, p_85102_9_ > 1.0F?(double)(16.0F * p_85102_9_):16.0D, this.field_72782_b.field_73011_w.field_76574_g, new Packet62LevelSound(p_85102_2_, p_85102_3_, p_85102_5_, p_85102_7_, p_85102_9_, p_85102_10_));
   }

   public void func_72707_a(int p_72707_1_, int p_72707_2_, int p_72707_3_, int p_72707_4_, int p_72707_5_, int p_72707_6_) {}

   public void func_72710_a(int p_72710_1_, int p_72710_2_, int p_72710_3_) {
      this.field_72782_b.func_73040_p().func_72687_a(p_72710_1_, p_72710_2_, p_72710_3_);
   }

   public void func_72711_b(int p_72711_1_, int p_72711_2_, int p_72711_3_) {}

   public void func_72702_a(String p_72702_1_, int p_72702_2_, int p_72702_3_, int p_72702_4_) {}

   public void func_72706_a(EntityPlayer p_72706_1_, int p_72706_2_, int p_72706_3_, int p_72706_4_, int p_72706_5_, int p_72706_6_) {
      this.field_72783_a.func_71203_ab().func_72397_a(p_72706_1_, (double)p_72706_3_, (double)p_72706_4_, (double)p_72706_5_, 64.0D, this.field_72782_b.field_73011_w.field_76574_g, new Packet61DoorChange(p_72706_2_, p_72706_3_, p_72706_4_, p_72706_5_, p_72706_6_, false));
   }

   public void func_82746_a(int p_82746_1_, int p_82746_2_, int p_82746_3_, int p_82746_4_, int p_82746_5_) {
      this.field_72783_a.func_71203_ab().func_72384_a(new Packet61DoorChange(p_82746_1_, p_82746_2_, p_82746_3_, p_82746_4_, p_82746_5_, true));
   }

   public void func_72705_a(int p_72705_1_, int p_72705_2_, int p_72705_3_, int p_72705_4_, int p_72705_5_) {
      Iterator var6 = this.field_72783_a.func_71203_ab().field_72404_b.iterator();

      while(var6.hasNext()) {
         EntityPlayerMP var7 = (EntityPlayerMP)var6.next();
         if(var7 != null && var7.field_70170_p == this.field_72782_b && var7.field_70157_k != p_72705_1_) {
            double var8 = (double)p_72705_2_ - var7.field_70165_t;
            double var10 = (double)p_72705_3_ - var7.field_70163_u;
            double var12 = (double)p_72705_4_ - var7.field_70161_v;
            if(var8 * var8 + var10 * var10 + var12 * var12 < 1024.0D) {
               var7.field_71135_a.func_72567_b(new Packet55BlockDestroy(p_72705_1_, p_72705_2_, p_72705_3_, p_72705_4_, p_72705_5_));
            }
         }
      }

   }
}
