package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComponentNetherBridgeStartPiece extends ComponentNetherBridgeCrossing3
{
    /** Instance of StructureNetherBridgePieceWeight. */
    public StructureNetherBridgePieceWeight theNetherBridgePieceWeight;

    /**
     * Contains the list of valid piece weights for the set of nether bridge structure pieces.
     */
    public List primaryWeights = new ArrayList();

    /**
     * Contains the list of valid piece weights for the secondary set of nether bridge structure pieces.
     */
    public List secondaryWeights;
    public ArrayList field_74967_d = new ArrayList();

    public ComponentNetherBridgeStartPiece(Random par1Random, int par2, int par3)
    {
        super(par1Random, par2, par3);
        StructureNetherBridgePieceWeight[] astructurenetherbridgepieceweight = StructureNetherBridgePieces.getPrimaryComponents();
        int k = astructurenetherbridgepieceweight.length;
        int l;
        StructureNetherBridgePieceWeight structurenetherbridgepieceweight;

        for (l = 0; l < k; ++l)
        {
            structurenetherbridgepieceweight = astructurenetherbridgepieceweight[l];
            structurenetherbridgepieceweight.field_78827_c = 0;
            this.primaryWeights.add(structurenetherbridgepieceweight);
        }

        this.secondaryWeights = new ArrayList();
        astructurenetherbridgepieceweight = StructureNetherBridgePieces.getSecondaryComponents();
        k = astructurenetherbridgepieceweight.length;

        for (l = 0; l < k; ++l)
        {
            structurenetherbridgepieceweight = astructurenetherbridgepieceweight[l];
            structurenetherbridgepieceweight.field_78827_c = 0;
            this.secondaryWeights.add(structurenetherbridgepieceweight);
        }
    }
}
