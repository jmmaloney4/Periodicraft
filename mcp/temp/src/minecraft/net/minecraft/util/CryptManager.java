package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.io.CipherInputStream;
import org.bouncycastle.crypto.io.CipherOutputStream;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class CryptManager {

   public static final Charset field_75898_a = Charset.forName("ISO_8859_1");


   @SideOnly(Side.CLIENT)
   public static SecretKey func_75890_a() {
      CipherKeyGenerator var0 = new CipherKeyGenerator();
      var0.init(new KeyGenerationParameters(new SecureRandom(), 128));
      return new SecretKeySpec(var0.generateKey(), "AES");
   }

   public static KeyPair func_75891_b() {
      try {
         KeyPairGenerator var0 = KeyPairGenerator.getInstance("RSA");
         var0.initialize(1024);
         return var0.generateKeyPair();
      } catch (NoSuchAlgorithmException var1) {
         var1.printStackTrace();
         System.err.println("Key pair generation failed!");
         return null;
      }
   }

   public static byte[] func_75895_a(String p_75895_0_, PublicKey p_75895_1_, SecretKey p_75895_2_) {
      try {
         return func_75893_a("SHA-1", new byte[][]{p_75895_0_.getBytes("ISO_8859_1"), p_75895_2_.getEncoded(), p_75895_1_.getEncoded()});
      } catch (UnsupportedEncodingException var4) {
         var4.printStackTrace();
         return null;
      }
   }

   private static byte[] func_75893_a(String p_75893_0_, byte[] ... p_75893_1_) {
      try {
         MessageDigest var2 = MessageDigest.getInstance(p_75893_0_);
         byte[][] var3 = p_75893_1_;
         int var4 = p_75893_1_.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            byte[] var6 = var3[var5];
            var2.update(var6);
         }

         return var2.digest();
      } catch (NoSuchAlgorithmException var7) {
         var7.printStackTrace();
         return null;
      }
   }

   public static PublicKey func_75896_a(byte[] p_75896_0_) {
      try {
         X509EncodedKeySpec var1 = new X509EncodedKeySpec(p_75896_0_);
         KeyFactory var2 = KeyFactory.getInstance("RSA");
         return var2.generatePublic(var1);
      } catch (NoSuchAlgorithmException var3) {
         var3.printStackTrace();
      } catch (InvalidKeySpecException var4) {
         var4.printStackTrace();
      }

      System.err.println("Public key reconstitute failed!");
      return null;
   }

   public static SecretKey func_75887_a(PrivateKey p_75887_0_, byte[] p_75887_1_) {
      return new SecretKeySpec(func_75889_b(p_75887_0_, p_75887_1_), "AES");
   }

   @SideOnly(Side.CLIENT)
   public static byte[] func_75894_a(Key p_75894_0_, byte[] p_75894_1_) {
      return func_75885_a(1, p_75894_0_, p_75894_1_);
   }

   public static byte[] func_75889_b(Key p_75889_0_, byte[] p_75889_1_) {
      return func_75885_a(2, p_75889_0_, p_75889_1_);
   }

   private static byte[] func_75885_a(int p_75885_0_, Key p_75885_1_, byte[] p_75885_2_) {
      try {
         return func_75886_a(p_75885_0_, p_75885_1_.getAlgorithm(), p_75885_1_).doFinal(p_75885_2_);
      } catch (IllegalBlockSizeException var4) {
         var4.printStackTrace();
      } catch (BadPaddingException var5) {
         var5.printStackTrace();
      }

      System.err.println("Cipher data failed!");
      return null;
   }

   private static Cipher func_75886_a(int p_75886_0_, String p_75886_1_, Key p_75886_2_) {
      try {
         Cipher var3 = Cipher.getInstance(p_75886_1_);
         var3.init(p_75886_0_, p_75886_2_);
         return var3;
      } catch (InvalidKeyException var4) {
         var4.printStackTrace();
      } catch (NoSuchAlgorithmException var5) {
         var5.printStackTrace();
      } catch (NoSuchPaddingException var6) {
         var6.printStackTrace();
      }

      System.err.println("Cipher creation failed!");
      return null;
   }

   private static BufferedBlockCipher func_75892_a(boolean p_75892_0_, Key p_75892_1_) {
      BufferedBlockCipher var2 = new BufferedBlockCipher(new CFBBlockCipher(new AESFastEngine(), 8));
      var2.init(p_75892_0_, new ParametersWithIV(new KeyParameter(p_75892_1_.getEncoded()), p_75892_1_.getEncoded(), 0, 16));
      return var2;
   }

   public static OutputStream func_75897_a(SecretKey p_75897_0_, OutputStream p_75897_1_) {
      return new CipherOutputStream(p_75897_1_, func_75892_a(true, p_75897_0_));
   }

   public static InputStream func_75888_a(SecretKey p_75888_0_, InputStream p_75888_1_) {
      return new CipherInputStream(p_75888_1_, func_75892_a(false, p_75888_0_));
   }

   static {
      Security.addProvider(new BouncyCastleProvider());
   }
}
