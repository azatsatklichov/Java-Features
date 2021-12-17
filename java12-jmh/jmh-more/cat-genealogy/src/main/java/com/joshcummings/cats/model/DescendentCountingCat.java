package com.joshcummings.cats.model;

public class DescendentCountingCat extends AbstractCat {
    public DescendentCountingCat() {}
    
    public DescendentCountingCat(String name, Cat dad, Cat mom) {
        super(name, dad, mom);
    }
    
    public long countDescendents() {
        return 1 + children.stream().mapToLong(Cat::countDescendents).sum();
    }
}