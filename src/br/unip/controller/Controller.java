package br.unip.controller;


import br.unip.controller.actions.Generate;
import br.unip.controller.actions.Open;
import br.unip.controller.actions.Order;
import br.unip.controller.actions.Save;
import br.unip.controller.actions.Show;
import br.unip.model.lists.VectorList;
import br.unip.view.inputs.BooleanInput;
import br.unip.view.inputs.IntInput;
import br.unip.view.inputs.StringInput;
import br.unip.view.screens.MenuScreen;
import br.unip.view.screens.QuestionScreen;

public class Controller {
    public static final String SAVE_FOLDER = "lists";
    
    private MenuScreen mainMenu;
    private MenuScreen generateMenu;
    private MenuScreen generateSubMenu;
    private QuestionScreen generateQuestion;
    private QuestionScreen saveQuestion;
    private MenuScreen orderMenu;
    private QuestionScreen orderQuestion;
    private VectorList list;
    
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
		new StringInput("Digite o nome da lista a ser salva: ", "([a-zA-Z0-9_-]{2,})"));
	
	orderMenu = new MenuScreen("Ordenar [Método]",
                new String[]{"Método bubble", "Método insertion", "Método merge", "Método quick", "Comparativo de desempenho"},
                "Digite a opção desejada de acordo com o menu");
	
	orderQuestion = new QuestionScreen("Ordenar [Ordem]", 
		new BooleanInput("Deseja ordenar em ordenar em ordem crescente ou decrescente (c/d)? ", 'd', 'c'));
	
    }
    
    public void controlView(){
        do{
	    mainMenu.display();
	    switch(mainMenu.getUserInput()){
		case 1:
		    list = new Generate(generateMenu, generateSubMenu, generateQuestion).doAction();
		    break;
		case 2:
		    if(list == null){
			mainMenu.setFooter("Não há lista para ser salva!");
			mainMenu.displayFooter(true);
		    }else new Save(mainMenu, saveQuestion, list).doAction();
		    break;
		case 3:
		    list = new Open(mainMenu).doAction();
		    break;
		case 4:
		    if (list == null) {
			mainMenu.setFooter("Não há lista para ser ordenada!");
			mainMenu.displayFooter(true);
		    } else if (list.isSorted()) {
			mainMenu.setFooter("A lista já está ordenada!");
			mainMenu.displayFooter(true);
		    }else new Order(orderMenu, orderQuestion, list).doAction();
		    break;
		case 5:
		    if(list == null) {
			mainMenu.setFooter("Não há lista para ser exibida!");
			mainMenu.displayFooter(true);
		    }else new Show(list).doAction();
	    }
	}while(mainMenu.getUserInput() != 8);
    }
    
}