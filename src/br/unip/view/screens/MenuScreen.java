package br.unip.view.screens;

import br.unip.view.inputs.RangeInput;
import br.unip.view.Builder;
import br.unip.view.outputs.CharLine;
import br.unip.view.screens.components.Menu;
import br.unip.view.screens.components.TopBox;

public class MenuScreen extends InputScreen<Integer> {
     
    private final Menu menu;
    
    public MenuScreen(final String title, final String[] items, final String prompt) {
	super(Builder.build(new TopBox(title)), new RangeInput(prompt, items.length));
	menu = Builder.build(new Menu(items)); 
    }
    
    @Override
    public void display(){
	top.println();
	menu.println();
	Builder.build(new CharLine(2)).println();
	userInput = (Integer) question.getInput();
    }  
    
}
