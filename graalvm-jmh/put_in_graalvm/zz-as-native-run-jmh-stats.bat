#This will start JMH on your benchmark classes. JMH will scan through your code and find all benchmarks and run them. JMH will print out the results to the command line.
echo "run JMH benchmark"
java -jar benchmarks.jar

native-image --no-server --no-fallback -cp benchmarks.jar:. MyBenchmark