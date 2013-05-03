package net.minecraft.client.texturepacks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import net.minecraft.client.texturepacks.TexturePackCustom;
import net.minecraft.client.texturepacks.TexturePackList;
import net.minecraft.util.IDownloadSuccess;

@SideOnly(Side.CLIENT)
class TexturePackDownloadSuccess implements IDownloadSuccess {

   // $FF: synthetic field
   final TexturePackList field_76171_a;


   TexturePackDownloadSuccess(TexturePackList p_i3024_1_) {
      this.field_76171_a = p_i3024_1_;
   }

   public void func_76170_a(File p_76170_1_) {
      if(TexturePackList.func_77301_a(this.field_76171_a)) {
         TexturePackList.func_77303_a(this.field_76171_a, new TexturePackCustom(TexturePackList.func_77291_a(this.field_76171_a, p_76170_1_), p_76170_1_, TexturePackList.func_98143_h()));
         TexturePackList.func_77306_b(this.field_76171_a).func_71395_y();
      }
   }
}
