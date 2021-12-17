echo REPL stands for Read-Eval-Print Loop

jshell

jshell>1+3

 ^l  like clr



echo int doubled(int i){ return i*2;}
echo doubled(6)
echo System.out.print("sdsd");
echo /exit    //or ^D
jshell


 ^l  like clr
 
 
 code completion  --- TAB
 
 > java.lang. TAB TAB
 >Thread.sleep( - TAB TAB, ... docm
 
 jshell> java.lang.S
SafeVarargs                       SecurityException
SecurityManager                   Short
StackOverflowError                StackTraceElement
StackWalker                       StrictMath
String                            StringBuffer
StringBuilder                     StringIndexOutOfBoundsException
SuppressWarnings                  System
 
 >jshell> Thread.sleep(10000)   ..or ^C  immediate stop
 
 
 
 /help 
/save myCode.jsh,  /open myCode.jsh , /open  MyDemo.java >jshell –-class-path …


> /set feedback verbose

jshell> /set feedback verbose
|  Feedback mode: verbose

jshell> int x=1
x ==> 1
|  modified variable x : int
|    update overwrote variable x : int

jshell>

jshell> int i=23
i ==> 23
|  created variable i : int

jshell> i=34
i ==> 34
|  assigned to i : int



---
jshell> Module which(Class c){
   ...>     return c.getModule();
   ...> }
|  created method which(Class)






================= ENV =====
 /help 
/save myCode.jsh,  /open myCode.jsh , /open  MyDemo.java >jshell –-class-path …

> /save my-history.jsh
> /open my-history.jsh

>jshell --class-path commons-lang3-3.12.0.jar
jshell> import org.apache.commons.lang3.StringUtils

jshell> StringUtils.leftPad("Broadcom", 33)
$3 ==> "                         Broadcom"


jshell>



/jshel as API

JShell js = JShell.create();
List<SnippetEvent> events = js.eval("int i=0;");
Stream<VarSnippet> vars = js.variables();

