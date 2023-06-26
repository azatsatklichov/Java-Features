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


import org.openjdk.jmh.runner.*;
import org.openjdk.jmh.runner.options.*;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)  //LATENCY - LOW is good, #of avearge time spent to do all operations
//@BenchmarkMode(Mode.Throughput)  //Throughput - HIGH is good, #of transaction(opeartion) per second
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)  //only on Single JVM, not like by default on 5 different JVMs
@State(Scope.Benchmark)
public class MyBenchmark2 {

    @Param({"1", "12345", "2147483647"})
    String parsedVal;

    @Benchmark
    public Integer parseInt() throws Exception {
    	//better to return method, to get rid-off Compiler dead-code understanding
      return Integer.parseInt(parsedVal);
    }
    
    //The setup and tear down execution time is not included in the benchmark runtime measurements.    
    @Setup(Level.Trial)
    public void doSetup() { 
        System.out.println("Do Setup");
    }

    @TearDown(Level.Trial)
    public void doTearDown() {
        System.out.println("Do TearDown");
    }

}