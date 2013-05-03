package cpw.mods.fml.client;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.renderer.texture.TextureStitched;

public class OpenGL43TextureHelper extends TextureHelper {

    public OpenGL43TextureHelper()
    {
//        GL43.
//        glCopyMethod = Class.forName("org.lwjgl.OpenGL")
    }
    @Override
    public void doTextureCopy(Texture atlas, Texture source, int atlasX, int atlasY)
    {
//        System.out.printf("Src: %d Targ: %d, Coords %d %d %d %d\n", source.getGlTextureId(), atlas.getGlTextureId(), atlasX, atlasY, source.getWidth(), source.getHeight());
//        GL43.glCopyImageSubData(source.getGlTextureId(), GL11.GL_TEXTURE_2D, 0, 0, 0, 0, atlas.getGlTextureId(), GL11.GL_TEXTURE_2D, 0, atlasX, atlasY, 0, source.getWidth(), source.getHeight(), 1);
//        System.out.printf("Err: %x\n", GL11.glGetError());
    }

    @Override
    public void doTextureUpload(TextureStitched source)
    {
//        source.createAndUploadTextures();
    }

}
