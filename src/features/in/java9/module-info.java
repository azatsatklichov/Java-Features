/**
 * A module is a self-describing collection of code and data and has a name to
 * identify it. Name should follow the reverse-domain-pattern.
 * 
 * By convention this file should reside in the folder whose name is same as
 * module name.
 * 
 * How to create Java module
 * 
 * Creating Java module required the following steps.
 * Create a directory structure 
 * Create a module declarator 
 * Java source code
 */
//module features.in.java9 {
// requires org.junit.jupiter.api;
// requires com.baeldung.java9.modules.engines;
// exports com.baeldung.java9.modules.car.handling;
// opens
// provides
// uses
//}