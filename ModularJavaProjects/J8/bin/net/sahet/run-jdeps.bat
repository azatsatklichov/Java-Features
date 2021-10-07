
>javac --add-exports java.base/sun.security.x509=ALL-UNNAMED  MigrationExample.java

>jdeps MigrationExample.class

>jdeps -jdkinternals MigrationExample.class


//fixed one 

>javac MigrationExampleReplaced.java