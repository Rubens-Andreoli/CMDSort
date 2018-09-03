package br.unip.controller.actions;

import br.unip.controller.Controller;
import br.unip.model.io.FileIO;
import br.unip.model.lists.VectorList;
import br.unip.view.QuestionScreen;
import br.unip.view.Screen;
import java.io.IOException;

public class Save {
    
    private final Screen mainMenu;
    private final QuestionScreen saveQuestion;
    private final VectorList list;

    public Save(Screen mainMenu, QuestionScreen saveQuestion, VectorList list) {
	this.mainMenu = mainMenu;
	this.saveQuestion = saveQuestion;
	this.list = list;
    }
    
    public Void doAction(){
	if(list == null){
	    mainMenu.setFooter("Não há lista para ser salva!");
	    mainMenu.displayFooter();
	}else{
	    saveQuestion.display();
	    try {
		new FileIO<VectorList>().writeFile(list, Controller.SAVE_FOLDER, saveQuestion.getInput()+".lst");
		mainMenu.setFooter("Lista salva com sucesso.");
	    } catch (IOException ex) {
		mainMenu.setFooter("Erro ao salvar a lista!");
	    }
	    mainMenu.displayFooter();
	}
	return null;
    }
    
}
