package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.StringUtils;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntitySkullRenderer extends TileEntitySpecialRenderer {

   public static TileEntitySkullRenderer field_82397_a;
   private ModelSkeletonHead field_82396_c = new ModelSkeletonHead(0, 0, 64, 32);
   private ModelSkeletonHead field_82395_d = new ModelSkeletonHead(0, 0, 64, 64);


   public void func_82394_a(TileEntitySkull p_82394_1_, double p_82394_2_, double p_82394_4_, double p_82394_6_, float p_82394_8_) {
      this.func_82393_a((float)p_82394_2_, (float)p_82394_4_, (float)p_82394_6_, p_82394_1_.func_70322_n() & 7, (float)(p_82394_1_.func_82119_b() * 360) / 16.0F, p_82394_1_.func_82117_a(), p_82394_1_.func_82120_c());
   }

   public void func_76893_a(TileEntityRenderer p_76893_1_) {
      super.func_76893_a(p_76893_1_);
      field_82397_a = this;
   }

   public void func_82393_a(float p_82393_1_, float p_82393_2_, float p_82393_3_, int p_82393_4_, float p_82393_5_, int p_82393_6_, String p_82393_7_) {
      ModelSkeletonHead var8 = this.field_82396_c;
      switch(p_82393_6_) {
      case 0:
      default:
         this.func_76897_a("/mob/skeleton.png");
         break;
      case 1:
         this.func_76897_a("/mob/skeleton_wither.png");
         break;
      case 2:
         this.func_76897_a("/mob/zombie.png");
         var8 = this.field_82395_d;
         break;
      case 3:
         if(p_82393_7_ != null && p_82393_7_.length() > 0) {
            String var9 = "http://skins.minecraft.net/MinecraftSkins/" + StringUtils.func_76338_a(p_82393_7_) + ".png";
            if(!field_82397_a.field_76898_b.field_76960_e.func_82773_c(var9)) {
               field_82397_a.field_76898_b.field_76960_e.func_78356_a(var9, new ImageBufferDownload());
            }

            this.func_82392_a(var9, "/mob/char.png");
         } else {
            this.func_76897_a("/mob/char.png");
         }
         break;
      case 4:
         this.func_76897_a("/mob/creeper.png");
      }

      GL11.glPushMatrix();
      GL11.glDisable(2884);
      if(p_82393_4_ != 1) {
         switch(p_82393_4_) {
         case 2:
            GL11.glTranslatef(p_82393_1_ + 0.5F, p_82393_2_ + 0.25F, p_82393_3_ + 0.74F);
            break;
         case 3:
            GL11.glTranslatef(p_82393_1_ + 0.5F, p_82393_2_ + 0.25F, p_82393_3_ + 0.26F);
            p_82393_5_ = 180.0F;
            break;
         case 4:
            GL11.glTranslatef(p_82393_1_ + 0.74F, p_82393_2_ + 0.25F, p_82393_3_ + 0.5F);
            p_82393_5_ = 270.0F;
            break;
         case 5:
         default:
            GL11.glTranslatef(p_82393_1_ + 0.26F, p_82393_2_ + 0.25F, p_82393_3_ + 0.5F);
            p_82393_5_ = 90.0F;
         }
      } else {
         GL11.glTranslatef(p_82393_1_ + 0.5F, p_82393_2_, p_82393_3_ + 0.5F);
      }

      float var10 = 0.0625F;
      GL11.glEnable('\u803a');
      GL11.glScalef(-1.0F, -1.0F, 1.0F);
      GL11.glEnable(3008);
      var8.func_78088_a((Entity)null, 0.0F, 0.0F, 0.0F, p_82393_5_, 0.0F, var10);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, float p_76894_8_) {
      this.func_82394_a((TileEntitySkull)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
   }
}
