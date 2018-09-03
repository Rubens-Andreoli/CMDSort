package main;

import java.io.File;
import model.items.IntItem;
import model.lists.VectorList;
import model.FileIO;
import view.MenuScreen;
import view.QuestionScreen;
import view.inputs.InputTypes;

public class Main {

    public static void main(String[] args) {
	//new MenuScreen("ESTRUTURAS DE ORDENAÇÃO",new String[]{"GERAR", "ABRIR", "ORDENAR", "VISUALIZAR", "AJUDA", "SOBRE", "SAIR"} , "Digite a opção desejada de acordo com o menu").display();
	//new MenuScreen("GERAÇÃO DE LISTAS", new String[]{"LISTA ALEATÓREA", "LISTA SEMI-ORDENADA", "LISTA ORDENADA"}, "Digite a opção desejada para criação da lista").display();
	//new QuestionScreen("GERAÇÃO DE LISTAS", InputTypes.INT, "Digite a quantidade de elementos desejada: ").display();
	//new QuestionScreen("GERAÇÃO DE LISTAS", InputTypes.BOOLEAN, "Deseja salvar lista criada (S/N): ").display();
	//new MenuScreen("RELAÇÃO DE LISTAS SALVAS", new String[]{"Arquivo 1.lst", "Arquivo 2.lst", "Arquivo 3.lst"}, "Digite o número correspondente ao arquivo desejado").display();
	//new MenuScreen("ORDENAR", new String[]{"MÉTODO BUBBLE", "MÉTODO MERGE", "MÉTODO QUICK", "COMPARATIVO DE DESEMPENHO"}, "Digite a opção desejada de acordo com o menu").display();
	//new QuesionScreen("ORDENAR", InputTypes.BOOLEAN, "")
	
	
	/*IntItem item = new IntItem();
	item.setValue(20);
	System.out.println(item.toString());*/
	
	/*IntItem item = new IntItem();
	item.generateRandom();
	System.out.println(item.toString());*/
	
	/*VectorList<IntItem> list = new VectorList<IntItem>(10);
	VectorListGenerator vg = new VectorListGenerator();
	vg.populateSemiOrdered(ItemTypes.INTITEM, list, 10);
	/*VectorListIO vlIO = new VectorListIO();
	vlIO.write(list, new File("D:\\testList.lst"));*/
	//list.writeToFile(new File("D:\\testList.lst"));
	
	VectorList<IntItem> list = new FileIO<VectorList>().read(new File("D:\\testList.lst"));

	
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
	
	for(Object item: list){
	    System.out.println(item.toString());
	}
    }
    
}
