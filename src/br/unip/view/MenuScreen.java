package br.unip.view;

import br.unip.view.inputs.LmtIntInput;
import br.unip.view.output.components.CharLine;
import br.unip.view.output.components.SimpleText;
import br.unip.view.output.structures.Menu;
import br.unip.view.output.structures.TopBox;

public class MenuScreen extends Screen{

    private Menu menu;
    private LmtIntInput prompt;
    private int input;

    public MenuScreen(String title, String[] items, String prompt) {
	this.top = new TopBox(title);
	menu = new Menu(items);
	this.prompt = new LmtIntInput(prompt, items.length);
    }

    public int getInput() {
	return input;
    }
    
    @Override
    public void setFooter(String footer) {
	this.footer = new SimpleText(footer);
    } 

    @Override
    public void display() {
	top.print();
	menu.print();
	new CharLine(2).print();
	input = prompt.getInput();
    }

}
