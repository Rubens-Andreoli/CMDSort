package model.Items;

public interface Item<Type extends Item> extends Comparable<Type>{
    
    void generateRandom();
    
}
