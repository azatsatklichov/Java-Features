package com.joshcummings.cats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.joshcummings.cats.model.Cat;
import com.joshcummings.cats.service.CatService;

public class CatLoader {
    public void loadCats(Number numberOfCats, CatService... services) {
        String fileName = "cat-tree-size-" + numberOfCats;
        try ( InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is)); ) {
            reader.lines()
                .map(line -> Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray())
                .forEach(split -> {
                    String catName = "Cat" + split[0];

                    for ( CatService service : services ) {                    
                        Cat dad = split[1] == -1 ? null : service.findCat("Cat" + split[1]).iterator().next();
                        Cat mom = split[2] == -1 ? null : service.findCat("Cat" + split[2]).iterator().next();

                        service.addCat(catName, dad, mom);    
                    }
                });
        } catch ( IOException e ) {
            throw new IllegalStateException(e);
        }
    }
    
    public void removeCats(CatService... services) {
        for ( CatService service : services ) {
            service.removeAll();
        }
    }
}
