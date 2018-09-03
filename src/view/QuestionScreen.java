package view;

import view.inputs.CmdInput;
import view.output.structures.TopBox;

public class QuestionScreen extends Screen{
    private final CmdInput prompt;
    private Object input;
    
    public QuestionScreen(String title, CmdInput cmdInput){
	this.top = new TopBox(title, 2);
	this.prompt = cmdInput;
    }

    public Object getInput() {
	return input;
    }

    @Override
    public void display() {
	top.print();
	prompt.getInput();
    }
    
}
