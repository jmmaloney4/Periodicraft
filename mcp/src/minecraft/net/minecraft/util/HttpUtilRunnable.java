package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@SideOnly(Side.CLIENT)
final class HttpUtilRunnable implements Runnable
{
    final IProgressUpdate feedbackHook;

    final String sourceURL;

    final Map field_76177_c;

    final File destinationFile;

    final IDownloadSuccess downloadSuccess;

    final int field_76173_f;

    HttpUtilRunnable(IProgressUpdate par1IProgressUpdate, String par2Str, Map par3Map, File par4File, IDownloadSuccess par5IDownloadSuccess, int par6)
    {
        this.feedbackHook = par1IProgressUpdate;
        this.sourceURL = par2Str;
        this.field_76177_c = par3Map;
        this.destinationFile = par4File;
        this.downloadSuccess = par5IDownloadSuccess;
        this.field_76173_f = par6;
    }

    public void run()
    {
        URLConnection urlconnection = null;
        InputStream inputstream = null;
        DataOutputStream dataoutputstream = null;

        if (this.feedbackHook != null)
        {
            this.feedbackHook.resetProgressAndMessage("Downloading Texture Pack");
            this.feedbackHook.resetProgresAndWorkingMessage("Making Request...");
        }

        try
        {
            try
            {
                byte[] abyte = new byte[4096];
                URL url = new URL(this.sourceURL);
                urlconnection = url.openConnection();
                float f = 0.0F;
                float f1 = (float)this.field_76177_c.entrySet().size();
                Iterator iterator = this.field_76177_c.entrySet().iterator();

                while (iterator.hasNext())
                {
                    Entry entry = (Entry)iterator.next();
                    urlconnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue());

                    if (this.feedbackHook != null)
                    {
                        this.feedbackHook.setLoadingProgress((int)(++f / f1 * 100.0F));
                    }
                }

                inputstream = urlconnection.getInputStream();
                f1 = (float)urlconnection.getContentLength();
                int i = urlconnection.getContentLength();

                if (this.feedbackHook != null)
                {
                    this.feedbackHook.resetProgresAndWorkingMessage(String.format("Downloading file (%.2f MB)...", new Object[] {Float.valueOf(f1 / 1000.0F / 1000.0F)}));
                }

                if (this.destinationFile.exists())
                {
                    long j = this.destinationFile.length();

                    if (j == (long)i)
                    {
                        this.downloadSuccess.onSuccess(this.destinationFile);

                        if (this.feedbackHook != null)
                        {
                            this.feedbackHook.onNoMoreProgress();
                        }

                        return;
                    }

                    System.out.println("Deleting " + this.destinationFile + " as it does not match what we currently have (" + i + " vs our " + j + ").");
                    this.destinationFile.delete();
                }

                dataoutputstream = new DataOutputStream(new FileOutputStream(this.destinationFile));

                if (this.field_76173_f > 0 && f1 > (float)this.field_76173_f)
                {
                    if (this.feedbackHook != null)
                    {
                        this.feedbackHook.onNoMoreProgress();
                    }

                    throw new IOException("Filesize is bigger than maximum allowed (file is " + f + ", limit is " + this.field_76173_f + ")");
                }

                boolean flag = false;
                int k;

                while ((k = inputstream.read(abyte)) >= 0)
                {
                    f += (float)k;

                    if (this.feedbackHook != null)
                    {
                        this.feedbackHook.setLoadingProgress((int)(f / f1 * 100.0F));
                    }

                    if (this.field_76173_f > 0 && f > (float)this.field_76173_f)
                    {
                        if (this.feedbackHook != null)
                        {
                            this.feedbackHook.onNoMoreProgress();
                        }

                        throw new IOException("Filesize was bigger than maximum allowed (got >= " + f + ", limit was " + this.field_76173_f + ")");
                    }

                    dataoutputstream.write(abyte, 0, k);
                }

                this.downloadSuccess.onSuccess(this.destinationFile);

                if (this.feedbackHook != null)
                {
                    this.feedbackHook.onNoMoreProgress();
                    return;
                }
            }
            catch (Throwable throwable)
            {
                throwable.printStackTrace();
            }
        }
        finally
        {
            try
            {
                if (inputstream != null)
                {
                    inputstream.close();
                }
            }
            catch (IOException ioexception)
            {
                ;
            }

            try
            {
                if (dataoutputstream != null)
                {
                    dataoutputstream.close();
                }
            }
            catch (IOException ioexception1)
            {
                ;
            }
        }
    }
}
