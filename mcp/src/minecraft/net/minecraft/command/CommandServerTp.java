package net.minecraft.command;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandServerTp extends CommandBase
{
    public String getCommandName()
    {
        return "tp";
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.tp.usage", new Object[0]);
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        if (par2ArrayOfStr.length < 1)
        {
            throw new WrongUsageException("commands.tp.usage", new Object[0]);
        }
        else
        {
            EntityPlayerMP entityplayermp;

            if (par2ArrayOfStr.length != 2 && par2ArrayOfStr.length != 4)
            {
                entityplayermp = getCommandSenderAsPlayer(par1ICommandSender);
            }
            else
            {
                entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[0]);

                if (entityplayermp == null)
                {
                    throw new PlayerNotFoundException();
                }
            }

            if (par2ArrayOfStr.length != 3 && par2ArrayOfStr.length != 4)
            {
                if (par2ArrayOfStr.length == 1 || par2ArrayOfStr.length == 2)
                {
                    EntityPlayerMP entityplayermp1 = func_82359_c(par1ICommandSender, par2ArrayOfStr[par2ArrayOfStr.length - 1]);

                    if (entityplayermp1 == null)
                    {
                        throw new PlayerNotFoundException();
                    }

                    if (entityplayermp1.worldObj != entityplayermp.worldObj)
                    {
                        notifyAdmins(par1ICommandSender, "commands.tp.notSameDimension", new Object[0]);
                        return;
                    }

                    entityplayermp.mountEntity((Entity)null);
                    entityplayermp.playerNetServerHandler.setPlayerLocation(entityplayermp1.posX, entityplayermp1.posY, entityplayermp1.posZ, entityplayermp1.rotationYaw, entityplayermp1.rotationPitch);
                    notifyAdmins(par1ICommandSender, "commands.tp.success", new Object[] {entityplayermp.getEntityName(), entityplayermp1.getEntityName()});
                }
            }
            else if (entityplayermp.worldObj != null)
            {
                int i = par2ArrayOfStr.length - 3;
                double d0 = this.func_82368_a(par1ICommandSender, entityplayermp.posX, par2ArrayOfStr[i++]);
                double d1 = this.func_82367_a(par1ICommandSender, entityplayermp.posY, par2ArrayOfStr[i++], 0, 0);
                double d2 = this.func_82368_a(par1ICommandSender, entityplayermp.posZ, par2ArrayOfStr[i++]);
                entityplayermp.mountEntity((Entity)null);
                entityplayermp.setPositionAndUpdate(d0, d1, d2);
                notifyAdmins(par1ICommandSender, "commands.tp.success.coordinates", new Object[] {entityplayermp.getEntityName(), Double.valueOf(d0), Double.valueOf(d1), Double.valueOf(d2)});
            }
        }
    }

    private double func_82368_a(ICommandSender par1ICommandSender, double par2, String par4Str)
    {
        return this.func_82367_a(par1ICommandSender, par2, par4Str, -30000000, 30000000);
    }

    private double func_82367_a(ICommandSender par1ICommandSender, double par2, String par4Str, int par5, int par6)
    {
        boolean flag = par4Str.startsWith("~");
        double d1 = flag ? par2 : 0.0D;

        if (!flag || par4Str.length() > 1)
        {
            boolean flag1 = par4Str.contains(".");

            if (flag)
            {
                par4Str = par4Str.substring(1);
            }

            d1 += func_82363_b(par1ICommandSender, par4Str);

            if (!flag1 && !flag)
            {
                d1 += 0.5D;
            }
        }

        if (par5 != 0 || par6 != 0)
        {
            if (d1 < (double)par5)
            {
                throw new NumberInvalidException("commands.generic.double.tooSmall", new Object[] {Double.valueOf(d1), Integer.valueOf(par5)});
            }

            if (d1 > (double)par6)
            {
                throw new NumberInvalidException("commands.generic.double.tooBig", new Object[] {Double.valueOf(d1), Integer.valueOf(par6)});
            }
        }

        return d1;
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        return par2ArrayOfStr.length != 1 && par2ArrayOfStr.length != 2 ? null : getListOfStringsMatchingLastWord(par2ArrayOfStr, MinecraftServer.getServer().getAllUsernames());
    }

    /**
     * Return whether the specified command parameter index is a username parameter.
     */
    public boolean isUsernameIndex(String[] par1ArrayOfStr, int par2)
    {
        return par2 == 0;
    }
}
