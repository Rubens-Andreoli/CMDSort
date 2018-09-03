package br.unip.view.screens;

import br.unip.view.inputs.RangeInput;
import br.unip.view.outputs.components.CharLine;
import br.unip.view.outputs.structures.Menu;
import br.unip.view.outputs.structures.TopBox;

public class MenuScreen extends InputScreen<Integer>{

    private final Menu menu;

    public MenuScreen(final String title, final String[] items, final String prompt) {
	super(new TopBox(title), new RangeInput(prompt, items.length));
	menu = new Menu(items);
    }

    @Override
    public void display() {
	top.print();
	menu.print();
	new CharLine(2).print();
	userInput = (Integer) prompt.getInput();
    }

}
