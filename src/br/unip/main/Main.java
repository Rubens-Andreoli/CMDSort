package br.unip.main;

import br.unip.model.items.IntItem;
import br.unip.model.items.Item;
import br.unip.model.items.generators.IntItemGenerator;
import br.unip.model.items.generators.MiscItemGenerator;
import br.unip.model.lists.VectorList;

public class Main {

    public static void main(String[] args) {
	
	Item[] items;
	//items = new IntItemGenerator().generateRandom(10);
	items = new IntItemGenerator().generateOrdered(10000);
	
	VectorList<IntItem> list = new VectorList<IntItem>(10000);
	list.setItems((IntItem[]) items);
	
	System.out.println(list.toString(20));
	/*for(Item item : items)
	    System.out.println(item.toString());*/
	
    }
    
}
