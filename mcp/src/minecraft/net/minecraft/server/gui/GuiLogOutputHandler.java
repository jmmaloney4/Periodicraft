package net.minecraft.server.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import javax.swing.JTextArea;

@SideOnly(Side.SERVER)
public class GuiLogOutputHandler extends Handler
{
    private int[] field_79023_b = new int[1024];
    private int field_79024_c = 0;
    Formatter field_79025_a = new GuiLogFormatter(this);
    private JTextArea field_79022_d;

    public GuiLogOutputHandler(JTextArea par1JTextArea)
    {
        this.setFormatter(this.field_79025_a);
        this.field_79022_d = par1JTextArea;
    }

    public void close() {}

    public void flush() {}

    public void publish(LogRecord par1LogRecord)
    {
        int i = this.field_79022_d.getDocument().getLength();
        this.field_79022_d.append(this.field_79025_a.format(par1LogRecord));
        this.field_79022_d.setCaretPosition(this.field_79022_d.getDocument().getLength());
        int j = this.field_79022_d.getDocument().getLength() - i;

        if (this.field_79023_b[this.field_79024_c] != 0)
        {
            this.field_79022_d.replaceRange("", 0, this.field_79023_b[this.field_79024_c]);
        }

        this.field_79023_b[this.field_79024_c] = j;
        this.field_79024_c = (this.field_79024_c + 1) % 1024;
    }
}
