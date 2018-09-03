package br.unip.controller;

import static br.unip.controller.Configs.*;
import br.unip.controller.actions.*;
import br.unip.model.items.generators.*;
import br.unip.model.lists.VectorList;
import br.unip.model.sorters.*;
import br.unip.view.screens.MenuScreen;
import br.unip.view.screens.TextScreen;
import java.util.LinkedList;

public class Controller {
    
    private MenuScreen mainMenu;
    private TextScreen help;
    private TextScreen about;
    private LinkedList<Sorter> sorters;
    private LinkedList<ItemGenerator> generators;
    private VectorList list;

    public void startView(){
        mainMenu = new MenuScreen(MAIN_TITLE, ACTIONS, MAIN_QUESTION);
	help = new TextScreen(HELP_TITLE, HELP);
	about = new TextScreen(ABOUT_TITLE, ABOUT);

	generators = new LinkedList<ItemGenerator>();
	generators.add(new IntItemGenerator());
	generators.add(new MiscItemGenerator());

	sorters = new LinkedList<Sorter>();
	sorters.add(new BubbleSorter());
	sorters.add(new InsertionSorter());
	sorters.add(new QuickSorter());
	
    }

    public void controlView(){
        do{
	    mainMenu.display();
	    switch(mainMenu.getUserInput()){
		case 1:
		    list = new Generate(generators).doAction();
		    break;
		case 2:
		    if(list == null){
			mainMenu.setFooter(SAVE_NULL);
			mainMenu.displayFooter(false);
			mainMenu.waitEnter();
		    }else new Save(mainMenu, list).doAction();
		    break;
		case 3:
		    list = new Open(mainMenu).doAction();
		    break;
		case 4:
		    if (list == null) {
			mainMenu.setFooter(ORDER_NULL);
			mainMenu.displayFooter(false);
			mainMenu.waitEnter();
		    } else new Order(sorters, list).doAction();
		    break;
		case 5:
		    if(list == null) {
			mainMenu.setFooter(SHOW_NULL);
			mainMenu.displayFooter(false);
			mainMenu.waitEnter();
		    }else new Show(list, SHOW_MAX).doAction();
		    break;
		case 6:
		    help.display();
		    break;
		case 7:
		    about.display();
		    break;
	    }
	}while(mainMenu.getUserInput() != ACTIONS.length);
    }
    
}
