package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagByteArray;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagEnd;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.nbt.NBTTagShort;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ReportedException;

public abstract class NBTBase {

   public static final String[] field_82578_b = new String[]{"END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST", "COMPOUND", "INT[]"};
   private String field_74741_a;


   abstract void func_74734_a(DataOutput var1) throws IOException;

   abstract void func_74735_a(DataInput var1) throws IOException;

   public abstract byte func_74732_a();

   protected NBTBase(String p_i3281_1_) {
      if(p_i3281_1_ == null) {
         this.field_74741_a = "";
      } else {
         this.field_74741_a = p_i3281_1_;
      }

   }

   public NBTBase func_74738_o(String p_74738_1_) {
      if(p_74738_1_ == null) {
         this.field_74741_a = "";
      } else {
         this.field_74741_a = p_74738_1_;
      }

      return this;
   }

   public String func_74740_e() {
      return this.field_74741_a == null?"":this.field_74741_a;
   }

   public static NBTBase func_74739_b(DataInput p_74739_0_) throws IOException {
      byte var1 = p_74739_0_.readByte();
      if(var1 == 0) {
         return new NBTTagEnd();
      } else {
         String var2 = p_74739_0_.readUTF();
         NBTBase var3 = func_74733_a(var1, var2);

         try {
            var3.func_74735_a(p_74739_0_);
            return var3;
         } catch (IOException var7) {
            CrashReport var5 = CrashReport.func_85055_a(var7, "Loading NBT data");
            CrashReportCategory var6 = var5.func_85058_a("NBT Tag");
            var6.func_71507_a("Tag name", var2);
            var6.func_71507_a("Tag type", Byte.valueOf(var1));
            throw new ReportedException(var5);
         }
      }
   }

   public static void func_74731_a(NBTBase p_74731_0_, DataOutput p_74731_1_) throws IOException {
      p_74731_1_.writeByte(p_74731_0_.func_74732_a());
      if(p_74731_0_.func_74732_a() != 0) {
         p_74731_1_.writeUTF(p_74731_0_.func_74740_e());
         p_74731_0_.func_74734_a(p_74731_1_);
      }
   }

   public static NBTBase func_74733_a(byte p_74733_0_, String p_74733_1_) {
      switch(p_74733_0_) {
      case 0:
         return new NBTTagEnd();
      case 1:
         return new NBTTagByte(p_74733_1_);
      case 2:
         return new NBTTagShort(p_74733_1_);
      case 3:
         return new NBTTagInt(p_74733_1_);
      case 4:
         return new NBTTagLong(p_74733_1_);
      case 5:
         return new NBTTagFloat(p_74733_1_);
      case 6:
         return new NBTTagDouble(p_74733_1_);
      case 7:
         return new NBTTagByteArray(p_74733_1_);
      case 8:
         return new NBTTagString(p_74733_1_);
      case 9:
         return new NBTTagList(p_74733_1_);
      case 10:
         return new NBTTagCompound(p_74733_1_);
      case 11:
         return new NBTTagIntArray(p_74733_1_);
      default:
         return null;
      }
   }

   public static String func_74736_a(byte p_74736_0_) {
      switch(p_74736_0_) {
      case 0:
         return "TAG_End";
      case 1:
         return "TAG_Byte";
      case 2:
         return "TAG_Short";
      case 3:
         return "TAG_Int";
      case 4:
         return "TAG_Long";
      case 5:
         return "TAG_Float";
      case 6:
         return "TAG_Double";
      case 7:
         return "TAG_Byte_Array";
      case 8:
         return "TAG_String";
      case 9:
         return "TAG_List";
      case 10:
         return "TAG_Compound";
      case 11:
         return "TAG_Int_Array";
      default:
         return "UNKNOWN";
      }
   }

   public abstract NBTBase func_74737_b();

   public boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof NBTBase)) {
         return false;
      } else {
         NBTBase var2 = (NBTBase)p_equals_1_;
         return this.func_74732_a() != var2.func_74732_a()?false:((this.field_74741_a != null || var2.field_74741_a == null) && (this.field_74741_a == null || var2.field_74741_a != null)?this.field_74741_a == null || this.field_74741_a.equals(var2.field_74741_a):false);
      }
   }

   public int hashCode() {
      return this.field_74741_a.hashCode() ^ this.func_74732_a();
   }

}
