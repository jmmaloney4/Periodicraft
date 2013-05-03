package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import net.minecraft.client.mco.McoServer;

@SideOnly(Side.CLIENT)
class ThreadConnectToOnlineServer extends Thread
{
    final McoServer field_96597_a;

    final GuiSlotOnlineServerList field_96596_b;

    ThreadConnectToOnlineServer(GuiSlotOnlineServerList par1GuiSlotOnlineServerList, McoServer par2McoServer)
    {
        this.field_96596_b = par1GuiSlotOnlineServerList;
        this.field_96597_a = par2McoServer;
    }

    public void run()
    {
        boolean flag = false;
        label194:
        {
            label195:
            {
                label196:
                {
                    label197:
                    {
                        label198:
                        {
                            try
                            {
                                flag = true;

                                if (!this.field_96597_a.field_96411_l)
                                {
                                    this.field_96597_a.field_96411_l = true;
                                    this.field_96597_a.field_96412_m = -2L;
                                    this.field_96597_a.field_96414_k = "";
                                    GuiScreenOnlineServers.func_101014_j();
                                    long i = System.nanoTime();
                                    GuiScreenOnlineServers.func_101002_a(this.field_96596_b.field_96294_a, this.field_96597_a);
                                    long j = System.nanoTime();
                                    this.field_96597_a.field_96412_m = (j - i) / 1000000L;
                                    flag = false;
                                }
                                else if (this.field_96597_a.field_102022_m)
                                {
                                    this.field_96597_a.field_102022_m = false;
                                    GuiScreenOnlineServers.func_101002_a(this.field_96596_b.field_96294_a, this.field_96597_a);
                                    flag = false;
                                }
                                else
                                {
                                    flag = false;
                                }

                                break label194;
                            }
                            catch (UnknownHostException unknownhostexception)
                            {
                                this.field_96597_a.field_96412_m = -1L;
                                flag = false;
                                break label195;
                            }
                            catch (SocketTimeoutException sockettimeoutexception)
                            {
                                this.field_96597_a.field_96412_m = -1L;
                                flag = false;
                                break label196;
                            }
                            catch (ConnectException connectexception)
                            {
                                this.field_96597_a.field_96412_m = -1L;
                                flag = false;
                                break label198;
                            }
                            catch (IOException ioexception)
                            {
                                this.field_96597_a.field_96412_m = -1L;
                                flag = false;
                            }
                            catch (Exception exception)
                            {
                                this.field_96597_a.field_96412_m = -1L;
                                flag = false;
                                break label197;
                            }
                            finally
                            {
                                if (flag)
                                {
                                    synchronized (GuiScreenOnlineServers.func_101007_h())
                                    {
                                        GuiScreenOnlineServers.func_101013_k();
                                    }
                                }
                            }

                            synchronized (GuiScreenOnlineServers.func_101007_h())
                            {
                                GuiScreenOnlineServers.func_101013_k();
                                return;
                            }
                        }

                        synchronized (GuiScreenOnlineServers.func_101007_h())
                        {
                            GuiScreenOnlineServers.func_101013_k();
                            return;
                        }
                    }

                    synchronized (GuiScreenOnlineServers.func_101007_h())
                    {
                        GuiScreenOnlineServers.func_101013_k();
                        return;
                    }
                }

                synchronized (GuiScreenOnlineServers.func_101007_h())
                {
                    GuiScreenOnlineServers.func_101013_k();
                    return;
                }
            }

            synchronized (GuiScreenOnlineServers.func_101007_h())
            {
                GuiScreenOnlineServers.func_101013_k();
                return;
            }
        }

        synchronized (GuiScreenOnlineServers.func_101007_h())
        {
            GuiScreenOnlineServers.func_101013_k();
        }
    }
}
