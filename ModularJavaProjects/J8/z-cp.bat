echo "javac -d classes src/test.core.modul/test/core/modul/Fibo.java"
javac -d classes src/test.core.modul/test/core/modul/Fibo.java

echo "mkdir lib"
mkdir lib

echo jar --create --file lib/fib.jar -C classes .
jar --create --file lib/fib.jar -C classes .


echo java --classpath lib/fib.jar test.core.modul.Fibo
java --classpath lib/fib.jar test.core.modul.Fibo  
 
 
 //detail 
 >jar tvf lib/hello.jar
 
 
--- for module 
>jar --file lib/fibo.jar --describe-module