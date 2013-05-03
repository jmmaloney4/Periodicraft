package net.minecraft.command;

import net.minecraft.util.ChunkCoordinates;

public interface ICommandSender
{
    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    String getCommandSenderName();

    void sendChatToPlayer(String s);

    /**
     * Returns true if the command sender is allowed to use the given command.
     */
    boolean canCommandSenderUseCommand(int i, String s);

    /**
     * Translates and formats the given string key with the given arguments.
     */
    String translateString(String s, Object ... var2);

    /**
     * Return the position for this command sender.
     */
    ChunkCoordinates getPlayerCoordinates();
}
