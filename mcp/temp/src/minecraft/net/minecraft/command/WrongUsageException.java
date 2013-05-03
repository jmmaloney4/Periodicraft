package net.minecraft.command;

import net.minecraft.command.SyntaxErrorException;

public class WrongUsageException extends SyntaxErrorException {

   public WrongUsageException(String p_i3259_1_, Object ... p_i3259_2_) {
      super(p_i3259_1_, p_i3259_2_);
   }
}
