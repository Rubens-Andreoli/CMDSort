package br.unip.controller.actions;

import static br.unip.controller.Configs.*;
import br.unip.model.io.FileIO;
import br.unip.model.lists.VectorList;
import br.unip.view.inputs.StringInput;
import br.unip.view.screens.MenuScreen;
import br.unip.view.screens.QuestionScreen;
import java.io.IOException;

public class Save implements Action{

    private final MenuScreen mainMenu;
    private final QuestionScreen saveQuestion;
    private final VectorList list;

    public Save(final MenuScreen mainMenu, final VectorList list) {
	this.mainMenu = mainMenu;
	this.list = list;
	this.saveQuestion = new QuestionScreen(SAVE_TITLE, 
		new StringInput(SAVE_PROMPT, SAVE_NAME_REGEX));	
    }

    @Override
    public Void doAction() {
	saveQuestion.display();
	try {
	    new FileIO<VectorList>().writeFile(list, SAVE_FOLDER, 
		    saveQuestion.getUserInput()+SAVE_FORMAT);
	    mainMenu.setFooter(SAVE_SUCCESS);
	} catch (IOException ex) {
	    mainMenu.setFooter(SAVE_ERROR);
	}
	mainMenu.displayFooter(false);
	mainMenu.waitEnter();
	return null;
    }

}
