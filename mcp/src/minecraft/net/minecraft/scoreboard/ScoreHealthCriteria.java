package net.minecraft.scoreboard;

import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

public class ScoreHealthCriteria extends ScoreDummyCriteria
{
    public ScoreHealthCriteria(String par1Str)
    {
        super(par1Str);
    }

    public int func_96635_a(List par1List)
    {
        float f = 0.0F;
        int i;
        float f1;

        for (Iterator iterator = par1List.iterator(); iterator.hasNext(); f += (float)i / f1)
        {
            EntityPlayer entityplayer = (EntityPlayer)iterator.next();
            i = entityplayer.getHealth();
            f1 = (float)entityplayer.getMaxHealth();

            if (i < 0)
            {
                i = 0;
            }

            if ((float)i > f1)
            {
                i = entityplayer.getMaxHealth();
            }
        }

        if (par1List.size() > 0)
        {
            f /= (float)par1List.size();
        }

        return MathHelper.floor_float(f * 19.0F) + (f > 0.0F ? 1 : 0);
    }

    public boolean isReadOnly()
    {
        return true;
    }
}
