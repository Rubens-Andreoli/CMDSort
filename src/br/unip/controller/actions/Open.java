package br.unip.controller.actions;

import static br.unip.controller.Controller.SAVE_FOLDER;
import br.unip.model.io.FileIO;
import br.unip.model.lists.VectorList;
import br.unip.view.screens.MenuScreen;
import java.io.File;
import java.io.IOException;

public class Open implements Action{

    private final MenuScreen mainMenu;
    private MenuScreen openMenu;
    private VectorList list;
    private File[] files;

    public Open(final MenuScreen mainMenu) {
	this.mainMenu = mainMenu;
    }


    @Override
    public VectorList doAction() {
	files = new FileIO<VectorList>().readFolder(SAVE_FOLDER);
	if (files.length == 0) {
	    mainMenu.setFooter("Não há lista(s) salva(s)!");
	    mainMenu.displayFooter(true);
	} else {
	    openMenu = new MenuScreen("Relação de listas salvas", this.filesToStrings(files), "Digite o número correspondente ao arquivo desejado");
	    openMenu.display();
	    try {
		list = new FileIO<VectorList>().readFile(files[openMenu.getUserInput() - 1]);
		openMenu.setFooter("Lista " + files[openMenu.getUserInput() - 1].getName() + " carregada com sucesso.");
	    } catch (IOException ex) {
		list = null;
		openMenu.setFooter("Arquivo não encontrado!");
	    } catch (ClassNotFoundException ex) {
		list = null;
		openMenu.setFooter("Lista incompatível com a versão atual!");
	    }
	    openMenu.displayFooter(true);
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
