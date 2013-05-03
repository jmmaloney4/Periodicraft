package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandClearInventory extends CommandBase {

   public String func_71517_b() {
      return "clear";
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.clear.usage", new Object[0]);
   }

   public int func_82362_a() {
      return 2;
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      EntityPlayerMP var3 = p_71515_2_.length == 0?func_71521_c(p_71515_1_):func_82359_c(p_71515_1_, p_71515_2_[0]);
      int var4 = p_71515_2_.length >= 2?func_71528_a(p_71515_1_, p_71515_2_[1], 1):-1;
      int var5 = p_71515_2_.length >= 3?func_71528_a(p_71515_1_, p_71515_2_[2], 0):-1;
      int var6 = var3.field_71071_by.func_82347_b(var4, var5);
      var3.field_71069_bz.func_75142_b();
      if(var6 == 0) {
         throw new CommandException("commands.clear.failure", new Object[]{var3.func_70023_ak()});
      } else {
         func_71522_a(p_71515_1_, "commands.clear.success", new Object[]{var3.func_70023_ak(), Integer.valueOf(var6)});
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 1?func_71530_a(p_71516_2_, this.func_82369_d()):null;
   }

   protected String[] func_82369_d() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
