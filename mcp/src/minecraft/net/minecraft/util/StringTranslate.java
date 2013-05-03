package net.minecraft.util;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.IllegalFormatException;
import java.util.Properties;
import java.util.TreeMap;

public class StringTranslate
{
    /** Is the private singleton instance of StringTranslate. */
    private static StringTranslate instance = new StringTranslate("en_US");

    /**
     * Contains all key/value pairs to be translated - is loaded from '/lang/en_US.lang' when the StringTranslate is
     * created.
     */
    public Properties translateTable = new Properties();
    private TreeMap languageList;
    private TreeMap field_94521_d = new TreeMap();
    public String currentLanguage;
    private boolean isUnicode;

    public StringTranslate(String par1Str)
    {
        this.loadLanguageList();
        this.setLanguage(par1Str, false);
    }

    /**
     * Return the StringTranslate singleton instance
     */
    public static StringTranslate getInstance()
    {
        return instance;
    }

    private void loadLanguageList()
    {
        TreeMap treemap = new TreeMap();

        try
        {
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(StringTranslate.class.getResourceAsStream("/lang/languages.txt"), "UTF-8"));

            for (String s = bufferedreader.readLine(); s != null; s = bufferedreader.readLine())
            {
                String[] astring = s.trim().split("=");

                if (astring != null && astring.length == 2)
                {
                    treemap.put(astring[0], astring[1]);
                }
            }
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return;
        }

        this.languageList = treemap;
        this.languageList.put("en_US", "English (US)");
    }

    public TreeMap getLanguageList()
    {
        return this.languageList;
    }

    private void loadLanguage(Properties par1Properties, String par2Str) throws IOException
    {
        BufferedReader bufferedreader = null;

        if (this.field_94521_d.containsKey(par2Str))
        {
            bufferedreader = new BufferedReader(new FileReader((File)this.field_94521_d.get(par2Str)));
        }
        else
        {
            bufferedreader = new BufferedReader(new InputStreamReader(StringTranslate.class.getResourceAsStream("/lang/" + par2Str + ".lang"), "UTF-8"));
        }

        for (String s1 = bufferedreader.readLine(); s1 != null; s1 = bufferedreader.readLine())
        {
            s1 = s1.trim();

            if (!s1.startsWith("#"))
            {
                String[] astring = s1.split("=");

                if (astring != null && astring.length == 2)
                {
                    par1Properties.setProperty(astring[0], astring[1]);
                }
            }
        }
        LanguageRegistry.instance().loadLanguageTable(par1Properties, par2Str);
    }

    public synchronized void setLanguage(String par1Str, boolean par2)
    {
        if (par2 || !par1Str.equals(this.currentLanguage))
        {
            Properties properties = new Properties();

            try
            {
                this.loadLanguage(properties, "en_US");
            }
            catch (IOException ioexception)
            {
                ;
            }

            this.isUnicode = false;

            if (!"en_US".equals(par1Str))
            {
                try
                {
                    this.loadLanguage(properties, par1Str);
                    Enumeration enumeration = properties.propertyNames();

                    while (enumeration.hasMoreElements() && !this.isUnicode)
                    {
                        Object object = enumeration.nextElement();
                        Object object1 = properties.get(object);

                        if (object1 != null)
                        {
                            String s1 = object1.toString();

                            for (int i = 0; i < s1.length(); ++i)
                            {
                                if (s1.charAt(i) >= 256)
                                {
                                    this.isUnicode = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                catch (IOException ioexception1)
                {
                    ioexception1.printStackTrace();
                    return;
                }
            }

            this.currentLanguage = par1Str;
            this.translateTable = properties;
        }
    }

    /**
     * Translate a key to current language.
     */
    public synchronized String translateKey(String par1Str)
    {
        return this.translateTable.getProperty(par1Str, par1Str);
    }

    /**
     * Translate a key to current language applying String.format()
     */
    public synchronized String translateKeyFormat(String par1Str, Object ... par2ArrayOfObj)
    {
        String s1 = this.translateTable.getProperty(par1Str, par1Str);

        try
        {
            return String.format(s1, par2ArrayOfObj);
        }
        catch (IllegalFormatException illegalformatexception)
        {
            return "Format error: " + s1;
        }
    }

    public String getCurrentLanguage()
    {
        return this.currentLanguage;
    }

    @SideOnly(Side.CLIENT)
    public boolean isUnicode()
    {
        return this.isUnicode;
    }

    public synchronized boolean func_94520_b(String par1Str)
    {
        return this.translateTable.containsKey(par1Str);
    }

    /**
     * Translate a key with a extra '.name' at end added, is used by blocks and items.
     */
    public synchronized String translateNamedKey(String par1Str)
    {
        return this.translateTable.getProperty(par1Str + ".name", "");
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBidirectional(String par0Str)
    {
        return "ar_SA".equals(par0Str) || "he_IL".equals(par0Str);
    }

    @SideOnly(Side.CLIENT)

    public synchronized void func_94519_a(String par1Str, File par2File)
    {
        int i = par1Str.indexOf(46);

        if (i > 0)
        {
            par1Str = par1Str.substring(0, i);
        }

        this.field_94521_d.put(par1Str, par2File);

        if (par1Str.contains(this.currentLanguage))
        {
            this.setLanguage(this.currentLanguage, true);
        }
    }
}
