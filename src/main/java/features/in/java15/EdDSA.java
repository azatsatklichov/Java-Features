package features.in.java15;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

/**
 * Cryptography related stuff, Java 15 implements an additional digital
 * signature scheme using the Edwards-Curve Digital Signature Algorithm (EdDSA)
 * as described by RFC 8032. The EdDSA signature scheme is popular due to its
 * improved security and performance (faster) over other signature schemes, and
 * it is also one of the signatures schemes that are allowed in TLS 1.3.
 *
 * https://en.wikipedia.org/wiki/EdDSA
 *
 */
public class EdDSA {
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {

		KeyPairGenerator kpg = KeyPairGenerator.getInstance("Ed25519");
		KeyPair kp = kpg.generateKeyPair();

		String str = "abc";
		byte[] msg = str.getBytes(StandardCharsets.UTF_8);

		Signature sig = Signature.getInstance("Ed25519");
		sig.initSign(kp.getPrivate());
		sig.update(msg);
		byte[] s = sig.sign();

		System.out.println(str);
		System.out.println(Base64.getEncoder().encodeToString(s));

	}
}
