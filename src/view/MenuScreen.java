package view;

import view.inputs.LmtIntInput;
import view.output.components.DashLine;
import view.output.components.SimpleText;
import view.output.structures.Menu;
import view.output.structures.TopBox;

public class MenuScreen extends Screen{

    private Menu menu;
    private LmtIntInput prompt;
    private int input;

    public MenuScreen(String title, String[] items, String prompt) {
	this.title = new TopBox(title);
	menu = new Menu(items);
	this.prompt = new LmtIntInput(prompt, items.length);
    }
    
    public int getInput() {
	return input;
    }
    
    @Override
    public void setFooter(String inform) {
	this.footer = new SimpleText(inform);
    } 

    @Override
    public void display() {
	title.print();
	menu.print();
	new DashLine(2).print();
	input = prompt.getInput();
    }

}
