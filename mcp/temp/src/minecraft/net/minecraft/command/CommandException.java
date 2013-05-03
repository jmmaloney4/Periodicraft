package net.minecraft.command;


public class CommandException extends RuntimeException {

   private Object[] field_74845_a;


   public CommandException(String p_i3254_1_, Object ... p_i3254_2_) {
      super(p_i3254_1_);
      this.field_74845_a = p_i3254_2_;
   }

   public Object[] func_74844_a() {
      return this.field_74845_a;
   }
}
