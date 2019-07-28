package features.in.java10;

/**
*  
* <pre>
*8.1. Command Line Options and Tools
*----------------------------------
Tool javah has been removed from Java 10 which generated C headers and source files which were required to implement 
native methods – now, javac -h can be used instead.

policytool was the UI based tool for policy file creation and management. This has now been removed. 
The user can use simple text editor for performing this operation.

Removed java -Xprofoption. The option was used to profile the running program and send profiling data to standard output. 
The user should now use jmap tool instead.

8.2. APIs
---------
Deprecated java.security.acl package has been marked forRemoval=true and is subject to removal in a 
future version of Java SE. It’s been replaced by java.security.Policy and related classes.

Similarly, java.security.{Certificate,Identity,IdentityScope,Signer} APIs are marked forRemoval=true.
*</pre>
*/
public class DeprecationsAndRemovals {

}
