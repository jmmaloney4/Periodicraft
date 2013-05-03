package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;

public class CommandEnchant extends CommandBase {

   public String func_71517_b() {
      return "enchant";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.enchant.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length < 2) {
         throw new WrongUsageException("commands.enchant.usage", new Object[0]);
      } else {
         EntityPlayerMP var3 = func_82359_c(p_71515_1_, p_71515_2_[0]);
         int var4 = func_71532_a(p_71515_1_, p_71515_2_[1], 0, Enchantment.field_77331_b.length - 1);
         int var5 = 1;
         ItemStack var6 = var3.func_71045_bC();
         if(var6 == null) {
            func_71522_a(p_71515_1_, "commands.enchant.noItem", new Object[0]);
         } else {
            Enchantment var7 = Enchantment.field_77331_b[var4];
            if(var7 == null) {
               throw new NumberInvalidException("commands.enchant.notFound", new Object[]{Integer.valueOf(var4)});
            } else if(!var7.func_92089_a(var6)) {
               func_71522_a(p_71515_1_, "commands.enchant.cantEnchant", new Object[0]);
            } else {
               if(p_71515_2_.length >= 3) {
                  var5 = func_71532_a(p_71515_1_, p_71515_2_[2], var7.func_77319_d(), var7.func_77325_b());
               }

               if(var6.func_77942_o()) {
                  NBTTagList var8 = var6.func_77986_q();
                  if(var8 != null) {
                     for(int var9 = 0; var9 < var8.func_74745_c(); ++var9) {
                        short var10 = ((NBTTagCompound)var8.func_74743_b(var9)).func_74765_d("id");
                        if(Enchantment.field_77331_b[var10] != null) {
                           Enchantment var11 = Enchantment.field_77331_b[var10];
                           if(!var11.func_77326_a(var7)) {
                              func_71522_a(p_71515_1_, "commands.enchant.cantCombine", new Object[]{var7.func_77316_c(var5), var11.func_77316_c(((NBTTagCompound)var8.func_74743_b(var9)).func_74765_d("lvl"))});
                              return;
                           }
                        }
                     }
                  }
               }

               var6.func_77966_a(var7, var5);
               func_71522_a(p_71515_1_, "commands.enchant.success", new Object[0]);
            }
         }
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 1?func_71530_a(p_71516_2_, this.func_90022_d()):null;
   }

   protected String[] func_90022_d() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
