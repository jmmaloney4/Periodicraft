package net.minecraft.command;

import net.minecraft.command.CommandException;

public class NumberInvalidException extends CommandException {

   public NumberInvalidException() {
      this("commands.generic.num.invalid", new Object[0]);
   }

   public NumberInvalidException(String p_i3255_1_, Object ... p_i3255_2_) {
      super(p_i3255_1_, p_i3255_2_);
   }
}
