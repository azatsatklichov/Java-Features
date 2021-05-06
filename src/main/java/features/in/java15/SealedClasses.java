package features.in.java15;

/**
 * Sealed Classes (Preview) This JEP introduced few new keywords, sealed,
 * non-seal, permits to support sealed classes and interfaces. The sealed
 * classes and interfaces restrict who can be a subtype.
 * 
 * 2.1 The below sealed interface allowed three specified sub-classes to
 * implement it.
 *
 */
public class SealedClasses {

	public static void main(String[] args) {
		Command command = null; //TBD
		switch (command) {
		case LoginCommand: // login
		case LogoutCommand: // logout
		case PluginCommand: // custom plugin
			// no default needed, only permits 3 sub-classes
		}
	}

}
