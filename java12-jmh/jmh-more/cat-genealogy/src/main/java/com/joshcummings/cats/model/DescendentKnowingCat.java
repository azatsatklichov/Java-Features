package com.joshcummings.cats.model;

public class DescendentKnowingCat extends AbstractCat {
    public DescendentKnowingCat() {}
    
    public DescendentKnowingCat(String name, Cat dad, Cat mom) {
        super(name, dad, mom);
    }
    
    protected long descendentCount;
    
    public void addChild(Cat child) {
        if ( children.add(child) ) {
            incrementDescendents();
        }
    }
    
    public void removeChild(Cat child) {
        if ( children.remove(child) ) {
            decrementDescendents();
        }
    }
    
    protected void incrementDescendents() {
        descendentCount++;
        if ( mom != null && mom instanceof DescendentKnowingCat ) {
            ((DescendentKnowingCat)mom).incrementDescendents();
        }
        if ( dad != null && dad instanceof DescendentKnowingCat ) {
            ((DescendentKnowingCat)dad).incrementDescendents();
        }
    }
    
    protected void decrementDescendents() {
        descendentCount--;
        if ( mom != null && mom instanceof DescendentKnowingCat ) {
            ((DescendentKnowingCat)mom).incrementDescendents();
        }
        if ( dad != null && dad instanceof DescendentKnowingCat ) {
            ((DescendentKnowingCat)dad).incrementDescendents();
        }
    }
    
    public long countDescendents() {
        return descendentCount;
    }
}
