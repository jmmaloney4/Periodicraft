package net.minecraft.server.management;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class LowerStringMap implements Map {

   private final Map field_76117_a = new LinkedHashMap();


   public int size() {
      return this.field_76117_a.size();
   }

   public boolean isEmpty() {
      return this.field_76117_a.isEmpty();
   }

   public boolean containsKey(Object p_containsKey_1_) {
      return this.field_76117_a.containsKey(p_containsKey_1_.toString().toLowerCase());
   }

   public boolean containsValue(Object p_containsValue_1_) {
      return this.field_76117_a.containsKey(p_containsValue_1_);
   }

   public Object get(Object p_get_1_) {
      return this.field_76117_a.get(p_get_1_.toString().toLowerCase());
   }

   public Object func_76116_a(String p_76116_1_, Object p_76116_2_) {
      return this.field_76117_a.put(p_76116_1_.toLowerCase(), p_76116_2_);
   }

   public Object remove(Object p_remove_1_) {
      return this.field_76117_a.remove(p_remove_1_.toString().toLowerCase());
   }

   public void putAll(Map p_putAll_1_) {
      Iterator var2 = p_putAll_1_.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.func_76116_a((String)var3.getKey(), var3.getValue());
      }

   }

   public void clear() {
      this.field_76117_a.clear();
   }

   public Set keySet() {
      return this.field_76117_a.keySet();
   }

   public Collection values() {
      return this.field_76117_a.values();
   }

   public Set entrySet() {
      return this.field_76117_a.entrySet();
   }

   // $FF: synthetic method
   public Object put(Object p_put_1_, Object p_put_2_) {
      return this.func_76116_a((String)p_put_1_, p_put_2_);
   }
}
