package net.minecraft.world.storage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.AnvilConverterException;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;

public interface ISaveFormat {

   ISaveHandler func_75804_a(String var1, boolean var2);

   @SideOnly(Side.CLIENT)
   List func_75799_b() throws AnvilConverterException;

   void func_75800_d();

   @SideOnly(Side.CLIENT)
   WorldInfo func_75803_c(String var1);

   boolean func_75802_e(String var1);

   @SideOnly(Side.CLIENT)
   void func_75806_a(String var1, String var2);

   boolean func_75801_b(String var1);

   boolean func_75805_a(String var1, IProgressUpdate var2);

   @SideOnly(Side.CLIENT)
   boolean func_90033_f(String var1);
}
