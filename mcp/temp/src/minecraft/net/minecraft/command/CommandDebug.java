package net.minecraft.command;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.profiler.ProfilerResult;
import net.minecraft.server.MinecraftServer;

public class CommandDebug extends CommandBase {

   private long field_71551_a = 0L;
   private int field_71550_b = 0;


   public String func_71517_b() {
      return "debug";
   }

   public int func_82362_a() {
      return 3;
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length == 1) {
         if(p_71515_2_[0].equals("start")) {
            func_71522_a(p_71515_1_, "commands.debug.start", new Object[0]);
            MinecraftServer.func_71276_C().func_71223_ag();
            this.field_71551_a = System.currentTimeMillis();
            this.field_71550_b = MinecraftServer.func_71276_C().func_71259_af();
            return;
         }

         if(p_71515_2_[0].equals("stop")) {
            if(!MinecraftServer.func_71276_C().field_71304_b.field_76327_a) {
               throw new CommandException("commands.debug.notStarted", new Object[0]);
            }

            long var3 = System.currentTimeMillis();
            int var5 = MinecraftServer.func_71276_C().func_71259_af();
            long var6 = var3 - this.field_71551_a;
            int var8 = var5 - this.field_71550_b;
            this.func_71548_a(var6, var8);
            MinecraftServer.func_71276_C().field_71304_b.field_76327_a = false;
            func_71522_a(p_71515_1_, "commands.debug.stop", new Object[]{Float.valueOf((float)var6 / 1000.0F), Integer.valueOf(var8)});
            return;
         }
      }

      throw new WrongUsageException("commands.debug.usage", new Object[0]);
   }

   private void func_71548_a(long p_71548_1_, int p_71548_3_) {
      File var4 = new File(MinecraftServer.func_71276_C().func_71209_f("debug"), "profile-results-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + ".txt");
      var4.getParentFile().mkdirs();

      try {
         FileWriter var5 = new FileWriter(var4);
         var5.write(this.func_71547_b(p_71548_1_, p_71548_3_));
         var5.close();
      } catch (Throwable var6) {
         MinecraftServer.func_71276_C().func_98033_al().func_98234_c("Could not save profiler results to " + var4, var6);
      }

   }

   private String func_71547_b(long p_71547_1_, int p_71547_3_) {
      StringBuilder var4 = new StringBuilder();
      var4.append("---- Minecraft Profiler Results ----\n");
      var4.append("// ");
      var4.append(func_71549_c());
      var4.append("\n\n");
      var4.append("Time span: ").append(p_71547_1_).append(" ms\n");
      var4.append("Tick span: ").append(p_71547_3_).append(" ticks\n");
      var4.append("// This is approximately ").append(String.format("%.2f", new Object[]{Float.valueOf((float)p_71547_3_ / ((float)p_71547_1_ / 1000.0F))})).append(" ticks per second. It should be ").append(20).append(" ticks per second\n\n");
      var4.append("--- BEGIN PROFILE DUMP ---\n\n");
      this.func_71546_a(0, "root", var4);
      var4.append("--- END PROFILE DUMP ---\n\n");
      return var4.toString();
   }

   private void func_71546_a(int p_71546_1_, String p_71546_2_, StringBuilder p_71546_3_) {
      List var4 = MinecraftServer.func_71276_C().field_71304_b.func_76321_b(p_71546_2_);
      if(var4 != null && var4.size() >= 3) {
         for(int var5 = 1; var5 < var4.size(); ++var5) {
            ProfilerResult var6 = (ProfilerResult)var4.get(var5);
            p_71546_3_.append(String.format("[%02d] ", new Object[]{Integer.valueOf(p_71546_1_)}));

            for(int var7 = 0; var7 < p_71546_1_; ++var7) {
               p_71546_3_.append(" ");
            }

            p_71546_3_.append(var6.field_76331_c);
            p_71546_3_.append(" - ");
            p_71546_3_.append(String.format("%.2f", new Object[]{Double.valueOf(var6.field_76332_a)}));
            p_71546_3_.append("%/");
            p_71546_3_.append(String.format("%.2f", new Object[]{Double.valueOf(var6.field_76330_b)}));
            p_71546_3_.append("%\n");
            if(!var6.field_76331_c.equals("unspecified")) {
               try {
                  this.func_71546_a(p_71546_1_ + 1, p_71546_2_ + "." + var6.field_76331_c, p_71546_3_);
               } catch (Exception var8) {
                  p_71546_3_.append("[[ EXCEPTION " + var8 + " ]]");
               }
            }
         }

      }
   }

   private static String func_71549_c() {
      String[] var0 = new String[]{"Shiny numbers!", "Am I not running fast enough? :(", "I\'m working as hard as I can!", "Will I ever be good enough for you? :(", "Speedy. Zoooooom!", "Hello world", "40% better than a crash report.", "Now with extra numbers", "Now with less numbers", "Now with the same numbers", "You should add flames to things, it makes them go faster!", "Do you feel the need for... optimization?", "*cracks redstone whip*", "Maybe if you treated it better then it\'ll have more motivation to work faster! Poor server."};

      try {
         return var0[(int)(System.nanoTime() % (long)var0.length)];
      } catch (Throwable var2) {
         return "Witty comment unavailable :(";
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 1?func_71530_a(p_71516_2_, new String[]{"start", "stop"}):null;
   }
}
