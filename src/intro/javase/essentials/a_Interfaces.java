
package intro.javase.essentials;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 
 * The Interface Body
 * 
 * <pre>
 * 
 * The interface body can contain 
 * 
 * -abstract methods, 
 * -default methods, and 
 * -static methods. 
 * - in Java 9 also private methods
 * 
 *  
 * 
 * An abstract method within an interface is followed by a semicolon,
 * but no braces (an abstract method does not contain an implementation).
 * Default methods are defined with the default modifier, and static methods
 * with the static keyword. All abstract, default, and static methods in an
 * interface are implicitly public, so you can omit the public modifier.
 * 
 * In addition, an interface can contain constant declarations. All constant
 * values defined in an interface are implicitly public, static, and final. Once
 * again, you can omit these modifiers.
 * 
 * </pre>
 * 
 * *
 */

public interface a_Interfaces {

}

interface DoIt {
    void doSomething(int i, double x);

    int doSomethingElse(String s);
}

/**
 * Desc:
 * 
 * <pre>
Suppose that, at a later time, you want to add a third method to DoIt, so that the interface now becomes:

public interface DoIt {

   void doSomething(int i, double x);
   int doSomethingElse(String s);
   boolean didItWork(int i, double x, String s);
   
}


If you make this change, then all classes that implement the old DoIt interface will break because they 
no longer implement the old interface. Programmers relying on this interface will protest loudly.
 * 
 * </pre>
 * 
 */

/**
 * Try to anticipate all uses for your interface and specify it completely from
 * the beginning. If you want to add additional methods to an interface, you
 * have several options. You could create a DoItPlus interface that extends
 * DoIt:
 * 
 *
 */

interface DoItPlus extends DoIt {

    boolean didItWork(int i, double x, String s);

}

// Alternatively, you can define your new methods as default methods. The
// following example defines a default method named didItWork:
// JAVA 8
interface DoItJ8 {

    void doSomething(int i, double x);

    int doSomethingElse(String s);

    default boolean didItWork(int i, double x, String s) {
        // Method body
        return false;
    }

}

interface TimeClient {
    void setTime(int hour, int minute, int second);

    void setDate(int day, int month, int year);

    void setDateAndTime(int day, int month, int year, int hour, int minute, int second);

    LocalDateTime getLocalDateTime();

    static ZoneId getZoneId(String zoneString) {
        try {
            return ZoneId.of(zoneString);
        } catch (DateTimeException e) {
            System.err.println("Invalid time zone: " + zoneString + "; using default time zone instead.");
            return ZoneId.systemDefault();
        }
    }

    /**
     * I am a default method
     * 
     * @param zoneString
     * @return
     */
    default ZonedDateTime getZonedDateTime(String zoneString) {
        return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
    }
}

class SimpleTimeClient implements TimeClient {

    private LocalDateTime dateAndTime;

    public SimpleTimeClient() {
        dateAndTime = LocalDateTime.now();
    }

    public void setTime(int hour, int minute, int second) {
        LocalDate currentDate = LocalDate.from(dateAndTime);
        LocalTime timeToSet = LocalTime.of(hour, minute, second);
        dateAndTime = LocalDateTime.of(currentDate, timeToSet);
    }

    public void setDate(int day, int month, int year) {
        LocalDate dateToSet = LocalDate.of(day, month, year);
        LocalTime currentTime = LocalTime.from(dateAndTime);
        dateAndTime = LocalDateTime.of(dateToSet, currentTime);
    }

    public void setDateAndTime(int day, int month, int year, int hour, int minute, int second) {
        LocalDate dateToSet = LocalDate.of(day, month, year);
        LocalTime timeToSet = LocalTime.of(hour, minute, second);
        dateAndTime = LocalDateTime.of(dateToSet, timeToSet);
    }

    public LocalDateTime getLocalDateTime() {
        return dateAndTime;
    }

    public String toString() {
        return dateAndTime.toString();
    }

    public static void main(String... args) {
        TimeClient myTimeClient = new SimpleTimeClient();
        System.out.println(myTimeClient.toString());
    }
}

class TestSimpleTimeClient {
    public static void main(String... args) {
        TimeClient myTimeClient = new SimpleTimeClient();
        System.out.println("Current time: " + myTimeClient.toString());
        System.out.println("Time in California: " + myTimeClient.getZonedDateTime("Blah blah").toString());
    }
}

/**
 * Desc:
 * 
 * <pre>
Extending Interfaces That Contain Default Methods

When you extend an interface that contains a default method, you can do the following:
•Not mention the default method at all, which lets your extended interface inherit the default method.
•Redeclare the default method, which makes it abstract.
•Redefine the default method, which overrides it.
 * 
 * </pre>
 * 
 */
// Suppose that you extend the interface TimeClient as follows:
interface AnotherTimeClient extends TimeClient {
}

/**
 * Any class that implements the interface AnotherTimeClient will have the
 * implementation specified by the default method TimeClient.getZonedDateTime.
 */
// Suppose that you extend the interface TimeClient as follows:
interface AbstractZoneTimeClient extends TimeClient {
    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public ZonedDateTime getZonedDateTime(String zoneString);
}

interface HandleInvalidTimeZoneClient extends TimeClient {
    default public ZonedDateTime getZonedDateTime(String zoneString) {
        try {
            return ZonedDateTime.of(getLocalDateTime(), ZoneId.of(zoneString));
        } catch (DateTimeException e) {
            System.err.println("Invalid zone ID: " + zoneString + "; using the default time zone instead.");
            return ZonedDateTime.of(getLocalDateTime(), ZoneId.systemDefault());
        }
    }
}

/*
 * Copyright (c) 2008,2012 Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * - Neither the name of Oracle or the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior
 * written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

// CharSequenceDemo presents a String value -- backwards.
class CharSequenceDemo implements CharSequence {
    private String s;

    public CharSequenceDemo(String s) {
        // It would be much more efficient to just reverse the string
        // in the constructor. But a lot less fun!
        this.s = s;
    }

    // If the string is backwards, the end is the beginning!
    private int fromEnd(int i) {
        return s.length() - 1 - i;
    }

    public char charAt(int i) {
        if ((i < 0) || (i >= s.length())) {
            throw new StringIndexOutOfBoundsException(i);
        }
        return s.charAt(fromEnd(i));
    }

    public int length() {
        return s.length();
    }

    public CharSequence subSequence(int start, int end) {
        if (start < 0) {
            throw new StringIndexOutOfBoundsException(start);
        }
        if (end > s.length()) {
            throw new StringIndexOutOfBoundsException(end);
        }
        if (start > end) {
            throw new StringIndexOutOfBoundsException(start - end);
        }
        StringBuilder sub = new StringBuilder(s.subSequence(fromEnd(end), fromEnd(start)));
        return sub.reverse();
    }

    public String toString() {
        StringBuilder s = new StringBuilder(this.s);
        return s.reverse().toString();
    }

    // Random int from 0 to max. As random() generates values between 0 and
    // 0.9999
    private static int random(int max) {
        return (int) Math.round(Math.random() * (max + 1));
    }

    public static void main(String[] args) {
        CharSequenceDemo s = new CharSequenceDemo(
                "Write a class that implements the CharSequence interface found in the java.lang package.");

        // exercise charAt() and length()
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
        }

        System.out.println("");

        // exercise subSequence() and length();
        int start = random(s.length() - 1);
        int end = random(s.length() - 1 - start) + start;
        System.out.println(s.subSequence(start, end));

        // exercise toString();
        System.out.println(s);

    }
}

interface TimeClientHW {
    void setTime(int hour, int minute, int second);

    void setDate(int day, int month, int year);

    void setDateAndTime(int day, int month, int year, int hour, int minute, int second);

    LocalDateTime getLocalDateTime();
}
