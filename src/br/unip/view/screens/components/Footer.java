package br.unip.view.screens.components;

import br.unip.view.Buildable;
import br.unip.view.Builder;
import br.unip.view.outputs.CmdOutput;
import br.unip.view.outputs.SimpleText;

public final class Footer implements Buildable{
    
    private final String msg;
    private CmdOutput output;

    public Footer(final String msg){
	this.msg = msg;
    }
    
    @Override
    public void build() {
	output = Builder.build(new SimpleText(msg));
    }

    public void print() {
	output.print();
    }

    public void println() {
	output.println();
    }
    
}
