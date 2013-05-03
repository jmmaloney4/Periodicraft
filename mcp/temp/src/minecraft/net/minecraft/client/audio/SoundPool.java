package net.minecraft.client.audio;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.client.audio.SoundPoolEntry;

@SideOnly(Side.CLIENT)
public class SoundPool {

   private Random field_77464_c = new Random();
   private Map field_77461_d = new HashMap();
   private List field_77462_e = new ArrayList();
   public int field_77465_a = 0;
   public boolean field_77463_b = true;


   public SoundPoolEntry func_77459_a(String p_77459_1_, File p_77459_2_) {
      try {
         String var3 = p_77459_1_;
         p_77459_1_ = p_77459_1_.substring(0, p_77459_1_.indexOf("."));
         if(this.field_77463_b) {
            while(Character.isDigit(p_77459_1_.charAt(p_77459_1_.length() - 1))) {
               p_77459_1_ = p_77459_1_.substring(0, p_77459_1_.length() - 1);
            }
         }

         p_77459_1_ = p_77459_1_.replaceAll("/", ".");
         if(!this.field_77461_d.containsKey(p_77459_1_)) {
            this.field_77461_d.put(p_77459_1_, new ArrayList());
         }

         SoundPoolEntry var4 = new SoundPoolEntry(var3, p_77459_2_.toURI().toURL());
         ((List)this.field_77461_d.get(p_77459_1_)).add(var4);
         this.field_77462_e.add(var4);
         ++this.field_77465_a;
         return var4;
      } catch (MalformedURLException var5) {
         var5.printStackTrace();
         throw new RuntimeException(var5);
      }
   }

   public SoundPoolEntry func_77458_a(String p_77458_1_) {
      List var2 = (List)this.field_77461_d.get(p_77458_1_);
      return var2 == null?null:(SoundPoolEntry)var2.get(this.field_77464_c.nextInt(var2.size()));
   }

   public SoundPoolEntry func_77460_a() {
      return this.field_77462_e.isEmpty()?null:(SoundPoolEntry)this.field_77462_e.get(this.field_77464_c.nextInt(this.field_77462_e.size()));
   }
}
