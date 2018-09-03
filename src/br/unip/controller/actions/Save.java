package br.unip.controller.actions;

import br.unip.controller.Controller;
import br.unip.model.io.FileIO;
import br.unip.model.lists.VectorList;
import br.unip.view.screens.MenuScreen;
import br.unip.view.screens.QuestionScreen;
import java.io.IOException;

public class Save implements Action{

    private final MenuScreen mainMenu;
    private final QuestionScreen saveQuestion;
    private final VectorList list;

    public Save(final MenuScreen mainMenu, final QuestionScreen saveQuestion, final VectorList list) {
	this.mainMenu = mainMenu;
	this.saveQuestion = saveQuestion;
	this.list = list;
    }

    @Override
    public Void doAction() {
	saveQuestion.display();
	try {
	    new FileIO<VectorList>().writeFile(list, Controller.SAVE_FOLDER, saveQuestion.getUserInput() + ".lst");
	    mainMenu.setFooter("Lista salva com sucesso.");
	} catch (IOException ex) {
	    mainMenu.setFooter("Erro ao salvar a lista!");
	}
	mainMenu.displayFooter(true);
	return null;
    }

}
