package br.unip.controller.actions;

import br.unip.model.lists.VectorList;
import br.unip.view.screens.TextScreen;

public class Show implements Action{
    
    private final VectorList list;
    
    public Show(final VectorList list){
	this.list = list;
    }

    @Override
    public Object doAction() {
	new TextScreen("Visualização de lista", 
		list.toString(list.getNumItems()>200?200:list.getNumItems()), 
		String.format("Lista %s, exibida com sucesso.", list.isSorted()?"ordenada pelo "+list.getSortMethod().getMethodName():"não ordenada")).display();
	return null;
    }
    
}
