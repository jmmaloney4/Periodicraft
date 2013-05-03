package net.minecraft.client.audio;

import java.io.InputStream;
import net.minecraft.client.audio.MusInputStream;
import paulscode.sound.codecs.CodecJOrbis;

public class CodecMus extends CodecJOrbis {

   protected InputStream openInputStream() {
      return new MusInputStream(this, this.url, this.urlConnection.getInputStream());
   }
}
