package intro.javase.essentials;

import java.lang.annotation.Documented;

/**
 * Desc:
 * 
 * <pre>
Suppose that a software group traditionally starts the body of every class with comments providing important information:

public class Generation3List extends Generation2List {

   // Author: John Doe
   // Date: 3/17/2002
   // Current revision: 6
   // Last modified: 4/12/2004
   // By: Jane Doe
   // Reviewers: Alice, Bill, Cindy

   // class code goes here

}


To add this same metadata with an annotation, you must first define the annotation type. The syntax for doing this is:

&#64;interface ClassPreamble {
   String author();
   String date();
   int currentRevision() default 1;
   String lastModified() default "N/A";
   String lastModifiedBy() default "N/A";
   // Note use of array
   String[] reviewers();
}
 * 
 * 
 * </pre>
 * 
 */
public class c_DeclareAnnot {

}

@interface ClassPreamble {
    String author();

    String date();

    int currentRevision()

    default 1;

    String lastModified()

    default "N/A";

    String lastModifiedBy()

    default "N/A";

    // Note use of array
    String[] reviewers();
}

@ClassPreamble(author = "John Doe", date = "3/17/2002", currentRevision = 6, lastModified = "4/12/2004", lastModifiedBy = "Jane Doe",
        // Note array notation
        reviewers = { "Alice", "Bob", "Cindy" })
class Generation3List extends Generation2List {

    // class code goes here

}

class Generation2List {

}

/**
 * Note: To make the information in @ClassPreamble appear in Javadoc-generated
 * documentation, you must annotate the @ClassPreamble definition with
 * the @Documented annotation:
 * 
 * // import this to use @Documented import java.lang.annotation.*;
 */
@Documented
@interface ClassPreamble2 {

    // Annotation element definitions
    
}
