package net.minecraft.command;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class CommandServerSaveOff extends CommandBase
{
    public String getCommandName()
    {
        return "save-off";
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

        for (int i = 0; i < minecraftserver.worldServers.length; ++i)
        {
            if (minecraftserver.worldServers[i] != null)
            {
                WorldServer worldserver = minecraftserver.worldServers[i];
                worldserver.canNotSave = true;
            }
        }

        notifyAdmins(par1ICommandSender, "commands.save.disabled", new Object[0]);
    }
}
