package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import net.minecraft.scoreboard.ScorePlayerTeam;

public class Packet209SetPlayerTeam extends Packet
{
    /** A unique name for the team. */
    public String teamName = "";

    /** Only if mode = 0 or 2. */
    public String teamDisplayName = "";

    /**
     * Only if mode = 0 or 2. Displayed before the players' name that are part of this team.
     */
    public String teamPrefix = "";

    /**
     * Only if mode = 0 or 2. Displayed after the players' name that are part of this team.
     */
    public String teamSuffix = "";

    /** Only if mode = 0 or 3 or 4. Players to be added/remove from the team. */
    public Collection playerNames = new ArrayList();

    /**
     * If 0 then the team is created. If 1 then the team is removed. If 2 the team team information is updated. If 3
     * then new players are added to the team. If 4 then players are removed from the team.
     */
    public int mode = 0;

    /** Only if mode = 0 or 2. */
    public int friendlyFire;

    public Packet209SetPlayerTeam() {}

    public Packet209SetPlayerTeam(ScorePlayerTeam par1, int par2)
    {
        this.teamName = par1.func_96661_b();
        this.mode = par2;

        if (par2 == 0 || par2 == 2)
        {
            this.teamDisplayName = par1.func_96669_c();
            this.teamPrefix = par1.func_96668_e();
            this.teamSuffix = par1.func_96663_f();
            this.friendlyFire = par1.func_98299_i();
        }

        if (par2 == 0)
        {
            this.playerNames.addAll(par1.func_96670_d());
        }
    }

    public Packet209SetPlayerTeam(ScorePlayerTeam par1, Collection par2, int par3)
    {
        if (par3 != 3 && par3 != 4)
        {
            throw new IllegalArgumentException("Method must be join or leave for player constructor");
        }
        else if (par2 != null && !par2.isEmpty())
        {
            this.mode = par3;
            this.teamName = par1.func_96661_b();
            this.playerNames.addAll(par2);
        }
        else
        {
            throw new IllegalArgumentException("Players cannot be null/empty");
        }
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        this.teamName = readString(par1DataInputStream, 16);
        this.mode = par1DataInputStream.readByte();

        if (this.mode == 0 || this.mode == 2)
        {
            this.teamDisplayName = readString(par1DataInputStream, 32);
            this.teamPrefix = readString(par1DataInputStream, 16);
            this.teamSuffix = readString(par1DataInputStream, 16);
            this.friendlyFire = par1DataInputStream.readByte();
        }

        if (this.mode == 0 || this.mode == 3 || this.mode == 4)
        {
            short short1 = par1DataInputStream.readShort();

            for (int i = 0; i < short1; ++i)
            {
                this.playerNames.add(readString(par1DataInputStream, 16));
            }
        }
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        writeString(this.teamName, par1DataOutputStream);
        par1DataOutputStream.writeByte(this.mode);

        if (this.mode == 0 || this.mode == 2)
        {
            writeString(this.teamDisplayName, par1DataOutputStream);
            writeString(this.teamPrefix, par1DataOutputStream);
            writeString(this.teamSuffix, par1DataOutputStream);
            par1DataOutputStream.writeByte(this.friendlyFire);
        }

        if (this.mode == 0 || this.mode == 3 || this.mode == 4)
        {
            par1DataOutputStream.writeShort(this.playerNames.size());
            Iterator iterator = this.playerNames.iterator();

            while (iterator.hasNext())
            {
                String s = (String)iterator.next();
                writeString(s, par1DataOutputStream);
            }
        }
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleSetPlayerTeam(this);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 3 + this.teamName.length();
    }
}
