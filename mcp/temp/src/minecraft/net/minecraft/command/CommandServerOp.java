package net.minecraft.command;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;

public class CommandServerOp extends CommandBase {

   public String func_71517_b() {
      return "op";
   }

   public int func_82362_a() {
      return 3;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.op.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length == 1 && p_71515_2_[0].length() > 0) {
         MinecraftServer.func_71276_C().func_71203_ab().func_72386_b(p_71515_2_[0]);
         func_71522_a(p_71515_1_, "commands.op.success", new Object[]{p_71515_2_[0]});
      } else {
         throw new WrongUsageException("commands.op.usage", new Object[0]);
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      if(p_71516_2_.length == 1) {
         String var3 = p_71516_2_[p_71516_2_.length - 1];
         ArrayList var4 = new ArrayList();
         String[] var5 = MinecraftServer.func_71276_C().func_71213_z();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            String var8 = var5[var7];
            if(!MinecraftServer.func_71276_C().func_71203_ab().func_72353_e(var8) && func_71523_a(var3, var8)) {
               var4.add(var8);
            }
         }

         return var4;
      } else {
         return null;
      }
   }
}
