package jvm.memory.management;

import java.util.Date;
import java.util.WeakHashMap;

  class Main2 {

    public static void main(String[] args) {
    	
        WeakHashMap<Person2, Person2MetaData> weakHashMap = new WeakHashMap<Person2, Person2MetaData>();
        Person2 kevin = new Person2(); //strong reference 
        weakHashMap.put(kevin, new Person2MetaData());

        Person2MetaData p = weakHashMap.get(kevin);

        System.out.println(p);

        kevin = null;
        System.gc();

        if(weakHashMap.containsValue(p)){
            System.out.println("Still contains key");
        } else {
            System.out.println("Key gone");
        }
    }
}

final class Person2 {

}

class Person2MetaData {
    Date date;

    Person2MetaData() {
        date = new Date();
    }

    @Override
    public String toString() {
        return "Person2MetaData {" +
                "date=" + date +
                '}';
    }
}