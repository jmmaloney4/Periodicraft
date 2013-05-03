package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandXP extends CommandBase {

   public String func_71517_b() {
      return "xp";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.xp.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length <= 0) {
         throw new WrongUsageException("commands.xp.usage", new Object[0]);
      } else {
         String var4 = p_71515_2_[0];
         boolean var5 = var4.endsWith("l") || var4.endsWith("L");
         if(var5 && var4.length() > 1) {
            var4 = var4.substring(0, var4.length() - 1);
         }

         int var6 = func_71526_a(p_71515_1_, var4);
         boolean var7 = var6 < 0;
         if(var7) {
            var6 *= -1;
         }

         EntityPlayerMP var3;
         if(p_71515_2_.length > 1) {
            var3 = func_82359_c(p_71515_1_, p_71515_2_[1]);
         } else {
            var3 = func_71521_c(p_71515_1_);
         }

         if(var5) {
            if(var7) {
               var3.func_82242_a(-var6);
               func_71522_a(p_71515_1_, "commands.xp.success.negative.levels", new Object[]{Integer.valueOf(var6), var3.func_70023_ak()});
            } else {
               var3.func_82242_a(var6);
               func_71522_a(p_71515_1_, "commands.xp.success.levels", new Object[]{Integer.valueOf(var6), var3.func_70023_ak()});
            }
         } else {
            if(var7) {
               throw new WrongUsageException("commands.xp.failure.widthdrawXp", new Object[0]);
            }

            var3.func_71023_q(var6);
            func_71522_a(p_71515_1_, "commands.xp.success", new Object[]{Integer.valueOf(var6), var3.func_70023_ak()});
         }

      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 2?func_71530_a(p_71516_2_, this.func_71542_c()):null;
   }

   protected String[] func_71542_c() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 1;
   }
}
