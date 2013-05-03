package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

@SideOnly(Side.CLIENT)
public class ServerList {

   private final Minecraft field_78859_a;
   private final List field_78858_b = new ArrayList();


   public ServerList(Minecraft p_i3113_1_) {
      this.field_78859_a = p_i3113_1_;
      this.func_78853_a();
   }

   public void func_78853_a() {
      try {
         NBTTagCompound var1 = CompressedStreamTools.func_74797_a(new File(this.field_78859_a.field_71412_D, "servers.dat"));
         NBTTagList var2 = var1.func_74761_m("servers");
         this.field_78858_b.clear();

         for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
            this.field_78858_b.add(ServerData.func_78837_a((NBTTagCompound)var2.func_74743_b(var3)));
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }

   public void func_78855_b() {
      try {
         NBTTagList var1 = new NBTTagList();
         Iterator var2 = this.field_78858_b.iterator();

         while(var2.hasNext()) {
            ServerData var3 = (ServerData)var2.next();
            var1.func_74742_a(var3.func_78836_a());
         }

         NBTTagCompound var5 = new NBTTagCompound();
         var5.func_74782_a("servers", var1);
         CompressedStreamTools.func_74793_a(var5, new File(this.field_78859_a.field_71412_D, "servers.dat"));
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }

   public ServerData func_78850_a(int p_78850_1_) {
      return (ServerData)this.field_78858_b.get(p_78850_1_);
   }

   public void func_78851_b(int p_78851_1_) {
      this.field_78858_b.remove(p_78851_1_);
   }

   public void func_78849_a(ServerData p_78849_1_) {
      this.field_78858_b.add(p_78849_1_);
   }

   public int func_78856_c() {
      return this.field_78858_b.size();
   }

   public void func_78857_a(int p_78857_1_, int p_78857_2_) {
      ServerData var3 = this.func_78850_a(p_78857_1_);
      this.field_78858_b.set(p_78857_1_, this.func_78850_a(p_78857_2_));
      this.field_78858_b.set(p_78857_2_, var3);
      this.func_78855_b();
   }

   public void func_78854_a(int p_78854_1_, ServerData p_78854_2_) {
      this.field_78858_b.set(p_78854_1_, p_78854_2_);
   }

   public static void func_78852_b(ServerData p_78852_0_) {
      ServerList var1 = new ServerList(Minecraft.func_71410_x());
      var1.func_78853_a();

      for(int var2 = 0; var2 < var1.func_78856_c(); ++var2) {
         ServerData var3 = var1.func_78850_a(var2);
         if(var3.field_78847_a.equals(p_78852_0_.field_78847_a) && var3.field_78845_b.equals(p_78852_0_.field_78845_b)) {
            var1.func_78854_a(var2, p_78852_0_);
            break;
         }
      }

      var1.func_78855_b();
   }
}
