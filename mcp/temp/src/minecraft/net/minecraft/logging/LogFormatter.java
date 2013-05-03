package net.minecraft.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import net.minecraft.logging.LogAgent;
import net.minecraft.logging.LogAgentINNER1;

class LogFormatter extends Formatter {

   private SimpleDateFormat field_98228_b;
   // $FF: synthetic field
   final LogAgent field_98229_a;


   private LogFormatter(LogAgent p_i11034_1_) {
      this.field_98229_a = p_i11034_1_;
      this.field_98228_b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   }

   public String format(LogRecord p_format_1_) {
      StringBuilder var2 = new StringBuilder();
      var2.append(this.field_98228_b.format(Long.valueOf(p_format_1_.getMillis())));
      if(LogAgent.func_98237_a(this.field_98229_a) != null) {
         var2.append(LogAgent.func_98237_a(this.field_98229_a));
      }

      var2.append(" [").append(p_format_1_.getLevel().getName()).append("] ");
      var2.append(this.formatMessage(p_format_1_));
      var2.append('\n');
      Throwable var3 = p_format_1_.getThrown();
      if(var3 != null) {
         StringWriter var4 = new StringWriter();
         var3.printStackTrace(new PrintWriter(var4));
         var2.append(var4.toString());
      }

      return var2.toString();
   }

   // $FF: synthetic method
   LogFormatter(LogAgent p_i11035_1_, LogAgentINNER1 p_i11035_2_) {
      this(p_i11035_1_);
   }
}
