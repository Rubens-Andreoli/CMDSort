package main;

import controller.Controller;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.items.IntItem;
import model.lists.VectorList;
import model.FileIO;
import model.lists.exceptions.FullListException;
import model.sorters.Sorter;
import view.MenuScreen;
import view.QuestionScreen;
import view.TextScreen;
import view.inputs.BooleanInput;
import view.inputs.IntInput;
import view.output.structures.ComplexMenu;

public class Main {

    public static void main(String[] args) {
	
	
	/*Map items = new LinkedHashMap();
	items.put("Manual", null);
	items.put("Automático", new String[]{"Aleatória","Semi-Ordenada", "Ordenada"});
	ComplexMenu cMenu = new ComplexMenu(items);
	cMenu.print();*/
	
        Controller controller = new Controller();
        controller.startView();
        controller.controlView();
        

        //new QuestionScreen("GERAÇÃO DE LISTAS", new IntInput("Digite a quantidade de elementos desejada: ")).display();
	//new QuestionScreen("GERAÇÃO DE LISTAS", new BooleanInput("Deseja salvar lista criada (S/N)? ")).display();
	//new QuestionScreen("ORDENAR", new BooleanInput("Deseja ordenar em ordenar em ordem crescente ou decrescente (c/d)? ", 'c', 'd')).display();
	//new TextScreen("ORDENAÇÃO PELO MÉTODO BUBBLE", "Text...").display();
	
	
	/*IntItem item = new IntItem();
	item.setValue(20);
	System.out.println(item.toString());*/
	
	/*IntItem item = new IntItem();
	item.generateRandom();
	System.out.println(item.toString());*/
	
	/*VectorList<IntItem> list = new VectorList<IntItem>(10);
	IntItem manualItem = new IntItem();
	manualItem.setValue(10);
	try {
	    list.addItem(manualItem);
	} catch (FullListException ex) {
	    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	}

	
	/*MiscItem itemManual = new MiscItem();
	itemManual.setItem('R', 29);
	list.addItem(itemManual);*/
	/*for(int i=list.getNumItems(); i<list.getMaxItems(); i++){
	    //IntItem item = new IntItem();
	    MiscItem item = new MiscItem();
	    item.generateRandom();
	    item.toString();
	    list.addItem(item);
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
