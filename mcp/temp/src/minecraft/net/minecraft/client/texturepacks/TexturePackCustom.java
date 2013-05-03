package net.minecraft.client.texturepacks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.client.texturepacks.ITexturePack;
import net.minecraft.client.texturepacks.TexturePackImplementation;

@SideOnly(Side.CLIENT)
public class TexturePackCustom extends TexturePackImplementation {

   private ZipFile field_77550_e;


   public TexturePackCustom(String p_i11002_1_, File p_i11002_2_, ITexturePack p_i11002_3_) {
      super(p_i11002_1_, p_i11002_2_, p_i11002_2_.getName(), p_i11002_3_);
   }

   public void func_77533_a(RenderEngine p_77533_1_) {
      super.func_77533_a(p_77533_1_);

      try {
         if(this.field_77550_e != null) {
            this.field_77550_e.close();
         }
      } catch (IOException var3) {
         ;
      }

      this.field_77550_e = null;
   }

   protected InputStream func_98139_b(String p_98139_1_) throws IOException {
      this.func_77549_g();
      ZipEntry var2 = this.field_77550_e.getEntry(p_98139_1_.substring(1));
      if(var2 == null) {
         throw new FileNotFoundException(p_98139_1_);
      } else {
         return this.field_77550_e.getInputStream(var2);
      }
   }

   public boolean func_98140_c(String p_98140_1_) {
      try {
         this.func_77549_g();
         return this.field_77550_e.getEntry(p_98140_1_.substring(1)) != null;
      } catch (Exception var3) {
         return false;
      }
   }

   private void func_77549_g() throws IOException, ZipException {
      if(this.field_77550_e == null) {
         this.field_77550_e = new ZipFile(this.field_77548_a);
      }
   }

   public boolean func_94179_g() {
      try {
         this.func_77549_g();
         Enumeration var1 = this.field_77550_e.entries();

         while(var1.hasMoreElements()) {
            ZipEntry var2 = (ZipEntry)var1.nextElement();
            if(var2.getName().startsWith("textures/")) {
               return true;
            }
         }
      } catch (Exception var3) {
         ;
      }

      boolean var4 = this.func_98140_c("terrain.png") || this.func_98140_c("gui/items.png");
      return !var4;
   }
}
