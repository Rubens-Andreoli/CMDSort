
package view.inputs;

public final class EnterInput extends CmdInput {

    public EnterInput() {
	super("Pressione ENTER para continuar.");
    }
    
    @Override
    public Void getInput(){
	askInput();
	scanner.nextLine();
	return null;
    }
    
}
