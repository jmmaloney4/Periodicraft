package net.minecraft.client.audio;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.minecraft.client.audio.CodecMus;
import net.minecraft.client.audio.ScheduledSound;
import net.minecraft.client.audio.SoundPool;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

@SideOnly(Side.CLIENT)
public class SoundManager {

   public static SoundSystem field_77381_a;
   public SoundPool field_77379_b = new SoundPool();
   public SoundPool field_77380_c = new SoundPool();
   public SoundPool field_77377_d = new SoundPool();
   private int field_77378_e = 0;
   private GameSettings field_77375_f;
   private Set field_82470_g = new HashSet();
   private List field_92072_h = new ArrayList();
   private static boolean field_77376_g = false;
   private Random field_77382_h = new Random();
   private int field_77383_i;


   public SoundManager() {
      this.field_77383_i = this.field_77382_h.nextInt(12000);
   }

   public void func_77373_a(GameSettings p_77373_1_) {
      this.field_77380_c.field_77463_b = false;
      this.field_77375_f = p_77373_1_;
      if(!field_77376_g && (p_77373_1_ == null || p_77373_1_.field_74340_b != 0.0F || p_77373_1_.field_74342_a != 0.0F)) {
         this.func_77363_d();
      }

   }

   private void func_77363_d() {
      try {
         float var1 = this.field_77375_f.field_74340_b;
         float var2 = this.field_77375_f.field_74342_a;
         this.field_77375_f.field_74340_b = 0.0F;
         this.field_77375_f.field_74342_a = 0.0F;
         this.field_77375_f.func_74303_b();
         SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
         SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);
         SoundSystemConfig.setCodec("mus", CodecMus.class);
         SoundSystemConfig.setCodec("wav", CodecWav.class);
         field_77381_a = new SoundSystem();
         this.field_77375_f.field_74340_b = var1;
         this.field_77375_f.field_74342_a = var2;
         this.field_77375_f.func_74303_b();
      } catch (Throwable var3) {
         var3.printStackTrace();
         System.err.println("error linking with the LibraryJavaSound plug-in");
      }

      field_77376_g = true;
   }

   public void func_77367_a() {
      if(!field_77376_g && (this.field_77375_f.field_74340_b != 0.0F || this.field_77375_f.field_74342_a != 0.0F)) {
         this.func_77363_d();
      }

      if(field_77376_g) {
         if(this.field_77375_f.field_74342_a == 0.0F) {
            field_77381_a.stop("BgMusic");
         } else {
            field_77381_a.setVolume("BgMusic", this.field_77375_f.field_74342_a);
         }
      }

   }

   public void func_77370_b() {
      if(field_77376_g) {
         field_77381_a.cleanup();
      }

   }

   public void func_77372_a(String p_77372_1_, File p_77372_2_) {
      this.field_77379_b.func_77459_a(p_77372_1_, p_77372_2_);
   }

   public void func_77374_b(String p_77374_1_, File p_77374_2_) {
      this.field_77380_c.func_77459_a(p_77374_1_, p_77374_2_);
   }

   public void func_77365_c(String p_77365_1_, File p_77365_2_) {
      this.field_77377_d.func_77459_a(p_77365_1_, p_77365_2_);
   }

   public void func_77371_c() {
      if(field_77376_g && this.field_77375_f.field_74342_a != 0.0F) {
         if(!field_77381_a.playing("BgMusic") && !field_77381_a.playing("streaming")) {
            if(this.field_77383_i > 0) {
               --this.field_77383_i;
               return;
            }

            SoundPoolEntry var1 = this.field_77377_d.func_77460_a();
            if(var1 != null) {
               this.field_77383_i = this.field_77382_h.nextInt(12000) + 12000;
               field_77381_a.backgroundMusic("BgMusic", var1.field_77384_b, var1.field_77385_a, false);
               field_77381_a.setVolume("BgMusic", this.field_77375_f.field_74342_a);
               field_77381_a.play("BgMusic");
            }
         }

      }
   }

   public void func_77369_a(EntityLiving p_77369_1_, float p_77369_2_) {
      if(field_77376_g && this.field_77375_f.field_74340_b != 0.0F) {
         if(p_77369_1_ != null) {
            float var3 = p_77369_1_.field_70127_C + (p_77369_1_.field_70125_A - p_77369_1_.field_70127_C) * p_77369_2_;
            float var4 = p_77369_1_.field_70126_B + (p_77369_1_.field_70177_z - p_77369_1_.field_70126_B) * p_77369_2_;
            double var5 = p_77369_1_.field_70169_q + (p_77369_1_.field_70165_t - p_77369_1_.field_70169_q) * (double)p_77369_2_;
            double var7 = p_77369_1_.field_70167_r + (p_77369_1_.field_70163_u - p_77369_1_.field_70167_r) * (double)p_77369_2_;
            double var9 = p_77369_1_.field_70166_s + (p_77369_1_.field_70161_v - p_77369_1_.field_70166_s) * (double)p_77369_2_;
            float var11 = MathHelper.func_76134_b(-var4 * 0.017453292F - 3.1415927F);
            float var12 = MathHelper.func_76126_a(-var4 * 0.017453292F - 3.1415927F);
            float var13 = -var12;
            float var14 = -MathHelper.func_76126_a(-var3 * 0.017453292F - 3.1415927F);
            float var15 = -var11;
            float var16 = 0.0F;
            float var17 = 1.0F;
            float var18 = 0.0F;
            field_77381_a.setListenerPosition((float)var5, (float)var7, (float)var9);
            field_77381_a.setListenerOrientation(var13, var14, var15, var16, var17, var18);
         }
      }
   }

   public void func_82464_d() {
      Iterator var1 = this.field_82470_g.iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         field_77381_a.stop(var2);
      }

      this.field_82470_g.clear();
   }

   public void func_77368_a(String p_77368_1_, float p_77368_2_, float p_77368_3_, float p_77368_4_) {
      if(field_77376_g && (this.field_77375_f.field_74340_b != 0.0F || p_77368_1_ == null)) {
         String var5 = "streaming";
         if(field_77381_a.playing(var5)) {
            field_77381_a.stop(var5);
         }

         if(p_77368_1_ != null) {
            SoundPoolEntry var6 = this.field_77380_c.func_77458_a(p_77368_1_);
            if(var6 != null) {
               if(field_77381_a.playing("BgMusic")) {
                  field_77381_a.stop("BgMusic");
               }

               float var7 = 16.0F;
               field_77381_a.newStreamingSource(true, var5, var6.field_77384_b, var6.field_77385_a, false, p_77368_2_, p_77368_3_, p_77368_4_, 2, var7 * 4.0F);
               field_77381_a.setVolume(var5, 0.5F * this.field_77375_f.field_74340_b);
               field_77381_a.play(var5);
            }

         }
      }
   }

   public void func_82460_a(Entity p_82460_1_) {
      this.func_82462_a(p_82460_1_, p_82460_1_);
   }

   public void func_82462_a(Entity p_82462_1_, Entity p_82462_2_) {
      String var3 = "entity_" + p_82462_1_.field_70157_k;
      if(this.field_82470_g.contains(var3)) {
         if(field_77381_a.playing(var3)) {
            field_77381_a.setPosition(var3, (float)p_82462_2_.field_70165_t, (float)p_82462_2_.field_70163_u, (float)p_82462_2_.field_70161_v);
            field_77381_a.setVelocity(var3, (float)p_82462_2_.field_70159_w, (float)p_82462_2_.field_70181_x, (float)p_82462_2_.field_70179_y);
         } else {
            this.field_82470_g.remove(var3);
         }
      }

   }

   public boolean func_82465_b(Entity p_82465_1_) {
      if(p_82465_1_ != null && field_77376_g) {
         String var2 = "entity_" + p_82465_1_.field_70157_k;
         return field_77381_a.playing(var2);
      } else {
         return false;
      }
   }

   public void func_82469_c(Entity p_82469_1_) {
      if(p_82469_1_ != null && field_77376_g) {
         String var2 = "entity_" + p_82469_1_.field_70157_k;
         if(this.field_82470_g.contains(var2)) {
            if(field_77381_a.playing(var2)) {
               field_77381_a.stop(var2);
            }

            this.field_82470_g.remove(var2);
         }

      }
   }

   public void func_82468_a(Entity p_82468_1_, float p_82468_2_) {
      if(p_82468_1_ != null && field_77376_g) {
         if(field_77376_g && this.field_77375_f.field_74340_b != 0.0F) {
            String var3 = "entity_" + p_82468_1_.field_70157_k;
            if(field_77381_a.playing(var3)) {
               field_77381_a.setVolume(var3, p_82468_2_ * this.field_77375_f.field_74340_b);
            }
         }
      }
   }

   public void func_82463_b(Entity p_82463_1_, float p_82463_2_) {
      if(p_82463_1_ != null && field_77376_g) {
         if(field_77376_g && this.field_77375_f.field_74340_b != 0.0F) {
            String var3 = "entity_" + p_82463_1_.field_70157_k;
            if(field_77381_a.playing(var3)) {
               field_77381_a.setPitch(var3, p_82463_2_);
            }
         }
      }
   }

   public void func_82467_a(String p_82467_1_, Entity p_82467_2_, float p_82467_3_, float p_82467_4_, boolean p_82467_5_) {
      if(p_82467_2_ != null) {
         if(field_77376_g && (this.field_77375_f.field_74340_b != 0.0F || p_82467_1_ == null)) {
            String var6 = "entity_" + p_82467_2_.field_70157_k;
            if(this.field_82470_g.contains(var6)) {
               this.func_82460_a(p_82467_2_);
            } else {
               if(field_77381_a.playing(var6)) {
                  field_77381_a.stop(var6);
               }

               if(p_82467_1_ == null) {
                  return;
               }

               SoundPoolEntry var7 = this.field_77379_b.func_77458_a(p_82467_1_);
               if(var7 != null && p_82467_3_ > 0.0F) {
                  float var8 = 16.0F;
                  if(p_82467_3_ > 1.0F) {
                     var8 *= p_82467_3_;
                  }

                  field_77381_a.newSource(p_82467_5_, var6, var7.field_77384_b, var7.field_77385_a, false, (float)p_82467_2_.field_70165_t, (float)p_82467_2_.field_70163_u, (float)p_82467_2_.field_70161_v, 2, var8);
                  field_77381_a.setLooping(var6, true);
                  field_77381_a.setPitch(var6, p_82467_4_);
                  if(p_82467_3_ > 1.0F) {
                     p_82467_3_ = 1.0F;
                  }

                  field_77381_a.setVolume(var6, p_82467_3_ * this.field_77375_f.field_74340_b);
                  field_77381_a.setVelocity(var6, (float)p_82467_2_.field_70159_w, (float)p_82467_2_.field_70181_x, (float)p_82467_2_.field_70179_y);
                  field_77381_a.play(var6);
                  this.field_82470_g.add(var6);
               }
            }

         }
      }
   }

   public void func_77364_b(String p_77364_1_, float p_77364_2_, float p_77364_3_, float p_77364_4_, float p_77364_5_, float p_77364_6_) {
      if(field_77376_g && this.field_77375_f.field_74340_b != 0.0F) {
         SoundPoolEntry var7 = this.field_77379_b.func_77458_a(p_77364_1_);
         if(var7 != null && p_77364_5_ > 0.0F) {
            this.field_77378_e = (this.field_77378_e + 1) % 256;
            String var8 = "sound_" + this.field_77378_e;
            float var9 = 16.0F;
            if(p_77364_5_ > 1.0F) {
               var9 *= p_77364_5_;
            }

            field_77381_a.newSource(p_77364_5_ > 1.0F, var8, var7.field_77384_b, var7.field_77385_a, false, p_77364_2_, p_77364_3_, p_77364_4_, 2, var9);
            field_77381_a.setPitch(var8, p_77364_6_);
            if(p_77364_5_ > 1.0F) {
               p_77364_5_ = 1.0F;
            }

            field_77381_a.setVolume(var8, p_77364_5_ * this.field_77375_f.field_74340_b);
            field_77381_a.play(var8);
         }

      }
   }

   public void func_77366_a(String p_77366_1_, float p_77366_2_, float p_77366_3_) {
      if(field_77376_g && this.field_77375_f.field_74340_b != 0.0F) {
         SoundPoolEntry var4 = this.field_77379_b.func_77458_a(p_77366_1_);
         if(var4 != null) {
            this.field_77378_e = (this.field_77378_e + 1) % 256;
            String var5 = "sound_" + this.field_77378_e;
            field_77381_a.newSource(false, var5, var4.field_77384_b, var4.field_77385_a, false, 0.0F, 0.0F, 0.0F, 0, 0.0F);
            if(p_77366_2_ > 1.0F) {
               p_77366_2_ = 1.0F;
            }

            p_77366_2_ *= 0.25F;
            field_77381_a.setPitch(var5, p_77366_3_);
            field_77381_a.setVolume(var5, p_77366_2_ * this.field_77375_f.field_74340_b);
            field_77381_a.play(var5);
         }

      }
   }

   public void func_82466_e() {
      Iterator var1 = this.field_82470_g.iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         field_77381_a.pause(var2);
      }

   }

   public void func_82461_f() {
      Iterator var1 = this.field_82470_g.iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         field_77381_a.play(var2);
      }

   }

   public void func_92071_g() {
      if(!this.field_92072_h.isEmpty()) {
         Iterator var1 = this.field_92072_h.iterator();

         while(var1.hasNext()) {
            ScheduledSound var2 = (ScheduledSound)var1.next();
            --var2.field_92064_g;
            if(var2.field_92064_g <= 0) {
               this.func_77364_b(var2.field_92069_a, var2.field_92067_b, var2.field_92068_c, var2.field_92065_d, var2.field_92066_e, var2.field_92063_f);
               var1.remove();
            }
         }
      }

   }

   public void func_92070_a(String p_92070_1_, float p_92070_2_, float p_92070_3_, float p_92070_4_, float p_92070_5_, float p_92070_6_, int p_92070_7_) {
      this.field_92072_h.add(new ScheduledSound(p_92070_1_, p_92070_2_, p_92070_3_, p_92070_4_, p_92070_5_, p_92070_6_, p_92070_7_));
   }

}
