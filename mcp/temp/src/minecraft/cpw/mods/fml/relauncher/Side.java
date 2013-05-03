package cpw.mods.fml.relauncher;


public enum Side {

   CLIENT("CLIENT", 0),
   SERVER("SERVER", 1),
   BUKKIT("BUKKIT", 2);
   // $FF: synthetic field
   private static final Side[] $VALUES = new Side[]{CLIENT, SERVER, BUKKIT};


   private Side(String var1, int var2) {}

   public boolean isServer() {
      return !this.isClient();
   }

   public boolean isClient() {
      return this == CLIENT;
   }

}
