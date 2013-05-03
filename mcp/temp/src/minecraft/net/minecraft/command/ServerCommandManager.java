package net.minecraft.command;

import java.util.Iterator;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandClearInventory;
import net.minecraft.command.CommandDebug;
import net.minecraft.command.CommandDefaultGameMode;
import net.minecraft.command.CommandDifficulty;
import net.minecraft.command.CommandEffect;
import net.minecraft.command.CommandEnchant;
import net.minecraft.command.CommandGameMode;
import net.minecraft.command.CommandGameRule;
import net.minecraft.command.CommandGive;
import net.minecraft.command.CommandHandler;
import net.minecraft.command.CommandHelp;
import net.minecraft.command.CommandKill;
import net.minecraft.command.CommandServerBan;
import net.minecraft.command.CommandServerBanIp;
import net.minecraft.command.CommandServerBanlist;
import net.minecraft.command.CommandServerDeop;
import net.minecraft.command.CommandServerEmote;
import net.minecraft.command.CommandServerKick;
import net.minecraft.command.CommandServerList;
import net.minecraft.command.CommandServerMessage;
import net.minecraft.command.CommandServerOp;
import net.minecraft.command.CommandServerPardon;
import net.minecraft.command.CommandServerPardonIp;
import net.minecraft.command.CommandServerPublishLocal;
import net.minecraft.command.CommandServerSaveAll;
import net.minecraft.command.CommandServerSaveOff;
import net.minecraft.command.CommandServerSaveOn;
import net.minecraft.command.CommandServerSay;
import net.minecraft.command.CommandServerStop;
import net.minecraft.command.CommandServerTp;
import net.minecraft.command.CommandServerWhitelist;
import net.minecraft.command.CommandSetSpawnpoint;
import net.minecraft.command.CommandShowSeed;
import net.minecraft.command.CommandTime;
import net.minecraft.command.CommandToggleDownfall;
import net.minecraft.command.CommandWeather;
import net.minecraft.command.CommandXP;
import net.minecraft.command.IAdminCommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.ServerCommandScoreboard;
import net.minecraft.scoreboard.ServerCommandTestFor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.util.EnumChatFormatting;

public class ServerCommandManager extends CommandHandler implements IAdminCommand {

   public ServerCommandManager() {
      this.func_71560_a(new CommandTime());
      this.func_71560_a(new CommandGameMode());
      this.func_71560_a(new CommandDifficulty());
      this.func_71560_a(new CommandDefaultGameMode());
      this.func_71560_a(new CommandKill());
      this.func_71560_a(new CommandToggleDownfall());
      this.func_71560_a(new CommandWeather());
      this.func_71560_a(new CommandXP());
      this.func_71560_a(new CommandServerTp());
      this.func_71560_a(new CommandGive());
      this.func_71560_a(new CommandEffect());
      this.func_71560_a(new CommandEnchant());
      this.func_71560_a(new CommandServerEmote());
      this.func_71560_a(new CommandShowSeed());
      this.func_71560_a(new CommandHelp());
      this.func_71560_a(new CommandDebug());
      this.func_71560_a(new CommandServerMessage());
      this.func_71560_a(new CommandServerSay());
      this.func_71560_a(new CommandSetSpawnpoint());
      this.func_71560_a(new CommandGameRule());
      this.func_71560_a(new CommandClearInventory());
      this.func_71560_a(new ServerCommandTestFor());
      this.func_71560_a(new ServerCommandScoreboard());
      if(MinecraftServer.func_71276_C().func_71262_S()) {
         this.func_71560_a(new CommandServerOp());
         this.func_71560_a(new CommandServerDeop());
         this.func_71560_a(new CommandServerStop());
         this.func_71560_a(new CommandServerSaveAll());
         this.func_71560_a(new CommandServerSaveOff());
         this.func_71560_a(new CommandServerSaveOn());
         this.func_71560_a(new CommandServerBanIp());
         this.func_71560_a(new CommandServerPardonIp());
         this.func_71560_a(new CommandServerBan());
         this.func_71560_a(new CommandServerBanlist());
         this.func_71560_a(new CommandServerPardon());
         this.func_71560_a(new CommandServerKick());
         this.func_71560_a(new CommandServerList());
         this.func_71560_a(new CommandServerWhitelist());
      } else {
         this.func_71560_a(new CommandServerPublishLocal());
      }

      CommandBase.func_71529_a(this);
   }

   public void func_71563_a(ICommandSender p_71563_1_, int p_71563_2_, String p_71563_3_, Object ... p_71563_4_) {
      boolean var5 = true;
      if(p_71563_1_ instanceof TileEntityCommandBlock && !MinecraftServer.func_71276_C().field_71305_c[0].func_82736_K().func_82766_b("commandBlockOutput")) {
         var5 = false;
      }

      if(var5) {
         Iterator var6 = MinecraftServer.func_71276_C().func_71203_ab().field_72404_b.iterator();

         while(var6.hasNext()) {
            EntityPlayerMP var7 = (EntityPlayerMP)var6.next();
            if(var7 != p_71563_1_ && MinecraftServer.func_71276_C().func_71203_ab().func_72353_e(var7.field_71092_bJ)) {
               var7.func_70006_a("" + EnumChatFormatting.GRAY + "" + EnumChatFormatting.ITALIC + "[" + p_71563_1_.func_70005_c_() + ": " + var7.func_70004_a(p_71563_3_, p_71563_4_) + "]");
            }
         }
      }

      if(p_71563_1_ != MinecraftServer.func_71276_C()) {
         MinecraftServer.func_71276_C().func_98033_al().func_98233_a("[" + p_71563_1_.func_70005_c_() + ": " + MinecraftServer.func_71276_C().func_70004_a(p_71563_3_, p_71563_4_) + "]");
      }

      if((p_71563_2_ & 1) != 1) {
         p_71563_1_.func_70006_a(p_71563_1_.func_70004_a(p_71563_3_, p_71563_4_));
      }

   }
}
