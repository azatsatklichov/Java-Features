/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package measures.in.graalvm;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Demo1 {

	private static final String DOMAINS_TXT = "C:\\workspace-JavaNew\\Java-Features\\graalvm-jmh\\src\\main\\java\\measures\\in\\graalvm\\domains_list.txt";
	private static HttpClient httpClient;

	//-XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCI -XX:-UseJVMCICompiler
	// disabling Graal: java -XX:-UseJVMCICompiler  Demo2    
	//to see JIT case ..... -XX:+PrintCompilation
	
	//with Graal - Elapsed time = Elapsed time = 10550 millisec
	//diasbling Graal:  Elapsed time = 11006 millisec
	public static void main(String[] args) throws IOException, InterruptedException {

		long start = System.currentTimeMillis();
		httpClient = HttpClient.newHttpClient();
		List<CompletableFuture<String>> completableFutureStringListResponse = Files.lines(Path.of(DOMAINS_TXT))
				.map(Demo1::validateLink).collect(Collectors.toList());
		completableFutureStringListResponse.stream().map(CompletableFuture::join).forEach(System.out::println);

		StringBuilder res = new StringBuilder();
		completableFutureStringListResponse.stream().map(CompletableFuture::join).forEach(v -> {
			long s = (long) (Math.random() * 10 + 1);
			Random generator = new Random(s);
			
			/* disable comment to include CPU intensive calculation */
			long sum = heavySum(generator.nextInt());
			System.out.println(v);
			res.append(v);
		});
		long end = System.currentTimeMillis();
		System.out.println("\nElapsed time = " + (end - start) + " millisec");
	}

	private static long heavySum(int nInt) {
		long sum = 0;
		for (int i = 0; i < nInt; i++) {
			sum += nInt;
		}
		return sum;
	}

	private static CompletableFuture<String> validateLink(String link) {
		HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(link)).GET().build();

		// including exception handling
		return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.discarding())
				.thenApply(
						asynResult -> 200 == asynResult.statusCode() ? link + " access OK  " : link + " access Failed")
				// Resiliency
				.exceptionally(e -> "Error occured once accessing to " + link + ", reson is: " + e.getMessage());

	}

}
