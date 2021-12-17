package com.joshcummings.cats.service;

import java.util.Collection;
import java.util.Set;
import com.joshcummings.cats.model.Cat;

public interface CatService {
    Set<Cat> listDescendents(Cat cat);
    long countDescendents(Cat cat);
    
    Cat addCat(Cat cat);
    Cat addCat(String name, Cat dad, Cat mom);
    Cat removeCat(Long id);
    void removeAll();
    
    Collection<Cat> findCat(String name);
    Cat findCat(long id);
    
    Collection<Cat> listCats();
}
