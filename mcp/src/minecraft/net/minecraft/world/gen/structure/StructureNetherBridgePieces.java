package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;

public class StructureNetherBridgePieces
{
    private static final StructureNetherBridgePieceWeight[] primaryComponents = new StructureNetherBridgePieceWeight[] {new StructureNetherBridgePieceWeight(ComponentNetherBridgeStraight.class, 30, 0, true), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCrossing3.class, 10, 4), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCrossing.class, 10, 4), new StructureNetherBridgePieceWeight(ComponentNetherBridgeStairs.class, 10, 3), new StructureNetherBridgePieceWeight(ComponentNetherBridgeThrone.class, 5, 2), new StructureNetherBridgePieceWeight(ComponentNetherBridgeEntrance.class, 5, 1)};
    private static final StructureNetherBridgePieceWeight[] secondaryComponents = new StructureNetherBridgePieceWeight[] {new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor5.class, 25, 0, true), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCrossing2.class, 15, 5), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor2.class, 5, 10), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor.class, 5, 10), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor3.class, 10, 3, true), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor4.class, 7, 2), new StructureNetherBridgePieceWeight(ComponentNetherBridgeNetherStalkRoom.class, 5, 2)};

    private static ComponentNetherBridgePiece createNextComponentRandom(StructureNetherBridgePieceWeight par0StructureNetherBridgePieceWeight, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        Class oclass = par0StructureNetherBridgePieceWeight.weightClass;
        Object object = null;

        if (oclass == ComponentNetherBridgeStraight.class)
        {
            object = ComponentNetherBridgeStraight.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (oclass == ComponentNetherBridgeCrossing3.class)
        {
            object = ComponentNetherBridgeCrossing3.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (oclass == ComponentNetherBridgeCrossing.class)
        {
            object = ComponentNetherBridgeCrossing.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (oclass == ComponentNetherBridgeStairs.class)
        {
            object = ComponentNetherBridgeStairs.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (oclass == ComponentNetherBridgeThrone.class)
        {
            object = ComponentNetherBridgeThrone.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (oclass == ComponentNetherBridgeEntrance.class)
        {
            object = ComponentNetherBridgeEntrance.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (oclass == ComponentNetherBridgeCorridor5.class)
        {
            object = ComponentNetherBridgeCorridor5.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (oclass == ComponentNetherBridgeCorridor2.class)
        {
            object = ComponentNetherBridgeCorridor2.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (oclass == ComponentNetherBridgeCorridor.class)
        {
            object = ComponentNetherBridgeCorridor.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (oclass == ComponentNetherBridgeCorridor3.class)
        {
            object = ComponentNetherBridgeCorridor3.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (oclass == ComponentNetherBridgeCorridor4.class)
        {
            object = ComponentNetherBridgeCorridor4.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (oclass == ComponentNetherBridgeCrossing2.class)
        {
            object = ComponentNetherBridgeCrossing2.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (oclass == ComponentNetherBridgeNetherStalkRoom.class)
        {
            object = ComponentNetherBridgeNetherStalkRoom.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }

        return (ComponentNetherBridgePiece)object;
    }

    static ComponentNetherBridgePiece createNextComponent(StructureNetherBridgePieceWeight par0StructureNetherBridgePieceWeight, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        return createNextComponentRandom(par0StructureNetherBridgePieceWeight, par1List, par2Random, par3, par4, par5, par6, par7);
    }

    static StructureNetherBridgePieceWeight[] getPrimaryComponents()
    {
        return primaryComponents;
    }

    static StructureNetherBridgePieceWeight[] getSecondaryComponents()
    {
        return secondaryComponents;
    }
}
