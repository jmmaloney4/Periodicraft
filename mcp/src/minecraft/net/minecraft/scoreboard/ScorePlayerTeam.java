package net.minecraft.scoreboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ScorePlayerTeam
{
    private final Scoreboard field_96677_a;
    private final String field_96675_b;
    private final Set field_96676_c = new HashSet();
    private String field_96673_d;
    private String field_96674_e = "";
    private String field_96671_f = "";
    private boolean field_96672_g = true;
    private boolean field_98301_h = true;

    public ScorePlayerTeam(Scoreboard par1Scoreboard, String par2Str)
    {
        this.field_96677_a = par1Scoreboard;
        this.field_96675_b = par2Str;
        this.field_96673_d = par2Str;
    }

    public String func_96661_b()
    {
        return this.field_96675_b;
    }

    public String func_96669_c()
    {
        return this.field_96673_d;
    }

    public void func_96664_a(String par1Str)
    {
        if (par1Str == null)
        {
            throw new IllegalArgumentException("Name cannot be null");
        }
        else
        {
            this.field_96673_d = par1Str;
            this.field_96677_a.func_96538_b(this);
        }
    }

    public Collection func_96670_d()
    {
        return this.field_96676_c;
    }

    public String func_96668_e()
    {
        return this.field_96674_e;
    }

    public void func_96666_b(String par1Str)
    {
        if (par1Str == null)
        {
            throw new IllegalArgumentException("Prefix cannot be null");
        }
        else
        {
            this.field_96674_e = par1Str;
            this.field_96677_a.func_96538_b(this);
        }
    }

    public String func_96663_f()
    {
        return this.field_96671_f;
    }

    public void func_96662_c(String par1Str)
    {
        if (par1Str == null)
        {
            throw new IllegalArgumentException("Suffix cannot be null");
        }
        else
        {
            this.field_96671_f = par1Str;
            this.field_96677_a.func_96538_b(this);
        }
    }

    public static String func_96667_a(ScorePlayerTeam par0ScorePlayerTeam, String par1Str)
    {
        return par0ScorePlayerTeam == null ? par1Str : par0ScorePlayerTeam.func_96668_e() + par1Str + par0ScorePlayerTeam.func_96663_f();
    }

    public boolean func_96665_g()
    {
        return this.field_96672_g;
    }

    public void func_96660_a(boolean par1)
    {
        this.field_96672_g = par1;
        this.field_96677_a.func_96538_b(this);
    }

    public boolean func_98297_h()
    {
        return this.field_98301_h;
    }

    public void func_98300_b(boolean par1)
    {
        this.field_98301_h = par1;
        this.field_96677_a.func_96538_b(this);
    }

    public int func_98299_i()
    {
        int i = 0;
        int j = 0;

        if (this.func_96665_g())
        {
            i |= 1 << j++;
        }

        if (this.func_98297_h())
        {
            i |= 1 << j++;
        }

        return i;
    }

    @SideOnly(Side.CLIENT)
    public void func_98298_a(int par1)
    {
        byte b0 = 0;
        int j = b0 + 1;
        this.func_96660_a((par1 & 1 << b0) > 0);
        this.func_98300_b((par1 & 1 << j++) > 0);
    }
}
