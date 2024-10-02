package Asymmetric_Cipher;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class TripleDESCipher {
	
	private static SecretKey generateKey(String key) throws NoSuchAlgorithmException{
		//key must be 24bytes (192 bits) long
		byte []keyBytes = key.getBytes();
		byte []validKeyBytes = new byte[24];
		int n = keyBytes.length;
		int m = validKeyBytes.length;
		
		//truncate or pad key bytes to make it 24 bits long
		for (int i = 0; i < m; i++) {
			if (i < n) {
				validKeyBytes[i] = keyBytes[i];
			}
			else {
				validKeyBytes[i] = 0; ///pad more 0 bytes
			}
		}
		
		SecretKeySpec keySpec = new SecretKeySpec(validKeyBytes, "DESede");
		return keySpec;
	}
	
	public static String encrypt(String text, String Key) {
        try {
            SecretKey key = generateKey(Key);
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrytedBytes = cipher.doFinal(text.getBytes());
            return Base64.getEncoder().encodeToString(encrytedBytes);
        } catch (Exception e) {
            return e.toString();
        }
    }
	
	public static String decrypt(String text, String Key) {
        try {
            SecretKey key = generateKey(Key);
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodeByte = Base64.getDecoder().decode(text);
            byte[] decrytedBytes = cipher.doFinal(decodeByte);
            return new String (decrytedBytes);
        } catch (Exception e) {
            return e.toString();
        }
    }
}
