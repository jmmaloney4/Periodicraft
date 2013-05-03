package net.minecraft.command;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumGameType;

public class CommandDefaultGameMode extends CommandGameMode
{
    public String getCommandName()
    {
        return "defaultgamemode";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.defaultgamemode.usage", new Object[0]);
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        if (par2ArrayOfStr.length > 0)
        {
            EnumGameType enumgametype = this.getGameModeFromCommand(par1ICommandSender, par2ArrayOfStr[0]);
            this.setGameType(enumgametype);
            String s = StatCollector.translateToLocal("gameMode." + enumgametype.getName());
            notifyAdmins(par1ICommandSender, "commands.defaultgamemode.success", new Object[] {s});
        }
        else
        {
            throw new WrongUsageException("commands.defaultgamemode.usage", new Object[0]);
        }
    }

    protected void setGameType(EnumGameType par1EnumGameType)
    {
        MinecraftServer.getServer().setGameType(par1EnumGameType);
    }
}
