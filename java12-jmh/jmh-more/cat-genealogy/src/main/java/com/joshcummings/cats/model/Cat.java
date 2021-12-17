package com.joshcummings.cats.model;

public interface Cat {
    Long getId();
    
    Cat getMom();
    
    Cat getDad();
    
    Iterable<Cat> getChildren();
    
    String getName();
    
    void addChild(Cat child);
    
    void removeChild(Cat child);
    
    long countDescendents();
}
