package net.minecraft.command;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandNotFoundException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;

public class CommandHelp extends CommandBase {

   public String func_71517_b() {
      return "help";
   }

   public int func_82362_a() {
      return 0;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.help.usage", new Object[0]);
   }

   public List func_71514_a() {
      return Arrays.asList(new String[]{"?"});
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      List var3 = this.func_71534_d(p_71515_1_);
      byte var4 = 7;
      int var5 = (var3.size() - 1) / var4;
      boolean var6 = false;

      ICommand var9;
      int var11;
      try {
         var11 = p_71515_2_.length == 0?0:func_71532_a(p_71515_1_, p_71515_2_[0], 1, var5 + 1) - 1;
      } catch (NumberInvalidException var10) {
         Map var8 = this.func_71535_c();
         var9 = (ICommand)var8.get(p_71515_2_[0]);
         if(var9 != null) {
            throw new WrongUsageException(var9.func_71518_a(p_71515_1_), new Object[0]);
         }

         throw new CommandNotFoundException();
      }

      int var7 = Math.min((var11 + 1) * var4, var3.size());
      p_71515_1_.func_70006_a(EnumChatFormatting.DARK_GREEN + p_71515_1_.func_70004_a("commands.help.header", new Object[]{Integer.valueOf(var11 + 1), Integer.valueOf(var5 + 1)}));

      for(int var12 = var11 * var4; var12 < var7; ++var12) {
         var9 = (ICommand)var3.get(var12);
         p_71515_1_.func_70006_a(var9.func_71518_a(p_71515_1_));
      }

      if(var11 == 0 && p_71515_1_ instanceof EntityPlayer) {
         p_71515_1_.func_70006_a(EnumChatFormatting.GREEN + p_71515_1_.func_70004_a("commands.help.footer", new Object[0]));
      }

   }

   protected List func_71534_d(ICommandSender p_71534_1_) {
      List var2 = MinecraftServer.func_71276_C().func_71187_D().func_71557_a(p_71534_1_);
      Collections.sort(var2);
      return var2;
   }

   protected Map func_71535_c() {
      return MinecraftServer.func_71276_C().func_71187_D().func_71555_a();
   }
}
