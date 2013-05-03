package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.minecraft.crash.CrashReport;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class PanelCrashReport extends Panel
{
    public PanelCrashReport(CrashReport par1CrashReport)
    {
        this.setBackground(new Color(3028036));
        this.setLayout(new BorderLayout());
        StringWriter stringwriter = new StringWriter();
        par1CrashReport.getCrashCause().printStackTrace(new PrintWriter(stringwriter));
        String s = stringwriter.toString();
        String s1 = "";
        String s2 = "";

        try
        {
            s2 = s2 + "Generated " + (new SimpleDateFormat()).format(new Date()) + "\n";
            s2 = s2 + "\n";
            s2 = s2 + par1CrashReport.func_90021_c();
            s1 = GL11.glGetString(GL11.GL_VENDOR);
        }
        catch (Throwable throwable)
        {
            s2 = s2 + "[failed to get system properties (" + throwable + ")]\n";
        }

        s2 = s2 + "\n\n";
        s2 = s2 + s;
        String s3 = "";
        s3 = s3 + "\n";
        s3 = s3 + "\n";

        if (s.contains("Pixel format not accelerated"))
        {
            s3 = s3 + "      Bad video card drivers!      \n";
            s3 = s3 + "      -----------------------      \n";
            s3 = s3 + "\n";
            s3 = s3 + "Minecraft was unable to start because it failed to find an accelerated OpenGL mode.\n";
            s3 = s3 + "This can usually be fixed by updating the video card drivers.\n";

            if (s1.toLowerCase().contains("nvidia"))
            {
                s3 = s3 + "\n";
                s3 = s3 + "You might be able to find drivers for your video card here:\n";
                s3 = s3 + "  http://www.nvidia.com/\n";
            }
            else if (s1.toLowerCase().contains("ati"))
            {
                s3 = s3 + "\n";
                s3 = s3 + "You might be able to find drivers for your video card here:\n";
                s3 = s3 + "  http://www.amd.com/\n";
            }
        }
        else
        {
            s3 = s3 + "      Minecraft has crashed!      \n";
            s3 = s3 + "      ----------------------      \n";
            s3 = s3 + "\n";
            s3 = s3 + "Minecraft has stopped running because it encountered a problem; " + par1CrashReport.getDescription() + "\n\n";
            File file1 = par1CrashReport.getFile();

            if (file1 == null)
            {
                par1CrashReport.saveToFile(new File(new File(Minecraft.getMinecraftDir(), "crash-reports"), "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-client.txt"), Minecraft.getMinecraft().getLogAgent());
                file1 = par1CrashReport.getFile();
            }

            if (file1 != null)
            {
                String s4 = file1.getAbsolutePath();
                s3 = s3 + "A full error report has been saved to " + s4 + " - Please include a copy of that file (Not this screen!) if you report this crash to anyone; without it, they will not be able to help fix the crash :(";
                s2 = "Full report at:\n" + s4 + "\nPlease show that file to Mojang, NOT just this screen!\n\n" + s2;
            }
            else
            {
                s3 = s3 + "We were unable to save this report to a file.";
            }

            s3 = s3 + "\n";
        }

        s3 = s3 + "\n";
        s3 = s3 + "\n";
        s3 = s3 + "\n";
        s3 = s3 + "--- BEGIN ERROR REPORT " + Integer.toHexString(s3.hashCode()) + " --------\n";
        s3 = s3 + s2;
        s3 = s3 + "--- END ERROR REPORT " + Integer.toHexString(s3.hashCode()) + " ----------\n";
        s3 = s3 + "\n";
        s3 = s3 + "\n";
        TextArea textarea = new TextArea(s3, 0, 0, 1);
        textarea.setFont(new Font("Monospaced", 0, 12));
        this.add(new CanvasMojangLogo(), "North");
        this.add(new CanvasCrashReport(80), "East");
        this.add(new CanvasCrashReport(80), "West");
        this.add(new CanvasCrashReport(100), "South");
        this.add(textarea, "Center");
    }
}
