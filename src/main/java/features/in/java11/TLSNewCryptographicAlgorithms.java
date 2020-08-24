package features.in.java11;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * ChaCha20 and ChaCha20-Poly1305 cipher implementations. These algorithms will
 * be implemented in the SunJCE provider.
 *
 * <pre>
 *Goals
 *
	Provide ChaCha20 and ChaCha20-Poly1305 Cipher implementations. These algorithms will be implemented in the SunJCE provider.
	
	Provide a KeyGenerator implementation that creates keys suitable for ChaCha20 and ChaCha20-Poly1305 algorithms.
	
	Provide an AlgorithmParameters implementation for use with the ChaCha20-Poly1305 algorithm.
 * </pre>
 * 
 * 
 * more details {@link here https://tools.ietf.org/html/rfc7539} and {@link here
 * https://javainterviewpoint.com/chacha20-poly1305-encryption-and-decryption/}
 * 
 */
public class TLSNewCryptographicAlgorithms {

	public static void main(String[] args) {
		/**
		 * * more details {@link here https://tools.ietf.org/html/rfc7539} and
		 * {@link here
		 * https://javainterviewpoint.com/chacha20-poly1305-encryption-and-decryption/}
		 * 
		 * https://www.eweek.com/development/oracle-improves-security-performance-in-java-11
		 */
		System.out.println(
				"1. ChaCha20 is a relatively new stream cipher that can replace the older, insecure RC4 stream cipher.");

		// https://tools.ietf.org/html/rfc7748
		System.out.println("2. Curve25519 and Curve448 key agreement is impelented");

	}

}

class ChaCha20Poly1305Example {
	static String plainText = "This is a plain text which will be encrypted and decrypted by ChaCha20 Poly1305 Algorithm";

	public static void main(String[] args) throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("ChaCha20");
		keyGenerator.init(256);

		// Generate Key
		SecretKey key = keyGenerator.generateKey();

		System.out.println("Original Text  : " + plainText);

		byte[] cipherText = encrypt(plainText.getBytes(), key);
		System.out.println("Encrypted Text : " + Base64.getEncoder().encodeToString(cipherText));

		String decryptedText = decrypt(cipherText, key);
		System.out.println("DeCrypted Text : " + decryptedText);

	}

	public static byte[] encrypt(byte[] plaintext, SecretKey key) throws Exception {
		byte[] nonceBytes = new byte[12];

		// Get Cipher Instance
		Cipher cipher = Cipher.getInstance("ChaCha20-Poly1305/None/NoPadding");

		// Create IvParamterSpec
		AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(nonceBytes);

		// Create SecretKeySpec
		SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "ChaCha20");

		// Initialize Cipher for ENCRYPT_MODE
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);

		// Perform Encryption
		byte[] cipherText = cipher.doFinal(plaintext);

		return cipherText;
	}

	public static String decrypt(byte[] cipherText, SecretKey key) throws Exception {
		byte[] nonceBytes = new byte[12];

		// Get Cipher Instance
		Cipher cipher = Cipher.getInstance("ChaCha20-Poly1305/None/NoPadding");

		// Create IvParamterSpec
		AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(nonceBytes);

		// Create SecretKeySpec
		SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "ChaCha20");

		// Initialize Cipher for DECRYPT_MODE
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);

		// Perform Decryption
		byte[] decryptedText = cipher.doFinal(cipherText);

		return new String(decryptedText);
	}
}