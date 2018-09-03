package br.unip.controller.actions;

import static br.unip.controller.Configs.*;
import br.unip.model.items.generators.ItemGenerator;
import br.unip.model.lists.VectorList;
import br.unip.view.inputs.IntInput;
import br.unip.view.screens.MenuScreen;
import br.unip.view.screens.QuestionScreen;
import java.util.List;

public class Generate implements Action{
    
    private final List<ItemGenerator> generators;
    private final MenuScreen itemMenu;
    private final MenuScreen methodMenu;
    private final QuestionScreen sizeQuestion;
    private VectorList list;

    public Generate(List<ItemGenerator> generators) {
	this.generators = generators;
	this.itemMenu =  new MenuScreen(GENERATE_ITEMS_TITLE, this.generatorsToString(), 
		GENERATE_ITEMS_QUESTION);	
	this.methodMenu = new MenuScreen(GENERATE_METHOD_TITLE, GENERATE_METHODS, 
		GENERATE_METHOD_QUESTION);
	this.sizeQuestion = new QuestionScreen(GENERATE_SIZE_TITLE, new IntInput(GENERATE_SIZE_PROMPT));
    }
    
    private String[] generatorsToString(){
	String[] items = new String[generators.size()];
	for(int i=0; i<generators.size(); i++){
	    items[i] = generators.get(i).getItemType();
	}
	return items;
    }
 
    @Override
    public VectorList doAction(){
	itemMenu.display();
	methodMenu.display();
	sizeQuestion.display();
	sizeQuestion.setFooter(INDICATOR_MSG);
	sizeQuestion.displayFooter(true);
	this.populateList();
	return list;
    }
    
    private void populateList(){
	int size = (int) sizeQuestion.getUserInput();
	list = new VectorList(size);
	int itemChoice = itemMenu.getUserInput()-1;
	switch(methodMenu.getUserInput()){
	    case 1:
		list.setItems(generators.get(itemChoice).generateRandom(size));
		break;
	    case 2:
		list.setItems(generators.get(itemChoice).generateSemiOrdered(size));
		break;
	    case 3:
		list.setItems(generators.get(itemChoice).generateOrdered(size));
		break;
	}
    }
   
}
