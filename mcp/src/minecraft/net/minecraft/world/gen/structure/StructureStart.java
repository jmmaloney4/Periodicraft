package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import net.minecraft.world.World;

public abstract class StructureStart
{
    /** List of all StructureComponents that are part of this structure */
    protected LinkedList components = new LinkedList();
    protected StructureBoundingBox boundingBox;

    public StructureBoundingBox getBoundingBox()
    {
        return this.boundingBox;
    }

    public LinkedList getComponents()
    {
        return this.components;
    }

    /**
     * Keeps iterating Structure Pieces and spawning them until the checks tell it to stop
     */
    public void generateStructure(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
    {
        Iterator iterator = this.components.iterator();

        while (iterator.hasNext())
        {
            StructureComponent structurecomponent = (StructureComponent)iterator.next();

            if (structurecomponent.getBoundingBox().intersectsWith(par3StructureBoundingBox) && !structurecomponent.addComponentParts(par1World, par2Random, par3StructureBoundingBox))
            {
                iterator.remove();
            }
        }
    }

    /**
     * Calculates total bounding box based on components' bounding boxes and saves it to boundingBox
     */
    protected void updateBoundingBox()
    {
        this.boundingBox = StructureBoundingBox.getNewBoundingBox();
        Iterator iterator = this.components.iterator();

        while (iterator.hasNext())
        {
            StructureComponent structurecomponent = (StructureComponent)iterator.next();
            this.boundingBox.expandTo(structurecomponent.getBoundingBox());
        }
    }

    /**
     * offsets the structure Bounding Boxes up to a certain height, typically 63 - 10
     */
    protected void markAvailableHeight(World par1World, Random par2Random, int par3)
    {
        int j = 63 - par3;
        int k = this.boundingBox.getYSize() + 1;

        if (k < j)
        {
            k += par2Random.nextInt(j - k);
        }

        int l = k - this.boundingBox.maxY;
        this.boundingBox.offset(0, l, 0);
        Iterator iterator = this.components.iterator();

        while (iterator.hasNext())
        {
            StructureComponent structurecomponent = (StructureComponent)iterator.next();
            structurecomponent.getBoundingBox().offset(0, l, 0);
        }
    }

    protected void setRandomHeight(World par1World, Random par2Random, int par3, int par4)
    {
        int k = par4 - par3 + 1 - this.boundingBox.getYSize();
        boolean flag = true;
        int l;

        if (k > 1)
        {
            l = par3 + par2Random.nextInt(k);
        }
        else
        {
            l = par3;
        }

        int i1 = l - this.boundingBox.minY;
        this.boundingBox.offset(0, i1, 0);
        Iterator iterator = this.components.iterator();

        while (iterator.hasNext())
        {
            StructureComponent structurecomponent = (StructureComponent)iterator.next();
            structurecomponent.getBoundingBox().offset(0, i1, 0);
        }
    }

    /**
     * currently only defined for Villages, returns true if Village has more than 2 non-road components
     */
    public boolean isSizeableStructure()
    {
        return true;
    }
}
