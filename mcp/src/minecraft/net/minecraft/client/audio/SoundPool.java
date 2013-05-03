package net.minecraft.client.audio;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@SideOnly(Side.CLIENT)
public class SoundPool
{
    /** The RNG used by SoundPool. */
    private Random rand = new Random();

    /**
     * Maps a name (can be sound/newsound/streaming/music/newmusic) to a list of SoundPoolEntry's.
     */
    private Map nameToSoundPoolEntriesMapping = new HashMap();

    /** A list of all SoundPoolEntries that have been loaded. */
    private List allSoundPoolEntries = new ArrayList();

    /**
     * The number of soundPoolEntry's. This value is computed but never used (should be equal to
     * allSoundPoolEntries.size()).
     */
    public int numberOfSoundPoolEntries = 0;
    public boolean isGetRandomSound = true;

    /**
     * Adds a sound to this sound pool.
     */
    public SoundPoolEntry addSound(String par1Str, File par2File)
    {
        try 
        {
            return addSound(par1Str, par2File.toURI().toURL());
        }
        catch (MalformedURLException ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    
    /**
     * URL version of addSound, as the back-end sound engine has full support for various types of URLs
     * 
     * @param par1Str The name of the sound to add
     * @param url The url of the sound resource
     * @return A SoundPoolEntry for the newly added sound
     */
    public SoundPoolEntry addSound(String par1Str, URL url)
    {
        try
        {
            String s1 = par1Str;
            par1Str = par1Str.substring(0, par1Str.indexOf("."));

            if (this.isGetRandomSound)
            {
                while (Character.isDigit(par1Str.charAt(par1Str.length() - 1)))
                {
                    par1Str = par1Str.substring(0, par1Str.length() - 1);
                }
            }

            par1Str = par1Str.replaceAll("/", ".");

            if (!this.nameToSoundPoolEntriesMapping.containsKey(par1Str))
            {
                this.nameToSoundPoolEntriesMapping.put(par1Str, new ArrayList());
            }

            SoundPoolEntry soundpoolentry = new SoundPoolEntry(s1, url);
            ((List)this.nameToSoundPoolEntriesMapping.get(par1Str)).add(soundpoolentry);
            this.allSoundPoolEntries.add(soundpoolentry);
            ++this.numberOfSoundPoolEntries;
            return soundpoolentry;
        }
        catch (Exception malformedurlexception)
        {
            malformedurlexception.printStackTrace();
            throw new RuntimeException(malformedurlexception);
        }
    }

    /**
     * gets a random sound from the specified (by name, can be sound/newsound/streaming/music/newmusic) sound pool.
     */
    public SoundPoolEntry getRandomSoundFromSoundPool(String par1Str)
    {
        List list = (List)this.nameToSoundPoolEntriesMapping.get(par1Str);
        return list == null ? null : (SoundPoolEntry)list.get(this.rand.nextInt(list.size()));
    }

    /**
     * Gets a random SoundPoolEntry.
     */
    public SoundPoolEntry getRandomSound()
    {
        return this.allSoundPoolEntries.isEmpty() ? null : (SoundPoolEntry)this.allSoundPoolEntries.get(this.rand.nextInt(this.allSoundPoolEntries.size()));
    }
}
