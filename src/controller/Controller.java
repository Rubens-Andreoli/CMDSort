package controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import model.FileIO;
import model.lists.VectorList;
import view.MenuScreen;
import view.TextScreen;

public class Controller {
    
    private MenuScreen mainMenu;
    private MenuScreen generateMenu;
    private MenuScreen orderMenu;
    private MenuScreen openMenu;
    private TextScreen viewList;
    private VectorList list;
    private File[] filesList;
    
    public void startView(){
        mainMenu = new MenuScreen("Estruturas de Ordenação",
                this.actionsToStrings(),
                "Digite a opção desejada de acordo com o menu");
        LinkedHashMap<String, String[]> generateItems = new LinkedHashMap<String, String[]>();
	generateItems.put("Manual", null);
	generateItems.put("Automático", new String[]{"Aleatória","Semi-Ordenada", "Ordenada"});
	generateMenu = new MenuScreen("Geração de listas", 
                generateItems,
                "Digite a opção desejada para criação da lista");
        orderMenu = new MenuScreen("Ordenar",
                new String[]{"MÉTODO BUBBLE", "MÉTODO MERGE", "MÉTODO QUICK", "COMPARATIVO DE DESEMPENHO"},
                "Digite a opção desejada de acordo com o menu");
        
   
    }
    
    public void controlView(){
        do{
	    mainMenu.display();
	    switch(mainMenu.getInput()){
		case 1:
		    generateMenu.display();
		    break;
		case 2:
		    filesList = new FileIO().readFolder();
		    openMenu = new MenuScreen("Relação de listas salvas", this.filesToStrings(filesList), "Digite o número correspondente ao arquivo desejado");
		    openMenu.display();
		    try {
			new FileIO().readFile(filesList[openMenu.getInput()]);
			openMenu.setFooter("Lista " + filesList[openMenu.getInput()].getName() + " carregada com sucesso!");
		    } catch (IOException ex) {
			openMenu.setFooter("Arquivo não encontrado!");
		    } catch (ClassNotFoundException ex) {
			openMenu.setFooter("Lista incompatível com a versão atual!");
		    }finally{
			openMenu.displayFooter();
		    }
		    break;
		case 3:
		    if(list != null) orderMenu.display();
		    else{ 
			mainMenu.setFooter("Não há lista para ser ordenada!");
			mainMenu.displayFooter();
		    }
		    break;
		case 4:
		    if(list != null) viewList = new TextScreen("Visualização de lista", list.toString(), "Lista exibida!");
		    else{
			    mainMenu.setFooter("Não há lista para ser exibida!");
			    mainMenu.displayFooter();
		    }
	    }
	}while(mainMenu.getInput() != 7);
    }
    
    private String[] actionsToStrings(){
        String[] actionsInString = new String[MainActions.values().length];
        for(int i=0; i<MainActions.values().length; i++){
            actionsInString[i] = MainActions.values()[i].name();
        }
        return actionsInString;
    }
    

    private String[] filesToStrings(File[] files){
        String[] filesInString = new String[files.length];
        for(int i=0; i<files.length; i++){
            filesInString[i] = files[i].getName();
        }
        return filesInString;
    }
}
