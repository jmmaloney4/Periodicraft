package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.StringUtils;

@SideOnly(Side.CLIENT)
public class ChatClickData {

   public static final Pattern field_78316_a = Pattern.compile("^(?:(https?)://)?([-\\w_\\.]{2,}\\.[a-z]{2,4})(/\\S*)?$");
   private final FontRenderer field_78314_b;
   private final ChatLine field_78315_c;
   private final int field_78312_d;
   private final int field_78313_e;
   private final String field_78310_f;
   private final String field_78311_g;


   public ChatClickData(FontRenderer p_i3053_1_, ChatLine p_i3053_2_, int p_i3053_3_, int p_i3053_4_) {
      this.field_78314_b = p_i3053_1_;
      this.field_78315_c = p_i3053_2_;
      this.field_78312_d = p_i3053_3_;
      this.field_78313_e = p_i3053_4_;
      this.field_78310_f = p_i3053_1_.func_78269_a(p_i3053_2_.func_74538_a(), p_i3053_3_);
      this.field_78311_g = this.func_78307_h();
   }

   public String func_78309_f() {
      return this.field_78311_g;
   }

   public URI func_78308_g() {
      String var1 = this.func_78309_f();
      if(var1 == null) {
         return null;
      } else {
         Matcher var2 = field_78316_a.matcher(var1);
         if(var2.matches()) {
            try {
               String var3 = var2.group(0);
               if(var2.group(1) == null) {
                  var3 = "http://" + var3;
               }

               return new URI(var3);
            } catch (URISyntaxException var4) {
               Minecraft.func_71410_x().func_98033_al().func_98234_c("Couldn\'t create URI from chat", var4);
            }
         }

         return null;
      }
   }

   private String func_78307_h() {
      int var1 = this.field_78310_f.lastIndexOf(" ", this.field_78310_f.length()) + 1;
      if(var1 < 0) {
         var1 = 0;
      }

      int var2 = this.field_78315_c.func_74538_a().indexOf(" ", var1);
      if(var2 < 0) {
         var2 = this.field_78315_c.func_74538_a().length();
      }

      return StringUtils.func_76338_a(this.field_78315_c.func_74538_a().substring(var1, var2));
   }

}
