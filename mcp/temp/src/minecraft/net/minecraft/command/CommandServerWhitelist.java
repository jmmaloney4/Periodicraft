package net.minecraft.command;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;

public class CommandServerWhitelist extends CommandBase {

   public String func_71517_b() {
      return "whitelist";
   }

   public int func_82362_a() {
      return 3;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.whitelist.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length >= 1) {
         if(p_71515_2_[0].equals("on")) {
            MinecraftServer.func_71276_C().func_71203_ab().func_72371_a(true);
            func_71522_a(p_71515_1_, "commands.whitelist.enabled", new Object[0]);
            return;
         }

         if(p_71515_2_[0].equals("off")) {
            MinecraftServer.func_71276_C().func_71203_ab().func_72371_a(false);
            func_71522_a(p_71515_1_, "commands.whitelist.disabled", new Object[0]);
            return;
         }

         if(p_71515_2_[0].equals("list")) {
            p_71515_1_.func_70006_a(p_71515_1_.func_70004_a("commands.whitelist.list", new Object[]{Integer.valueOf(MinecraftServer.func_71276_C().func_71203_ab().func_72388_h().size()), Integer.valueOf(MinecraftServer.func_71276_C().func_71203_ab().func_72373_m().length)}));
            p_71515_1_.func_70006_a(func_71527_a(MinecraftServer.func_71276_C().func_71203_ab().func_72388_h().toArray(new String[0])));
            return;
         }

         if(p_71515_2_[0].equals("add")) {
            if(p_71515_2_.length < 2) {
               throw new WrongUsageException("commands.whitelist.add.usage", new Object[0]);
            }

            MinecraftServer.func_71276_C().func_71203_ab().func_72359_h(p_71515_2_[1]);
            func_71522_a(p_71515_1_, "commands.whitelist.add.success", new Object[]{p_71515_2_[1]});
            return;
         }

         if(p_71515_2_[0].equals("remove")) {
            if(p_71515_2_.length < 2) {
               throw new WrongUsageException("commands.whitelist.remove.usage", new Object[0]);
            }

            MinecraftServer.func_71276_C().func_71203_ab().func_72379_i(p_71515_2_[1]);
            func_71522_a(p_71515_1_, "commands.whitelist.remove.success", new Object[]{p_71515_2_[1]});
            return;
         }

         if(p_71515_2_[0].equals("reload")) {
            MinecraftServer.func_71276_C().func_71203_ab().func_72362_j();
            func_71522_a(p_71515_1_, "commands.whitelist.reloaded", new Object[0]);
            return;
         }
      }

      throw new WrongUsageException("commands.whitelist.usage", new Object[0]);
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      if(p_71516_2_.length == 1) {
         return func_71530_a(p_71516_2_, new String[]{"on", "off", "list", "add", "remove", "reload"});
      } else {
         if(p_71516_2_.length == 2) {
            if(p_71516_2_[0].equals("add")) {
               String[] var3 = MinecraftServer.func_71276_C().func_71203_ab().func_72373_m();
               ArrayList var4 = new ArrayList();
               String var5 = p_71516_2_[p_71516_2_.length - 1];
               String[] var6 = var3;
               int var7 = var3.length;

               for(int var8 = 0; var8 < var7; ++var8) {
                  String var9 = var6[var8];
                  if(func_71523_a(var5, var9) && !MinecraftServer.func_71276_C().func_71203_ab().func_72388_h().contains(var9)) {
                     var4.add(var9);
                  }
               }

               return var4;
            }

            if(p_71516_2_[0].equals("remove")) {
               return func_71531_a(p_71516_2_, MinecraftServer.func_71276_C().func_71203_ab().func_72388_h());
            }
         }

         return null;
      }
   }
}
