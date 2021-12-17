package com.joshcummings.cats.model;

public class ParallelDescendentCountingCat extends AbstractCat {
    public ParallelDescendentCountingCat(String name, Cat dad, Cat mom) {
        super(name, dad, mom);
    }
    
    public long countDescendents() {
        return 1 + children.stream().parallel().mapToLong(Cat::countDescendents).sum();
    }
}
