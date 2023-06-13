package features.in.java14;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serial;
import java.io.Serializable;

/**
 * This annotation type is intended to allow compile-time checking of
 * serialization-related declarations, analogous to the checking enabled by the
 * {@link java.lang.Override} annotation type to validate method overriding.
 * {@code Serializable} classes are encouraged to use {@code @Serial}
 * annotations to help a compiler catch mis-declared serialization-related
 * fields and methods, mis-declarations that may otherwise be difficult to
 * detect.
 * 
 * https://www.baeldung.com/java-14-serial-annotation
 *
 */


class MySerialClass implements Serializable {

	@Serial
	private static final ObjectStreamField[] serialPersistentFields = null;
	
	
	@Serial
	private static final long serialVersionUID = 1;

	@Serial
	private void writeObject(ObjectOutputStream stream) throws IOException {
		// ...
	}

	@Serial
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		// ...
	}

	@Serial
	private void readObjectNoData() throws ObjectStreamException {
		// ...
	}

	@Serial
	private Object writeReplace() throws ObjectStreamException {
		// ...
		return null;
	}

	@Serial
	private Object readResolve() throws ObjectStreamException {
		// ...
		return null;
	}

}


public class SerialDemo {

	@Serial
	private static final long serialVersionUID = 63L; //class not implementing Serializable ,,.. 
	
	@Serial
	private static final long seralVersionUID = 123L; // compile-time error, should be 'serialVersionUID'

	
 

}

 
//
//enum MyEnum { 
//    @Serial 
//    private void readObjectNoData() throws ObjectStreamException {} // Compilation error 
//}

//class MyExternalizableClass implements Externalizable {
//    @Serial 
//    private void writeObject(ObjectOutputStream stream) throws IOException {}  
// 
//}