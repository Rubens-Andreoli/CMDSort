package br.unip.controller.actions;

import static br.unip.controller.Configs.*;
import br.unip.model.io.FileIO;
import br.unip.model.lists.VectorList;
import br.unip.view.screens.MenuScreen;
import java.io.File;
import java.io.IOException;

public class Open implements Action{

    private final MenuScreen mainMenu;
    private MenuScreen openMenu;
    private File[] files;
    private VectorList list;

    public Open(final MenuScreen mainMenu) {
	this.mainMenu = mainMenu;
    }

    @Override
    public VectorList doAction() {
	files = new FileIO<VectorList>().readFolder(SAVE_FOLDER, SAVE_FORMAT);
	if (files.length == 0) {
	    mainMenu.setFooter(OPEN_EMPTY);
	    mainMenu.displayFooter(false);
	    mainMenu.waitEnter();
	} else {
	    openMenu = new MenuScreen(OPEN_TITLE, this.filesToStrings(files), OPEN_QUESTION);
	    openMenu.display();
	    try {
		list = new FileIO<VectorList>().readFile(files[openMenu.getUserInput()-1]);
		openMenu.setFooter(String.format(OPEN_SUCCESS_MASK, 
			files[openMenu.getUserInput()-1].getName()));
	    } catch (IOException ex) {
		openMenu.setFooter(OPEN_NOT_FOUND);
	    } catch (ClassNotFoundException ex) {
		openMenu.setFooter(OPEN_CLASS_ERROR);
	    }
	    openMenu.displayFooter(true);
	    openMenu.waitEnter();
	}
	return list;
    }
    
    private String[] filesToStrings(File[] files){
        String[] filesInString = new String[files.length];
        for(int i=0; i<files.length; i++){
            filesInString[i] = files[i].getName();
        }
        return filesInString;
    }
    
}
