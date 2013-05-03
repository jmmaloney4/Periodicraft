package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GLAllocation {

   private static final Map field_74531_a = new HashMap();
   private static final List field_74530_b = new ArrayList();


   public static synchronized int func_74526_a(int p_74526_0_) {
      int var1 = GL11.glGenLists(p_74526_0_);
      field_74531_a.put(Integer.valueOf(var1), Integer.valueOf(p_74526_0_));
      return var1;
   }

   public static synchronized int func_74528_a() {
      int var0 = GL11.glGenTextures();
      field_74530_b.add(Integer.valueOf(var0));
      return var0;
   }

   public static synchronized void func_74523_b(int p_74523_0_) {
      GL11.glDeleteLists(p_74523_0_, ((Integer)field_74531_a.remove(Integer.valueOf(p_74523_0_))).intValue());
   }

   public static synchronized void func_98302_b() {
      for(int var0 = 0; var0 < field_74530_b.size(); ++var0) {
         GL11.glDeleteTextures(((Integer)field_74530_b.get(var0)).intValue());
      }

      field_74530_b.clear();
   }

   public static synchronized void func_74525_a() {
      Iterator var0 = field_74531_a.entrySet().iterator();

      while(var0.hasNext()) {
         Entry var1 = (Entry)var0.next();
         GL11.glDeleteLists(((Integer)var1.getKey()).intValue(), ((Integer)var1.getValue()).intValue());
      }

      field_74531_a.clear();
      func_98302_b();
   }

   public static synchronized ByteBuffer func_74524_c(int p_74524_0_) {
      return ByteBuffer.allocateDirect(p_74524_0_).order(ByteOrder.nativeOrder());
   }

   public static IntBuffer func_74527_f(int p_74527_0_) {
      return func_74524_c(p_74527_0_ << 2).asIntBuffer();
   }

   public static FloatBuffer func_74529_h(int p_74529_0_) {
      return func_74524_c(p_74529_0_ << 2).asFloatBuffer();
   }

}
