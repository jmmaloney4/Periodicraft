package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.world.World;

class StructureStrongholdStart extends StructureStart
{
    public StructureStrongholdStart(World par1World, Random par2Random, int par3, int par4)
    {
        StructureStrongholdPieces.prepareStructurePieces();
        ComponentStrongholdStairs2 componentstrongholdstairs2 = new ComponentStrongholdStairs2(0, par2Random, (par3 << 4) + 2, (par4 << 4) + 2);
        this.components.add(componentstrongholdstairs2);
        componentstrongholdstairs2.buildComponent(componentstrongholdstairs2, this.components, par2Random);
        ArrayList arraylist = componentstrongholdstairs2.field_75026_c;

        while (!arraylist.isEmpty())
        {
            int k = par2Random.nextInt(arraylist.size());
            StructureComponent structurecomponent = (StructureComponent)arraylist.remove(k);
            structurecomponent.buildComponent(componentstrongholdstairs2, this.components, par2Random);
        }

        this.updateBoundingBox();
        this.markAvailableHeight(par1World, par2Random, 10);
    }
}
