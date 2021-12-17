package com.joshcummings.cats.service;

import com.joshcummings.cats.model.Cat;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class SimpleCatService implements CatService {
    private final Map<Long, Cat> cats = new ConcurrentHashMap<>();
    
    private final Class<? extends Cat> defaultCatType;
    
    public SimpleCatService(Class<? extends Cat> defaultCatType) {
        this.defaultCatType = defaultCatType;
    }
    
    public Stream<Cat> descendents(Cat cat) {
        final Set<Cat> closedSet = Collections.synchronizedSet(new HashSet<>());
        return helper(cat, closedSet).parallel();
    }
 
    private Stream<Cat> helper(Cat cat, Set<Cat> visited) {
        if (!visited.add(cat)) return Stream.empty();

        return Stream.concat(
                    Stream.of(cat),
                    StreamSupport.stream(cat.getChildren().spliterator(), false)
                        .flatMap(child -> helper(child, visited)));
    }
    
    public Set<Cat> listDescendents(Cat cat) {
        return descendents(cat).collect(Collectors.toSet());
    }
    
    public long countDescendents(Cat cat) {
        return descendents(cat).count();
    }
    
    @Override
    public Cat addCat(Cat cat) {
        cats.put(cat.getId(), cat);
        return cat;
    }
    
    @Override
    public Cat addCat(String name, Cat dad, Cat mom) {
        try {
            Cat cat = (Cat)defaultCatType.getConstructor(String.class, Cat.class, Cat.class).newInstance(name, dad, mom);
            return addCat(cat);
        } catch ( Exception e ) {
            throw new IllegalStateException(e);
        }
    }
    
    @Override
    public Cat findCat(long id) {
        return cats.get(id);
    }
    
    @Override
    public Collection<Cat> findCat(String name) {
        Collection<Cat> withName = new ArrayList<>();
        for ( Cat cat : cats.values() ) {
            if ( cat.getName().equals(name) ) {
                withName.add(cat);
            }
        }
        return withName;
    }
    
    @Override
    public Cat removeCat(Long id) {
        Cat cat = findCat(id);
        Cat mom = cat.getMom();
        Cat dad = cat.getDad();
        mom.removeChild(cat);
        dad.removeChild(cat);
        return cats.remove(cat.getId());
    }
    
    @Override
    public void removeAll() {
        cats.clear();
    }
    
    @Override
    public Collection<Cat> listCats() {
        return cats.values();
    }
}
