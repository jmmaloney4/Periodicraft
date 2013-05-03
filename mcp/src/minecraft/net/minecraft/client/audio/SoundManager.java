package net.minecraft.client.audio;

import net.minecraftforge.client.*;
import net.minecraftforge.client.event.sound.*;
import net.minecraftforge.common.MinecraftForge;
import static net.minecraftforge.client.event.sound.SoundEvent.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

@SideOnly(Side.CLIENT)
public class SoundManager
{
    /** A reference to the sound system. */
    public static SoundSystem sndSystem;

    /** Sound pool containing sounds. */
    public SoundPool soundPoolSounds = new SoundPool();

    /** Sound pool containing streaming audio. */
    public SoundPool soundPoolStreaming = new SoundPool();

    /** Sound pool containing music. */
    public SoundPool soundPoolMusic = new SoundPool();

    /**
     * The last ID used when a sound is played, passed into SoundSystem to give active sounds a unique ID
     */
    private int latestSoundID = 0;

    /** A reference to the game settings. */
    private GameSettings options;

    /** Identifiers of all currently playing sounds. Type: HashSet<String> */
    private Set playingSounds = new HashSet();
    private List field_92072_h = new ArrayList();

    /** Set to true when the SoundManager has been initialised. */
    private static boolean loaded = false;

    /** RNG. */
    private Random rand = new Random();
    private int ticksBeforeMusic;

    public static int MUSIC_INTERVAL = 12000;

    public SoundManager()
    {
        this.ticksBeforeMusic = this.rand.nextInt(MUSIC_INTERVAL);
    }

    /**
     * Used for loading sound settings from GameSettings
     */
    public void loadSoundSettings(GameSettings par1GameSettings)
    {
        this.soundPoolStreaming.isGetRandomSound = false;
        this.options = par1GameSettings;

        if (!loaded && (par1GameSettings == null || par1GameSettings.soundVolume != 0.0F || par1GameSettings.musicVolume != 0.0F))
        {
            this.tryToSetLibraryAndCodecs();
        }
        ModCompatibilityClient.audioModLoad(this);
        MinecraftForge.EVENT_BUS.post(new SoundLoadEvent(this));
    }

    /**
     * Tries to add the paulscode library and the relevant codecs. If it fails, the volumes (sound and music) will be
     * set to zero in the options file.
     */
    private void tryToSetLibraryAndCodecs()
    {
        try
        {
            float f = this.options.soundVolume;
            float f1 = this.options.musicVolume;
            this.options.soundVolume = 0.0F;
            this.options.musicVolume = 0.0F;
            this.options.saveOptions();
            SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);
            SoundSystemConfig.setCodec("mus", CodecMus.class);
            SoundSystemConfig.setCodec("wav", CodecWav.class);
            ModCompatibilityClient.audioModAddCodecs();
            MinecraftForge.EVENT_BUS.post(new SoundSetupEvent(this));
            sndSystem = new SoundSystem();
            this.options.soundVolume = f;
            this.options.musicVolume = f1;
            this.options.saveOptions();
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            System.err.println("error linking with the LibraryJavaSound plug-in");
        }

        loaded = true;
    }

    /**
     * Called when one of the sound level options has changed.
     */
    public void onSoundOptionsChanged()
    {
        if (!loaded && (this.options.soundVolume != 0.0F || this.options.musicVolume != 0.0F))
        {
            this.tryToSetLibraryAndCodecs();
        }

        if (loaded)
        {
            if (this.options.musicVolume == 0.0F)
            {
                sndSystem.stop("BgMusic");
            }
            else
            {
                sndSystem.setVolume("BgMusic", this.options.musicVolume);
            }
        }
    }

    /**
     * Called when Minecraft is closing down.
     */
    public void closeMinecraft()
    {
        if (loaded)
        {
            sndSystem.cleanup();
        }
    }

    /**
     * Adds a sounds with the name from the file. Args: name, file
     */
    public void addSound(String par1Str, File par2File)
    {
        this.soundPoolSounds.addSound(par1Str, par2File);
    }

    /**
     * Adds an audio file to the streaming SoundPool.
     */
    public void addStreaming(String par1Str, File par2File)
    {
        this.soundPoolStreaming.addSound(par1Str, par2File);
    }

    /**
     * Adds an audio file to the music SoundPool.
     */
    public void addMusic(String par1Str, File par2File)
    {
        this.soundPoolMusic.addSound(par1Str, par2File);
    }

    /**
     * If its time to play new music it starts it up.
     */
    public void playRandomMusicIfReady()
    {
        if (loaded && this.options.musicVolume != 0.0F)
        {
            if (!sndSystem.playing("BgMusic") && !sndSystem.playing("streaming"))
            {
                if (this.ticksBeforeMusic > 0)
                {
                    --this.ticksBeforeMusic;
                    return;
                }

                SoundPoolEntry soundpoolentry = this.soundPoolMusic.getRandomSound();
                soundpoolentry = ModCompatibilityClient.audioModPickBackgroundMusic(this, soundpoolentry);
                soundpoolentry = SoundEvent.getResult(new PlayBackgroundMusicEvent(this, soundpoolentry));

                if (soundpoolentry != null)
                {
                    this.ticksBeforeMusic = this.rand.nextInt(MUSIC_INTERVAL) + MUSIC_INTERVAL;
                    sndSystem.backgroundMusic("BgMusic", soundpoolentry.soundUrl, soundpoolentry.soundName, false);
                    sndSystem.setVolume("BgMusic", this.options.musicVolume);
                    sndSystem.play("BgMusic");
                }
            }
        }
    }

    /**
     * Sets the listener of sounds
     */
    public void setListener(EntityLiving par1EntityLiving, float par2)
    {
        if (loaded && this.options.soundVolume != 0.0F)
        {
            if (par1EntityLiving != null)
            {
                float f1 = par1EntityLiving.prevRotationPitch + (par1EntityLiving.rotationPitch - par1EntityLiving.prevRotationPitch) * par2;
                float f2 = par1EntityLiving.prevRotationYaw + (par1EntityLiving.rotationYaw - par1EntityLiving.prevRotationYaw) * par2;
                double d0 = par1EntityLiving.prevPosX + (par1EntityLiving.posX - par1EntityLiving.prevPosX) * (double)par2;
                double d1 = par1EntityLiving.prevPosY + (par1EntityLiving.posY - par1EntityLiving.prevPosY) * (double)par2;
                double d2 = par1EntityLiving.prevPosZ + (par1EntityLiving.posZ - par1EntityLiving.prevPosZ) * (double)par2;
                float f3 = MathHelper.cos(-f2 * 0.017453292F - (float)Math.PI);
                float f4 = MathHelper.sin(-f2 * 0.017453292F - (float)Math.PI);
                float f5 = -f4;
                float f6 = -MathHelper.sin(-f1 * 0.017453292F - (float)Math.PI);
                float f7 = -f3;
                float f8 = 0.0F;
                float f9 = 1.0F;
                float f10 = 0.0F;
                sndSystem.setListenerPosition((float)d0, (float)d1, (float)d2);
                sndSystem.setListenerOrientation(f5, f6, f7, f8, f9, f10);
            }
        }
    }

    /**
     * Stops all currently playing sounds
     */
    public void stopAllSounds()
    {
        Iterator iterator = this.playingSounds.iterator();

        while (iterator.hasNext())
        {
            String s = (String)iterator.next();
            sndSystem.stop(s);
        }

        this.playingSounds.clear();
    }

    public void playStreaming(String par1Str, float par2, float par3, float par4)
    {
        if (loaded && (this.options.soundVolume != 0.0F || par1Str == null))
        {
            String s1 = "streaming";

            if (sndSystem.playing(s1))
            {
                sndSystem.stop(s1);
            }

            if (par1Str != null)
            {
                SoundPoolEntry soundpoolentry = this.soundPoolStreaming.getRandomSoundFromSoundPool(par1Str);
                soundpoolentry = SoundEvent.getResult(new PlayStreamingEvent(this, soundpoolentry, par1Str, par2, par3, par4));

                if (soundpoolentry != null)
                {
                    if (sndSystem.playing("BgMusic"))
                    {
                        sndSystem.stop("BgMusic");
                    }

                    float f3 = 16.0F;
                    sndSystem.newStreamingSource(true, s1, soundpoolentry.soundUrl, soundpoolentry.soundName, false, par2, par3, par4, 2, f3 * 4.0F);
                    sndSystem.setVolume(s1, 0.5F * this.options.soundVolume);
                    MinecraftForge.EVENT_BUS.post(new PlayStreamingSourceEvent(this, s1, par2, par3, par4));
                    sndSystem.play(s1);
                }
            }
        }
    }

    /**
     * Updates the sound associated with the entity with that entity's position and velocity. Args: the entity
     */
    public void updateSoundLocation(Entity par1Entity)
    {
        this.updateSoundLocation(par1Entity, par1Entity);
    }

    /**
     * Updates the sound associated with soundEntity with the position and velocity of trackEntity. Args: soundEntity,
     * trackEntity
     */
    public void updateSoundLocation(Entity par1Entity, Entity par2Entity)
    {
        String s = "entity_" + par1Entity.entityId;

        if (this.playingSounds.contains(s))
        {
            if (sndSystem.playing(s))
            {
                sndSystem.setPosition(s, (float)par2Entity.posX, (float)par2Entity.posY, (float)par2Entity.posZ);
                sndSystem.setVelocity(s, (float)par2Entity.motionX, (float)par2Entity.motionY, (float)par2Entity.motionZ);
            }
            else
            {
                this.playingSounds.remove(s);
            }
        }
    }

    /**
     * Returns true if a sound is currently associated with the given entity, or false otherwise.
     */
    public boolean isEntitySoundPlaying(Entity par1Entity)
    {
        if (par1Entity != null && loaded)
        {
            String s = "entity_" + par1Entity.entityId;
            return sndSystem.playing(s);
        }
        else
        {
            return false;
        }
    }

    /**
     * Stops playing the sound associated with the given entity
     */
    public void stopEntitySound(Entity par1Entity)
    {
        if (par1Entity != null && loaded)
        {
            String s = "entity_" + par1Entity.entityId;

            if (this.playingSounds.contains(s))
            {
                if (sndSystem.playing(s))
                {
                    sndSystem.stop(s);
                }

                this.playingSounds.remove(s);
            }
        }
    }

    /**
     * Sets the volume of the sound associated with the given entity, if one is playing. The volume is scaled by the
     * global sound volume. Args: the entity, the volume (from 0 to 1)
     */
    public void setEntitySoundVolume(Entity par1Entity, float par2)
    {
        if (par1Entity != null && loaded)
        {
            if (loaded && this.options.soundVolume != 0.0F)
            {
                String s = "entity_" + par1Entity.entityId;

                if (sndSystem.playing(s))
                {
                    sndSystem.setVolume(s, par2 * this.options.soundVolume);
                }
            }
        }
    }

    /**
     * Sets the pitch of the sound associated with the given entity, if one is playing. Args: the entity, the pitch
     */
    public void setEntitySoundPitch(Entity par1Entity, float par2)
    {
        if (par1Entity != null && loaded)
        {
            if (loaded && this.options.soundVolume != 0.0F)
            {
                String s = "entity_" + par1Entity.entityId;

                if (sndSystem.playing(s))
                {
                    sndSystem.setPitch(s, par2);
                }
            }
        }
    }

    /**
     * If a sound is already playing from the given entity, update the position and velocity of that sound to match the
     * entity. Otherwise, start playing a sound from that entity. Args: The sound name, the entity, the volume, the
     * pitch, unknown flag
     */
    public void playEntitySound(String par1Str, Entity par2Entity, float par3, float par4, boolean par5)
    {
        if (par2Entity != null)
        {
            if (loaded && (this.options.soundVolume != 0.0F || par1Str == null))
            {
                String s1 = "entity_" + par2Entity.entityId;

                if (this.playingSounds.contains(s1))
                {
                    this.updateSoundLocation(par2Entity);
                }
                else
                {
                    if (sndSystem.playing(s1))
                    {
                        sndSystem.stop(s1);
                    }

                    if (par1Str == null)
                    {
                        return;
                    }

                    SoundPoolEntry soundpoolentry = this.soundPoolSounds.getRandomSoundFromSoundPool(par1Str);

                    if (soundpoolentry != null && par3 > 0.0F)
                    {
                        float f2 = 16.0F;

                        if (par3 > 1.0F)
                        {
                            f2 *= par3;
                        }

                        sndSystem.newSource(par5, s1, soundpoolentry.soundUrl, soundpoolentry.soundName, false, (float)par2Entity.posX, (float)par2Entity.posY, (float)par2Entity.posZ, 2, f2);
                        sndSystem.setLooping(s1, true);
                        sndSystem.setPitch(s1, par4);

                        if (par3 > 1.0F)
                        {
                            par3 = 1.0F;
                        }

                        sndSystem.setVolume(s1, par3 * this.options.soundVolume);
                        sndSystem.setVelocity(s1, (float)par2Entity.motionX, (float)par2Entity.motionY, (float)par2Entity.motionZ);
                        sndSystem.play(s1);
                        this.playingSounds.add(s1);
                    }
                }
            }
        }
    }

    /**
     * Plays a sound. Args: soundName, x, y, z, volume, pitch
     */
    public void playSound(String par1Str, float par2, float par3, float par4, float par5, float par6)
    {
        if (loaded && this.options.soundVolume != 0.0F)
        {
            SoundPoolEntry soundpoolentry = this.soundPoolSounds.getRandomSoundFromSoundPool(par1Str);
            soundpoolentry = SoundEvent.getResult(new PlaySoundEvent(this, soundpoolentry, par1Str, par2, par3, par4, par5, par6));

            if (soundpoolentry != null && par5 > 0.0F)
            {
                this.latestSoundID = (this.latestSoundID + 1) % 256;
                String s1 = "sound_" + this.latestSoundID;
                float f5 = 16.0F;

                if (par5 > 1.0F)
                {
                    f5 *= par5;
                }

                sndSystem.newSource(par5 > 1.0F, s1, soundpoolentry.soundUrl, soundpoolentry.soundName, false, par2, par3, par4, 2, f5);
                sndSystem.setPitch(s1, par6);

                if (par5 > 1.0F)
                {
                    par5 = 1.0F;
                }

                sndSystem.setVolume(s1, par5 * this.options.soundVolume);
                MinecraftForge.EVENT_BUS.post(new PlaySoundSourceEvent(this, s1, par2, par3, par4));
                sndSystem.play(s1);
            }
        }
    }

    /**
     * Plays a sound effect with the volume and pitch of the parameters passed. The sound isn't affected by position of
     * the player (full volume and center balanced)
     */
    public void playSoundFX(String par1Str, float par2, float par3)
    {
        if (loaded && this.options.soundVolume != 0.0F)
        {
            SoundPoolEntry soundpoolentry = this.soundPoolSounds.getRandomSoundFromSoundPool(par1Str);
            soundpoolentry = SoundEvent.getResult(new PlaySoundEffectEvent(this, soundpoolentry, par1Str, par2, par3));

            if (soundpoolentry != null)
            {
                this.latestSoundID = (this.latestSoundID + 1) % 256;
                String s1 = "sound_" + this.latestSoundID;
                sndSystem.newSource(false, s1, soundpoolentry.soundUrl, soundpoolentry.soundName, false, 0.0F, 0.0F, 0.0F, 0, 0.0F);

                if (par2 > 1.0F)
                {
                    par2 = 1.0F;
                }

                par2 *= 0.25F;
                sndSystem.setPitch(s1, par3);
                sndSystem.setVolume(s1, par2 * this.options.soundVolume);
                MinecraftForge.EVENT_BUS.post(new PlaySoundEffectSourceEvent(this, s1));
                sndSystem.play(s1);
            }
        }
    }

    /**
     * Pauses all currently playing sounds
     */
    public void pauseAllSounds()
    {
        Iterator iterator = this.playingSounds.iterator();

        while (iterator.hasNext())
        {
            String s = (String)iterator.next();
            sndSystem.pause(s);
        }
    }

    /**
     * Resumes playing all currently playing sounds (after pauseAllSounds)
     */
    public void resumeAllSounds()
    {
        Iterator iterator = this.playingSounds.iterator();

        while (iterator.hasNext())
        {
            String s = (String)iterator.next();
            sndSystem.play(s);
        }
    }

    public void func_92071_g()
    {
        if (!this.field_92072_h.isEmpty())
        {
            Iterator iterator = this.field_92072_h.iterator();

            while (iterator.hasNext())
            {
                ScheduledSound scheduledsound = (ScheduledSound)iterator.next();
                --scheduledsound.field_92064_g;

                if (scheduledsound.field_92064_g <= 0)
                {
                    this.playSound(scheduledsound.field_92069_a, scheduledsound.field_92067_b, scheduledsound.field_92068_c, scheduledsound.field_92065_d, scheduledsound.field_92066_e, scheduledsound.field_92063_f);
                    iterator.remove();
                }
            }
        }
    }

    public void func_92070_a(String par1Str, float par2, float par3, float par4, float par5, float par6, int par7)
    {
        this.field_92072_h.add(new ScheduledSound(par1Str, par2, par3, par4, par5, par6, par7));
    }
}
