package net.minecraft.client.texturepacks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import net.minecraft.client.texturepacks.ITexturePack;
import net.minecraft.client.texturepacks.TexturePackImplementation;

@SideOnly(Side.CLIENT)
public class TexturePackDefault extends TexturePackImplementation {

   public TexturePackDefault() {
      super("default", (File)null, "Default", (ITexturePack)null);
   }

   protected void func_77540_a() {
      this.field_77546_b = "The default look of Minecraft";
   }

   public boolean func_98140_c(String p_98140_1_) {
      return TexturePackDefault.class.getResourceAsStream(p_98140_1_) != null;
   }

   public boolean func_94179_g() {
      return true;
   }

   protected InputStream func_98139_b(String p_98139_1_) throws IOException {
      InputStream var2 = TexturePackDefault.class.getResourceAsStream(p_98139_1_);
      if(var2 == null) {
         throw new FileNotFoundException(p_98139_1_);
      } else {
         return var2;
      }
   }
}
