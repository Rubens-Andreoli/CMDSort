package br.unip.view.screens.components;

import br.unip.view.Buildable;
import br.unip.view.Builder;
import static br.unip.view.Configs.LINE_BREAK;
import static br.unip.view.Configs.TOPMSG_ALIGNMENT;
import static br.unip.view.Configs.TOPTITLE_ALIGNMENT;
import br.unip.view.outputs.BoxedText;
import br.unip.view.outputs.CharLine;
import java.io.IOException;
import br.unip.view.outputs.CmdOutput;

public class TopBox implements Buildable{   
    
    private final String title;
    private String msg;
    private CmdOutput[] outputs;
    
    public TopBox(final String title){
        this.title = title;
    }

    public void setMsg(String msg) { this.msg = msg; }
    
    @Override
    public void build() {
	outputs = new CmdOutput[msg==null ? 3:4];
	outputs[0] = Builder.build(new CharLine());
	outputs[1] = Builder.build(new BoxedText(title.toUpperCase(), TOPTITLE_ALIGNMENT));
	if(msg!=null){
	    outputs[2] = Builder.build(new BoxedText(msg.toUpperCase(), TOPMSG_ALIGNMENT));
	    outputs[3] = Builder.build(new CharLine());
	}else{
	    outputs[2] = Builder.build(new CharLine());
	}
    }

    public void println() {
	try {
	    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	} catch (IOException | InterruptedException ex) {
	    System.out.println();
	    Builder.build(new CharLine(LINE_BREAK)).println();
	    System.out.println();
	}
	for(CmdOutput item : outputs) item.println();
    }
    
}
