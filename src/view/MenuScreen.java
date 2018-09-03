package view;

import java.util.Map;
import view.inputs.LmtIntInput;
import view.output.components.DashLine;
import view.output.components.SimpleText;
import view.output.structures.ComplexMenu;
import view.output.structures.Menu;
import view.output.structures.TopBox;

public class MenuScreen extends Screen{

    private Menu menu;
    private LmtIntInput prompt;
    private int input;

    public MenuScreen(String title, String[] items, String prompt) {
	this.top = new TopBox(title);
	menu = new Menu(items);
	this.prompt = new LmtIntInput(prompt, menu.getNumItems());
    }
    
    public MenuScreen(String title, Map<String, String[]> items, String prompt) {
	this.top = new TopBox(title);
	menu = new ComplexMenu(items);
	this.prompt = new LmtIntInput(prompt, menu.getNumItems());
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
	new DashLine(2).print();
	input = prompt.getInput();
    }

}
