package net.minecraft.command;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;

public class CommandKill extends CommandBase
{
    public String getCommandName()
    {
        return "kill";
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 0;
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        EntityPlayerMP entityplayermp = getCommandSenderAsPlayer(par1ICommandSender);
        entityplayermp.attackEntityFrom(DamageSource.outOfWorld, 1000);
        par1ICommandSender.sendChatToPlayer("Ouch. That looks like it hurt.");
    }
}
