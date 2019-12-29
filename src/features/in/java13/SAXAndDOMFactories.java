package features.in.java13;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * DOM and SAX Factories with Namespace Support There are new methods to
 * instantiate DOM and SAX factories with Namespace support.
 *
 * <pre>
 * 	
	newDefaultNSInstance()
	newNSInstance()
	newNSInstance(String factoryClassName, ClassLoader classLoader) *
 * </pre>
 */
public class SAXAndDOMFactories {

	public static void main(String[] args) throws ParserConfigurationException {
		// java 13 onwards
		DocumentBuilder db = DocumentBuilderFactory.newDefaultNSInstance().newDocumentBuilder();

		// before java 13
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
		dbf.setNamespaceAware(true);
		db = dbf.newDocumentBuilder();
	}

}
