package features.in.java8;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class BuildInEncDecForBase64 {

	public static void main(String[] args) {
		try {

			// Encode using basic encoder: The BASIC encoder does not add any line feed in
			// output, and the decoder rejects any character other than A-Za-z0-9+/.
			String base64encodedString = Base64.getEncoder().encodeToString("features?java8".getBytes("utf-8"));
			System.out.println("Base64 Encoded String (Basic) :" + base64encodedString);

			// Decode
			byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
			System.out.println("Original String: " + new String(base64decodedBytes, "utf-8"));
			System.out.println();

			// encode using getUrlEncoder: Output is mapped to set of characters lying in
			// A-Za-z0-9+_. Output is URL and filename safe.
			base64encodedString = Base64.getUrlEncoder().encodeToString("features?java8".getBytes("utf-8"));
			System.out.println("Base64 Encoded String (URL) :" + base64encodedString);
			// Decode
			base64decodedBytes = Base64.getUrlDecoder().decode(base64encodedString);
			System.out.println("Original String: " + new String(base64decodedBytes, "utf-8"));
			System.out.println();

			// encode using getMimeEncoder: Output is represented in lines of no more than
			// 76 characters each, and uses a carriage return '\r' followed by a linefeed
			// '\n' as the line separator.
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < 10; ++i) {
				stringBuilder.append(UUID.randomUUID().toString());
			}

			byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
			// byte[] mimeBytes = "features?java8".toString().getBytes("utf-8");
			String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
			System.out.println("Base64 Encoded String (MIME) :" + mimeEncodedString);
			// Decode
			base64decodedBytes = Base64.getMimeDecoder().decode(mimeEncodedString);
			System.out.println("Original String: " + new String(mimeBytes, "utf-8"));
			System.out.println();

		} catch (UnsupportedEncodingException e) {
			System.out.println("Error :" + e.getMessage());
		}
	}
}