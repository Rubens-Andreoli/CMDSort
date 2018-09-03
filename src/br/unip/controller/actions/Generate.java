package br.unip.controller.actions;

import br.unip.model.items.ItemTypes;
import br.unip.model.lists.VectorList;
import br.unip.model.lists.VectorListPopulator;
import br.unip.view.screens.MenuScreen;
import br.unip.view.screens.QuestionScreen;

public class Generate implements Action{
    
    private final MenuScreen generateMenu;
    private final MenuScreen generateSubMenu;
    private final QuestionScreen generateQuestion;
    private VectorList list;

    public Generate(final MenuScreen generateMenu, final MenuScreen generateSubMenu, final QuestionScreen generateQuestion) {
	this.generateMenu = generateMenu;
	this.generateSubMenu = generateSubMenu;
	this.generateQuestion = generateQuestion;
    }
 
    @Override
    public VectorList doAction(){
	generateMenu.display();
	generateSubMenu.display();
	generateQuestion.display();
	if(generateSubMenu.getUserInput() > 1){ 
	    this.populateList();
	    generateQuestion.setFooter("Processando...\n");
	    generateQuestion.displayFooter(false);
	    return list;
	}else{
	    //TODO: Geração manual!
	    return null;
	}
    }
    
    private void populateList(){
	list = new VectorList((int) generateQuestion.getUserInput());
	switch(generateSubMenu.getUserInput()){
	    case 2:
		if(generateMenu.getUserInput() == 1) new VectorListPopulator().populateRandom(ItemTypes.INTITEM, list);
		if(generateMenu.getUserInput() == 2) new VectorListPopulator().populateRandom(ItemTypes.MISCITEM, list);
		break;
	    case 3:
		if(generateMenu.getUserInput() == 1) new VectorListPopulator().populateSemiOrdered(ItemTypes.INTITEM, list);
		if(generateMenu.getUserInput() == 2) new VectorListPopulator().populateSemiOrdered(ItemTypes.MISCITEM, list);
		break;
	    case 4:
		if(generateMenu.getUserInput() == 1) new VectorListPopulator().populateOrdered(ItemTypes.INTITEM, list);
		if(generateMenu.getUserInput() == 2) new VectorListPopulator().populateOrdered(ItemTypes.MISCITEM, list);
		break;
	}
    }
    
}
