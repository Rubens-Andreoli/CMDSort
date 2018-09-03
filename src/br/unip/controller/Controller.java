package br.unip.controller;


import br.unip.controller.actions.Generate;
import br.unip.controller.actions.Open;
import br.unip.controller.actions.Save;
import java.io.File;
import br.unip.model.lists.VectorList;
import br.unip.model.sorters.BubbleSorter;
import br.unip.model.sorters.MergeSorter;
import br.unip.model.sorters.QuickSorter;
import br.unip.view.MenuScreen;
import br.unip.view.QuestionScreen;
import br.unip.view.TextScreen;
import br.unip.view.inputs.BooleanInput;
import br.unip.view.inputs.IntInput;
import br.unip.view.inputs.WordInput;

public class Controller {
    public static final String SAVE_FOLDER = "lists";
    
    private MenuScreen mainMenu;
    private MenuScreen generateMenu;
    private MenuScreen generateSubMenu;
    private QuestionScreen generateQuestion;
    private QuestionScreen saveQuestion;
    private MenuScreen openMenu;
    private MenuScreen orderMenu;
    private QuestionScreen orderQuestion;
    private VectorList list;
    private File[] filesList;
    
    public void startView(){
        mainMenu = new MenuScreen("Listas - Métodos de Ordenação",
                new String[]{"Gerar", "Salvar", "Abrir", "Ordenar", "Visualizar", "Ajuda", "Sobre", "Sair"},
                "Digite a opção desejada de acordo com o menu");
	
	generateMenu = new MenuScreen("Geração de listas [Tipo de itens]", 
		new String[]{"Inteiro", "Misto"}, 
		"Digite a opção de acordo com o tipo de item desejado");
	
	generateSubMenu = new MenuScreen("Geração de listas [Forma de criação]", 
                new String[]{"Manual", "Aleatória", "Semi-Ordenada", "Ordenada"},
                "Digite a opção desejada para criação da lista");
        
	generateQuestion = new QuestionScreen("Geração de listas [Número de elementos]", 
		new IntInput("Digite a quantidade de elementos desejada: "));
	
	saveQuestion = new QuestionScreen("Salvar lista", 
		new WordInput("Digite o nome da lista a ser salva: "));
	
	orderMenu = new MenuScreen("Ordenar [Método]",
                new String[]{"Método bubble", "Método merge", "Método quick", "Comparativo de desempenho"},
                "Digite a opção desejada de acordo com o menu");
	
	orderQuestion = new QuestionScreen("Ordenar [Ordem]", 
		new BooleanInput("Deseja ordenar em ordenar em ordem crescente ou decrescente (c/d)? ", 'd', 'c'));
	
    }
    
    public void controlView(){
        do{
	    mainMenu.display();
	    switch(mainMenu.getInput()){
		case 1:
		    list = new Generate(generateMenu, generateSubMenu, generateQuestion).doAction();
		    break;
		case 2:
		    new Save(mainMenu, saveQuestion, list).doAction();
		    break;
		case 3:
		    new Open(mainMenu, openMenu, list, filesList).doActtion();
		    break;
		case 4:
		    if(list == null){ 
			mainMenu.setFooter("Não há lista para ser ordenada!");
			mainMenu.displayFooter();
		    }else{ 
			if(list.isSorted()){
			    mainMenu.setFooter("A lista já está ordenada!");
			    mainMenu.displayFooter();
			}else{
			    orderMenu.display();
			    orderQuestion.display();
			    //orderQuestion.setFooter("Processando...\n");
			    //orderQuestion.displayFooter();
			    long time = this.orderList()[0];
			    if(orderMenu.getInput() == 4){
				//TODO: Exibir comparativo!
			    }else{
				new TextScreen("Ordenação pelo "+list.getSortMethod().getMethodName(),
					list.getSortMethod().getMethodBrief(),
					"A ordenação foi concluida com sucesso em "+time+" ms.\n").display();
			    }
			}
		    }
		    break;
		case 5:
		    if(list == null) {
			mainMenu.setFooter("Não há lista para ser exibida!");
			mainMenu.displayFooter();
		    }else new TextScreen("Visualização de lista", 
			    list.toString(list.getMaxItems()>200?200:null), 
			    String.format("Lista %s, exibida com sucesso.", list.isSorted()?"ordenada pelo "+list.getSortMethod().getMethodName():"não ordenada")).display();
	    }
	}while(mainMenu.getInput() != 8);
    }
    
    private long[] orderList(){
	long start;
	long end;
	switch(orderMenu.getInput()){
	    case 1:
		start = System.currentTimeMillis();
		list.sort(new BubbleSorter(), (boolean)orderQuestion.getInput());
		end = System.currentTimeMillis();
		return new long[]{end-start};
	    case 2:
		start = System.currentTimeMillis();
		list.sort(new MergeSorter(), (boolean)orderQuestion.getInput());
		end = System.currentTimeMillis();
		return new long[]{end-start};
	    case 3:
		start = System.currentTimeMillis();
		list.sort(new QuickSorter(), (boolean)orderQuestion.getInput());
		end = System.currentTimeMillis();
		return new long[]{end-start};
	    case 4:
		long[] times = new long[3];
		start = System.currentTimeMillis();
		new VectorList(list).sort(new BubbleSorter(), (boolean)orderQuestion.getInput());
		end = System.currentTimeMillis();
		times[0] = end-start;
		start = System.currentTimeMillis();
		new VectorList(list).sort(new MergeSorter(), (boolean)orderQuestion.getInput());
		end = System.currentTimeMillis();
		times[1] = end-start;
		start = System.currentTimeMillis();
		new VectorList(list).sort(new QuickSorter(), (boolean)orderQuestion.getInput());
		end = System.currentTimeMillis();
		times[2] = end-start;
		return times;
	    default:
		return null;
	}
    }
    
}
