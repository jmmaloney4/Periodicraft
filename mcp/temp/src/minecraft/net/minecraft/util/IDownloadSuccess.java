package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;

@SideOnly(Side.CLIENT)
public interface IDownloadSuccess {

   void func_76170_a(File var1);
}
