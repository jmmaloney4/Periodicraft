package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureNetherBridgeStart;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenNetherBridge extends MapGenStructure {

   private List field_75060_e = new ArrayList();


   public MapGenNetherBridge() {
      this.field_75060_e.add(new SpawnListEntry(EntityBlaze.class, 10, 2, 3));
      this.field_75060_e.add(new SpawnListEntry(EntityPigZombie.class, 5, 4, 4));
      this.field_75060_e.add(new SpawnListEntry(EntitySkeleton.class, 10, 4, 4));
      this.field_75060_e.add(new SpawnListEntry(EntityMagmaCube.class, 3, 4, 4));
   }

   public List func_75059_a() {
      return this.field_75060_e;
   }

   protected boolean func_75047_a(int p_75047_1_, int p_75047_2_) {
      int var3 = p_75047_1_ >> 4;
      int var4 = p_75047_2_ >> 4;
      this.field_75038_b.setSeed((long)(var3 ^ var4 << 4) ^ this.field_75039_c.func_72905_C());
      this.field_75038_b.nextInt();
      return this.field_75038_b.nextInt(3) != 0?false:(p_75047_1_ != (var3 << 4) + 4 + this.field_75038_b.nextInt(8)?false:p_75047_2_ == (var4 << 4) + 4 + this.field_75038_b.nextInt(8));
   }

   protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_) {
      return new StructureNetherBridgeStart(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_);
   }
}
