package br.unip.view;

import br.unip.view.inputs.CmdInput;
import br.unip.view.output.structures.TopBox;

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
	input = prompt.getInput();
    }
    
}
