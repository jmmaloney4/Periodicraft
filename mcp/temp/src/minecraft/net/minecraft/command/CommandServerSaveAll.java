package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldServer;

public class CommandServerSaveAll extends CommandBase {

   public String func_71517_b() {
      return "save-all";
   }

   public int func_82362_a() {
      return 4;
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      MinecraftServer var3 = MinecraftServer.func_71276_C();
      p_71515_1_.func_70006_a(p_71515_1_.func_70004_a("commands.save.start", new Object[0]));
      if(var3.func_71203_ab() != null) {
         var3.func_71203_ab().func_72389_g();
      }

      try {
         for(int var4 = 0; var4 < var3.field_71305_c.length; ++var4) {
            if(var3.field_71305_c[var4] != null) {
               WorldServer var5 = var3.field_71305_c[var4];
               boolean var6 = var5.field_73058_d;
               var5.field_73058_d = false;
               var5.func_73044_a(true, (IProgressUpdate)null);
               var5.field_73058_d = var6;
            }
         }
      } catch (MinecraftException var7) {
         func_71522_a(p_71515_1_, "commands.save.failed", new Object[]{var7.getMessage()});
         return;
      }

      func_71522_a(p_71515_1_, "commands.save.success", new Object[0]);
   }
}
