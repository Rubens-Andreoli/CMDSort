package br.unip.main;

import br.unip.controller.Controller;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.unip.model.items.IntItem;
import br.unip.model.lists.VectorList;
import br.unip.model.io.FileIO;
import br.unip.model.items.MiscItem;
import br.unip.model.lists.exceptions.FullListException;
import br.unip.model.sorters.BubbleSorter;
import br.unip.model.sorters.Sorter;
import br.unip.view.MenuScreen;
import br.unip.view.QuestionScreen;
import br.unip.view.TextScreen;
import br.unip.view.inputs.BooleanInput;
import br.unip.view.inputs.IntInput;

public class Main {

    public static void main(String[] args) {
	
        Controller controller = new Controller();
        controller.startView();
        controller.controlView();
        
	
	/*IntItem item = new IntItem();
	item.setValue(20);
	System.out.println(item.toString());*/
	
	/*IntItem item = new IntItem();
	item.generateRandom();
	System.out.println(item.toString());*/
	
	//VectorList<IntItem> list = new VectorList<IntItem>(50000);
	/*IntItem manualItem = new IntItem();
	manualItem.setValue(10);
	try {
	    list.addItem(manualItem);
	} catch (FullListException ex) {
	    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	}*/
	/*for(int i=list.getNumItems(); i<list.getMaxItems(); i++){
	    IntItem item = new IntItem();
	    //MiscItem item = new MiscItem();
	    item.generateRandom();
	    try {
		list.addItem(item);
	    } catch (FullListException ex) {
		Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}*/
	
	/*Sorter bubble = new BubbleSorter();
	bubble.sort(list.getItems(), list.getNumItems(), false);*/
	//list.sort(new BubbleSorter(), false);
	
	
	/*Iterator<Comparable> iterator = list.iterator();
	while(iterator.hasNext()) {
	    Comparable item = iterator.next();
	    System.out.println(item.toString());
	}*/
	/*for(Object item: list){
	    System.out.println(item.toString());
	}*/
    }
    
}
