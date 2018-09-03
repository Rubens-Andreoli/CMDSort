package model.items;

import java.io.Serializable;

public interface Item<ItemType extends Item> extends Comparable<ItemType>, Generatable, Serializable{
    
}
