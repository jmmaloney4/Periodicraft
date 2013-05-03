package net.minecraft.command;

import net.minecraft.command.CommandException;

public class CommandNotFoundException extends CommandException {

   public CommandNotFoundException() {
      this("commands.generic.notFound", new Object[0]);
   }

   public CommandNotFoundException(String p_i3258_1_, Object ... p_i3258_2_) {
      super(p_i3258_1_, p_i3258_2_);
   }
}
