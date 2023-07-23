echo "or just copy it under UI-config VM options: -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCI -XX:+UseJVMCICompiler"
echo  java -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCI -XX:+UseJVMCICompiler -Dgraal.PrintCompilation=true JITDemo

javac JITDemo
java  -XX:-UseJVMCICompiler  Demo2