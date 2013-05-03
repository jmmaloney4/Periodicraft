package net.minecraft.command;

import net.minecraft.command.CommandException;

public class SyntaxErrorException extends CommandException {

   public SyntaxErrorException() {
      this("commands.generic.snytax", new Object[0]);
   }

   public SyntaxErrorException(String p_i3256_1_, Object ... p_i3256_2_) {
      super(p_i3256_1_, p_i3256_2_);
   }
}
