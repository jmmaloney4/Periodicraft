package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandServerBanlist extends CommandBase {

   public String func_71517_b() {
      return "banlist";
   }

   public int func_82362_a() {
      return 3;
   }

   public boolean func_71519_b(ICommandSender p_71519_1_) {
      return (MinecraftServer.func_71276_C().func_71203_ab().func_72363_f().func_73710_b() || MinecraftServer.func_71276_C().func_71203_ab().func_72390_e().func_73710_b()) && super.func_71519_b(p_71519_1_);
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.banlist.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length >= 1 && p_71515_2_[0].equalsIgnoreCase("ips")) {
         p_71515_1_.func_70006_a(p_71515_1_.func_70004_a("commands.banlist.ips", new Object[]{Integer.valueOf(MinecraftServer.func_71276_C().func_71203_ab().func_72363_f().func_73712_c().size())}));
         p_71515_1_.func_70006_a(func_71527_a(MinecraftServer.func_71276_C().func_71203_ab().func_72363_f().func_73712_c().keySet().toArray()));
      } else {
         p_71515_1_.func_70006_a(p_71515_1_.func_70004_a("commands.banlist.players", new Object[]{Integer.valueOf(MinecraftServer.func_71276_C().func_71203_ab().func_72390_e().func_73712_c().size())}));
         p_71515_1_.func_70006_a(func_71527_a(MinecraftServer.func_71276_C().func_71203_ab().func_72390_e().func_73712_c().keySet().toArray()));
      }

   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 1?func_71530_a(p_71516_2_, new String[]{"players", "ips"}):null;
   }
}
