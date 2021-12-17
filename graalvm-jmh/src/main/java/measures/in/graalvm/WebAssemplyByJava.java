package measures.in.graalvm;

import java.io.IOException;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
import org.graalvm.polyglot.io.ByteSequence;

//https://www.graalvm.org/reference-manual/wasm/
/**
 * Embedding WebAssembly Programs The compiled WebAssembly binary code can be
 * accessed programmatically with GraalVM Polyglot API, which allows embedding
 * GraalVM WebAssembly into user programs. Here is a simple example of how to
 * call WebAssembly code from a Java application:
 *
 */
public class WebAssemplyByJava {

	public static void main(String[] args) throws IOException {
		// Load the WASM contents into a byte array
		byte[] binary = readBytes("example.wasm");
		Context.Builder contextBuilder = Context.newBuilder("wasm");
		Source.Builder sourceBuilder = Source.newBuilder("wasm", ByteSequence.create(binary), "example");
		Source source = sourceBuilder.build();
		Context context = contextBuilder.build();

		context.eval(source);

		Value mainFunction = context.getBindings("wasm").getMember("main").getMember("_start");
		mainFunction.execute();
	}

	private static byte[] readBytes(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
