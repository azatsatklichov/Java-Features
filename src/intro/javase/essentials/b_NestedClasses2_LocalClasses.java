package intro.javase.essentials;

class LocalClassExample {

    static String regularExpression = "[^0-9]";

    /**
     * <pre>
     *   However, starting in Java SE 8, a local class can access local variables
         * and parameters of the enclosing block that are final or effectively
         * final. A variable or parameter whose value is never changed after it is
         * initialized is effectively final. 
         * 
         * For example, suppose that the variable
         * numberLength is not declared final, and you add the highlighted
         * assignment statement in the PhoneNumber constructor to change the length
         * of a valid phone number to 7 digits:
     * 
     *
     * </pre>
     * 
     */
    public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {

        final int numberLength = 10;

        // Valid in JDK 8 and later:
        int numberLength2 = 10;

        class PhoneNumber {

            String formattedPhoneNumber = null;
             
            PhoneNumber(String phoneNumber) {
                // int numberLength = 7;
                String currentNumber = phoneNumber.replaceAll(regularExpression, "");
                if (currentNumber.length() == numberLength)
                    formattedPhoneNumber = currentNumber;
                else
                    formattedPhoneNumber = null;
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }

            // Valid in JDK 8 and later:
            public void printOriginalNumbers() {
            	//numberLength2++; you can not do this, becuase localVar must be either final or effective final (which means not modified) 
            	System.out.println(numberLength2);
                System.out.println("Original numbers are " + phoneNumber1 + " and " + phoneNumber2);
            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        // Valid in JDK 8 and later:

        myNumber1.printOriginalNumbers();

        if (myNumber1.getNumber() == null)
            System.out.println("First number is invalid");
        else
            System.out.println("First number is " + myNumber1.getNumber());
        if (myNumber2.getNumber() == null)
            System.out.println("Second number is invalid");
        else
            System.out.println("Second number is " + myNumber2.getNumber());

    }

    public static void main(String... args) {
        System.out.println("Local classes are classes that are defined in a block, \n"
                + "which is a group of zero or more statements between balanced braces. \n"
                + "You typically find local classes defined in the body of a method.");
        System.out.println();
        validatePhoneNumber("123-456-7890", "456-7890");
    }
}
