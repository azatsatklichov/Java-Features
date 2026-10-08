
#java -cp test.jar features.in.java9.JRelease9
#Create the multi-release jar
#jar -c -f test.jar -C java7 . --release 9 -C java9.
javac --release 9 JRelease9.java
