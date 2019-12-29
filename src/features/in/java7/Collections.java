package features.in.java7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collections {
	public static void main(String[] args) {
		//Retrieving elements from collection:
		
       // Old approach 
        List<String> list = new ArrayList<String>();
        list.add("item");
        String item = list.get(0);

       Set<String> set = new HashSet<String>();
       set.add("item");

       Map<String, Integer> map = new HashMap<String, Integer>();
       map.put("key", 1);
       int value = map.get("key");

       //NEW - These collections are immutable.
        List<String> list7 = ["item"];
        String item = list7[0];

        Set<String> set7 = {"item"};

        Map<String, Integer> map7 = {"key" : 1};
        int value = map7["key"];
        
        //hashcode then equals
        
        /*
         * Dondi Imperial 24 Nov, 2009

They way they did automatic resource management looks a little weird to me. They essentially added special syntax for a very small ‘corner’ of a normally (for better or worse) verbose language. In itself it looks good but looks iffy taken in the context of everything else in Java.

As for language support for collections I wonder if it turns out to be something similar to how they did arrays where you can to do:
f(new int[]{1,2,3});
or:
int[] x = {1,2,3};
f(x);
but not:
f({1,2,3});

I like the improved type inference and strings in switch though.

         */
    }
}