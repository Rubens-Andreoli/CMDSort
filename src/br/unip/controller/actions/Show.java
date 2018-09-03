package br.unip.controller.actions;

import static br.unip.controller.Configs.*;
import br.unip.model.lists.VectorList;
import br.unip.view.screens.TextScreen;

public class Show implements Action{
    
    private final int numItems;
    private final VectorList list;
    
    public Show(final VectorList list, final int numItems){
	this.list = list;
	this.numItems = numItems;
    }

    @Override
    public Object doAction() {
	TextScreen show = new TextScreen(SHOW_TITLE, 
		list.toString(list.getNumItems()>numItems ? numItems : list.getNumItems()), 
		String.format(SHOW_MSG_MASK, 
			list.isSorted() ? String.format(SHOW_ORDER_MASK, 
				list.getSortMethod().getMethodName()) : SHOW_NOT_ORDER)
	);
	show.display();
	return null;
    }

}
