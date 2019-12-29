package features.in.java6;

import java.io.Console;
import java.util.Arrays;
import java.io.IOException;

/**
 * <p><font color="#000080">
<b>Output of the program is:</b>
</font></p>



<table border="0" cellpadding="0" cellspacing="0" width="32%" bgcolor="#000000">
<tr>
<td width="100%"><font color="#FFFFFF"><b>C:\j2se6&gt;javac UseConsole.java&nbsp;</b></font>
  <p><font color="#FFFFFF"><b>C:\j2se6>java UseConsole<br>

  Enter your login Name: rahul<br>
  Enter your Existing password:<br>
  Enter your new password:<br>
  Enter new password again:<br>
  Mismatch the Passwords. Please try again.<br>
  Enter your new password:<br>

  Enter new password again:<br>
  Password for rahul has changed.<br>
  <br>
  C:\j2se6></b></font></p>
</td>
</tr>
</table>

 */
public class UseConsole{
	static char [] oldPass;
       public static void main (String args[]) throws IOException {
        Console c = System.console();
        if (c == null) {
            System.err.println("Console Object is not available.");
            System.exit(1);
        }
        String login = c.readLine("Enter your login Name: ");
        oldPass = c.readPassword("Enter your Existing password: ");
        if (check(login, oldPass)) {
            boolean flag;
		
            do {
                char [] newPass1 =
                    c.readPassword("Enter your new password: ");
                char [] newPass2 =
                    c.readPassword("Enter new password again: ");
                flag = !Arrays.equals(newPass1, newPass2);
				
                if (flag) {
                    c.format("Mismatch the Passwords. Please try again.%n");	
                    
                } else {
			change(newPass1);
                    c.format("Password for %s has changed.%n", login);
		    
                }
                Arrays.fill(newPass1, ' ');
                Arrays.fill(newPass2, ' ');		
		
            } while (flag);
		
        }
        
    }
    //check method. 
    static boolean check(String login, char[] password) {
        return true;
    }
    //change method.
    static void change(char[] password) {
		oldPass=password;
		}
    
    
}




