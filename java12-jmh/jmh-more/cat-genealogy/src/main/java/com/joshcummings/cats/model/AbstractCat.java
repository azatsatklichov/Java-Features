package com.joshcummings.cats.model;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractCat implements Cat {
    private Long id;
    
    protected Cat mom;
    protected Cat dad;
    protected transient Set<Cat> children = 
        Collections.newSetFromMap(
            new ConcurrentHashMap<>());

    private String name;
    
    public AbstractCat() {
        id = System.nanoTime();
    }
    
    public AbstractCat(String name, Cat dad, Cat mom) {
        this();
        this.name = name;
        this.mom = mom;
        this.dad = dad;
        
        if ( mom != null ) {
            mom.addChild(this);
        }
        
        if ( dad != null ) {
            dad.addChild(this);
        }

    }
    
    public Long getId() {
        return id;
    }
    
    public Cat getMom() {
        return mom;
    }
    
    public Cat getDad() {
        return dad;
    }
    
    public Iterable<Cat> getChildren() {
        return children;
    }
    
    public String getName() {
        return name;
    }
    
    public void addChild(Cat child) {
        children.add(child);
    }
    
    public void removeChild(Cat child) {
        children.remove(child);
    }
    
    public String toString() {
        return name;
    }
}
