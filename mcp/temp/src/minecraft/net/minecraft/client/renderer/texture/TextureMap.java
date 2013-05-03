package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.StitcherException;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.StitchHolder;
import net.minecraft.client.renderer.texture.StitchSlot;
import net.minecraft.client.renderer.texture.Stitcher;
import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureStitched;
import net.minecraft.client.texturepacks.ITexturePack;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

@SideOnly(Side.CLIENT)
public class TextureMap implements IconRegister {

   public final int field_94255_a;
   public final String field_94253_b;
   public final String field_94254_c;
   public final String field_94251_d;
   private final HashMap field_94252_e = new HashMap();
   private BufferedImage field_94249_f = new BufferedImage(64, 64, 2);
   private TextureStitched field_94250_g;
   private Texture field_94257_h;
   private final List field_94258_i = new ArrayList();
   private final Map field_94256_j = new HashMap();


   public TextureMap(int p_i9011_1_, String p_i9011_2_, String p_i9011_3_, BufferedImage p_i9011_4_) {
      this.field_94255_a = p_i9011_1_;
      this.field_94253_b = p_i9011_2_;
      this.field_94254_c = p_i9011_3_;
      this.field_94251_d = ".png";
      this.field_94249_f = p_i9011_4_;
   }

   public void func_94247_b() {
      this.field_94256_j.clear();
      int var2;
      int var3;
      if(this.field_94255_a == 0) {
         Block[] var1 = Block.field_71973_m;
         var2 = var1.length;

         for(var3 = 0; var3 < var2; ++var3) {
            Block var4 = var1[var3];
            if(var4 != null) {
               var4.func_94332_a(this);
            }
         }

         Minecraft.func_71410_x().field_71438_f.func_94140_a(this);
         RenderManager.field_78727_a.func_94178_a(this);
      }

      Item[] var19 = Item.field_77698_e;
      var2 = var19.length;

      for(var3 = 0; var3 < var2; ++var3) {
         Item var22 = var19[var3];
         if(var22 != null && var22.func_94901_k() == this.field_94255_a) {
            var22.func_94581_a(this);
         }
      }

      HashMap var20 = new HashMap();
      Stitcher var21 = TextureManager.func_94267_b().func_94262_d(this.field_94253_b);
      this.field_94252_e.clear();
      this.field_94258_i.clear();
      Texture var23 = TextureManager.func_94267_b().func_94261_a("missingno", 2, this.field_94249_f.getWidth(), this.field_94249_f.getHeight(), 10496, 6408, 9728, 9728, false, this.field_94249_f);
      StitchHolder var24 = new StitchHolder(var23);
      var21.func_94312_a(var24);
      var20.put(var24, Arrays.asList(new Texture[]{var23}));
      Iterator var5 = this.field_94256_j.keySet().iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();
         String var7 = this.field_94254_c + var6 + this.field_94251_d;
         List var8 = TextureManager.func_94267_b().func_94266_e(var7);
         if(!var8.isEmpty()) {
            StitchHolder var9 = new StitchHolder((Texture)var8.get(0));
            var21.func_94312_a(var9);
            var20.put(var9, var8);
         }
      }

      try {
         var21.func_94305_f();
      } catch (StitcherException var18) {
         throw var18;
      }

      this.field_94257_h = var21.func_94306_e();
      var5 = var21.func_94309_g().iterator();

      while(var5.hasNext()) {
         StitchSlot var26 = (StitchSlot)var5.next();
         StitchHolder var27 = var26.func_94183_a();
         Texture var28 = var27.func_98150_a();
         String var29 = var28.func_94280_f();
         List var10 = (List)var20.get(var27);
         TextureStitched var11 = (TextureStitched)this.field_94256_j.get(var29);
         boolean var12 = false;
         if(var11 == null) {
            var12 = true;
            var11 = TextureStitched.func_94220_a(var29);
            if(!var29.equals("missingno")) {
               Minecraft.func_71410_x().func_98033_al().func_98236_b("Couldn\'t find premade icon for " + var29 + " doing " + this.field_94253_b);
            }
         }

         var11.func_94218_a(this.field_94257_h, var10, var26.func_94186_b(), var26.func_94185_c(), var27.func_98150_a().func_94275_d(), var27.func_98150_a().func_94276_e(), var27.func_94195_e());
         this.field_94252_e.put(var29, var11);
         if(!var12) {
            this.field_94256_j.remove(var29);
         }

         if(var10.size() > 1) {
            this.field_94258_i.add(var11);
            String var13 = this.field_94254_c + var29 + ".txt";
            ITexturePack var14 = Minecraft.func_71410_x().field_71418_C.func_77292_e();
            boolean var15 = !var14.func_98138_b("/" + this.field_94254_c + var29 + ".png", false);

            try {
               InputStream var16 = var14.func_98137_a("/" + var13, var15);
               Minecraft.func_71410_x().func_98033_al().func_98233_a("Found animation info for: " + var13);
               var11.func_94221_a(new BufferedReader(new InputStreamReader(var16)));
            } catch (IOException var17) {
               ;
            }
         }
      }

      this.field_94250_g = (TextureStitched)this.field_94252_e.get("missingno");
      var5 = this.field_94256_j.values().iterator();

      while(var5.hasNext()) {
         TextureStitched var25 = (TextureStitched)var5.next();
         var25.func_94217_a(this.field_94250_g);
      }

      this.field_94257_h.func_94279_c("debug.stitched_" + this.field_94253_b + ".png");
      this.field_94257_h.func_94285_g();
   }

   public void func_94248_c() {
      Iterator var1 = this.field_94258_i.iterator();

      while(var1.hasNext()) {
         TextureStitched var2 = (TextureStitched)var1.next();
         var2.func_94219_l();
      }

   }

   public Texture func_94246_d() {
      return this.field_94257_h;
   }

   public Icon func_94245_a(String p_94245_1_) {
      if(p_94245_1_ == null) {
         (new RuntimeException("Don\'t register null!")).printStackTrace();
      }

      TextureStitched var2 = (TextureStitched)this.field_94256_j.get(p_94245_1_);
      if(var2 == null) {
         var2 = TextureStitched.func_94220_a(p_94245_1_);
         this.field_94256_j.put(p_94245_1_, var2);
      }

      return var2;
   }

   public Icon func_96455_e() {
      return this.field_94250_g;
   }
}
