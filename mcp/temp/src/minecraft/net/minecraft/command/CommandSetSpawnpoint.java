package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;

public class CommandSetSpawnpoint extends CommandBase {

   public String func_71517_b() {
      return "spawnpoint";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.spawnpoint.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      EntityPlayerMP var3 = p_71515_2_.length == 0?func_71521_c(p_71515_1_):func_82359_c(p_71515_1_, p_71515_2_[0]);
      if(p_71515_2_.length == 4) {
         if(var3.field_70170_p != null) {
            byte var4 = 1;
            int var5 = 30000000;
            int var10 = var4 + 1;
            int var6 = func_71532_a(p_71515_1_, p_71515_2_[var4], -var5, var5);
            int var7 = func_71532_a(p_71515_1_, p_71515_2_[var10++], 0, 256);
            int var8 = func_71532_a(p_71515_1_, p_71515_2_[var10++], -var5, var5);
            var3.func_71063_a(new ChunkCoordinates(var6, var7, var8), true);
            func_71522_a(p_71515_1_, "commands.spawnpoint.success", new Object[]{var3.func_70023_ak(), Integer.valueOf(var6), Integer.valueOf(var7), Integer.valueOf(var8)});
         }
      } else {
         if(p_71515_2_.length > 1) {
            throw new WrongUsageException("commands.spawnpoint.usage", new Object[0]);
         }

         ChunkCoordinates var11 = var3.func_82114_b();
         var3.func_71063_a(var11, true);
         func_71522_a(p_71515_1_, "commands.spawnpoint.success", new Object[]{var3.func_70023_ak(), Integer.valueOf(var11.field_71574_a), Integer.valueOf(var11.field_71572_b), Integer.valueOf(var11.field_71573_c)});
      }

   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length != 1 && p_71516_2_.length != 2?null:func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
