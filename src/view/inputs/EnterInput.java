
package view.inputs;

public final class EnterInput extends CmdInput {

    public EnterInput() {
	super("Pressione ENTER para voltar.");
    }
    
    @Override
    public Void getInput(){
	askInput();
	scanner.nextLine();
	return null;
    }
    
}
