package net.minecraft.world;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.GameRuleValue;

public class GameRules {

   private TreeMap field_82771_a = new TreeMap();


   public GameRules() {
      this.func_82769_a("doFireTick", "true");
      this.func_82769_a("mobGriefing", "true");
      this.func_82769_a("keepInventory", "false");
      this.func_82769_a("doMobSpawning", "true");
      this.func_82769_a("doMobLoot", "true");
      this.func_82769_a("doTileDrops", "true");
      this.func_82769_a("commandBlockOutput", "true");
   }

   public void func_82769_a(String p_82769_1_, String p_82769_2_) {
      this.field_82771_a.put(p_82769_1_, new GameRuleValue(p_82769_2_));
   }

   public void func_82764_b(String p_82764_1_, String p_82764_2_) {
      GameRuleValue var3 = (GameRuleValue)this.field_82771_a.get(p_82764_1_);
      if(var3 != null) {
         var3.func_82757_a(p_82764_2_);
      } else {
         this.func_82769_a(p_82764_1_, p_82764_2_);
      }

   }

   public String func_82767_a(String p_82767_1_) {
      GameRuleValue var2 = (GameRuleValue)this.field_82771_a.get(p_82767_1_);
      return var2 != null?var2.func_82756_a():"";
   }

   public boolean func_82766_b(String p_82766_1_) {
      GameRuleValue var2 = (GameRuleValue)this.field_82771_a.get(p_82766_1_);
      return var2 != null?var2.func_82758_b():false;
   }

   public NBTTagCompound func_82770_a() {
      NBTTagCompound var1 = new NBTTagCompound("GameRules");
      Iterator var2 = this.field_82771_a.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         GameRuleValue var4 = (GameRuleValue)this.field_82771_a.get(var3);
         var1.func_74778_a(var3, var4.func_82756_a());
      }

      return var1;
   }

   public void func_82768_a(NBTTagCompound p_82768_1_) {
      Collection var2 = p_82768_1_.func_74758_c();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         NBTBase var4 = (NBTBase)var3.next();
         String var5 = var4.func_74740_e();
         String var6 = p_82768_1_.func_74779_i(var4.func_74740_e());
         this.func_82764_b(var5, var6);
      }

   }

   public String[] func_82763_b() {
      return (String[])this.field_82771_a.keySet().toArray(new String[0]);
   }

   public boolean func_82765_e(String p_82765_1_) {
      return this.field_82771_a.containsKey(p_82765_1_);
   }
}
