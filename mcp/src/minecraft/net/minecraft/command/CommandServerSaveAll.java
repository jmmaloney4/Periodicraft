package net.minecraft.command;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldServer;

public class CommandServerSaveAll extends CommandBase
{
    public String getCommandName()
    {
        return "save-all";
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 4;
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        MinecraftServer minecraftserver = MinecraftServer.getServer();
        par1ICommandSender.sendChatToPlayer(par1ICommandSender.translateString("commands.save.start", new Object[0]));

        if (minecraftserver.getConfigurationManager() != null)
        {
            minecraftserver.getConfigurationManager().saveAllPlayerData();
        }

        try
        {
            for (int i = 0; i < minecraftserver.worldServers.length; ++i)
            {
                if (minecraftserver.worldServers[i] != null)
                {
                    WorldServer worldserver = minecraftserver.worldServers[i];
                    boolean flag = worldserver.canNotSave;
                    worldserver.canNotSave = false;
                    worldserver.saveAllChunks(true, (IProgressUpdate)null);
                    worldserver.canNotSave = flag;
                }
            }
        }
        catch (MinecraftException minecraftexception)
        {
            notifyAdmins(par1ICommandSender, "commands.save.failed", new Object[] {minecraftexception.getMessage()});
            return;
        }

        notifyAdmins(par1ICommandSender, "commands.save.success", new Object[0]);
    }
}
