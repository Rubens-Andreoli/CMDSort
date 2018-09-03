package br.unip.controller.actions;

import br.unip.model.items.ItemTypes;
import br.unip.model.lists.VectorList;
import br.unip.model.lists.VectorListPopulator;
import br.unip.view.MenuScreen;
import br.unip.view.QuestionScreen;

public class Generate {
    
    private final MenuScreen menu;
    private final MenuScreen subMenu;
    private final QuestionScreen question;
    VectorList list;

    public Generate(MenuScreen menu, MenuScreen subMenu, QuestionScreen question) {
	this.menu = menu;
	this.subMenu = subMenu;
	this.question = question;
    }
 
    public VectorList doAction(){
	menu.display();
	subMenu.display();
	if(subMenu.getInput() > 1){ 
	    question.display();
	    this.populateList();
	    return list;
	}else{
	    //TODO: Geração manual!
	    return null;
	}
    }
    
    private void populateList(){
	list = new VectorList((int) question.getInput());
	switch(subMenu.getInput()){
	    case 2:
		if(menu.getInput() == 1) new VectorListPopulator().populateRandom(ItemTypes.INTITEM, list);
		if(menu.getInput() == 2) new VectorListPopulator().populateRandom(ItemTypes.MISCITEM, list);
		break;
	    case 3:
		if(menu.getInput() == 1) new VectorListPopulator().populateSemiOrdered(ItemTypes.INTITEM, list);
		if(menu.getInput() == 2) new VectorListPopulator().populateSemiOrdered(ItemTypes.MISCITEM, list);
		break;
	    case 4:
		if(menu.getInput() == 1) new VectorListPopulator().populateOrdered(ItemTypes.INTITEM, list);
		if(menu.getInput() == 2) new VectorListPopulator().populateOrdered(ItemTypes.MISCITEM, list);
		break;
	}
    }
    
}
