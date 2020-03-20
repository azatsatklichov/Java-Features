package features.in.java13;

/**
 * As mentioned previously, JDK 13 includes only 76 new APIs in the core class
 * libraries. These cover the following areas:
 * 
 * 
 * 
 * <pre>
 *  - Updates to Unicode support - 4 new scripts, 555 new characters, 61 new emoji, Japanese New Era (Emperor ;) 2019	 )
 *  
 *  - Three new methods in String to support text blocks already described.
 *  
 *  - The type-specific Buffer classes of java.nio now have absolute (as opposed to relative) bulk get and set methods. 
 *  They, as well as the base abstract Buffer class, include a slice() method to extract part of the buffer.
 *  
 *  - MappedByteBuffer has a force() method that will force a write of a section of the buffer to its backing store.
 *  
 *  - nio.FileSystem adds three new overloaded forms of newFileSystem() to access the contents of a file as a file system.
 *  
 *  - There's an interesting new method in  javax.annotation.processing.ProcessingEnvironment. isPreviewEnabled() will 
 *  tell you whether the preview features (discussed earlier) are enabled. The reason this is interesting is that the 
 *  annotation, @PreviewFeature, will not be available until JDK 14.
 *  
 *  - Element-specific types in javax.lang.model.element all get and asType() method. This returns a pseudo-type.
 *  
 *  - DocumentBuilderFactoryand SAXParserFactory in javax.xml.parsers  get three new methods to create namespace-aware instances.
 * 
 * </pre>
 */
public class APIChanges {

}
