package br.unip.model.items;

import java.io.Serializable;

public interface Item<ItemType extends Item> extends Comparable<ItemType>, Serializable{

    void generateRandom();
    
}
