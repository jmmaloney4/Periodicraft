package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;
import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

@SideOnly(Side.CLIENT)
public class RenderBiped extends RenderLiving
{
    protected ModelBiped modelBipedMain;
    protected float field_77070_b;
    protected ModelBiped field_82423_g;
    protected ModelBiped field_82425_h;

    /** List of armor texture filenames. */
    public static String[] bipedArmorFilenamePrefix = new String[] {"cloth", "chain", "iron", "diamond", "gold"};

    public RenderBiped(ModelBiped par1ModelBiped, float par2)
    {
        this(par1ModelBiped, par2, 1.0F);
    }

    public RenderBiped(ModelBiped par1ModelBiped, float par2, float par3)
    {
        super(par1ModelBiped, par2);
        this.modelBipedMain = par1ModelBiped;
        this.field_77070_b = par3;
        this.func_82421_b();
    }

    protected void func_82421_b()
    {
        this.field_82423_g = new ModelBiped(1.0F);
        this.field_82425_h = new ModelBiped(0.5F);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        ItemStack itemstack = par1EntityLiving.getCurrentArmor(3 - par2);

        if (itemstack != null)
        {
            Item item = itemstack.getItem();

            if (item instanceof ItemArmor)
            {
                ItemArmor itemarmor = (ItemArmor)item;
                this.loadTexture(ForgeHooksClient.getArmorTexture(par1EntityLiving, itemstack, "/armor/" + bipedArmorFilenamePrefix[itemarmor.renderIndex] + "_" + (par2 == 2 ? 2 : 1) + ".png", par2, 1));
                ModelBiped modelbiped = par2 == 2 ? this.field_82425_h : this.field_82423_g;
                modelbiped.bipedHead.showModel = par2 == 0;
                modelbiped.bipedHeadwear.showModel = par2 == 0;
                modelbiped.bipedBody.showModel = par2 == 1 || par2 == 2;
                modelbiped.bipedRightArm.showModel = par2 == 1;
                modelbiped.bipedLeftArm.showModel = par2 == 1;
                modelbiped.bipedRightLeg.showModel = par2 == 2 || par2 == 3;
                modelbiped.bipedLeftLeg.showModel = par2 == 2 || par2 == 3;
                modelbiped = ForgeHooksClient.getArmorModel(par1EntityLiving, itemstack, par2, modelbiped);
                this.setRenderPassModel(modelbiped);

                if (modelbiped != null)
                {
                    modelbiped.onGround = this.mainModel.onGround;
                }

                if (modelbiped != null)
                {
                    modelbiped.isRiding = this.mainModel.isRiding;
                }

                if (modelbiped != null)
                {
                    modelbiped.isChild = this.mainModel.isChild;
                }

                float f1 = 1.0F;

                //Move out of if to allow for more then just CLOTH to have color
                int j = itemarmor.getColor(itemstack);
                if (j != -1)
                {
                    float f2 = (float)(j >> 16 & 255) / 255.0F;
                    float f3 = (float)(j >> 8 & 255) / 255.0F;
                    float f4 = (float)(j & 255) / 255.0F;
                    GL11.glColor3f(f1 * f2, f1 * f3, f1 * f4);

                    if (itemstack.isItemEnchanted())
                    {
                        return 31;
                    }

                    return 16;
                }

                GL11.glColor3f(f1, f1, f1);

                if (itemstack.isItemEnchanted())
                {
                    return 15;
                }

                return 1;
            }
        }

        return -1;
    }

    protected void func_82408_c(EntityLiving par1EntityLiving, int par2, float par3)
    {
        ItemStack itemstack = par1EntityLiving.getCurrentArmor(3 - par2);

        if (itemstack != null)
        {
            Item item = itemstack.getItem();

            if (item instanceof ItemArmor)
            {
                ItemArmor itemarmor = (ItemArmor)item;
                this.loadTexture(ForgeHooksClient.getArmorTexture(par1EntityLiving, itemstack, "/armor/" + bipedArmorFilenamePrefix[itemarmor.renderIndex] + "_" + (par2 == 2 ? 2 : 1) + "_b.png", par2, 2));
                float f1 = 1.0F;
                GL11.glColor3f(f1, f1, f1);
            }
        }
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        float f2 = 1.0F;
        GL11.glColor3f(f2, f2, f2);
        ItemStack itemstack = par1EntityLiving.getHeldItem();
        this.func_82420_a(par1EntityLiving, itemstack);
        double d3 = par4 - (double)par1EntityLiving.yOffset;

        if (par1EntityLiving.isSneaking() && !(par1EntityLiving instanceof EntityPlayerSP))
        {
            d3 -= 0.125D;
        }

        super.doRenderLiving(par1EntityLiving, par2, d3, par6, par8, par9);
        this.field_82423_g.aimedBow = this.field_82425_h.aimedBow = this.modelBipedMain.aimedBow = false;
        this.field_82423_g.isSneak = this.field_82425_h.isSneak = this.modelBipedMain.isSneak = false;
        this.field_82423_g.heldItemRight = this.field_82425_h.heldItemRight = this.modelBipedMain.heldItemRight = 0;
    }

    protected void func_82420_a(EntityLiving par1EntityLiving, ItemStack par2ItemStack)
    {
        this.field_82423_g.heldItemRight = this.field_82425_h.heldItemRight = this.modelBipedMain.heldItemRight = par2ItemStack != null ? 1 : 0;
        this.field_82423_g.isSneak = this.field_82425_h.isSneak = this.modelBipedMain.isSneak = par1EntityLiving.isSneaking();
    }

    protected void renderEquippedItems(EntityLiving par1EntityLiving, float par2)
    {
        float f1 = 1.0F;
        GL11.glColor3f(f1, f1, f1);
        super.renderEquippedItems(par1EntityLiving, par2);
        ItemStack itemstack = par1EntityLiving.getHeldItem();
        ItemStack itemstack1 = par1EntityLiving.getCurrentArmor(3);
        float f2;

        if (itemstack1 != null)
        {
            GL11.glPushMatrix();
            this.modelBipedMain.bipedHead.postRender(0.0625F);

            IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack1, EQUIPPED);
            boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, itemstack1, BLOCK_3D));

            if (itemstack1.getItem() instanceof ItemBlock)
            {
                if (is3D || RenderBlocks.renderItemIn3d(Block.blocksList[itemstack1.itemID].getRenderType()))
                {
                    f2 = 0.625F;
                    GL11.glTranslatef(0.0F, -0.25F, 0.0F);
                    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glScalef(f2, -f2, -f2);
                }

                this.renderManager.itemRenderer.renderItem(par1EntityLiving, itemstack1, 0);
            }
            else if (itemstack1.getItem().itemID == Item.skull.itemID)
            {
                f2 = 1.0625F;
                GL11.glScalef(f2, -f2, -f2);
                String s = "";

                if (itemstack1.hasTagCompound() && itemstack1.getTagCompound().hasKey("SkullOwner"))
                {
                    s = itemstack1.getTagCompound().getString("SkullOwner");
                }

                TileEntitySkullRenderer.skullRenderer.func_82393_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack1.getItemDamage(), s);
            }

            GL11.glPopMatrix();
        }

        if (itemstack != null)
        {
            GL11.glPushMatrix();

            if (this.mainModel.isChild)
            {
                f2 = 0.5F;
                GL11.glTranslatef(0.0F, 0.625F, 0.0F);
                GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
                GL11.glScalef(f2, f2, f2);
            }

            this.modelBipedMain.bipedRightArm.postRender(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

            IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, EQUIPPED);
            boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, itemstack, BLOCK_3D));

            if (itemstack.getItem() instanceof ItemBlock && (is3D || RenderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType())))
            {
                f2 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                f2 *= 0.75F;
                GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(-f2, -f2, f2);
            }
            else if (itemstack.itemID == Item.bow.itemID)
            {
                f2 = 0.625F;
                GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
                GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            }
            else if (Item.itemsList[itemstack.itemID].isFull3D())
            {
                f2 = 0.625F;

                if (Item.itemsList[itemstack.itemID].shouldRotateAroundWhenRendering())
                {
                    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(0.0F, -0.125F, 0.0F);
                }

                this.func_82422_c();
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            }
            else
            {
                f2 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(f2, f2, f2);
                GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
            }

            this.renderManager.itemRenderer.renderItem(par1EntityLiving, itemstack, 0);

            if (itemstack.getItem().requiresMultipleRenderPasses())
            {
                for (int x = 1; x < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); x++)
                {
                    this.renderManager.itemRenderer.renderItem(par1EntityLiving, itemstack, x);
                }
            }

            GL11.glPopMatrix();
        }
    }

    protected void func_82422_c()
    {
        GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRenderLiving((EntityLiving)par1Entity, par2, par4, par6, par8, par9);
    }
}
