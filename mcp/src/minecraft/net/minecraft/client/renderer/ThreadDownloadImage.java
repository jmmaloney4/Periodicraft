package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;

@SideOnly(Side.CLIENT)
class ThreadDownloadImage extends Thread
{
    /** The URL of the image to download. */
    final String location;

    /** The image buffer to use. */
    final IImageBuffer buffer;

    /** The image data. */
    final ThreadDownloadImageData imageData;

    ThreadDownloadImage(ThreadDownloadImageData par1, String par2Str, IImageBuffer par3IImageBuffer)
    {
        this.imageData = par1;
        this.location = par2Str;
        this.buffer = par3IImageBuffer;
    }

    public void run()
    {
        HttpURLConnection httpurlconnection = null;

        try
        {
            URL url = new URL(this.location);
            httpurlconnection = (HttpURLConnection)url.openConnection();
            httpurlconnection.setDoInput(true);
            httpurlconnection.setDoOutput(false);
            httpurlconnection.connect();

            if (httpurlconnection.getResponseCode() / 100 == 4)
            {
                return;
            }

            if (this.buffer == null)
            {
                this.imageData.image = ImageIO.read(httpurlconnection.getInputStream());
            }
            else
            {
                this.imageData.image = this.buffer.parseUserSkin(ImageIO.read(httpurlconnection.getInputStream()));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            httpurlconnection.disconnect();
        }
    }
}
