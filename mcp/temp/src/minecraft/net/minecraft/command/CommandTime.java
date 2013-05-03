package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class CommandTime extends CommandBase {

   public String func_71517_b() {
      return "time";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.time.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length > 1) {
         int var3;
         if(p_71515_2_[0].equals("set")) {
            if(p_71515_2_[1].equals("day")) {
               var3 = 0;
            } else if(p_71515_2_[1].equals("night")) {
               var3 = 12500;
            } else {
               var3 = func_71528_a(p_71515_1_, p_71515_2_[1], 0);
            }

            this.func_71552_a(p_71515_1_, var3);
            func_71522_a(p_71515_1_, "commands.time.set", new Object[]{Integer.valueOf(var3)});
            return;
         }

         if(p_71515_2_[0].equals("add")) {
            var3 = func_71528_a(p_71515_1_, p_71515_2_[1], 0);
            this.func_71553_b(p_71515_1_, var3);
            func_71522_a(p_71515_1_, "commands.time.added", new Object[]{Integer.valueOf(var3)});
            return;
         }
      }

      throw new WrongUsageException("commands.time.usage", new Object[0]);
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 1?func_71530_a(p_71516_2_, new String[]{"set", "add"}):(p_71516_2_.length == 2 && p_71516_2_[0].equals("set")?func_71530_a(p_71516_2_, new String[]{"day", "night"}):null);
   }

   protected void func_71552_a(ICommandSender p_71552_1_, int p_71552_2_) {
      for(int var3 = 0; var3 < MinecraftServer.func_71276_C().field_71305_c.length; ++var3) {
         MinecraftServer.func_71276_C().field_71305_c[var3].func_72877_b((long)p_71552_2_);
      }

   }

   protected void func_71553_b(ICommandSender p_71553_1_, int p_71553_2_) {
      for(int var3 = 0; var3 < MinecraftServer.func_71276_C().field_71305_c.length; ++var3) {
         WorldServer var4 = MinecraftServer.func_71276_C().field_71305_c[var3];
         var4.func_72877_b(var4.func_72820_D() + (long)p_71553_2_);
      }

   }
}
