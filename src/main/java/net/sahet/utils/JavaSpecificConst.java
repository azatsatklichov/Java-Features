package net.sahet.utils;




import java.text.DateFormat;
import java.util.Date;


/**
 * @author Azat
 *
 */
public enum JavaSpecificConst {
    DATE_TIME {
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    USER_DIR {
        String getInfo() {
            return System.getProperty("user.home");
        }
    }, 
    CLASSPATH {
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };
    
    abstract String getInfo();

    public static void main(String[] args) {
        for (JavaSpecificConst csm : values())
            System.out.println(csm.getInfo());
    }
} /* (Execute to see output) */// :~
