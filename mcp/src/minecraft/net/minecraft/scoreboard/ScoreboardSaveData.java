package net.minecraft.scoreboard;

import java.util.Collection;
import java.util.Iterator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldSavedData;

public class ScoreboardSaveData extends WorldSavedData
{
    private Scoreboard field_96507_a;
    private NBTTagCompound field_96506_b;

    public ScoreboardSaveData()
    {
        this("scoreboard");
    }

    public ScoreboardSaveData(String par1Str)
    {
        super(par1Str);
    }

    public void func_96499_a(Scoreboard par1Scoreboard)
    {
        this.field_96507_a = par1Scoreboard;

        if (this.field_96506_b != null)
        {
            this.readFromNBT(this.field_96506_b);
        }
    }

    /**
     * reads in data from the NBTTagCompound into this MapDataBase
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        if (this.field_96507_a == null)
        {
            this.field_96506_b = par1NBTTagCompound;
        }
        else
        {
            this.func_96501_b(par1NBTTagCompound.getTagList("Objectives"));
            this.func_96500_c(par1NBTTagCompound.getTagList("PlayerScores"));

            if (par1NBTTagCompound.hasKey("DisplaySlots"))
            {
                this.func_96504_c(par1NBTTagCompound.getCompoundTag("DisplaySlots"));
            }

            if (par1NBTTagCompound.hasKey("Teams"))
            {
                this.func_96498_a(par1NBTTagCompound.getTagList("Teams"));
            }
        }
    }

    protected void func_96498_a(NBTTagList par1NBTTagList)
    {
        for (int i = 0; i < par1NBTTagList.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)par1NBTTagList.tagAt(i);
            ScorePlayerTeam scoreplayerteam = this.field_96507_a.func_96527_f(nbttagcompound.getString("Name"));
            scoreplayerteam.func_96664_a(nbttagcompound.getString("DisplayName"));
            scoreplayerteam.func_96666_b(nbttagcompound.getString("Prefix"));
            scoreplayerteam.func_96662_c(nbttagcompound.getString("Suffix"));

            if (nbttagcompound.hasKey("AllowFriendlyFire"))
            {
                scoreplayerteam.func_96660_a(nbttagcompound.getBoolean("AllowFriendlyFire"));
            }

            if (nbttagcompound.hasKey("SeeFriendlyInvisibles"))
            {
                scoreplayerteam.func_98300_b(nbttagcompound.getBoolean("SeeFriendlyInvisibles"));
            }

            this.func_96502_a(scoreplayerteam, nbttagcompound.getTagList("Players"));
        }
    }

    protected void func_96502_a(ScorePlayerTeam par1ScorePlayerTeam, NBTTagList par2NBTTagList)
    {
        for (int i = 0; i < par2NBTTagList.tagCount(); ++i)
        {
            this.field_96507_a.func_96521_a(((NBTTagString)par2NBTTagList.tagAt(i)).data, par1ScorePlayerTeam);
        }
    }

    protected void func_96504_c(NBTTagCompound par1NBTTagCompound)
    {
        for (int i = 0; i < 3; ++i)
        {
            if (par1NBTTagCompound.hasKey("slot_" + i))
            {
                String s = par1NBTTagCompound.getString("slot_" + i);
                ScoreObjective scoreobjective = this.field_96507_a.getObjective(s);
                this.field_96507_a.func_96530_a(i, scoreobjective);
            }
        }
    }

    protected void func_96501_b(NBTTagList par1NBTTagList)
    {
        for (int i = 0; i < par1NBTTagList.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)par1NBTTagList.tagAt(i);
            ScoreObjectiveCriteria scoreobjectivecriteria = (ScoreObjectiveCriteria)ScoreObjectiveCriteria.field_96643_a.get(nbttagcompound.getString("CriteriaName"));
            ScoreObjective scoreobjective = this.field_96507_a.func_96535_a(nbttagcompound.getString("Name"), scoreobjectivecriteria);
            scoreobjective.setDisplayName(nbttagcompound.getString("DisplayName"));
        }
    }

    protected void func_96500_c(NBTTagList par1NBTTagList)
    {
        for (int i = 0; i < par1NBTTagList.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)par1NBTTagList.tagAt(i);
            ScoreObjective scoreobjective = this.field_96507_a.getObjective(nbttagcompound.getString("Objective"));
            Score score = this.field_96507_a.func_96529_a(nbttagcompound.getString("Name"), scoreobjective);
            score.func_96647_c(nbttagcompound.getInteger("Score"));
        }
    }

    /**
     * write data to NBTTagCompound from this MapDataBase, similar to Entities and TileEntities
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        if (this.field_96507_a == null)
        {
            MinecraftServer.getServer().getLogAgent().logWarning("Tried to save scoreboard without having a scoreboard...");
        }
        else
        {
            par1NBTTagCompound.setTag("Objectives", this.func_96505_b());
            par1NBTTagCompound.setTag("PlayerScores", this.func_96503_e());
            par1NBTTagCompound.setTag("Teams", this.func_96496_a());
            this.func_96497_d(par1NBTTagCompound);
        }
    }

    protected NBTTagList func_96496_a()
    {
        NBTTagList nbttaglist = new NBTTagList();
        Collection collection = this.field_96507_a.func_96525_g();
        Iterator iterator = collection.iterator();

        while (iterator.hasNext())
        {
            ScorePlayerTeam scoreplayerteam = (ScorePlayerTeam)iterator.next();
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.setString("Name", scoreplayerteam.func_96661_b());
            nbttagcompound.setString("DisplayName", scoreplayerteam.func_96669_c());
            nbttagcompound.setString("Prefix", scoreplayerteam.func_96668_e());
            nbttagcompound.setString("Suffix", scoreplayerteam.func_96663_f());
            nbttagcompound.setBoolean("AllowFriendlyFire", scoreplayerteam.func_96665_g());
            nbttagcompound.setBoolean("SeeFriendlyInvisibles", scoreplayerteam.func_98297_h());
            NBTTagList nbttaglist1 = new NBTTagList();
            Iterator iterator1 = scoreplayerteam.func_96670_d().iterator();

            while (iterator1.hasNext())
            {
                String s = (String)iterator1.next();
                nbttaglist1.appendTag(new NBTTagString("", s));
            }

            nbttagcompound.setTag("Players", nbttaglist1);
            nbttaglist.appendTag(nbttagcompound);
        }

        return nbttaglist;
    }

    protected void func_96497_d(NBTTagCompound par1NBTTagCompound)
    {
        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
        boolean flag = false;

        for (int i = 0; i < 3; ++i)
        {
            ScoreObjective scoreobjective = this.field_96507_a.func_96539_a(i);

            if (scoreobjective != null)
            {
                nbttagcompound1.setString("slot_" + i, scoreobjective.getName());
                flag = true;
            }
        }

        if (flag)
        {
            par1NBTTagCompound.setCompoundTag("DisplaySlots", nbttagcompound1);
        }
    }

    protected NBTTagList func_96505_b()
    {
        NBTTagList nbttaglist = new NBTTagList();
        Collection collection = this.field_96507_a.getScoreObjectives();
        Iterator iterator = collection.iterator();

        while (iterator.hasNext())
        {
            ScoreObjective scoreobjective = (ScoreObjective)iterator.next();
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.setString("Name", scoreobjective.getName());
            nbttagcompound.setString("CriteriaName", scoreobjective.getCriteria().func_96636_a());
            nbttagcompound.setString("DisplayName", scoreobjective.getDisplayName());
            nbttaglist.appendTag(nbttagcompound);
        }

        return nbttaglist;
    }

    protected NBTTagList func_96503_e()
    {
        NBTTagList nbttaglist = new NBTTagList();
        Collection collection = this.field_96507_a.func_96528_e();
        Iterator iterator = collection.iterator();

        while (iterator.hasNext())
        {
            Score score = (Score)iterator.next();
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.setString("Name", score.func_96653_e());
            nbttagcompound.setString("Objective", score.func_96645_d().getName());
            nbttagcompound.setInteger("Score", score.func_96652_c());
            nbttaglist.appendTag(nbttagcompound);
        }

        return nbttaglist;
    }
}
