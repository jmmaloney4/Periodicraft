package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.StatCollector;

public class CommandEffect extends CommandBase {

   public String func_71517_b() {
      return "effect";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.effect.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length >= 2) {
         EntityPlayerMP var3 = func_82359_c(p_71515_1_, p_71515_2_[0]);
         int var4 = func_71528_a(p_71515_1_, p_71515_2_[1], 1);
         int var5 = 600;
         int var6 = 30;
         int var7 = 0;
         if(var4 >= 0 && var4 < Potion.field_76425_a.length && Potion.field_76425_a[var4] != null) {
            if(p_71515_2_.length >= 3) {
               var6 = func_71532_a(p_71515_1_, p_71515_2_[2], 0, 1000000);
               if(Potion.field_76425_a[var4].func_76403_b()) {
                  var5 = var6;
               } else {
                  var5 = var6 * 20;
               }
            } else if(Potion.field_76425_a[var4].func_76403_b()) {
               var5 = 1;
            }

            if(p_71515_2_.length >= 4) {
               var7 = func_71532_a(p_71515_1_, p_71515_2_[3], 0, 255);
            }

            if(var6 == 0) {
               if(!var3.func_82165_m(var4)) {
                  throw new CommandException("commands.effect.failure.notActive", new Object[]{StatCollector.func_74838_a(Potion.field_76425_a[var4].func_76393_a()), var3.func_70023_ak()});
               }

               var3.func_82170_o(var4);
               func_71522_a(p_71515_1_, "commands.effect.success.removed", new Object[]{StatCollector.func_74838_a(Potion.field_76425_a[var4].func_76393_a()), var3.func_70023_ak()});
            } else {
               PotionEffect var8 = new PotionEffect(var4, var5, var7);
               var3.func_70690_d(var8);
               func_71522_a(p_71515_1_, "commands.effect.success", new Object[]{StatCollector.func_74838_a(var8.func_76453_d()), Integer.valueOf(var4), Integer.valueOf(var7), var3.func_70023_ak(), Integer.valueOf(var6)});
            }

         } else {
            throw new NumberInvalidException("commands.effect.notFound", new Object[]{Integer.valueOf(var4)});
         }
      } else {
         throw new WrongUsageException("commands.effect.usage", new Object[0]);
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 1?func_71530_a(p_71516_2_, this.func_98152_d()):null;
   }

   protected String[] func_98152_d() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
