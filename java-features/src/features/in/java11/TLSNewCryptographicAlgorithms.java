package features.in.java11;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.NamedParameterSpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLSocketFactory;

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

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
		/**
		 * * more details {@link here https://tools.ietf.org/html/rfc7539} and
		 * {@link here
		 * https://javainterviewpoint.com/chacha20-poly1305-encryption-and-decryption/}
		 * 
		 * https://www.eweek.com/development/oracle-improves-security-performance-in-java-11
		 */
		System.out.println(
				"1. ChaCha20 is a relatively new stream cipher that can replace the older, insecure RC4 stream cipher.");
		/**
		 * ChaCha20 is a high-speed stream cipher, an encryption and decryption
		 * algorithm. ChaCha20-Poly1305 means ChaCha20 running in AEAD mode with the
		 * Poly1305 authenticator, encryption and authentication together, both are
		 * defined in RFC 7539. This JEP update of ChaCha20 cryptographic algorithms is
		 * a replacement for the insecure RC4 stream cipher.
		 * 
		 * The inputs to ChaCha20 are:
		 * 
		 * A 256-bit secret key (32 bytes) A 96-bit nonce (12 bytes) A 32-bit initial
		 * count (4 bytes)
		 */

//
//		byte[] nonce = "sdsdsdw%$d".getBytes();
//		int counter = 8;
//		ChaCha20ParameterSpec param = new ChaCha20ParameterSpec(nonce, counter);
//
//		KeyPairGenerator kpg = KeyPairGenerator.getInstance("XDH");
//		NamedParameterSpec paramSpec = new NamedParameterSpec("X25519");
//		kpg.initialize(paramSpec); // equivalent to kpg.initialize(255)
//		// alternatively: kpg = KeyPairGenerator.getInstance("X25519")
//		KeyPair kp = kpg.generateKeyPair();
//		Key key = kp.getPrivate(); 
//		cipher.init(Cipher.ENCRYPT_MODE, key, param);
//
//		byte[] pText = "saastwed".getBytes();
//		byte[] encryptedText = cipher.doFinal(pText);

		// https://tools.ietf.org/html/rfc7748
		System.out.println("2. Curve25519 and Curve448 key agreement is implemented");
		/**
		 * JEP 324: Key Agreement with Curve25519 and Curve448 Java Cryptography related
		 * item. It replaced the existing elliptic curve Diffie-Hellman (ECDH) scheme
		 * with Curve25519 and Curve448 algorithms, a key agreement scheme defined in
		 * RFC 7748.
		 * 
		 * A simple KeyPairGenerator example using the Curve25519 algorithm to generate
		 * a key pair.
		 */

		KeyPairGenerator kpg = KeyPairGenerator.getInstance("XDH");
		NamedParameterSpec paramSpec = new NamedParameterSpec("X25519");
		kpg.initialize(paramSpec); // equivalent to kpg.initialize(255)
		// alternatively: kpg = KeyPairGenerator.getInstance("X25519")
		KeyPair kp = kpg.generateKeyPair();

		System.out.println("--- Public Key ---");
		PublicKey publicKey = kp.getPublic();

		System.out.println(publicKey.getAlgorithm()); // XDH
		System.out.println(publicKey.getFormat()); // X.509

		// save this public key
		byte[] pubKey = publicKey.getEncoded();

		System.out.println("---");

		System.out.println("--- Private Key ---");
		PrivateKey privateKey = kp.getPrivate();

		System.out.println(privateKey.getAlgorithm()); // XDH
		System.out.println(privateKey.getFormat()); // PKCS#8

		// save this private key
		byte[] priKey = privateKey.getEncoded();

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

class TLS13 {
	/**
	 * Java 11 supports RFC 8446 Transport Layer Security (TLS) 1.3 protocol.
	 * However, not all TLS 1.3 feature is implemented, refer to this JEP 332 for
	 * detail.
	 * 
	 * Java Secure Socket Extension (JSSE) + TLS 1.3 example.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		Socket socket = factory.createSocket("google.com", 443);

		//socket.setEnabledProtocols(new String[] { "TLSv1.3" });
		//socket.setEnabledCipherSuites(new String[] { "TLS_AES_128_GCM_SHA256" });
	}

}