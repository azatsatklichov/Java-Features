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

package features.in.java12.jmh;

import org.openjdk.jmh.annotations.Benchmark;

public class MyBenchmark {

	// @Benchmark //# of operation per time unit - throughput
	// public void testMethod() {
	// @BenchmarkMode(Mode.Throughput) //Throughput by default
	public int testMethod() {
		// This is a demo/sample template for building your JMH benchmarks. Edit as
		// needed.
		// Put your benchmark code here.
		int a = 1;
		int b = 2;
		// as the JVM can see that sum is never used, and may thus eliminate the sum
		// calculation.
		// Well in fact the whole method body could be removed by JVM dead code
		// elimination.
		int sum = a + b;
		return sum;
		//even some JVM optimizations just result 3
	}

	/**
	 * The JVM can detect that the calculation of a + b which is assigned to sum is
	 * never used. Therefore the JVM can remove the calculation of a + b altogether.
	 * It is considered dead code.
	 * 
	 * The JVM can then detect that the sum variable is never used, and that
	 * subsequently a and b are never used. They too can be eliminated.
	 * 
	 * In the end, there is no code left in the benchmark. The results from running
	 * this benchmark are thus highly misleading. The benchmarks do not actually
	 * measure the time of adding two variables and assigning the value to a third
	 * variable. The benchmarks measure nothing at all.
	 */
	@Benchmark
	public void testMethod_DEAD_CODE() {
		int a = 1;
		int b = 2;
		int sum = a + b;
	}

}