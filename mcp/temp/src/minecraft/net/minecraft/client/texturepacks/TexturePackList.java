package net.minecraft.client.texturepacks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiProgress;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.texturepacks.ITexturePack;
import net.minecraft.client.texturepacks.TexturePackCustom;
import net.minecraft.client.texturepacks.TexturePackDefault;
import net.minecraft.client.texturepacks.TexturePackDownloadSuccess;
import net.minecraft.client.texturepacks.TexturePackFolder;
import net.minecraft.util.HttpUtil;

@SideOnly(Side.CLIENT)
public class TexturePackList {

   private static final ITexturePack field_77314_a = new TexturePackDefault();
   private final Minecraft field_77312_b;
   private final File field_77313_c;
   private final File field_77310_d;
   private List field_77311_e = new ArrayList();
   private Map field_77308_f = new HashMap();
   private ITexturePack field_77309_g;
   private boolean field_77315_h;


   public TexturePackList(File p_i3025_1_, Minecraft p_i3025_2_) {
      this.field_77312_b = p_i3025_2_;
      this.field_77313_c = new File(p_i3025_1_, "texturepacks");
      this.field_77310_d = new File(p_i3025_1_, "texturepacks-mp-cache");
      this.func_77307_h();
      this.func_77305_c();
   }

   private void func_77307_h() {
      if(!this.field_77313_c.isDirectory()) {
         this.field_77313_c.delete();
         this.field_77313_c.mkdirs();
      }

      if(!this.field_77310_d.isDirectory()) {
         this.field_77310_d.delete();
         this.field_77310_d.mkdirs();
      }

   }

   public boolean func_77294_a(ITexturePack p_77294_1_) {
      if(p_77294_1_ == this.field_77309_g) {
         return false;
      } else {
         this.field_77315_h = false;
         this.field_77309_g = p_77294_1_;
         this.field_77312_b.field_71474_y.field_74346_m = p_77294_1_.func_77538_c();
         this.field_77312_b.field_71474_y.func_74303_b();
         return true;
      }
   }

   public void func_77296_a(String p_77296_1_) {
      String var2 = p_77296_1_.substring(p_77296_1_.lastIndexOf("/") + 1);
      if(var2.contains("?")) {
         var2 = var2.substring(0, var2.indexOf("?"));
      }

      if(var2.endsWith(".zip")) {
         File var3 = new File(this.field_77310_d, var2);
         this.func_77297_a(p_77296_1_, var3);
      }
   }

   private void func_77297_a(String p_77297_1_, File p_77297_2_) {
      HashMap var3 = new HashMap();
      GuiProgress var4 = new GuiProgress();
      var3.put("X-Minecraft-Username", this.field_77312_b.field_71449_j.field_74286_b);
      var3.put("X-Minecraft-Version", "1.5.1");
      var3.put("X-Minecraft-Supported-Resolutions", "16");
      this.field_77315_h = true;
      this.field_77312_b.func_71373_a(var4);
      HttpUtil.func_76182_a(p_77297_2_, p_77297_1_, new TexturePackDownloadSuccess(this), var3, 10000000, var4);
   }

   public boolean func_77295_a() {
      return this.field_77315_h;
   }

   public void func_77304_b() {
      this.field_77315_h = false;
      this.func_77305_c();
      this.field_77312_b.func_71395_y();
   }

   public void func_77305_c() {
      ArrayList var1 = new ArrayList();
      this.field_77309_g = field_77314_a;
      var1.add(field_77314_a);
      Iterator var2 = this.func_77299_i().iterator();

      while(var2.hasNext()) {
         File var3 = (File)var2.next();
         String var4 = this.func_77302_a(var3);
         if(var4 != null) {
            Object var5 = (ITexturePack)this.field_77308_f.get(var4);
            if(var5 == null) {
               var5 = var3.isDirectory()?new TexturePackFolder(var4, var3, field_77314_a):new TexturePackCustom(var4, var3, field_77314_a);
               this.field_77308_f.put(var4, var5);
            }

            if(((ITexturePack)var5).func_77538_c().equals(this.field_77312_b.field_71474_y.field_74346_m)) {
               this.field_77309_g = (ITexturePack)var5;
            }

            var1.add(var5);
         }
      }

      this.field_77311_e.removeAll(var1);
      var2 = this.field_77311_e.iterator();

      while(var2.hasNext()) {
         ITexturePack var6 = (ITexturePack)var2.next();
         var6.func_77533_a(this.field_77312_b.field_71446_o);
         this.field_77308_f.remove(var6.func_77536_b());
      }

      this.field_77311_e = var1;
   }

   private String func_77302_a(File p_77302_1_) {
      return p_77302_1_.isFile() && p_77302_1_.getName().toLowerCase().endsWith(".zip")?p_77302_1_.getName() + ":" + p_77302_1_.length() + ":" + p_77302_1_.lastModified():(p_77302_1_.isDirectory() && (new File(p_77302_1_, "pack.txt")).exists()?p_77302_1_.getName() + ":folder:" + p_77302_1_.lastModified():null);
   }

   private List func_77299_i() {
      return this.field_77313_c.exists() && this.field_77313_c.isDirectory()?Arrays.asList(this.field_77313_c.listFiles()):Collections.emptyList();
   }

   public List func_77293_d() {
      return Collections.unmodifiableList(this.field_77311_e);
   }

   public ITexturePack func_77292_e() {
      return this.field_77309_g;
   }

   public boolean func_77300_f() {
      if(!this.field_77312_b.field_71474_y.field_74356_s) {
         return false;
      } else {
         ServerData var1 = this.field_77312_b.func_71362_z();
         return var1 == null?true:var1.func_78840_c();
      }
   }

   public boolean func_77298_g() {
      if(!this.field_77312_b.field_71474_y.field_74356_s) {
         return false;
      } else {
         ServerData var1 = this.field_77312_b.func_71362_z();
         return var1 == null?false:var1.func_78839_b();
      }
   }

   // $FF: synthetic method
   static boolean func_77301_a(TexturePackList p_77301_0_) {
      return p_77301_0_.field_77315_h;
   }

   // $FF: synthetic method
   static ITexturePack func_77303_a(TexturePackList p_77303_0_, ITexturePack p_77303_1_) {
      return p_77303_0_.field_77309_g = p_77303_1_;
   }

   // $FF: synthetic method
   static String func_77291_a(TexturePackList p_77291_0_, File p_77291_1_) {
      return p_77291_0_.func_77302_a(p_77291_1_);
   }

   // $FF: synthetic method
   static ITexturePack func_98143_h() {
      return field_77314_a;
   }

   // $FF: synthetic method
   static Minecraft func_77306_b(TexturePackList p_77306_0_) {
      return p_77306_0_.field_77312_b;
   }

}
